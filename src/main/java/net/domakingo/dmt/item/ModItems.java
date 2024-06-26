package net.domakingo.dmt.item;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.ModEntities;
import net.domakingo.dmt.fluid.ModFluids;
import net.domakingo.dmt.item.custom.HornItem;
import net.domakingo.dmt.item.custom.ScoopItem;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
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

    public static final RegistryObject<Item> SNAIL_SHELL_FRAGMENT = ITEMS.register("snail_shell_fragment",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DROOL_BUCKET= ITEMS.register("drool_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER, new BucketItem.Properties()));

    public static final RegistryObject<Item> HORN_SHELL = ITEMS.register("horn_shell",
            () -> new HornItem(new Item.Properties(), InstrumentTags.GOAT_HORNS));

    public static final RegistryObject<Item> SNAIL_SLIME = ITEMS.register("snail_slime",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SCOOP = ITEMS.register("scoop",
            () -> new ScoopItem(new Item.Properties().durability(50)));

    public static final RegistryObject<Item> SNAIL_GLUE = ITEMS.register("snail_glue",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SNAIL_SLIME_SOUP = ITEMS.register("snail_slime_soup",
            () -> new Item(new Item.Properties().food(ModFoods.SNAIL_SLIME_SOUP)));

    public static final RegistryObject<Item> SNAIL_HAMMER = ITEMS.register("snail_hammer",
            () -> new SwordItem(ModToolTiers.SNAIL, 4, 2, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
