package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Raport przechowujący dane o customers szkółki jednorożców
public class CustomerUnicornReport implements CustomerReportable {
    private String[][] customersData;
    public CustomerUnicornReport(String[][] data) { this.customersData = data; }
    public String[][] getData() { return customersData; }
    public int getSize() { return customersData.length; }

    @Override
    public String accept(CustomerReportVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec tydzień 6, wzorzec visitor