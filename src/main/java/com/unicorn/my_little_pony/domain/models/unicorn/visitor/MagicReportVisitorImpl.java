package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Wizytator generujący raport JSON z mocy magicznej jednorożców
public class MagicReportVisitorImpl implements MagicReportVisitor {
    @Override
    public String visit(MagicUnicornReport report) {
        StringBuilder sb = new StringBuilder("{\n");
        for(int i=0;i<report.getSize();i++){
            String[] row = report.getData()[i];
            sb.append("\t{\n");
            sb.append("\t\t\"name\":\""+row[0]+"\";\n");
            sb.append("\t\t\"magicType\":\""+row[1]+"\";\n");
            sb.append("\t\t\"powerLevel\":"+row[2]+";\n");
            sb.append("\t}\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
//Koniec tydzień 6, wzorzec visitor