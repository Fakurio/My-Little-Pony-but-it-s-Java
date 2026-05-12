package com.unicorn.my_little_pony.integration.transport;

import com.unicorn.my_little_pony.domain.exceptions.TransportUnavailableException;
import com.unicorn.my_little_pony.integration.inventory.StoreAvailabilityAdapter;
import com.unicorn.my_little_pony.integration.inventory.UnicornAvailabilityService;

//Tydzień 3, Wzorzec Adapter 2 (przez kompozycję)
//Adapter, który implementuje interfejs UnicornTransportService i korzysta z ExternalTransportSystem
//do realizacji zamówień transportu dla jednorożców. Dodatkowo sprawdzana dostępność jednorożca przed zamówieniem transportu
public class TransportAdapter implements UnicornTransportService {
    private ExternalTransportSystem externalTransportSystem = new ExternalTransportSystem();
    private UnicornAvailabilityService availabilityService = new StoreAvailabilityAdapter();

    @Override
    public void scheduleTransport(String unicornId, String unicornName, String destination) {
        ensureUnicornIsAvailable(unicornId);
        bookExternalTransport(unicornId, unicornName, destination);
    }

    private void ensureUnicornIsAvailable(String unicornId) {
        if (!availabilityService.isAvailable(unicornId)) {
            throw new TransportUnavailableException(unicornId);
        }
    }

    private void bookExternalTransport(String unicornId, String unicornName, String destination) {
        System.out.println("[Adapter] Transport: Unicorn " + unicornId + " is available, scheduling transport...");
        externalTransportSystem.bookRide(formatAnimalDescription(unicornId, unicornName), destination);
    }

    private String formatAnimalDescription(String unicornId, String unicornName) {
        return "UNICORN: " + unicornName + " (ID: " + unicornId + ")";
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 2
