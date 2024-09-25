package com.convalescence.spell;

import com.convalescence.Convalescence;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Spells {

    /** Restoration spells. */
    public static final Item RESTORE_HEALTH = Registry.register(Registries.ITEM, new Identifier(Convalescence.MOD_ID, "restore_health"), new RestoreHealthSpell(new FabricItemSettings()));

    /** Dangerous spells. */
    public static final Item SHOOT_FIRE = Registry.register(Registries.ITEM, new Identifier(Convalescence.MOD_ID, "shoot_fire"), new ShootFireSpell(new FabricItemSettings()));

    public static void init() {
        Convalescence.LOGGER.info("Spells initialized");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Spells::addItemsToIngredientItemGroup);
    }

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries items) {
        items.add(RESTORE_HEALTH);
        items.add(SHOOT_FIRE);
    }

}
