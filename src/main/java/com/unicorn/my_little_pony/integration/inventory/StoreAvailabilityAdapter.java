package com.unicorn.my_little_pony.integration.inventory;
import com.unicorn.my_little_pony.domain.store.UnicornStore;

//Tydzień 3, Wzorzec Adapter 3 (przez kompozycję)
//Klasa, która implementuje interfejs UnicornAvailabilityService i korzysta z UnicornStore, aby sprawdzić dostępność jednorożca.
//Adapter tłumaczy wywołania isAvailable na format zrozumiały dla UnicornStore.
public class StoreAvailabilityAdapter implements UnicornAvailabilityService {

    private UnicornStore unicornStore = UnicornStore.getInstance();

    @Override
    public boolean isAvailable(String unicornId) {
        System.out.println("[Adapter] Checking unicorn availability in UnicornStore for id: " + unicornId);
        return unicornStore.getById(unicornId).isPresent();
    }
}
//Koniec, Tydzień 3, Wzorzec Adapter 3