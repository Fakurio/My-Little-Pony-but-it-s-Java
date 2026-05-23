package com.unicorn.my_little_pony.aspect.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
// Adnotacja @Auditable oznacza metody, których pomyślne wykonanie powinno zostać
// zarejestrowane w dzienniku audytu.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditable {
}
// Koniec, Tydzień 11, Programowanie Aspektowe, Zastosowanie 3
