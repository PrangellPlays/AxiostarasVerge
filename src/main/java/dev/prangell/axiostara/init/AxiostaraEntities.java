package dev.prangell.axiostara.init;

import dev.prangell.axiostara.Axiostara;
import dev.prangell.axiostara.entity.pulse.DeepMineHarmonizerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface AxiostaraEntities {
    Map<EntityType<? extends Entity>, Identifier> ENTITIES = new LinkedHashMap();
    EntityType<DeepMineHarmonizerEntity> DEEP_MINE_HARMONIZER = Registry.register(Registries.ENTITY_TYPE, Axiostara.id("deep_mine_harmonizer"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, DeepMineHarmonizerEntity::new).dimensions(new EntityDimensions(1.0f, 1.0f, true)).build());

    private static <T extends EntityType<? extends Entity>> T createEntity(String name, T entity) {
        ENTITIES.put(entity, new Identifier(Axiostara.MOD_ID, name));
        return entity;
    }

    static void init() {
        ENTITIES.keySet().forEach((entityType) -> {
            Registry.register(Registries.ENTITY_TYPE, (Identifier) ENTITIES.get(entityType), entityType);
        });
    }
}