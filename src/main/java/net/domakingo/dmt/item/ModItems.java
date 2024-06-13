package net.domakingo.dmt.item;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoThingsMod.MOD_ID);

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNAIL, 0x725563, 0xa3ad54, new Item.Properties()));
    public static final RegistryObject<Item> SHELL = ITEMS.register("shell",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORN_SHELL = ITEMS.register("horn_shell",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
