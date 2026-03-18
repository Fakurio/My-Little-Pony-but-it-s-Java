package com.unicorn.my_little_pony.domain.facades.returnprocess;

import com.unicorn.my_little_pony.domain.facades.returnprocess.services.UnicornStatusUpdateService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.DamageInspectionService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.LateFeeService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.RentalLookupService;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca proces zwrotu jednorożca.

public class UnicornReturnFacade {

    private RentalLookupService lookupService = new RentalLookupService();
    private DamageInspectionService inspectionService = new DamageInspectionService();
    private LateFeeService lateFeeService = new LateFeeService();
    private UnicornStatusUpdateService statusService = new UnicornStatusUpdateService();

    public String returnUnicorn(Unicorn unicorn) {

        boolean damaged = inspectionService.inspect();

        double fee = lateFeeService.calculateFee();

        statusService.updateStatus(unicorn);

        String result = "Return completed for unicorn " + unicorn.getName() +
                ". Fee: " + fee +
                " | Damaged: " + damaged;

        System.out.println(result);

        return result;
    }
}
//koniec Tydzień 4, Wzorzec Facade