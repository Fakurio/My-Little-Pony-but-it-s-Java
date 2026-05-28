package com.unicorn.my_little_pony.aspect.methodcounter;

import java.lang.annotation.*;
//Tydzien 11, Zastosowanie 8
// Adnotacja @CountInvocations oznacza metody, których wywołania
// mają być zliczane w celu analizy użycia funkcjonalności.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CountInvocations {
}
