package dev.prangell.axiostara.init;

import dev.prangell.axiostara.Axiostara;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public interface AxiostaraItemGroups {
    ItemGroup PULSE_WEAPONS_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(Axiostara.MOD_ID, "pulse_weapons_group"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.axiostara.pulse_weapons_group")).icon(() -> new ItemStack(AxiostaraItems.RESONANT_BLADE)).entries((displayContext, entries) -> {
        entries.add(AxiostaraItems.RESONANT_BLADE);
    }).build());

    public static void init() {

    }
}
