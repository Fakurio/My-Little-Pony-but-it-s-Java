package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Klasa przechowująca dane o klientach, które będą przetwarzane przez wizytatorów
public class CustomerUnicornReport implements CustomerReportable {
    private static final int CUSTOMER_NAME_INDEX = 0;
    private static final int CUSTOMER_RANK_INDEX = 1;
    private static final int RENTAL_COUNT_INDEX = 2;

    private String[][] customersData;
    public CustomerUnicornReport(String[][] customerRows) { this.customersData = customerRows; }
    public String[][] getData() { return customersData; }
    public int getSize() { return customersData.length; }

    public String getCustomerName(int rowIndex) {
        return customersData[rowIndex][CUSTOMER_NAME_INDEX];
    }

    public String getCustomerRank(int rowIndex) {
        return customersData[rowIndex][CUSTOMER_RANK_INDEX];
    }

    public String getRentalCount(int rowIndex) {
        return customersData[rowIndex][RENTAL_COUNT_INDEX];
    }

    @Override
    public String accept(CustomerReportVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec tydzień 6, wzorzec visitor
