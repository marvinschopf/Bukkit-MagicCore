package de.marvnet.minecraft.magiccore.api;

import de.marvnet.minecraft.magiccore.pluginutil.SysUtil;

public class MagicPlugins {

    @Deprecated
    public static void checkVersion(String pluginName, String pluginPrefix, int currentVersion) {
        SysUtil.checkVersion(pluginName, pluginPrefix, currentVersion, currentVersion + ".0.0");
    }

    public static void checkVersion(String pluginName, String pluginPrefix, int currentVersionID, String currentVersion) {
        SysUtil.checkVersion(pluginName, pluginPrefix, currentVersionID, currentVersion);
    }

    public static void checkVersion(String pluginName, int currentVersionID, String currentVersion) {
        SysUtil.checkVersion(pluginName, pluginName + "§7:§f ", currentVersionID, currentVersion);
    }

    public static void checkVersion(String pluginName) {
        SysUtil.checkVersion(pluginName, pluginName + "§7:§f ", 1, "1.0.0");
    }

    public static void checkVersion(String pluginName, String pluginPrefix) {
        SysUtil.checkVersion(pluginName, pluginPrefix, 1, "1.0.0");
    }
}
