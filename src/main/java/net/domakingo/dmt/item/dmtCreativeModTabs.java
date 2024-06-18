package net.domakingo.dmt.item;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class dmtCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoThingsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DMT_TAB = CREATIVE_MODE_TABS.register("dmt_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ENDER_EYE))
                    .title(Component.translatable("creativetab.dmt_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.HOPE_FLOWER.get());
                        pOutput.accept(ModBlocks.SNAIL_SHELL_BLOCK.get());
                        pOutput.accept(ModBlocks.OPENED_SNAIL_SHELL_BLOCK.get());
                        pOutput.accept(ModBlocks.GEM_POLISHING_STATION.get());

                        pOutput.accept(ModItems.SNAIL_SPAWN_EGG.get());
                        pOutput.accept(ModItems.SNAIL_SHELL_FRAGMENT.get());
                        pOutput.accept(ModItems.HORN_SHELL.get());
                        pOutput.accept(ModItems.DROOL_BUCKET.get());
                        pOutput.accept(ModItems.SNAIL_SLIME.get());
                        pOutput.accept(ModItems.SCOOP.get());
                        pOutput.accept(ModItems.SNAIL_GLUE.get());
                        pOutput.accept(ModItems.SNAIL_SLIME_SOUP.get());
                        pOutput.accept(ModItems.SNAIL_HAMMER.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
