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
        ReturnSummary returnSummary = processReturn(unicorn);
        queueMaintenance(unicorn);
        return publishResult(unicorn, returnSummary);
    }

    private ReturnSummary processReturn(Unicorn unicorn) {
        boolean damaged = inspectionService.inspect();
        double fee = lateFeeService.calculateFee();
        statusService.updateStatus(unicorn);
        return new ReturnSummary(damaged, fee);
    }

    private void queueMaintenance(Unicorn unicorn) {
        maintenanceQueue.addJob(new FeedCommand(unicorn));
        maintenanceQueue.addJob(new BrushCommand(unicorn));
    }

    private String publishResult(Unicorn unicorn, ReturnSummary returnSummary) {
        String result = formatResult(unicorn, returnSummary);
        System.out.println(result);
        return result;
    }

    private String formatResult(Unicorn unicorn, ReturnSummary returnSummary) {
        return "Return completed for unicorn " + unicorn.getName() +
                ". Fee: " + returnSummary.fee() +
                " | Damaged: " + returnSummary.damaged();
    }

    private record ReturnSummary(boolean damaged, double fee) {
    }
}
//koniec Tydzień 4, Wzorzec Facade
