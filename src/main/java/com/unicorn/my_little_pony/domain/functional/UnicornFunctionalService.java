package com.unicorn.my_little_pony.domain.functional;

import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UnicornFunctionalService {

    public List<Unicorn> findMatchingUnicorns(List<Unicorn> unicorns, Predicate<Unicorn> unicornRule) {
        return unicorns.stream()
                .filter(unicornRule)
                .sorted(Comparator.comparingDouble(Unicorn::getRating).reversed())
                .toList();
    }

    public List<String> prepareRecommendationCards(
            List<Unicorn> unicorns,
            Predicate<Unicorn> unicornRule,
            Function<Unicorn, String> cardFormatter
    ) {
        return findMatchingUnicorns(unicorns, unicornRule).stream()
                .map(cardFormatter)
                .toList();
    }
}
