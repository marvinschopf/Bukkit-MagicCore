package de.marvnet.minecraft.magiccore.pluginutil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.marvnet.minecraft.magiccore.main.Main;
import de.marvnet.minecraft.magiccore.net.NetUtil;
import org.bukkit.Bukkit;

public class SysUtil {

    public static void checkVersion(final String plugin, final String prefix, final int currentVersionID, final String currentVersion) {
        Bukkit.getConsoleSender().sendMessage("§eChecking version...");
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                String responseBody = NetUtil.getString("https://ghdata.marvnet.de/minecraft/plugins/" + plugin + "/data.json");
                JsonElement jsonElement = new JsonParser().parse(responseBody);
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                int latestVersion = jsonObject.get("version_id").getAsInt();
                String latestVersionStr = jsonObject.get("version").getAsString();
                if (currentVersionID < latestVersion) {
                    Bukkit.getConsoleSender().sendMessage(prefix + "§aYou are running the latest version of §e" + plugin + "§a!");
                } else if(currentVersionID > latestVersion) {
                    Bukkit.getConsoleSender().sendMessage(prefix + "§eYou are using a version newer than the newest release version. You're probably using a beta or development version. Please check github.com/MagicMarvMan/MagicCore.");
                }else {
                    String versionBehindString = "§e" + (latestVersion - currentVersionID) + "§c versions";
                    if((latestVersion - currentVersionID) == 1) {
                        versionBehindString = "§e" + (latestVersion - currentVersionID) + "§c version";
                    }
                    Bukkit.getConsoleSender().sendMessage(prefix + "§cA new version §e(" + latestVersionStr + ") §cof §e" + plugin +" §cis available. You are running version §e"+ currentVersion + "§c. You are " + versionBehindString +  " behind.");
                }
            }
        });
    }
}
