package com.convalescence.magic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RestoreHealthSpell extends Spell {

    private final float RESTORE_HEALTH_PER_TICK = 0.5f;

    public RestoreHealthSpell(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        // Cast this spell.
        float maxHealth = user.getMaxHealth();
        float currentHealth = user.getHealth();

        if (currentHealth < maxHealth) {
            // Restore health.
            user.heal(RESTORE_HEALTH_PER_TICK);

            return TypedActionResult.consume(user.getStackInHand(hand));
        } else {
            // Player already has full health!
            return TypedActionResult.success(user.getStackInHand(hand));
        }

    }

}
