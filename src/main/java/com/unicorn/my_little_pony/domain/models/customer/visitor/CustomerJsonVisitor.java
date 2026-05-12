package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Wizytator generujący raport JSON z danych customers
public class CustomerJsonVisitor implements CustomerReportVisitor {

    @Override
    public String visit(CustomerUnicornReport report) {
        StringBuilder sb = new StringBuilder("{\n");

        for (int i = 0; i < report.getSize(); i++) {
            sb.append("\t{ \"name\": \"").append(report.getCustomerName(i))
                    .append("\", \"rank\": \"").append(report.getCustomerRank(i))
                    .append("\", \"rentals\": ").append(report.getRentalCount(i))
                    .append(" }\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
//Koniec tydzień 6, wzorzec visitor
