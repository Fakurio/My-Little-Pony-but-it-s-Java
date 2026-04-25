package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;
import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
//Fabryka przechowuje flyweighty w Map, jeżeli obiekt już istnieje, to zwraca go.
//Jeżeli nie ma obiektu, to tworzy nowy.
public class UnicornVariantFactory {

    private static final Map<String, UnicornVariantFlyweight> unicornVariants = new HashMap<>();

    public static UnicornVariantFlyweight getUnicornVariant(UnicornVariantConfig config) {

        String key = config.toKey();

        if (!unicornVariants.containsKey(key)) {

            unicornVariants.put(
                    key,
                    new ConcreteUnicornVariant(
                            config.getBreed(),
                            config.getHornStyle(),
                            config.getWingType(),
                            config.getManeColor(),
                            config.getMagicAura()
                    )
            );
        }

        return unicornVariants.get(key);
    }

    public static int getFlyweightCount() {
        return unicornVariants.size();
    }
}
// Koniec, Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
