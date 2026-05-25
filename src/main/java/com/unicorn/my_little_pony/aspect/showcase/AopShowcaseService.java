package com.unicorn.my_little_pony.aspect.showcase;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
// Tydzień 11, Programowanie Aspektowe, Zastosowanie 4, 5, 6
// Klasa demonstracyjna zbiera trzy operacje wykorzystywane przez nowe aspekty.
// Jedna metoda służy do pomiaru czasu wykonania, druga przyjmuje request do
// walidacji, a trzecia zwraca wynik, który można raportować po wykonaniu.
public class AopShowcaseService {

    private static final int FEATURED_UNICORN_COUNT = 2;

    @TimedOperation
    public List<String> prepareCampaignMessages(List<Unicorn> unicorns, String campaignName) {
        return unicorns.stream()
                .map(unicorn -> String.format(
                        "%s promuje kampanię '%s' z mocą %d i oceną %.1f",
                        unicorn.getName(),
                        campaignName,
                        unicorn.getTotalPower(),
                        unicorn.getRating()))
                .toList();
    }

    @ValidatedCampaignRequest
    public String launchCampaign(CampaignRequest campaignRequest) {
        return String.format(
                "Kampania '%s' uruchomiona dla %d jednorożców.",
                campaignRequest.campaignName(),
                campaignRequest.targetAudienceSize());
    }

    @ReportedResult
    public List<String> buildFeaturedUnicornNames(List<Unicorn> unicorns) {
        return unicorns.stream()
                .sorted(Comparator.comparingInt(Unicorn::getTotalPower).reversed())
                .limit(FEATURED_UNICORN_COUNT)
                .map(Unicorn::getName)
                .toList();
    }
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 4, 5, 6