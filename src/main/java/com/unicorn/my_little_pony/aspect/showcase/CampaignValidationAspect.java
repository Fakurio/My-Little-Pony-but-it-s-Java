package com.unicorn.my_little_pony.aspect.showcase;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 4
// Aspekt sprawdza poprawność danych wejściowych przed uruchomieniem kampanii.
// Oczekuje obiektu CampaignRequest jako pierwszego argumentu metody i odrzuca
// puste nazwy kampanii oraz niepoprawną liczebność grupy docelowej.
@Aspect
@Component
public class CampaignValidationAspect {

    private static final int MINIMUM_VALID_AUDIENCE_SIZE = 1;

    @Before("@annotation(validatedCampaignRequest)")
    public void validateCampaignRequest(JoinPoint joinPoint, ValidatedCampaignRequest validatedCampaignRequest) {
        Object[] arguments = joinPoint.getArgs();
        if (arguments.length == 0 || !(arguments[0] instanceof CampaignRequest request)) {
            throw new IllegalStateException("Oczekiwano obiektu CampaignRequest jako pierwszego argumentu.");
        }

        if (request.campaignName() == null || request.campaignName().isBlank()) {
            throw new IllegalArgumentException("Nazwa kampanii nie może być pusta.");
        }

        if (request.targetAudienceSize() < MINIMUM_VALID_AUDIENCE_SIZE) {
            throw new IllegalArgumentException("Liczba docelowych jednorożców musi być dodatnia.");
        }

        System.out.println("[AOP - Validation] Kampania " + request.campaignName()
                + " przeszła walidację dla " + request.targetAudienceSize() + " jednorożców.");
    }
}
    // Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 4