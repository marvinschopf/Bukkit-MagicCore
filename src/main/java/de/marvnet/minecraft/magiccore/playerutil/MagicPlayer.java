package de.marvnet.minecraft.magiccore.playerutil;

import de.marvnet.minecraft.magiccore.storage.PlayerStorage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MagicPlayer {
    private static PlayerStorage playerStorage;
    private static Player bukkitPlayer;

    public MagicPlayer(Player player) {
        bukkitPlayer = player;
        loadStorage();
    }

    public MagicPlayer(String player) {
        bukkitPlayer = Bukkit.getServer().getPlayer(player);
        loadStorage();
    }

    public MagicPlayer(UUID uuid) {
        bukkitPlayer = Bukkit.getServer().getPlayer(uuid);
        loadStorage();
    }

    private static void loadStorage() {
        playerStorage = new PlayerStorage(bukkitPlayer);
    }

    public static PlayerStorage getPlayerStorage() {
        return playerStorage;
    }
}
