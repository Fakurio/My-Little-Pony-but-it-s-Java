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