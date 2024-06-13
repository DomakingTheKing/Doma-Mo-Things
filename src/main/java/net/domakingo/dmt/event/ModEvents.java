package net.domakingo.dmt.event;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.ModEntities;
import net.domakingo.dmt.entity.custom.SnailEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoThingsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SNAIL.get(), SnailEntity.setAttributes());
    }
}
