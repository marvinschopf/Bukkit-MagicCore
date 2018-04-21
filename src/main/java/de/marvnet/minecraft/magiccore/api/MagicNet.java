package de.marvnet.minecraft.magiccore.api;

import de.marvnet.minecraft.magiccore.net.NetUtil;

public class MagicNet {
    public static String getString(String url) {
        return NetUtil.getString(url);
    }
}
