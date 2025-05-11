package dev.prangell.axiostara.entity.entitytype;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;

public interface HarmonicTyped {
    RegistryKey<DamageType> getHarmonicType();
    void setHarmonicType(RegistryKey<DamageType> type);
}