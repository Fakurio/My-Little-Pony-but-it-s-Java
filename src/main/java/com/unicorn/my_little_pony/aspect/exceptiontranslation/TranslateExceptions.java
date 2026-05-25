package com.unicorn.my_little_pony.aspect.exceptiontranslation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 1
// Adnotacja @TranslateExceptions oznacza metody lub klasy, w których surowe wyjątki
// powinny być tłumaczone na wyjątki domenowe.
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TranslateExceptions {
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 1
