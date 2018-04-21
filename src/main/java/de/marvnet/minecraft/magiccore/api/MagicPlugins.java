package de.marvnet.minecraft.magiccore.api;

import de.marvnet.minecraft.magiccore.pluginutil.SysUtil;

public class MagicPlugins {

    public static void checkVersion(String pluginName, String pluginPrefix, int currentVersion) {
        SysUtil.checkVersion(pluginName, pluginPrefix, currentVersion);
    }

    public static void checkVersion(String pluginName, int currentVersion) {
        SysUtil.checkVersion(pluginName, pluginName + "§7:§f ", currentVersion);
    }

    public static void checkVersion(String pluginName) {
        SysUtil.checkVersion(pluginName, pluginName + "§7:§f ", 1);
    }

    public static void checkVersion(String pluginName, String pluginPrefix) {
        SysUtil.checkVersion(pluginName, pluginPrefix, 1);
    }
}
