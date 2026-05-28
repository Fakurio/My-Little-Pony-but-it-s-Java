package com.unicorn.my_little_pony.aspect.audit.powermonitoring;

import java.lang.annotation.*;
//Tydzien 11, Zastosowanie 9
// Adnotacja @MonitorPowerLevel oznacza metody zwracające listę jednorożców,
// których poziom mocy powinien być analizowany po wykonaniu.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MonitorPowerLevel {
}