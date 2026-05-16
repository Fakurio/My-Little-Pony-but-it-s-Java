package com.unicorn.my_little_pony.domain.models.rentedunicorn;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RentedUnicorn {
    private static final int DEFAULT_STAMINA = 100;

    private int stamina = DEFAULT_STAMINA;

    public RentedUnicorn() {}
}
