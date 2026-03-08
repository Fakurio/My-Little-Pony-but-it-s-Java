package com.unicorn.my_little_pony.integration.transport;

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
        // Sprawdzamy czy jednorożec jest dostępny przed zamówieniem transportu
        if (!availabilityService.isAvailable(unicornId)) {
            System.out.println("Transport Adapter: Cannot schedule transport - unicorn with ID " 
                + unicornId + " is not available!");
            return;
        }
        System.out.println("[Adapter] Transport: Unicorn " + unicornId + " is available, scheduling transport...");
        String animalDescription = "UNICORN: " + unicornName + " (ID: " + unicornId + ")";
        externalTransportSystem.bookRide(animalDescription, destination);
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 2