package com.unicorn.my_little_pony.domain.pricing;

import com.unicorn.my_little_pony.domain.pricing.strategies.magicFee.MagicFeeStrategy;

//Tydzień 7, OCP przez abstrakcje
// Klasa jest zamknięta na modyfikację -> nie wymaga ingerencji kiedy dodamy nową opłatę magiczną
// Klasa jest otwarta na rozbudowę -> wystarczy przekazać nową strategię obliczania opłaty jako parametr metody
public class MagicFeeAbstractCalculator {
    public double calculate(MagicFeeStrategy strategy, double basePrice) {
        return strategy.applyFee(basePrice);
    }
}
// Koniec, Tydzień 7, OCP przez abstrakcje
