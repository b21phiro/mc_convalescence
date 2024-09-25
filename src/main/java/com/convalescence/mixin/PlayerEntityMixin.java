package com.convalescence.mixin;

import com.convalescence.Convalescence;
import com.convalescence.mana.ManaManager;
import com.convalescence.mana.PlayerManaInterface;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerManaInterface {

    protected ManaManager manaManager = new ManaManager();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick()V", at = @At("TAIL"))
    public void tick(CallbackInfo ci) {

        if (!this.getWorld().isClient) {
            this.manaManager.update((PlayerEntity) (Object) this);
        }

    }

    @Override
    public ManaManager getManaManager() {
        return this.manaManager;
    }

}
