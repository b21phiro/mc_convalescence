package com.convalescence.magic;

import com.convalescence.Convalescence;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class Spell extends Item {

    public Spell(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        // Casts the spell.
        Convalescence.LOGGER.info("Cast spell");

        return TypedActionResult.consume(user.getStackInHand(hand));
    }

}
