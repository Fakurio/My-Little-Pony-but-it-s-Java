package com.unicorn.my_little_pony.domain.models.unicorn.careTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 3
// Implementacja procesu przygotowania tęczowego jednorożca, definiująca kolorowe i błyszczące metody pielęgnacji oraz dekoracji, które odzwierciedlają jego radosną i magiczną naturę
public class RainbowUnicornPreparation extends UnicornPreparationTemplate {

    @Override
    public void cleanCoat() {
        System.out.println("The mane was washed with glitter rainbow shampoo.");
    }

    @Override
    public void polishHorn() {
        System.out.println("The horn was polished to a pearly shine.");
    }

    @Override
    public void decorateUnicorn() {
        System.out.println("Rainbow ribbons and delicate stardust added.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 3