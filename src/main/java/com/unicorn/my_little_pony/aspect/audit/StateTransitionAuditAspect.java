package com.unicorn.my_little_pony.aspect.audit;

import com.unicorn.my_little_pony.domain.models.unicorn.states.UnicornContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
// Aspekt audytu przejść stanów jednorożca – przechwytuje pomyślne wywołania metod
// oznaczonych adnotacją @Auditable i zapisuje wpis w AuditLog.
@Aspect
@Component
public class StateTransitionAuditAspect {

    @AfterReturning("execution(* *(..)) && @annotation(Auditable)")
    public void auditTransition(JoinPoint jp) {
        String transitionName = jp.getSignature().getName();

        Object target = jp.getTarget();
        String unicornName = "nieznany";

        if (target instanceof UnicornContext unicornContext) {
            unicornName = unicornContext.getUnicorn().getName();
        }

        AuditEntry entry = new AuditEntry(LocalDateTime.now(), unicornName, transitionName);
        AuditLog auditLog = AuditLog.getInstance();
        if (auditLog != null) {
            auditLog.add(entry);
        }

        System.out.println("[AOP - Audit] Zarejestrowano przejście: " + entry);
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
