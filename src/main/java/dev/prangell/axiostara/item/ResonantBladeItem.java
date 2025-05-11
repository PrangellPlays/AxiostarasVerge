package dev.prangell.axiostara.item;

import dev.prangell.axiostara.damage.DamageMode;
import dev.prangell.axiostara.damage.HarmonicType;
import dev.prangell.axiostara.entity.AxiostaraEntity;
import dev.prangell.axiostara.item.weapontype.HarmonicWeapon;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResonantBladeItem extends SwordItem implements HarmonicWeapon {
    public ResonantBladeItem(Settings settings) {
        super(ToolMaterials.NETHERITE, -4, -2.4f, settings);
    }

    @Override
    public boolean dealsPercentDamage() {
        return true;
    }

    @Override
    public float getPercentDamage() {
        return 0.15f; // 15% of max health
    }

    @Override
    public boolean dealsTrueDamage() {
        return false;
    }

    @Override
    public float getTrueDamage() {
        return 0.0f;
    }

    @Override
    public RegistryKey<DamageType> getHarmonicType() {
        return HarmonicType.PULSE;
    }

    @Override
    public float getHarmonicDamage() {
        return 0.2f;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker.getWorld() instanceof ServerWorld serverWorld)) return false;

        Registry<DamageType> registry = serverWorld.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE);

        if (dealsPercentDamage()) {
            if (target instanceof AxiostaraEntity axiostaraEntity && axiostaraEntity.getHarmonicType() == this.getHarmonicType()) {
                float percentDamage = target.getMaxHealth() * getPercentDamage();
                float harmonicDamage = getHarmonicDamage();
                float modifiedPercentDamage = ((1 + harmonicDamage) * percentDamage) - percentDamage;
                RegistryEntry<DamageType> percentEntry = registry.getEntry(DamageMode.PERCENT).orElseThrow();
                target.damage(new DamageSource(percentEntry), percentDamage);

                RegistryEntry<DamageType> harmonicEntry = registry.getEntry(getHarmonicType()).orElseThrow();
                target.damage(new DamageSource(harmonicEntry), modifiedPercentDamage);

                if (attacker instanceof ServerPlayerEntity player) {
                    float percent = ((percentDamage * (1 + harmonicDamage)) / target.getMaxHealth()) * 100f;

                    player.sendMessage(Text.literal(String.format(
                            "Dealt %.1f%% of %s's health (%.2f percent damage + %.3f harmonic damage)", percent, target.getName().getString(), percentDamage, modifiedPercentDamage
                    )).formatted(Formatting.BLUE), false);
                }
            } else {
                float percentDamage = target.getMaxHealth() * getPercentDamage();
                RegistryEntry<DamageType> percentEntry = registry.getEntry(DamageMode.PERCENT).orElseThrow();
                target.damage(new DamageSource(percentEntry), percentDamage);

                if (attacker instanceof ServerPlayerEntity player) {
                    float percent = (percentDamage / target.getMaxHealth()) * 100f;

                    player.sendMessage(Text.literal(String.format(
                            "Dealt %.1f%% of %s's health (%.2f percent damage)", percent, target.getName().getString(), percentDamage
                    )).formatted(Formatting.BLUE), false);
                }
            }
        }

        if (dealsTrueDamage()) {
            if (target instanceof AxiostaraEntity axiostaraEntity && axiostaraEntity.getHarmonicType() == this.getHarmonicType()) {
                float trueDamage = target.getMaxHealth() * getTrueDamage();
                float harmonicDamage = getHarmonicDamage();
                float modifiedTrueDamage = ((1 + harmonicDamage) * trueDamage) - trueDamage;
                RegistryEntry<DamageType> trueEntry = registry.getEntry(DamageMode.TRUE).orElseThrow();
                target.damage(new DamageSource(trueEntry), trueDamage);

                RegistryEntry<DamageType> harmonicEntry = registry.getEntry(getHarmonicType()).orElseThrow();
                target.damage(new DamageSource(harmonicEntry), modifiedTrueDamage);

                if (attacker instanceof ServerPlayerEntity player) {
                    float trueD = ((trueDamage * (1 + harmonicDamage)) / target.getMaxHealth()) * 100f;

                    player.sendMessage(Text.literal(String.format(
                            "Dealt %.1f%% of %s's health (%.2f true damage + %.3f harmonic damage)", trueD, target.getName().getString(), trueDamage, modifiedTrueDamage
                    )).formatted(Formatting.BLUE), false);
                }
            } else {
                float trueDamage = target.getMaxHealth() * getTrueDamage();
                RegistryEntry<DamageType> trueEntry = registry.getEntry(DamageMode.TRUE).orElseThrow();
                target.damage(new DamageSource(trueEntry), trueDamage);

                if (attacker instanceof ServerPlayerEntity player) {
                    float trueD = (trueDamage / target.getMaxHealth()) * 100f;

                    player.sendMessage(Text.literal(String.format(
                            "Dealt %.1f%% of %s's health (%.2f true damage)", trueD, target.getName().getString(), trueDamage
                    )).formatted(Formatting.BLUE), false);
                }
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.axiostara.resonant_blade.desc").formatted(Formatting.LIGHT_PURPLE));
        tooltip.add(Text.empty());
        tooltip.add(Text.translatable("axiostara.type.pulse").formatted(Formatting.AQUA));
        tooltip.add(Text.translatable("axiostara.mode.percent").formatted(Formatting.GOLD));
    }
}