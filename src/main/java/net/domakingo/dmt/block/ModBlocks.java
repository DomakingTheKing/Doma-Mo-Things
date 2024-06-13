package net.domakingo.dmt.block;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoThingsMod.MOD_ID);


    public static final RegistryObject<Block> HOPE_FLOWER = registerBlock("hope_flower",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY)));

    public static final RegistryObject<Block> SNAIL_SHELL_BLOCK = registerBlock("snail_shell_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
