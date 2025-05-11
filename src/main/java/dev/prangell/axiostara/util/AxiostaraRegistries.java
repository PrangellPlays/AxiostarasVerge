package dev.prangell.axiostara.util;

import dev.prangell.axiostara.client.entity.deepmineharmonizer.renderer.DeepMineHarmonizerRenderer;
import dev.prangell.axiostara.entity.pulse.DeepMineHarmonizerEntity;
import dev.prangell.axiostara.init.AxiostaraEntities;
import dev.prangell.axiostara.init.AxiostaraItemGroups;
import dev.prangell.axiostara.init.AxiostaraItems;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;

public class AxiostaraRegistries {
    public static void init() {
        AxiostaraItems.init();
        AxiostaraItemGroups.init();
        AxiostaraEntities.init();
        registerEntityAttributes();
    }

    public static void clientInit() {
        registerEntityRenderer();
    }

    //server
    private static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(AxiostaraEntities.DEEP_MINE_HARMONIZER, DeepMineHarmonizerEntity.createAxiostaraEntityAttributes());
    }

    //client
    private static void registerEntityRenderer() {
        EntityRendererRegistry.register(AxiostaraEntities.DEEP_MINE_HARMONIZER, DeepMineHarmonizerRenderer::new);
    }
}
