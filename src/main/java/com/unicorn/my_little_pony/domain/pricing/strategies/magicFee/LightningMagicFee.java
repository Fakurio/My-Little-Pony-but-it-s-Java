package com.unicorn.my_little_pony.domain.pricing.strategies.magicFee;

public class LightningMagicFee implements MagicFeeStrategy {
    private static final double LIGHTNING_MAGIC_MULTIPLIER = 1.80;

    @Override
    public double applyFee(double price) {
        return price * LIGHTNING_MAGIC_MULTIPLIER;
    }
}
