package de.marvnet.minecraft.magiccore.api;

import de.marvnet.minecraft.magiccore.playerutil.MagicPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MagicPlayers {
    public static MagicPlayer getPlayer(Player player) {
        return new MagicPlayer(player);
    }

    public static MagicPlayer getPlayer(String player) {
        return new MagicPlayer(player);
    }

    public static MagicPlayer getPlayer(UUID uuid) {
        return new MagicPlayer(uuid);
    }
}
