package com.unicorn.my_little_pony.domain.store.isp.unicorncare;

// Tydzien 8, ISP, Zastosowanie 2
// Klient po segregacji - zalezy tylko od treningu
public class TrainerWorker {
    private final UnicornTrainingService trainingService;

    public TrainerWorker(UnicornTrainingService trainingService) {
        this.trainingService = trainingService;
    }

    public void trainUnicorn(String unicornId, boolean advanced) {
        System.out.println("[ISP] Trainer: Starting training session");
        if (advanced) {
            trainingService.trainAdvanced(unicornId);
        } else {
            trainingService.trainBasics(unicornId);
        }
    }
}
// Koniec, Tydzien 8, ISP, Zastosowanie 2

