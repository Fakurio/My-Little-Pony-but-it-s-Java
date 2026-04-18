package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Implementacja segregated interface - trening
public class TrainingServiceImpl implements UnicornTrainingService {

    @Override
    public void trainBasics(String unicornId) {
        System.out.println("[ISP] Training basics for unicorn " + unicornId);
    }

    @Override
    public void trainAdvanced(String unicornId) {
        System.out.println("[ISP] Training advanced skills for unicorn " + unicornId);
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

