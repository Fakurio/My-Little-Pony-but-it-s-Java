package com.unicorn.my_little_pony.aspect.exceptiontranslation;

import com.unicorn.my_little_pony.domain.exceptions.PaymentProcessingException;
import com.unicorn.my_little_pony.domain.exceptions.TransportUnavailableException;
import com.unicorn.my_little_pony.integration.payment.providers.PaymentProvider;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 1
// Aspekt tłumaczenia wyjątków – przechwytuje surowe RuntimeException rzucane przez warstwę
// integracyjną (dostawcy płatności i adapter transportu) i zamienia je na właściwe wyjątki
// domenowe, bez konieczności dodawania bloków try-catch w każdym miejscu wywołania.
@Aspect
@Component
public class IntegrationExceptionTranslationAspect {

    @Pointcut("execution(public * com.unicorn.my_little_pony.integration.payment.providers.*.*(..))")
    public void paymentProviderExecution() {}

    @Pointcut("execution(public * com.unicorn.my_little_pony.integration.transport.TransportAdapter.*(..))")
    public void transportAdapterExecution() {}

    @AfterThrowing(
            pointcut = "paymentProviderExecution() || transportAdapterExecution()",
            throwing = "ex"
    )
    public void translateException(JoinPoint jp, RuntimeException ex) {
        String method = jp.getSignature().toShortString();
        System.out.println("[AOP - ExceptionTranslation] Przechwycono wyjątek w: " + method
                + " → " + ex.getClass().getSimpleName() + ": " + ex.getMessage());

        if (jp.getTarget() instanceof PaymentProvider) {
            if (!(ex instanceof PaymentProcessingException)) {
                throw new PaymentProcessingException(
                        "Błąd dostawcy płatności [" + jp.getTarget().getClass().getSimpleName()
                        + "]: " + ex.getMessage());
            }
        } else {
            if (!(ex instanceof TransportUnavailableException)) {
                throw new TransportUnavailableException(
                        jp.getTarget().getClass().getSimpleName() + " – " + ex.getMessage());
            }
        }
        throw ex;
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 1