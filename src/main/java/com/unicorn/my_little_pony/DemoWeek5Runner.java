package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.facades.rental.UnicornRentalFacade;
import com.unicorn.my_little_pony.domain.facades.returnprocess.MaintenanceQueue;
import com.unicorn.my_little_pony.domain.models.rental.mementos.RentalApplication;
import com.unicorn.my_little_pony.domain.models.rental.mementos.SessionCache;
import com.unicorn.my_little_pony.domain.models.unicorn.commands.*;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.Equipment;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.RainbowSaddle;
import com.unicorn.my_little_pony.domain.models.unicorn.equipment.TitaniumArmor;
import com.unicorn.my_little_pony.domain.models.unicorn.memento.LoadoutManager;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.WaterUnicorn;
import com.unicorn.my_little_pony.domain.pricing.PricingConfig;
import com.unicorn.my_little_pony.domain.store.UnicornCart;
import com.unicorn.my_little_pony.enums.UnicornStatus;
import com.unicorn.my_little_pony.util.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek5Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 5: Command + Interpreter + Iterator + Mediator + Memento ");
        System.out.println("===========================================================");
        System.out.println();
        demoCommand();
        demoInterpreter();
        demoIterator();
        demoMediator();
        demoMemento();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoCommand() {
        System.out.println("=========================");
        System.out.println("Command");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Equipment command");

        Unicorn blaze = new FireUnicorn("1", "Blaze", "Red", 100);
        UnicornCart cart = new UnicornCart();

        Equipment saddle = new RainbowSaddle();
        Equipment armor = new TitaniumArmor();

        System.out.println("Client add saddle to cart ...");
        cart.addEquipment(new EquipCommand(blaze, saddle));

        System.out.println("Client add armor to cart ...");
        cart.addEquipment(new EquipCommand(blaze, armor));

        System.out.println("Current equipment: " + blaze.getEquipment().getDescription());
        System.out.println("\nClient clicks 'Undo'...");
        cart.undoLastAction();
        System.out.println("Current equipment: " + blaze.getEquipment().getDescription());
        System.out.println("\nClient clicks 'Undo'...");
        cart.undoLastAction();
        System.out.println("Current equipment: " + blaze.getEquipment().getDescription());


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Maintenance command queue");

        UnicornRentalFacade rentalFacade = new UnicornRentalFacade();
        Unicorn splash = new WaterUnicorn(IdGenerator.getInstance().nextUnicornId(), "Splash", "Blue", 80);
        rentalFacade.rentUnicorn(splash, IdGenerator.getInstance().nextCustomerId());
        MaintenanceQueue queue = new MaintenanceQueue();

        System.out.println("Client returns water unicorn: " + splash);
        System.out.println("UnicornReturnFacade delegate commands to background queue...");
        queue.addJob(new FeedCommand(splash));
        queue.addJob(new BrushCommand(splash));
        queue.processAll();


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Transaction command");

        Unicorn starlight = new LightningUnicorn(IdGenerator.getInstance().nextUnicornId(), "Starlight", "White", 50);
        System.out.println("Unicorn status: " + starlight.getStatus());
        TransactionMacro transaction = new TransactionMacro();

        try {
            System.out.println("\nUnicorn renting process starts...");
            Command lockCommand = new ChangeStatusCommand(starlight, UnicornStatus.RENTED);
            transaction.executeCommand(lockCommand);
            System.out.println("Unicorn status during transaction: " + starlight.getStatus());

            System.out.println("Moving to payment step...");
            System.out.println("CRITICAL ERROR: Payment database is dead!!!");
            throw new RuntimeException("Database connection failed!");
        } catch (Exception e) {
            System.out.println("Rolling back transaction...");
            transaction.undo();
        }
        System.out.println("\nUnicorn status after error: " + starlight.getStatus());
    }

    private void demoInterpreter() {}

    private void demoIterator() {}

    private void demoMediator() {}

    private void demoMemento() {
        System.out.println("=========================");
        System.out.println("Memento");
        System.out.println("=========================");
        System.out.println("Zastosowanie 1: Unicorn equipment loadout");

        Unicorn blaze = new FireUnicorn("1", "Blaze", "Red", 100);
        LoadoutManager loadoutManager = new LoadoutManager();

        System.out.println("Client prepare future battle build");
        blaze.setEquipment(new TitaniumArmor());
        Unicorn.UnicornMemento battleBuild = blaze.saveLoadout();
        loadoutManager.saveFavorite("MyBattleBuild", battleBuild);

        System.out.println("\nClient is going for peaceful walk");
        blaze.setEquipment(new RainbowSaddle());
        System.out.println("Current equipment: " + blaze.getEquipment().getDescription());

        System.out.println("\nSudden battle breaks out. Client loads previously saved battle build");
        blaze.restoreLoadout(loadoutManager.getFavorite("MyBattleBuild"));
        System.out.println("Current equipment: " + blaze.getEquipment().getDescription());


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 2: Rental application draft");

        System.out.println("Client start filling rental application form...");
        RentalApplication app = new RentalApplication();
        SessionCache sessionCache = new SessionCache();
        app.setUnicornId(IdGenerator.getInstance().nextUnicornId());
        app.setCustomerId(IdGenerator.getInstance().nextCustomerId());
        System.out.println("Form state: " + app);

        System.out.println("\nUser closes browser by accident. Form draft is saved in background...");
        sessionCache.save(app.saveDraft());

        app = new RentalApplication();
        System.out.println("Fresh form after opening browser: " + app);
        System.out.println("\nForm draft found in cache. Restoring...");

        app.restoreDraft(sessionCache.getDraft());
        System.out.println("Form state: " + app);


        System.out.println("-------------------------");
        System.out.println("Zastosowanie 3: Price config backup");

        PricingConfig config = PricingConfig.getInstance();
        System.out.println("Price config state: ");
        config.printConfig();

        System.out.println("\nAdmin creates restoration point...");
        PricingConfig.PricingConfigMemento backup = config.saveState();

        System.out.println("\nAdmin sets wrong data...");
        config.setBasePricePerHour(0);
        config.setRainbowPriceRaise(-1);
        config.printConfig();

        System.out.println("\nAdmin clicks restore data...");
        config.restoreState(backup);
        config.printConfig();
    }
}
