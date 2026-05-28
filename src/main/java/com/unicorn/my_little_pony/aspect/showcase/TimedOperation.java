package com.unicorn.my_little_pony.aspect.showcase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 5
// Adnotacja oznacza metody, dla których chcemy mierzyć czas wykonania.
// Jest rozpoznawana przez CampaignTimingAspect, który otacza wywołanie,
// uruchamia metodę i po zakończeniu wypisuje czas trwania operacji.
// (klasa)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimedOperation {
}
// Koniec, Tydzień 11, Pro gramowanie Aspektowe (AOP), Zastosowanie 5