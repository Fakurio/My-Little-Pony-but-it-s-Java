package com.unicorn.my_little_pony;

import com.unicorn.my_little_pony.domain.models.customer.Customer;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.DeliveryManager;
import com.unicorn.my_little_pony.domain.models.unicorn.strategies.unicornDelivery.TeleportationDeliveryStrategy;
import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.LightningUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.pricing.MagicFeeAbstractCalculator;
import com.unicorn.my_little_pony.domain.pricing.MagicFeeDDCalculator;
import com.unicorn.my_little_pony.domain.pricing.strategies.magicFee.FireMagicFee;
import com.unicorn.my_little_pony.domain.pricing.strategies.magicFee.WaterMagicFee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoWeek7Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n");
        System.out.println("===========================================================");
        System.out.println("  DEMO TYDZIEŃ 7: SRP + OCP ");
        System.out.println("===========================================================");
        System.out.println();
        demoSRP();
        demoOCP();
        System.out.println();
        System.out.println("===========================================================");
    }

    private void demoSRP() {
        System.out.println("=========================");
        System.out.println("SRP");
        System.out.println("=========================");

        DeliveryManager deliveryManager = new DeliveryManager();
        Unicorn inferno =  new FireUnicorn("1", "Inferno", "Red", 100);
        Customer vipCustomer = new Customer("C-1", "Princess Celestia",
                "princess@gmail.com", "111111111", true);
        Customer customer = new Customer("C-2", "Tony", "tony@gmail.com", "222222222", false);
        deliveryManager.arrangeDelivery(new TeleportationDeliveryStrategy(), inferno, vipCustomer);
        deliveryManager.arrangeDelivery(new TeleportationDeliveryStrategy(), inferno, customer);
    }

    private void demoOCP() {
        System.out.println("=========================");
        System.out.println("OCP");
        System.out.println("=========================");

        System.out.println("Obliczanie opłaty magicznej - przez abstrakcje");
        MagicFeeAbstractCalculator abstractCalculator = new MagicFeeAbstractCalculator();
        int basePrice = 100;
        System.out.println("Opłata bazowa: " + basePrice);
        System.out.println("Opłata za ognistą magie: " + abstractCalculator.calculate(new FireMagicFee(), basePrice));
        System.out.println("Opłata za wodną magie: " + abstractCalculator.calculate(new WaterMagicFee(), basePrice));
        System.out.println("-------------------------");

        System.out.println("Obliczanie opłaty magicznej - przez sterowanie danymi");
        MagicFeeDDCalculator ddCalculator = new MagicFeeDDCalculator();
        System.out.println("Opłata bazowa: " + basePrice);
        System.out.println("Opłata za ognistą magie: " + ddCalculator.calculate("Fire", basePrice));
        System.out.println("Opłata za wodną magie: " + ddCalculator.calculate("Water", basePrice));
    }
}
