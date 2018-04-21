package de.marvnet.minecraft.magiccore.pluginutil;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.marvnet.minecraft.magiccore.main.Main;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.bukkit.Bukkit;

import java.io.IOException;

public class SysUtil {

    public static void checkVersion(final String plugin, final String prefix, final int currentVersion) {
        Bukkit.getConsoleSender().sendMessage("§eChecking version...");
        Bukkit.getScheduler().runTaskAsynchronously(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                CloseableHttpClient httpclient = HttpClients.createDefault();
                try {
                    HttpGet httpGet = new HttpGet("https://ghdata.marvnet.de/minecraft/plugins/" + plugin + "/data.json");
                    // Create a custom response handler
                    ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                        @Override
                        public String handleResponse(
                                final HttpResponse response) throws ClientProtocolException, IOException {
                            int status = response.getStatusLine().getStatusCode();
                            if (status >= 200 && status < 300) {
                                HttpEntity entity = response.getEntity();
                                return entity != null ? EntityUtils.toString(entity) : null;
                            } else {
                                throw new ClientProtocolException("Unexpected response status: " + status);
                            }
                        }

                    };
                    String responseBody = httpclient.execute(httpGet, responseHandler);
                    JsonElement jsonElement = new JsonParser().parse(responseBody);
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    int latestVersion = jsonObject.get("version_id").getAsInt();
                    if(currentVersion == latestVersion) {
                        Bukkit.getConsoleSender().sendMessage(prefix + "§aYou are running the latest version of AdminGUI!");
                    } else {
                        Bukkit.getConsoleSender().sendMessage(prefix + "§cA newer version §e(" + latestVersion + ") §cof AdminGUI is available. You are running version §e"+ currentVersion + "§c.");
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        httpclient.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
