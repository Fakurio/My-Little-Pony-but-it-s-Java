package com.unicorn.my_little_pony.aspect.showcase;

// Tydzień 11, Programowanie Aspektowe, Zastosowanie 4
// Rekord przechowuje dane wejściowe dla scenariusza walidacji kampanii.
// Aspekt sprawdza na nim nazwę kampanii oraz wielkość docelowej grupy,
// zanim metoda uruchamiająca kampanię otrzyma możliwość dalszego działania.
public record CampaignRequest(String campaignName, int targetAudienceSize) {
}
// Koniec, Tydzień 11, Programowanie Aspektowe (AOP), Zastosowanie 4