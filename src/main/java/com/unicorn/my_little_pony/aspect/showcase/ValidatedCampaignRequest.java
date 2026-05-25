package com.unicorn.my_little_pony.aspect.showcase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 4
// Adnotacja oznacza metody, które wymagają weryfikacji pierwszego argumentu.
// CampaignValidationAspect odczytuje CampaignRequest z wywołania i sprawdza,
// czy dane wejściowe spełniają minimalne warunki przed wykonaniem metody.
// (klasa)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatedCampaignRequest {
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 4