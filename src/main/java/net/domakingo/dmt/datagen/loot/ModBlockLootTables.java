package net.domakingo.dmt.datagen.loot;

import net.domakingo.dmt.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SNAIL_SHELL_BLOCK.get());
        this.dropSelf(ModBlocks.OPENED_SNAIL_SHELL_BLOCK.get());
        this.dropSelf(ModBlocks.SNAIL_SLIME_BLOCK.get());

        this.dropSelf(ModBlocks.HOPE_FLOWER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
