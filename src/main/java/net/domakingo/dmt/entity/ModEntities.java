package net.domakingo.dmt.entity;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.custom.SnailEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoThingsMod.MOD_ID);

    public static final RegistryObject<EntityType<SnailEntity>> SNAIL =
            ENTITY_TYPES.register("snail",
                    () -> EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE)
                        .sized(1.5f, 1.75f)
                        .build(new ResourceLocation(MoThingsMod.MOD_ID, "snail").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
