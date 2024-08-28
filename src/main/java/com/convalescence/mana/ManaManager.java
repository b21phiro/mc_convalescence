package com.convalescence.mana;

public class ManaManager {

    private int manaLevel;
    private int prevManaLevel;

    public ManaManager() {
        this.prevManaLevel = ManaConstants.MANA_MAX_LEVEL;
        this.manaLevel = this.prevManaLevel;
    }

    public void add(int mana) {
        this.manaLevel = Math.min(mana + this.manaLevel, ManaConstants.MANA_MAX_LEVEL);
    }

}