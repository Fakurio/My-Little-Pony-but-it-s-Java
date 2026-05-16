package com.unicorn.my_little_pony.domain.models.unicorn.proxies;

import com.unicorn.my_little_pony.database.RentalHistoryLoader;
import com.unicorn.my_little_pony.domain.models.rental.Rental;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

// Tydzień 4, Wzorzec Proxy, Zastosowanie 3
// Proxy pamięci podręcznej dla długiej operacji ładowania historii wypożyczeń jednorożca
@AllArgsConstructor
public class CachingRentalHistoryProxy implements RentalHistoryLoader {
    private final RentalHistoryLoader loader;
    private final Map<String, List<Rental>> cache = new HashMap<>();

    @Override
    public List<Rental> fetchRentalHistory(String unicornId) {
        if (cache.containsKey(unicornId)) {
            System.out.println("[CACHE HIT] Returning rental history instantly from memory!");
            return cache.get(unicornId);
        }

        System.out.println("[CACHE MISS] Data not in memory. Forwarding request to database...");
        List<Rental> historyData = loader.fetchRentalHistory(unicornId);
        cache.put(unicornId, historyData);

        return historyData;
    }
}
// Koniec, Tydzień 4, Wzorzec Proxy