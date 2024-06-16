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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HORN_SHELL.get())
                .pattern("SZS")
                .pattern("TST")
                .pattern("SZS")
                .define('S', ModItems.SNAIL_SHELL_FRAGMENT.get())
                .define('T', Items.STRING)
                .define('Z', Items.STICK)
                .unlockedBy(getHasName(ModItems.SNAIL_SHELL_FRAGMENT.get()), has(ModItems.SNAIL_SHELL_FRAGMENT.get()))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCOOP.get())
                .pattern("   ")
                .pattern(" I ")
                .pattern("Z  ")
                .define('I', Items.IRON_INGOT)
                .define('Z', Items.STICK)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(recipeOutput);
    }
}
