package net.domakingo.dmt.datagen;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.block.ModBlocks;
import net.domakingo.dmt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MoThingsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.SNAIL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        simpleItem(ModItems.SNAIL_SHELL_FRAGMENT);
        simpleItem(ModItems.HORN_SHELL);
        simpleItem(ModItems.DROOL_BUCKET);
        simpleItem(ModItems.SNAIL_SLIME);
        simpleItem(ModItems.SCOOP);
        simpleItem(ModItems.SNAIL_GLUE);
        simpleItem(ModItems.SNAIL_SLIME_SOUP);
        simpleItem(ModItems.SNAIL_HAMMER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MoThingsMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
