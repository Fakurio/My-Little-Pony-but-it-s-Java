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

## Decorator Design Pattern
### Decorator - Ulepszenia do wypożyczenia jednorożca
Wzorzec dekorator został użyty do dynamicznego dodawania nowych właściwości jednorożców.
* **Interfejs komponentu:** `domain.models.unicorn.unicornAddOns.UnicornRental`
* **Konkretny komponent bez dekoratora:** `domain.models.unicorn.unicornAddOns.BasicUnicornRental`
* **Abstrakcyjna klasa dekoratora:** `domain.models.unicorn.unicornAddOns.UnicornRentalDecorator`
* **Konkretne dekoratory:** `domain.models.unicorn.unicornAddOns.WingPolishDecorator`, `domain.decorators.unicornAddOns.RainbowManeDecorator`, `domain.decorators.unicornAddOns.GlitterDecorator`

### Decorator - Poziomy wsparcia klienta
Zastosowano do dodawania dodatkowych usług do wsparcia klienta.
* **Interfejs komponentu:** `domain.models.support.CustomerSupport`
* **Konkretny komponent bez dekoratora:** `domain.models.support.NoSupport`
* **Abstrakcyjna klasa dekoratora:** `domain.models.support.SupportDecorator`
* **Konkretne dekoratory:** `domain.models.support.StandardSupport`, `domain.decorators.support.PrioritySupport`, `domain.decorators.support.TwentyFourHourCaretaker`

### Decorator - Poziomy ubecpieczenia
Wzorzec ten został użyty do dodawania kolejnych warstw ochrony do polisy ubezpieczeniowej, np. od kradzieży, od warunków pogodowych itp.
* **Interfejs komponentu:** `domain.models.insurance.RentalInsurance`
* **Konkretny komponent bez dekoratora:** `domain.models.insurance.NoInsurance`
* **Abstrakcyjna klasa dekoratora:** `domain.models.insurance.InsuranceDecorator`
* **Konkretne dekoratory:** `domain.models.insurance.BasicInsurance`, `domain.decorators.insurance.ExtendedInsurance`, `domain.decorators.insurance.ExtremeWeatherCoverage`

## Adapter Design Pattern
### Adapter - Integracja z systemem płatności
Wzorzec adapter został użyty do integracji z zewnętrznym systemem płatności. Adapter tłumaczy interfejs oczekiwany przez naszą aplikację na format wymagany przez zewnętrzną usługę płatności.
* **Interfejs oczekiwany przez aplikację:** `integration.payment.PaymentService`
* **Interfejs zewnętrznej usługi płatności:** `integration.payment.ExternalPaymentGateway`
* **Klasa Adaptera:** `integration.payment.PaymentAdapter`

### Adapter - Integracja z systemem do przewozu jednorożców
Wzorzec adapter został również zastosowany do integracji z zewnętrznym systemem logistycznym, który zajmuje się transportem jednorożców do klientów. 
* **Interfejs oczekiwany przez aplikację:** `integration.transport.UnicornTransportService`
* **Interfejs zewnętrznej usługi transportowej:** `integration.transport.ExternalTransportProvider`
* **Klasa Adaptera:** `integration.transport.TransportAdapter`

### Adapter - Integracja z systemem inwentaryzowania jednorożców
Wzorzec został użyty do integracji z systemem sprawdzania dostępności jednorożców, ktory wymaga innego formatu, niż ten, który dostarczono dotychczas w aplikacji.
* **Interfejs oczekiwany przez aplikację:** `integration.inventory.UnicornInventoryService`
* **Interfejs usługi inwentaryzacyjnej:** `domain.store.UnicornStore`
* **Klasa Adaptera:** `integration.inventory.StoreAvailabilityAdapter`


## 📅 Tydzień 4

---

## Proxy Design Pattern

### Protection Proxy
Wzorzec został użyty do zabezpieczenia dostępu do specjalnych umiejętności jednorożca. 
Proxy sprawdza czy klient jest Vipem przed przekazaniem wywołania do rzeczywistego obiektu jednorożca.

* **Interfejs i Klasy rzeczywiste:** `domain.models.unicorn.types`
* **Klasa Proxy:** `domain.models.unicorn.proxies.ProtectedUnicornProxy`

### Logging Proxy
Zastosowano do monitorowania procesu płatności. Proxy owija adapter płatności, dodając logi audytowe (rozpoczęcie transakcji, czas trwania, sukces, błąd) bez modyfikowania oryginalnej logiki przetwarzania płatności w klasie adaptera.

* **Interfejs usług płatności:** `integration.payment.PaymentService`
* **Klasa Proxy:** `integration.payment.PaymentLoggingProxy`

### Caching Proxy
Użyto w celu optymalizacji pobierania historii wypożyczeń jednorożca z bazy danych. Proxy przechowuje w pamięci (cache) pobraną już listę obiektów `Rental`, co skraca czas kolejnych zapytań o tego samego jednorożca.

* **Interfejs historii wypożyczeń:** `database.RentingHistoryService`
* **Klasa Proxy:** `domain.models.unicorn.proxies.CachingRentingHistoryProxy`

## Flyweight Design Pattern
### Flyweight - wiele rodzajów jednorożców
Wzorzec Flyweight został użyty do zarządzania dużą liczbą obiektów jednorożców, które mają wspólne cechy (np. kolor, typ) ale różnią się unikalnymi właściwościami (imię, lokalizacja przechowywania). Dzięki temu można zaoszczędzić pamięć, przechowując wspólne dane w jednym obiekcie flyweight, a unikalne dane w osobnych obiektach.

* **Interfejs Flyweight:** `domain.models.unicorn.flyweight.UnicornVariantFlyweight`
* **Klasa flyweight:** `domain.models.unicorn.flyweight.UnicornVariant`
* **Klasa fabryki flyweight:** `domain.models.unicorn.flyweight.UnicornVariantFactory`
* **Klasa konkretnych jednorożców:** `domain.models.unicorn.flyweight.Unicorn`

### Flyweight - wiele rodzajów wyposażenia
Wzorzec wykorzystany do zarządzania zestawami wyposażenia różnego typu.
* **Interfejs Flyweight:** `domain.models.unicorn.equipment.flyweight.EquipmentFlyweight`
* **Klasa flyweight:** `domain.models.unicorn.equipment.flyweight.BasicEquipmentPackage`, `domain.models.unicorn.equipment.flyweight.PremiumEquipmentPackage`
* **Klasa fabryki flyweight:** `domain.models.unicorn.equipment.flyweight.EquipmentFlyweightFactory`
* **Klasa konkretnych zestawów wyposażenia:** `domain.models.unicorn.equipment.flyweight.RentalEquipmentAssignment`

### Flyweight - wiele rodzajów tras
Wzorzec został użyty do zarządzania różnymi trasami, na które można wypożyczyć jednorożca. Trasy mogą mieć wspólne cechy (np. długość, poziom trudności) ale różnią się unikalnymi właściwościami (np. nazwa trasy, lokalizacja). Dzięki temu można zaoszczędzić pamięć, przechowując wspólne dane w jednym obiekcie flyweight, a unikalne dane w osobnych obiektach.

* **Interfejs Flyweight:** `domain.models.route.RideRouteFlyweight`
* **Klasa flyweight:** `domain.models.route.flyweight.ShortRideRoute`, `domain.models.route.flyweight.AdventureRideRoute`
* **Klasa fabryki flyweight:** `domain.models.route.flyweight.RideRouteFlyweightFactory`
* **Klasa konkretnych tras:** `domain.models.route.flyweight.RidePlan`


## 📅 Tydzień 5

---

## Command Design Pattern

### Enkapsulacja Akcji
Wzorzec Command został użyty do enkapsulacji zmian ekwipunku jako pojedynczych obiektów, co pozwala na odkładanie ich na stos historii. Umożliwia to zaimplementowanie funkcjonalności "Cofnij", pozwalając na łatwe wycofywanie zmian ekwipunku

* **Interfejs i Konkretne Komendy:** `domain.models.unicorn.commands.EquipCommand`
* **Invoker (Historia Koszyka):** `domain.store.UnicornCart`

### Kolejkowanie Zadań
Użyto do oddzielenia żądania wykonania operacji od jej faktycznego wykonania. Gdy jednorożec jest zwracany, fasada `UnicornReturnFacade` generuje zadania porządkowe (karmienie, szczotkowanie) w postaci komend i umieszcza je w asynchronicznej kolejce.

* **Konkretne Komendy:** `domain.models.unicorn.commands.FeedCommand`, `domain.models.unicorn.commands.BrushCommand`
* **Invoker (Kolejka Zadań):** `domain.facades.returnprocess.MaintenanceQueue`

### Wycofywanie Transakcji
Zastosowano w celu zabezpieczenia złożonego procesu wypożyczenia. Krytyczne akcje (takie jak zmiana statusu jednorożca na `RENTED`) są opakowane w komendy i zgrupowane w obiekcie `TransactionMacro`. Jeśli jakikolwiek krok procesu rezerwacji zawiedzie makro automatycznie iteruje wstecz i wywołuje metodę `undo()` na zakończonych sukcesem komendach.

* **Makro i Komendy Stanu:** `domain.models.unicorn.commands.TransactionMacro`, `domain.models.unicorn.commands.ChangeStatusCommand`
* **Klient:** `domain.facades.rental.UnicornRentalFacade`

## Memento Design Pattern

### Ulubione Konfiguracje
Wzorzec Memento został użyty do zapisywania konfiguracji ekwipunku jednorożca. Obiekt jednorożca potrafi utworzyć pamiątkę ze swoim obecnym ekwipunkiem, która następnie jest przechowywana przez menedżera. Pozwala to klientom na zapisywanie i natychmiastowe przywracanie ich ulubionych "zestawów" bez konieczności ponownego, ręcznego uzbrajania jednorożca.

* **Originator:** `domain.models.unicorn.types.Unicorn`
* **Memento:** `domain.models.unicorn.types.Unicorn.UnicornMemento`
* **Caretaker:** `domain.models.unicorn.memento.LoadoutManager`

### Szkice Wypożyczeń
Zastosowany w celu poprawy doświadczenia użytkownika podczas wypełniania złożonego formularza wypożyczenia. System na bieżąco generuje zrzut stanu niedokończonej aplikacji i zapisuje go w pamięci sesji przeglądarki. W przypadku awarii lub przypadkowego odświeżenia strony, formularz natychmiast odtwarza utracone dane.

* **Originator:** `domain.models.rental.mementos.RentalApplication`
* **Memento:** `domain.models.rental.mementos.RentalApplication.RentalDraftMemento`
* **Caretaker:** `domain.models.rental.mementos.SessionCache`

### Przywracanie Konfiguracji Cen
Użyto do zabezpieczenia kluczowego dla systemu Singletona (`PricingConfig`) przed błędami ludzkimi. Zanim administrator wprowadzi nowe stawki cenowe, system generuje obiekt Memento z poprzednimi wartościami pozwalając na bezpieczne cofnięcie zmian.

* **Originator:** `domain.pricing.PricingConfig`
* **Memento:** `domain.pricing.PricingConfig.PricingConfigMemento`

## Iterator Design Pattern
### Iteracja po statusach jednorożców
Wzorzec został użyty do umożliwienia iterowania po jednorożcach o określonym statusie.
* **Typ wyliczeniowy do statusów:** `enums.UnicornStatus`
* **Klasa jednorożca:** `domain.models.unicorn.types.Unicorn`
* **Interfejs iteratora:** `domain.models.unicorn.iterator.status.UnicornIterator`
* **Interfejs kolekcji jednorożców:** `domain.models.unicorn.iterator.status.UnicornCollection`
* **Konkretna kolekcja jednorożców z klasą wewnętrzną iteratora dla statusów:** `domain.models.unicorn.iterator.status.StableUnicornCollection`

### Iteracja po statusach wypożyczeń
Wzorzec został użyty do umożliwienia iterowania po wypożyczeniach o określonym statusie.
* **Typ wyliczeniowy do statusów:** `enums.RentalStatus`
* **Klasa wypożuczenia:** `domain.models.rental.Rental`
* **Interfejs iteratora:** `domain.models.rental.iterator.RentalIterator`
* **Interfejs kolekcji wypożyczeń:** `domain.models.rental.iterator.RentalCollection`
* **Konkretna kolekcja wypożyczeń z klasą wewnętrzną iteratora dla statusów:** `domain.models.rental.RentalBook`

### Iteracja po poziomach mocy jednorożców
Wzorzec został użyty do umożliwienia iterowania po jednorożcach o określonym poziomie mocy.
* **Typ wyliczeniowy do poziomów mocy:** `enums.PowerLevelCategory`
* **Klasa jednorożca:** `domain.models.unicorn.types.Unicorn`
* **Interfejs iteratora:** `domain.models.unicorn.iterator.PowerLevel.PowerLevelUnicornIterator`
* **Interfejs kolekcji jednorożców:** `domain.models.unicorn.iterator.PowerLevel.PowerLevelUnicornCollection`
* **Konkretna kolekcja jednorożców z klasą wewnętrzną iteratora dla poziomów mocy:** `domain.models.unicorn.iterator.PowerLevel.UnicornPowerBook`

## Mediator Design Pattern
### Mediator - Koordynacja procesu wypożyczenia
Wzorzec został użyty do centralizacji komunikacji pomiędzy modułami systemu wypożyczalni. Poszczególne moduły nie komunikują się bezpośrednio ze sobą, lecz przesyłają komunikaty przez wspólnego mediatora.
* **Interfejs mediatora:** `domain.rentalsystem.SystemMediator`
* **Interfejs współpracownika:** `domain.rentalsystem.SystemModule`
* **Konkretny mediator:** `domain.rentalsystem.RentalSystemMediator`
* **Abstrakcyjna klasa współpracownika ze wspólną logiką wysyłania komunikatów:** `domain.rentalsystem.AbstractSystemModule`
* **Konkretny współpracownik – moduł rezerwacji:** `domain.rentalsystem.BookingModule`
* **Konkretny współpracownik – moduł płatności:** `domain.rentalsystem.PaymentModule`
* **Konkretny współpracownik – moduł powiadomień:** `domain.rentalsystem.NotificationModule`
* **Konkretny współpracownik – moduł dostępności:** `domain.rentalsystem.AvailabilityModule`

### Mediator - koordynacja działań pracowników
Wzorzec został użyty do centralizacji komunikacji pomiędzy pracownikami stajni. Pracownicy nie komunikują się bezpośrednio między sobą, lecz przekazują informacje przez mediatora.
* **Interfejs mediatora:** `domain.employees.StableMediator`
* **Interfejs współpracownika:** `domain.employees.StableWorker`
* **Konkretny mediator:** `domain.employees.UnicornStableMediator`
* **Abstrakcyjna klasa współpracownika ze wspólną logiką wysyłania komunikatów:** `domain.employees.AbstractStableWorker`
* **Konkretny współpracownik – opiekun jednorożców:** `domain.employees.Caretaker`
* **Konkretny współpracownik – weterynarz:** `domain.employees.Veterinarian`
* **Konkretny współpracownik – pracownik sprzątający:** `domain.employees.Cleaner`
* **Konkretny współpracownik – manager stajni:** `domain.employees.StableManager`

### Mediator - koordynacja modułów powiązanych z wypożyczeniem
Wzorzec został użyty do centralizacji komunikacji pomiędzy usługami odpowiedzialnymi za obsługę wypożyczenia. Poszczególne usługi nie są połączone bezpośrednio, lecz wymieniają komunikaty przez mediatora.
* **Interfejs mediatora:** `domain.rentalservices.ServiceMediator`
* **Interfejs współpracownika:** b`domain.rentalservices.RentalService`
* **Konkretny mediator:** `domain.rentalservices.UnicornRentalServiceMediator`
* **Abstrakcyjna klasa współpracownika ze wspólną logiką wysyłania komunikatów:** `domain.rentalservices.AbstractRentalService`
* **Konkretny współpracownik – usługa wyliczania ceny:** `domain.rentalservices.PricingService`
* **Konkretny współpracownik – usługa rabatów:** `domain.rentalservices.DiscountService`
* **Konkretny współpracownik – usługa ubezpieczeń:** `domain.rentalservices.InsuranceService`


## 📅 Tydzień 6

---

## Strategy Design Pattern
### Obliczanie ceny
Wzorzec ten został użyty do dynamicznego obliczania ostatecznej ceny wypożyczenia w zależności od obowiązujących reguł biznesowych (np. stawka standardowa, dopłata weekendowa). 
* **Interfejs i Konkretne Strategie:** `domain.pricing.strategies`
* **Kontekst:** `domain.store.UnicornCart`

### Wybór jednorożca
Zastosowano w celu hermetyzacji różnych algorytmów dopasowujących wierzchowca do klienta z puli dostępnych zwierząt.

* **Interfejs i Konkretne Strategie:** `domain.models.unicorn.strategies.unicornSelection`
* **Kontekst:** `domain.models.unicorn.strategies.unicornSelection.UnicornMatcher`

### Metody dostawy
Wzorzec pozwolił na odseparowanie logiki logistycznej od reszty systemu. Klienci mogą decydować, w jaki sposób odbiorą swojego jednorożca. Menedżer dostaw inicjuje operację, delegując całą odpowiedzialność za szczegóły transportu do wstrzykniętego w argumencie obiektu strategii.

* **Interfejs i Konkretne Strategie:** `domain.models.unicorn.strategies.unicornDelivery`
* **Kontekst:** `domain.models.unicorn.strategies.unicornSelection.DeliveryManager`


## State Design Pattern
### Status dostępności jednorożca
Wzorzec ten pozwolił na wdrożenie "maszyny stanów" zarządzającej logistyką w stajni. Poszczególne zachowania (wypożyczenie, zwrot, czyszczenie) wywołują różne efekty i odpowiednio odrzucają błędy w zależności od tego, czy jednorożec jest obecnie dostępny, wypożyczony czy w trakcie czyszczenia.

* **Interfejs i Stany:** `domain.models.unicorn.states`
* **Kontekst:** `domain.models.unicorn.states.UnicornContext`

### Cykl życia rezerwacji
Wzorzec State zabezpieczył przepływ zamówień w systemie. Zapobiega to błędom logicznym, takim jak próba opłacenia już anulowanego zamówienia lub anulowania transakcji, która została już zrealizowana.

* **Interfejs i Stany:** `domain.models.rental.states`
* **Kontekst:** `domain.models.rental.states.RentalOrderContext`

### Stan energii wypożyczonego jednorożca
Zastosowany do symulacji poziomu energii podczas jazdy. W zależności od punktów kondycji (stamina) zachowanie obiektu się zmienia. Energiczny jednorożec pędzi szybko, zmęczony zwalnia, a wyczerpany odrzuca komendy galopu do czasu, aż klient wywoła metodę odpoczynku.

* **Interfejs i Stany:** `domain.models.rentedUnicorn.states`
* **Kontekst:** `domain.models.rentedUnicorn.states.RentedUnicornContext`

## Template Method Design Pattern
### Proces wypożyczenia
Wzorzec Template Method został użyty do zdefiniowania szkieletu procesu wypożyczenia, pozostawiając szczegóły implementacji poszczególnych kroków do klas potomnych.
Dzięki temu można łatwo tworzyć różne warianty procesu wypożyczenia (np. standardowy, ekspresowy) bez duplikowania kodu.

* **Klasa abstrakcyjna z szablonem:** `domain.models.rental.template.UnicornRentalProcess`
* **Konkretne implementacje:** `domain.models.rental.template.StandardRentalProcess`, `domain.models.rental.template.ExpressRentalProcess`, `domain.models.rental.template.PremiumRentalProcess`

### Proces zwrotu jednorożca
Wzorzec Template Method został użyty do zdefiniowania szkieletu procesu zwrotu, pozostawiając szczegóły implementacji poszczególnych kroków do klas potomnych.

* **Klasa abstrakcyjna z szablonem:** `domain.models.rental.returnTemplate.UnicornReturnTemplate`
* **Konkretne implementacje:** `domain.models.rental.returnTemplate.DamagedReturnProcess`, `domain.models.rental.returnTemplate.LateReturnProcess`, `domain.models.rental.returnTemplate.StandardReturnProcess`

### Proces pielęgnacji jednorożca
Wzorzec Template Method został użyty do zdefiniowania szkieletu procesu wypożyczenia, pozostawiając szczegóły implementacji poszczególnych kroków do klas potomnych.
Dzięki temu można łatwo tworzyć różne warianty procesu wypożyczenia (np. standardowy, ekspresowy) bez duplikowania kodu.

* **Klasa abstrakcyjna z szablonem:** `domain.models.rental.template.UnicornRentalProcess`
* **Konkretne implementacje:** `domain.models.rental.template.StandardRentalProcess`, `domain.models.rental.template.ExpressRentalProcess`, `domain.models.rental.template.PremiumRentalProcess`
