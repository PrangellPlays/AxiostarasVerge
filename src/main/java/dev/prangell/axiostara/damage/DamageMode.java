package dev.prangell.axiostara.damage;

import dev.prangell.axiostara.Axiostara;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface DamageMode {
    RegistryKey<DamageType> PERCENT = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("percent"));
    RegistryKey<DamageType> TRUE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Axiostara.id("true"));
}