# 📄 Dokumentacja
## 📅 Tydzień 2

---

## Factory Design Pattern


### Simple Factory (Prosta Fabryka)
Wzorzec projektowy prosta fabryka został użyty do tworzenia obiektów powiadomień.

* **Klasa fabryki:** `domain.models.notification.NotificationFactory`
* **Klasy konkretnych powiadomień:** `domain.models.notification.types`

### Abstract Factory (Fabryka Abstrakcyjna)
Wzorzec ten został użyty do tworzenia powiązanego zestawu obiektów wchodzących w skład planu cenowego. W skład tego zestawu wchodzą: obiekt polisy anulowania wypożyczenia oraz cennik wypożyczenia.

* **Klasy fabryk:** `domain.pricing.policies`
* **Klasy konkretnych polis anulowania wypożyczenia :** `domain.pricing.policies.cancellation`
* **Klasy konkretnych cenników :** `domain.pricing.policies.pricing`

### Factory Method (Metoda Fabrykująca)
Wzorzec metoda fabrykująca został użyty do tworzenia obiektów konkretnych typów jednorożców. W obecnym systemie dostępna jest fabryka dla ognistych oraz wodnych jednorożców.

* **Klasy fabryk:** `domain.models.unicorn.factories`
* **Klasy konkretnych jednorożców:** `domain.models.unicorn.types`


## Singleton Design Pattern

### Eager Initialization
Konfiguracja cen globalna dla całego systemu. Nie ma sensu tworzyć wielu instancji konfiguracji, bo wartości powinny być jednolite w całej aplikacji.
* **Klasa:** `domain.pricing.PricingConfig`

### Thread-safe synchronized
Identyfikatory obiektów (Unicorn, Customer, Rental) muszą być unikalne w obrębie całej aplikacji. Zapewnia istnienie jednego, wspólnego źródła generowania ID, co eliminuje niespójności danych
* **Klasa:** `util.IdGenetaror`

### William Pugh
Magazyn jednorożców musi być jeden. Gdyby powstały dwie instancje, część systemu widziałaby inne jednorożce niż reszta.
* **Klasa:** `domain.store.UnicornStore`



## 📅 Tydzień 3

---

## Bridge Design Pattern

### Bridge - Ekwipunek Jednorożca
Wzorzec projektowy Most został użyty do oddzielenia klas jednorożców (abstrakcja) od ich wyposażenia (implementacja). 

* **Klasy abstrakcji (Jednorożce):** `domain.models.unicorn.types`
* **Klasy implementacji (Rodzaje Ekwipunku):** `domain.models.unicorn.equipment`

### Bridge - Plany Cenowe
Wzorzec ten został również zastosowany do oddzielenia logiki planów zniżkowych (np. Standard, VIP) od silników obliczających bazowy koszt czasu wypożyczenia (np. godzinowy, dzienny).

* **Klasy abstrakcji (Plany Cenowe):** `domain.pricing.plans`
* **Klasy implementacji (Silniki Obliczeniowe):** `domain.pricing.engines`

### Bridge - Powiadomienia
Trzecie zastosowanie wzorca Bridge oddziela rodzaj powiadomienia (np. potwierdzenie rezerwacji, potwierdzenie płatności) od kanału jej dostarczenia (np. Facebook, Instragram).

* **Klasy abstrakcji (Typy Powiadomień):** `domain.models.notification.notifiers`
* **Klasy implementacji (Kanały Social media):** `domain.models.notification.channels`