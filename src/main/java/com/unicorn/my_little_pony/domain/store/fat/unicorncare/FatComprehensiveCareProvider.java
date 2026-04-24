package com.unicorn.my_little_pony.domain.store.fat.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Fat implementation implementuje wszystko naraz
public class FatComprehensiveCareProvider implements ComprehensiveUnicornCare {

    @Override
    public void groom(String unicornId) {
        System.out.println("[FAT CARE] Grooming unicorn " + unicornId);
    }

    @Override
    public void bath(String unicornId) {
        System.out.println("[FAT CARE] Bathing unicorn " + unicornId);
    }

    @Override
    public void checkHealth(String unicornId) {
        System.out.println("[FAT CARE] Checking health of unicorn " + unicornId);
    }

    @Override
    public void treatInjury(String unicornId, String injury) {
        System.out.println("[FAT CARE] Treating " + injury + " on unicorn " + unicornId);
    }

    @Override
    public void trainBasics(String unicornId) {
        System.out.println("[FAT CARE] Training basics for unicorn " + unicornId);
    }

    @Override
    public void trainAdvanced(String unicornId) {
        System.out.println("[FAT CARE] Training advanced skills for unicorn " + unicornId);
    }

    @Override
    public String getReport(String unicornId) {
        return "Full care report for " + unicornId;
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

