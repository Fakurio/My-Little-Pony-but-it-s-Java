package com.unicorn.my_little_pony.aspect.vipaccess;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
// Adnotacja @VipOnly oznacza metody, do których dostęp powinien być ograniczony wyłącznie
// do klientów VIP.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VipOnly {
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 2
