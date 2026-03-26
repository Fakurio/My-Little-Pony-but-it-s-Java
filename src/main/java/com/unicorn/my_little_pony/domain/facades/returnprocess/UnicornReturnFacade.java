package com.unicorn.my_little_pony.domain.facades.returnprocess;

import com.unicorn.my_little_pony.domain.facades.returnprocess.services.UnicornStatusUpdateService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.DamageInspectionService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.LateFeeService;
import com.unicorn.my_little_pony.domain.facades.returnprocess.services.RentalLookupService;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.BrushCommand;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.FeedCommand;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;

// Tydzień 4, Wzorzec Facade
// Fasada upraszczająca proces zwrotu jednorożca.

public class UnicornReturnFacade {

    private final RentalLookupService lookupService = new RentalLookupService();
    private final DamageInspectionService inspectionService = new DamageInspectionService();
    private final LateFeeService lateFeeService = new LateFeeService();
    private final UnicornStatusUpdateService statusService = new UnicornStatusUpdateService();
    private final MaintenanceQueue maintenanceQueue = new MaintenanceQueue();

    public String returnUnicorn(Unicorn unicorn) {
        boolean damaged = inspectionService.inspect();
        double fee = lateFeeService.calculateFee();
        statusService.updateStatus(unicorn);

        // Tydzień 5, Wzorzec Command, Zastosowanie 2
        // Dodanie konkretnych zadań do kolejki
        maintenanceQueue.addJob(new FeedCommand(unicorn));
        maintenanceQueue.addJob(new BrushCommand(unicorn));
        // Koniec, Tydzień 5, Wzorzec Command

        String result = "Return completed for unicorn " + unicorn.getName() +
                ". Fee: " + fee +
                " | Damaged: " + damaged;

        System.out.println(result);

        return result;
    }
}
//koniec Tydzień 4, Wzorzec Facade