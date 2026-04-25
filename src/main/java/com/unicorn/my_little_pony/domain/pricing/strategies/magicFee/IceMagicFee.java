package com.unicorn.my_little_pony.domain.pricing.strategies.magicFee;

public class IceMagicFee implements MagicFeeStrategy{
    private static final double ICE_MAGIC_MULTIPLIER = 1.60;

    @Override
    public double applyFee(double price) {
        return price * ICE_MAGIC_MULTIPLIER;
    }
}
