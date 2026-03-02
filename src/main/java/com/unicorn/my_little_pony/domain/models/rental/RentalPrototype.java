package com.unicorn.my_little_pony.domain.models.rental;

import com.unicorn.my_little_pony.domain.models.rental.builders.RentalBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Tydzień 2, Wzorzec Prototype
// Klasa implementuje interfejs Cloneable, co pozwala na tworzenie kopii istniejących obiektów.
public class RentalPrototype implements Cloneable {

    private List<Rental> rentalList;

    public RentalPrototype() {
        this.rentalList = new ArrayList<>();
    }

    public RentalPrototype(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public void loadDefaultTemplates() {
        rentalList.add(new RentalBuilder()
                .unicornId("U1")
                .customerId("C1")
                .start(LocalDateTime.now())
                .end(LocalDateTime.now().plusHours(2))
                .basePrice(100)
                .finalPrice(100)
                .termsAccepted(true)
                .build());
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Rental> clonedRentalList = new ArrayList<>();

        this.getRentalList().forEach(rental -> {
            clonedRentalList.add(new Rental(
                    rental.getId(),
                    rental.getUnicornId(),
                    rental.getCustomerId(),
                    rental.getStart(),
                    rental.getEnd(),
                    rental.getBasePrice(),
                    rental.getFinalPrice(),
                    rental.isTermsAccepted()
            ));
        });

        return new RentalPrototype(clonedRentalList);
    }
}
// Koniec, Tydzień 2, Wzorzec Prototype