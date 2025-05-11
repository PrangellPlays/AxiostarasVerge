package dev.prangell.axiostara.item.weapontype;

import dev.prangell.axiostara.damage.DamageMode;
import dev.prangell.axiostara.damage.HarmonicType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;

import java.util.Map;

public interface HarmonicWeapon {
    boolean dealsPercentDamage();
    float getPercentDamage(); // e.g. 0.15f for 15%

    boolean dealsTrueDamage();
    float getTrueDamage(); // e.g. 0.15f for 15%

    RegistryKey<DamageType> getHarmonicType(); // Optional, if you want elemental interactions
    float getHarmonicDamage(); // e.g. 0.15f for 15%
}