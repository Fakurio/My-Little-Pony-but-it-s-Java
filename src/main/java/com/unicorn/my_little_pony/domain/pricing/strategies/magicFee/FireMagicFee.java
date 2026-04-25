package com.unicorn.my_little_pony.domain.pricing.strategies.magicFee;

public class FireMagicFee implements MagicFeeStrategy{
    private static final double FIRE_MAGIC_MULTIPLIER = 1.20;

    @Override
    public double applyFee(double price) {
        return price * FIRE_MAGIC_MULTIPLIER;
    }
}
