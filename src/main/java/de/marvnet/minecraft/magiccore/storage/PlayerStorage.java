package de.marvnet.minecraft.magiccore.storage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerStorage {
    private static Player player;
    private static YamlConfiguration yaml;
    private static File file;

    public PlayerStorage(Player nPlayer) {
        player = nPlayer;
        initStorage();
    }

    private static void initStorage() {
        File folder = new File("plugins//Magic//players");
        if(!folder.exists()) {
            folder.mkdirs();
        }

        file = new File("plugins//Magic//players//" + player.getUniqueId().toString());
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage("§cAn error occured while creating player storage for §e" + player.getName() + "§c: " + e.getMessage());
            }
        }
        yaml = YamlConfiguration.loadConfiguration(file);
    }

    public static Object get(String path) {
        return yaml.get(path);
    }

    public static String getString(String path) {
        return yaml.getString(path);
    }

    public static int getInt(String path) {
        return yaml.getInt(path);
    }

    public static boolean getBool(String path) {
        return yaml.getBoolean(path);
    }

    public static void save() {
        try {
            yaml.save(file);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage("§cCould not save player file for §e" + player.getName() + "§c!");
        }
    }

    public static void set(String path, Object value, boolean autosave) {
        yaml.set(path, value);
        if(autosave) {
            save();
        }
    }

    public static void set(String path, Object value) {
        yaml.set(path, value);
        save();
    }


}
