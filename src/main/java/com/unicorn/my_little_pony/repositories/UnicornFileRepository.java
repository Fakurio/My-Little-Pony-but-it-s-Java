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
    private static final int UNICORN_NAME_INDEX = 0;
    private static final int UNICORN_COLOR_INDEX = 1;
    private static final int POWER_LEVEL_INDEX = 2;

    private final List<Unicorn> unicorns;

    public UnicornFileRepository() {
        this.unicorns = loadUnicornsFromFile();
    }

    private List<Unicorn> loadUnicornsFromFile() {
        List<Unicorn> loadedUnicorns = new ArrayList<>();
        try (BufferedReader bufferedReader = createReader()) {
            readUnicorns(bufferedReader, loadedUnicorns);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load unicorns from file", e);
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
        String unicornName = attributes[UNICORN_NAME_INDEX].trim();
        String unicornColor = attributes[UNICORN_COLOR_INDEX].trim();
        int powerLevel = Integer.parseInt(attributes[POWER_LEVEL_INDEX].trim());
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
