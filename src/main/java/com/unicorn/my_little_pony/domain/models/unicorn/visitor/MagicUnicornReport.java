package com.unicorn.my_little_pony.domain.models.unicorn.visitor;

// Tydzień 6, Wzorzec Visitor, Zastosowanie 1
// Raport przechowujący dane o mocy magicznej jednorożców
public class MagicUnicornReport implements MagicReportable {
    private String[][] magicData; // [0]=name, [1]=magicType, [2]=powerLevel
    public MagicUnicornReport(String[][] data) { this.magicData = data; }
    public String[][] getData() { return magicData; }
    public int getSize() { return magicData.length; }

    @Override
    public String accept(MagicReportVisitor visitor) {
        return visitor.visit(this);
    }
}
//Koniec tydzień 6, wzorzec visitor