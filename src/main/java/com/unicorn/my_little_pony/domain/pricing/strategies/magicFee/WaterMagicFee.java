package com.unicorn.my_little_pony.domain.pricing.strategies.magicFee;

public class WaterMagicFee implements MagicFeeStrategy{
    private static final double WATER_MAGIC_MULTIPLIER = 1.40;

    @Override
    public double applyFee(double price) {
        return price * WATER_MAGIC_MULTIPLIER;
    }
}
