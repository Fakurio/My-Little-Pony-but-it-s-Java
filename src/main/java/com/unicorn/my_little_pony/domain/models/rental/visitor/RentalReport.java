package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Klasa reprezentująca pojedyncze wypożyczenie jednorożca

public class RentalReport implements RentalReportable {

    private String unicornName;
    private int hours;

    public RentalReport(String unicornName, int hours) {
        this.unicornName = unicornName;
        this.hours = hours;
    }

    public String getUnicornName() {
        return unicornName;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String accept(RentalVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec tydzień 6, wzorzec visitor
