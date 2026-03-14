package com.unicorn.my_little_pony.domain.models.unicorn.flyweight;
import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Flyweight, Zastosowanie 1
//Fabryka przechowuje flyweighty w Map, jeżeli obiekt już istnieje, to zwraca go.
//Jeżeli nie ma obiektu, to tworzy nowy.
public class UnicornVariantFactory {

    private static final Map<String, UnicornVariantFlyweight> unicornVariants = new HashMap<>();

    public static UnicornVariantFlyweight getUnicornVariant(
            String breed,
            String hornStyle,
            String wingType,
            String maneColor,
            String magicAura) {

        String key = breed + "_" + hornStyle + "_" + wingType + "_" + maneColor + "_" + magicAura;

        if (!unicornVariants.containsKey(key)) {

            unicornVariants.put(
                    key,
                    new ConcreteUnicornVariant(
                            breed,
                            hornStyle,
                            wingType,
                            maneColor,
                            magicAura
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
