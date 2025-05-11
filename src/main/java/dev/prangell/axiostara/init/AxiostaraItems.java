package dev.prangell.axiostara.init;

import dev.prangell.axiostara.Axiostara;
import dev.prangell.axiostara.item.ResonantBladeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.LinkedHashMap;
import java.util.Map;

public class AxiostaraItems {
    protected static final Map<Item, Identifier> ITEMS = new LinkedHashMap();
    public static final Item RESONANT_BLADE;

    public static void init() {
        ITEMS.forEach((item, id) -> {
            Registry.register(Registries.ITEM, id, item);
        });
    }

    protected static <T extends Item> T register(String name, T item) {
        ITEMS.put(item, Axiostara.id(name));
        return item;
    }

    public AxiostaraItems() {
    }

    static {
        RESONANT_BLADE = register((String) "resonant_blade", (Item) (new ResonantBladeItem(new FabricItemSettings().fireproof().rarity(Rarity.COMMON))));
    }
}