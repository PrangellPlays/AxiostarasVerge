package dev.prangell.axiostara;

import dev.prangell.axiostara.util.AxiostaraRegistries;
import net.fabricmc.api.ClientModInitializer;

public class AxiostaraClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AxiostaraRegistries.clientInit();
    }
}
