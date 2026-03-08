# Wzorzec Decorator - Implementacja w My Little Pony

## Opis implementacji

Projekt zawiera **3 niezależne implementacje wzorca Decorator**, zgodnie z wymogami tygodnia 4.

## Struktura wzorca

Każda implementacja składa się z:
1. **Interfejs komponentu** - definiuje podstawowe operacje
2. **Konkretny komponent** - bazowa implementacja
3. **Abstrakcyjna klasa dekoratora** - przechowuje referencję do komponentu
4. **Konkretne dekoratory** - dodają nowe funkcjonalności

---

## Decorator #1: Dodatki do Jednorożca 🦄✨

**Lokalizacja**: `com.unicorn.my_little_pony.domain.decorators.unicornAddOns`

### Struktura:
- **Interfejs**: `UnicornRental`
  - `double getPrice()` - zwraca cenę wypożyczenia
  - `String getDescription()` - zwraca opis
  
- **Komponent bazowy**: `BasicUnicornRental`
  - Podstawowe wypożyczenie jednorożca

- **Abstrakcyjna klasa**: `UnicornRentalDecorator`
  
- **Dekoratory**:
  - `GlitterDecorator` - dodaje brokat (+50 PLN)
  - `WingPolishDecorator` - dodaje polerowanie skrzydeł (+75 PLN)
  - `RainbowManeDecorator` - dodaje tęczową grzywę (+100 PLN)

### Cel:
Dynamiczne "doklejanie" dodatkowych usług kosmetycznych do wypożyczenia.

---

## Decorator #2: Ubezpieczenia 🛡️

**Lokalizacja**: `com.unicorn.my_little_pony.domain.decorators.insurance`

### Struktura:
- **Interfejs**: `RentalInsurance`
  - `double getCost()` - zwraca koszt ubezpieczenia
  - `String getCoverage()` - zwraca zakres ochrony
  
- **Komponent bazowy**: `NoInsurance`
  - Brak ubezpieczenia (0 PLN)

- **Abstrakcyjna klasa**: `InsuranceDecorator`
  
- **Dekoratory**:
  - `BasicInsurance` - podstawowe OC (+30 PLN)
  - `ExtendedInsurance` - AC + medyczne (+60 PLN)
  - `ExtremeWeatherCoverage` - ochrona przed pogodą (+45 PLN)

### Cel:
Możliwość budowania pakietów ubezpieczeniowych dostosowanych do ryzyka i potrzeb klienta.

---

## Decorator #3: Pakiet Obsługi Klienta 📞

**Lokalizacja**: `com.unicorn.my_little_pony.domain.decorators.support`

### Struktura:
- **Interfejs**: `CustomerSupport`
  - `double getCost()` - zwraca koszt wsparcia
  - `String getDescription()` - zwraca opis pakietu
  
- **Komponent bazowy**: `NoSupport`
  - Brak wsparcia (0 PLN)

- **Abstrakcyjna klasa**: `SupportDecorator`
  
- **Dekoratory**:
  - `StandardSupport` - wsparcie 9-17 (+20 PLN)
  - `PrioritySupport` - wsparcie priorytetowe 8-20 (+40 PLN)
  - `TwentyFourHourCaretaker` - dedykowany opiekun 24/7 (+80 PLN)

### Cel:
Niezależna linia dekorowania pozwalająca na budowanie różnych poziomów obsługi klienta.

---

## Demo - DemoWeek4Runner

**Lokalizacja**: `com.unicorn.my_little_pony.DemoWeek4Runner`

### Uruchomienie:
```bash
./gradlew build
java -cp build/classes/java/main com.unicorn.my_little_pony.DemoWeek4Runner
```

### Konfiguracje demonstracyjne:

#### Konfiguracja 1: Pakiet Budżetowy (300 PLN)
- Brokat
- Podstawowe ubezpieczenie
- Standardowe wsparcie

#### Konfiguracja 2: Pakiet Standardowy Plus (475 PLN)
- Brokat + Polerowanie skrzydeł
- Podstawowe + Rozszerzone ubezpieczenie
- Standardowe + Priorytetowe wsparcie

#### Konfiguracja 3: Pakiet Premium VIP (700 PLN)
- Wszystkie dodatki kosmetyczne
- Pełne ubezpieczenie (wszystkie warianty)
- Pełne wsparcie (wszystkie poziomy)

---

## Zalety wzorca Decorator w tym projekcie

✅ **Elastyczność** - możliwość dowolnego łączenia dodatków  
✅ **Single Responsibility** - każdy dekorator odpowiada za jedną funkcjonalność  
✅ **Open/Closed** - łatwo dodać nowe dekoratory bez zmiany istniejącego kodu  
✅ **Niezależność** - 3 osobne linie dekorowania (dodatki, ubezpieczenia, wsparcie)  
✅ **Dynamiczny charakter** - decyzje w runtime, nie compile-time  

---

## Zgodność z wykładem

Implementacja wzorowana na przykładzie z wykładu (ButtonDecorator):
- Interfejs `Button` → `UnicornRental`, `RentalInsurance`, `CustomerSupport`
- Klasa `PlainButton` → `BasicUnicornRental`, `NoInsurance`, `NoSupport`
- Abstrakcyjny `ButtonDecorator` → odpowiednie klasy `*Decorator`
- Konkretne dekoratory zachowują tę samą strukturę

**Komentarze w kodzie** oznaczają:
```java
// Tydzień 4, Wzorzec Decorator, Zastosowanie X
// ... kod ...
// Koniec, Tydzień 4, Wzorzec Decorator, Zastosowanie X
```
