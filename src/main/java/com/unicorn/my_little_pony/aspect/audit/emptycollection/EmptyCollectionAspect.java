package com.unicorn.my_little_pony.aspect.audit.emptycollection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collection;
//Tydzien 11, Zastosowanie 7
// Aspekt wykrywający zwrócenie pustej kolekcji przez metody oznaczone
// adnotacją @CheckEmptyCollection i raportujący ten stan.
@Aspect
@Component
public class EmptyCollectionAspect {

    @AfterReturning(
            pointcut = "@annotation(CheckEmptyCollection)",
            returning = "result"
    )
    public void checkCollection(JoinPoint jp, Object result) {

        if (result instanceof Collection<?> collection) {

            if (collection.isEmpty()) {
                System.out.println(
                        "[AOP - EmptyCollection] "
                                + jp.getSignature().getName()
                                + " zwróciła pustą kolekcję."
                );
            }
        }
    }
}