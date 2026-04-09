package com.unicorn.my_little_pony.domain.models.customer.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 3
// Wizytator generujący raport JSON z danych customers
public class CustomerReportVisitorImpl implements CustomerReportVisitor {
    @Override
    public String visit(CustomerUnicornReport report) {
        StringBuilder sb = new StringBuilder("{\n");
        for(int i=0;i<report.getSize();i++){
            String[] row = report.getData()[i];
            sb.append("\t{\n");
            sb.append("\t\t\"customer_name\":\""+row[0]+"\";\n");
            sb.append("\t\t\"rank\":\""+row[1]+"\";\n");
            sb.append("\t\t\"rentals\":"+row[2]+";\n");
            sb.append("\t}\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
//Koniec tydzień 6, wzorzec visitor
