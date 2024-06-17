package net.domakingo.dmt.item;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.MoThingsMod;;
import net.domakingo.dmt.block.ModBlocks;
import net.domakingo.dmt.item.custom.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SNAIL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEED_SNAIL_TOOL, () -> Ingredient.of(ModBlocks.SNAIL_SHELL_BLOCK.get())),
            new ResourceLocation(MoThingsMod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());

}
