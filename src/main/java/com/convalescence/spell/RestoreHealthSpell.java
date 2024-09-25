package com.convalescence.spell;

import com.convalescence.mana.ManaManager;
import com.convalescence.mana.PlayerManaInterface;
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

        ManaManager manaManager = ((PlayerManaInterface) user).getManaManager();

        if (user.getHealth() < user.getMaxHealth() && manaManager.canAffordCost(this.DEFAULT_MANA_COST)) {
            manaManager.consumeMana(this.DEFAULT_MANA_COST);
            user.heal(RESTORE_HEALTH_PER_TICK);
            return TypedActionResult.consume(user.getStackInHand(hand));
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

    }

}
