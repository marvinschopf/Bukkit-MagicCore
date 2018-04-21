package de.marvnet.minecraft.magiccore.listeners;

import de.marvnet.minecraft.magiccore.api.MagicPlayers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EvtJoin implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        MagicPlayers.getPlayer(player).getPlayerStorage().set("name", player.getName());
    }
}
