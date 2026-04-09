package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Wizytator generujący raport JSON z danych customers
public class CustomerJsonVisitor implements CustomerReportVisitor {

    @Override
    public String visit(CustomerUnicornReport report) {
        StringBuilder sb = new StringBuilder("{\n");

        for (int i = 0; i < report.getSize(); i++) {
            String[] row = report.getData()[i];
            sb.append("\t{ \"name\": \"").append(row[0])
                    .append("\", \"rank\": \"").append(row[1])
                    .append("\", \"rentals\": ").append(row[2])
                    .append(" }\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
//Koniec tydzień 6, wzorzec visitor
