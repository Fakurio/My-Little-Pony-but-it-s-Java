package com.unicorn.my_little_pony.domain.models.unicorn.careTemplate;

// Tydzień 6, Wzorzec Template, Zastosowanie 3
// Implementacja procesu przygotowania leśnego jednorożca, definiująca metody pielęgnacji i dekoracji, które odzwierciedlają jego związek z naturą
public class ForestUnicornPreparation extends UnicornPreparationTemplate {

    @Override
    public void cleanCoat() {
        System.out.println("The coat was gently cleansed with natural herbs.");
    }

    @Override
    public void polishHorn() {
        System.out.println("The horn was preserved with a natural protective resin.");
    }

    @Override
    public void decorateUnicorn() {
        System.out.println("Leaf and forest flower decorations added.");
    }
}
// Koniec, Tydzień 6, Wzorzec Template, Zastosowanie 3