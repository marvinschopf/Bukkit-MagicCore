package de.marvnet.minecraft.magiccore.main;

import de.marvnet.minecraft.magiccore.api.MagicPlugins;
import de.marvnet.minecraft.magiccore.listeners.EvtJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    public static Main getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(new EvtJoin(), getPlugin());
        MagicPlugins.checkVersion("MagicCore", "§7[§5MagicCore§7]§f ", 7, "1.0.7");
    }
}
