package com.unicorn.my_little_pony.domain.store;

import com.unicorn.my_little_pony.domain.models.Unicorn;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

//Tydzień 2, Wzorzec Singleton 3 (William Pugh)
//Magazyn jednorożców musi być jeden. Gdyby powstały dwie instancje, część systemu widziałaby
//inne jednorożce niż reszta.
public final class UnicornStore {

    private final Map<String, Unicorn> unicorns = new ConcurrentHashMap<>();

    private UnicornStore(){};

    private static class UnicornStoreHelper {
        private static final UnicornStore instance = new UnicornStore();
    }

    public static UnicornStore getInstance() {
        return UnicornStoreHelper.instance;
    }

    public void add(Unicorn u) {
        Objects.requireNonNull(u);
        unicorns.put(u.getId(), u);
    }

    public Optional<Unicorn> getById(String id) {
        return Optional.ofNullable(unicorns.get(id));
    }

    public List<Unicorn> findAll() {
        return List.copyOf(unicorns.values());
    }

    public void remove(String id) {
        unicorns.remove(id);
    }
}
//Koniec, Tydzień 2, Wzorzec Singleton 3