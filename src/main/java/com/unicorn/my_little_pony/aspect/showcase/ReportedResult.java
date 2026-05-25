package com.unicorn.my_little_pony.aspect.showcase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 6
// Adnotacja oznacza metody, których wynik ma zostać opisany po zakończeniu.
// CampaignResultReportingAspect sprawdza, czy rezultat jest kolekcją, pustą
// wartością, czy zwykłym obiektem i wypisuje odpowiedni komunikat diagnostyczny.
// (klasa)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportedResult {
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 6