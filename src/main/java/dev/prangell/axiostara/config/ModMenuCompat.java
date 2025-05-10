package dev.prangell.axiostara.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.prangell.axiostara.Axiostara;
import eu.midnightdust.lib.config.MidnightConfig;

public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent, Axiostara.MOD_ID);
    }
}