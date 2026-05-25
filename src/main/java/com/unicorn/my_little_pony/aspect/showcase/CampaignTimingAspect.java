package com.unicorn.my_little_pony.aspect.showcase;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 5
// Aspekt mierzy czas wykonania metody oznaczonej @TimedOperation.
// Startuje zegar przed wywołaniem, przepuszcza wykonanie metody docelowej,
// a po zakończeniu raportuje czas w milisekundach.
@Aspect
@Component
public class CampaignTimingAspect {

    @Around("@annotation(timedOperation)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint, TimedOperation timedOperation) throws Throwable {
        long startTimeNanos = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long elapsedNanos = System.nanoTime() - startTimeNanos;
            Duration elapsedTime = Duration.ofNanos(elapsedNanos);
            System.out.println("[AOP - Timing] " + joinPoint.getSignature().toShortString()
                    + " wykonano w " + elapsedTime.toMillis() + " ms");
        }
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 5