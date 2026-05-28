package com.unicorn.my_little_pony.aspect.audit.emptycollection;

import java.lang.annotation.*;
//Tydzien 11, Zastosowanie 7
// Adnotacja @CheckEmptyCollection oznacza metody zwracające kolekcje,
// dla których należy wykryć przypadek pustego wyniku.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEmptyCollection {
}