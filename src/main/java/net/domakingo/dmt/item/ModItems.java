package net.domakingo.dmt.item;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.ModEntities;
import net.domakingo.dmt.fluid.ModFluids;
import net.domakingo.dmt.item.custom.HornItem;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Instruments;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoThingsMod.MOD_ID);

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SNAIL, 0x725563, 0xa3ad54, new Item.Properties()));
    public static final RegistryObject<Item> SNAIL_SHELL_FRAGMENT = ITEMS.register("snail_shell_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DROOL_BUCKET= ITEMS.register("drool_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER, new BucketItem.Properties()));
    public static final RegistryObject<Item> HORN_SHELL = ITEMS.register("horn_shell",
            () -> new HornItem(new Item.Properties(), InstrumentTags.GOAT_HORNS));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
