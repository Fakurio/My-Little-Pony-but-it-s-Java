package com.unicorn.my_little_pony.repositories;

import com.unicorn.my_little_pony.domain.models.unicorn.types.FireUnicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.Unicorn;
import com.unicorn.my_little_pony.domain.models.unicorn.types.UnicornIdentity;
import com.unicorn.my_little_pony.util.IdGenerator;

import java.io.BufferedReader;
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
        List<Unicorn> loadedUnicorns = new ArrayList<>();
        try (BufferedReader bufferedReader = createReader()) {
            readUnicorns(bufferedReader, loadedUnicorns);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return loadedUnicorns;
    }

    private BufferedReader createReader() {
        return new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("unicorns.txt"))
        ));
    }

    private void readUnicorns(BufferedReader bufferedReader, List<Unicorn> loadedUnicorns) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            loadedUnicorns.add(parseUnicorn(line));
        }
    }

    private Unicorn parseUnicorn(String line) {
        String[] attributes = line.split(";");
        String unicornName = attributes[0].trim();
        String unicornColor = attributes[1].trim();
        int powerLevel = Integer.parseInt(attributes[2].trim());
        UnicornIdentity unicornIdentity = new UnicornIdentity(
                IdGenerator.getInstance().nextUnicornId(),
                unicornName,
                unicornColor
        );
        return new FireUnicorn(unicornIdentity, powerLevel);
    }

    @Override
    public List<Unicorn> getAllUnicorns() {
        return this.unicorns;
    }
}
//Koniec, Tydzień 8, DI
