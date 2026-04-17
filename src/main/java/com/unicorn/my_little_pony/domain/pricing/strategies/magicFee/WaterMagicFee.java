package com.unicorn.my_little_pony.domain.pricing.strategies.magicFee;

public class WaterMagicFee implements MagicFeeStrategy{
    @Override
    public double applyFee(double price) {
        return price * 1.40;
    }
}
