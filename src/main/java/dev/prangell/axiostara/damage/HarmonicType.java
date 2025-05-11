package dev.prangell.axiostara.damage;

import dev.prangell.axiostara.Axiostara;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface HarmonicType {
    RegistryKey<DamageType> STABILIZED = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("stabilized"));
    RegistryKey<DamageType> PULSE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("pulse"));
    RegistryKey<DamageType> DISRUPTIVE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("disruptive"));
    RegistryKey<DamageType> FLOWING = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("flowing"));
}