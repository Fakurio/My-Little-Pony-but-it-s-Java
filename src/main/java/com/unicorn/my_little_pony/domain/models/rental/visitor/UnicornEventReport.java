package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Raport przechowujący dane o wydarzeniach i treningach jednorożców
public class UnicornEventReport implements EventReportable {
    private String[][] eventsData;
    public UnicornEventReport(String[][] data){ this.eventsData = data; }
    public String[][] getData(){ return eventsData; }
    public int getSize(){ return eventsData.length; }

    @Override
    public String accept(EventReportVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec tydzień 6, wzorzec visitor
