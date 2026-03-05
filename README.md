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