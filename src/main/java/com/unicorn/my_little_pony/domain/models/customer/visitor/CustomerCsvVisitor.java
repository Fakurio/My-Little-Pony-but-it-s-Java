package com.unicorn.my_little_pony.domain.models.customer.visitor;

public class CustomerCsvVisitor implements CustomerReportVisitor {
// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Wizytator generujący raport w formacie CSV

    @Override
    public String visit(CustomerUnicornReport report) {
        StringBuilder sb = new StringBuilder("name,rank,rentals\n");

        for (int i = 0; i < report.getSize(); i++) {
            sb.append(report.getCustomerName(i)).append(",")
                    .append(report.getCustomerRank(i)).append(",")
                    .append(report.getRentalCount(i)).append("\n");
        }

        return sb.toString();
    }
}
//Koniec tydzien 6, wzorzec visitor
