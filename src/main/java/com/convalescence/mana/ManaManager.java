package com.convalescence.mana;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameRules;

public class ManaManager {


    private final int MAX_MANA_LEVEL = 100;
    private final int MANA_REGENERATION_SPEED_VALUE = 1;

    private int manaLevel = MAX_MANA_LEVEL;
    private int manaTickTimer;

    public void update(PlayerEntity player) {

        boolean naturalRegenerationIsActive = player.getWorld()
                .getGameRules()
                .getBoolean(GameRules.NATURAL_REGENERATION);

        // Restores mana every second.
        if (naturalRegenerationIsActive && this.manaLevel < this.MAX_MANA_LEVEL) {
            this.manaTickTimer++;
            if (this.manaTickTimer >= 10) {
                this.manaLevel = Math.min(this.manaLevel + this.MANA_REGENERATION_SPEED_VALUE, this.MAX_MANA_LEVEL);
                this.manaTickTimer = 0;
            }
        } else {
            this.manaTickTimer = 0;
        }

    }

    public boolean canAffordCost(int cost) {
        return (this.manaLevel - cost) >= 0;
    }

    public void consumeMana(int amount) {
        this.manaLevel = Math.max(this.manaLevel - amount, 0);
    }

}
