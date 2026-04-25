package com.unicorn.my_little_pony.repositories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.util.IdGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Tydzień 8, DI, Zastosowanie 2
//Implementacja modułu niskopoziomowego zgodna z wymaganiami modułu wysokopoziomowego
public class UnicornFileRepository implements UnicornRepository {
    private final List<Unicorn> unicorns;

    public UnicornFileRepository() {
        this.unicorns = loadUnicornsFromFile();
    }

    private List<Unicorn> loadUnicornsFromFile() {
        List<Unicorn> loaded = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("unicorns.txt")))
        )) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0].trim();
                String color = parts[1].trim();
                int powerLevel = Integer.parseInt(parts[2].trim());
                loaded.add(new FireUnicorn(IdGenerator.getInstance().nextUnicornId(), name, color, powerLevel));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return loaded;
    }

    @Override
    public List<Unicorn> getAllUnicorn() {
        return this.unicorns;
    }
}
//Koniec, Tydzień 8, DI