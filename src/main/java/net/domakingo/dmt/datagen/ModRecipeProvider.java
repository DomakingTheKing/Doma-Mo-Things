package net.domakingo.dmt.datagen;

import net.domakingo.dmt.block.ModBlocks;
import net.domakingo.dmt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.SNAIL_SHELL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SNAIL_SHELL_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.SNAIL_SHELL_FRAGMENT.get()), has(ModItems.SNAIL_SHELL_FRAGMENT.get()))
                .save(recipeOutput);
    }
}
