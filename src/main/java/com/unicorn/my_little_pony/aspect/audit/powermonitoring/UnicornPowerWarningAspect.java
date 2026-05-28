package com.unicorn.my_little_pony.aspect.audit.powermonitoring;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
//Tydzien 11, Zastosowanie 9
// Aspekt analizujący poziom mocy jednorożców zwróconych przez metody
// oznaczone @MonitorPowerLevel i generujący ostrzeżenia dla bardzo silnych jednostek.
public class UnicornPowerWarningAspect {
    int highPowerLevel=100;
    @AfterReturning(
            pointcut = "@annotation(MonitorPowerLevel)",
            returning = "result"
    )
    public void checkPowerLevels(Object result) {

        if (result instanceof List<?> unicorns) {

            for (Object obj : unicorns) {

                if (obj instanceof Unicorn unicorn) {

                    if (unicorn.getTotalPower() > highPowerLevel) {

                        System.out.println(
                                "[AOP - PowerWarning] "
                                        + unicorn.getName()
                                        + " ma bardzo wysoki poziom mocy!"
                        );
                    }
                }
            }
        }
    }
}