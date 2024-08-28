package com.convalescence.mana;

public class ManaManager {

    private int manaLevel;

    public ManaManager() {
        this.manaLevel = ManaConstants.MANA_MAX_LEVEL;
    }

    public void add(int mana) {
        this.manaLevel = Math.min(mana + this.manaLevel, ManaConstants.MANA_MAX_LEVEL);
    }

}