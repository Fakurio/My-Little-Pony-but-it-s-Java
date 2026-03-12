package com.unicorn.my_little_pony.domain.rules.composite;

// Tydzień 3, Wzorzec Composite, Zastosowanie 3
// Pojedyncza reguła walidacji wynajmu
public class LicenseRule implements Rule {

    private final boolean hasLicense;

    public LicenseRule(boolean hasLicense) {
        this.hasLicense = hasLicense;
    }

    @Override
    public boolean check() {
        return hasLicense;
    }
}
//Koniec, Tydzień 3, Wzorzec Composite, Zastosowanie 3