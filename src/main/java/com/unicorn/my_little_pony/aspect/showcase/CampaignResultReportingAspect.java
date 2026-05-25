package com.unicorn.my_little_pony.aspect.showcase;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collection;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 6
// Aspekt raportuje wynik metod oznaczonych @ReportedResult po ich zakończeniu.
// Rozpoznaje kolekcje, wartości puste oraz zwykłe wyniki i wypisuje czytelny
// komunikat diagnostyczny bez zmieniania zwracanej wartości.
@Aspect
@Component
public class CampaignResultReportingAspect {

    @AfterReturning(pointcut = "@annotation(reportedResult)", returning = "result")
    public void reportResult(JoinPoint joinPoint, ReportedResult reportedResult, Object result) {
        String operationName = joinPoint.getSignature().toShortString();

        if (result instanceof Collection<?> collection) {
            System.out.println("[AOP - Result] " + operationName + " zwrócił kolekcję o rozmiarze " + collection.size());
            return;
        }

        if (result == null) {
            System.out.println("[AOP - Result] " + operationName + " zwrócił pusty wynik.");
            return;
        }

        System.out.println("[AOP - Result] " + operationName + " zwrócił: " + result);
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 6