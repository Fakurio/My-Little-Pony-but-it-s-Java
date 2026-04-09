package com.unicorn.my_little_pony.domain.models.rental.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 2
// Wizytator generujący raport JSON z wydarzeń i treningów jednorożców
public class EventReportVisitorImpl implements EventReportVisitor {
    @Override
    public String visit(UnicornEventReport report){
        StringBuilder sb = new StringBuilder("{\n");
        for(int i=0;i<report.getSize();i++){
            String[] row = report.getData()[i];
            sb.append("\t{\n");
            sb.append("\t\t\"event\":\""+row[0]+"\";\n");
            sb.append("\t\t\"date\":\""+row[1]+"\";\n");
            sb.append("\t\t\"participants\":"+row[2]+";\n");
            sb.append("\t}\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
//Koniec tydzień 6, wzorzec visitor