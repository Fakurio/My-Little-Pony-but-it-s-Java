package com.unicorn.my_little_pony.domain.models.rental.template.dataDriven;

// Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)
// Typ wyliczeniowy reprezentujący możliwe kroki procesu wypożyczenia.
// Każda wartość odpowiada jednemu etapowi logiki biznesowej.
public enum RentalStepType {
    VALIDATE_CUSTOMER,
    CHOOSE_UNICORN,
    CALCULATE_PRICE,
    PREPARE_AGREEMENT,
    RELEASE_UNICORN,
    SEND_NOTIFICATION
}
// Koniec, Tydzień 7, Zasada otwarte-zamknięte, Zastosowanie 2 (przez sterowanie danymi)