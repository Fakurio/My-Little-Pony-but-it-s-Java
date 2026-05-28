package com.unicorn.my_little_pony.aspect.methodcounter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
//Tydzien 11, Zastosowanie 8
// Aspekt zliczający wywołania metod oznaczonych @CountInvocations
// w celu monitorowania częstotliwości użycia operacji.
@Aspect
@Component
public class MethodCounterAspect {

    private final AtomicInteger counter = new AtomicInteger();

    @Before("@annotation(CountInvocations)")
    public void countMethodCall(JoinPoint jp) {

        int current = counter.incrementAndGet();

        System.out.println("[AOP - Counter] wywołanie zliczone");
    }

    public void printSummary(String methodName) {
        System.out.println("[AOP - Counter] " + methodName + " wywołano " + counter.get() + " razy.");
    }
}