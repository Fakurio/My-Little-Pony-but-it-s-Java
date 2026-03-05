# Sprawozdanie
## Tydzień 2
### Factory design pattern

#### Simple Factory
Wzorzec projektowy prosta fabryka został użyty do tworzenia obiektów powiadomień

Klasa fabryki: domain.models.notification.NotificationFactory  
Klasy konkretnych powiadomień: domain.models.notification.types

#### Abstract Factory
Wzorzec projektowy fabryka abstrakcyjna został użyty do tworzenia zestawu obiektów wchodzących w skład  
planu cenowego. W skład zestawu wchodzi obiekt polisy anulowania wypożyczenia oraz cennik wypożyczenia

Wszystkie klasy znajdują się w pakiecie pricing.policies

#### Factory method
Wzorzec projektowy metoda fabryki został użyty do tworzenia obiektów konkretnych typów jednorożców.
W systemie dostępna jest fabryka dla ognistych i wodnych jednorożców

Klasy fabryk: domain.models.unicorn.factories

