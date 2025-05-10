package dev.prangell.axiostara.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class AxiostaraConfig extends MidnightConfig {
    public static final String axiostara = "axiostara";
    @Entry(category = axiostara)
    public static boolean enableMod = true;
}
