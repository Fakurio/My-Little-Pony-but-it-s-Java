package com.unicorn.my_little_pony.integration.transport;

//Tydzień 3, Wzorzec Adapter 2 (przez kompozycję)
//Interfejs, który będzie używany przez resztę aplikacji do zamawiania transportu dla jednorożca
public interface UnicornTransportService {
    void scheduleTransport(String unicornId, String unicornName, String destination);
}
//Koniec, Tydzień 3, Wzorzec Adapter 2