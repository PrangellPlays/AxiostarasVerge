package dev.prangell.axiostara.entity;

import dev.prangell.axiostara.damage.HarmonicType;
import dev.prangell.axiostara.entity.entitytype.HarmonicTyped;
import dev.prangell.axiostara.entity.pulse.DeepMineHarmonizerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public abstract class AxiostaraEntity extends MobEntity implements HarmonicTyped {
    public static final TrackedData<String> HARMONIC_TYPE =
            DataTracker.registerData(AxiostaraEntity.class, TrackedDataHandlerRegistry.STRING);

    protected AxiostaraEntity(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(HARMONIC_TYPE, HarmonicType.PULSE.getValue().toString());
    }

    @Override
    public RegistryKey<DamageType> getHarmonicType() {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(this.dataTracker.get(HARMONIC_TYPE)));
    }

    @Override
    public void setHarmonicType(RegistryKey<DamageType> type) {
        this.dataTracker.set(HARMONIC_TYPE, type.getValue().toString());
    }
}
