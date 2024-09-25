package com.convalescence.spell;

import com.convalescence.entity.FireEntity;
import com.convalescence.mana.ManaManager;
import com.convalescence.mana.PlayerManaInterface;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ShootFireSpell extends Spell {

    public ShootFireSpell(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

        ManaManager manaManager = ((PlayerManaInterface) user).getManaManager();

        if (manaManager.canAffordCost(this.DEFAULT_MANA_COST)) {

            if (!world.isClient) {
                FireEntity snowballEntity = new FireEntity(world, user);
                snowballEntity.setItem(itemStack);
                snowballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
                world.spawnEntity(snowballEntity);
            }

            world.playSound(
                    null,
                    user.getX(),
                    user.getY(),
                    user.getZ(),
                    SoundEvents.ENTITY_SNOWBALL_THROW,
                    SoundCategory.NEUTRAL,
                    0.5F,
                    0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );

            manaManager.consumeMana(this.DEFAULT_MANA_COST);

            return TypedActionResult.success(user.getStackInHand(hand));

        } else {
            return TypedActionResult.fail(itemStack);
        }

    }

}
