package me.uchks.slashping;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import java.util.ArrayList;
import java.util.Collection;

public final class OnlinePlayers {
    
    private static final String[] EMPTY_ARRAY = new String[0];
    
    private OnlinePlayers() {}
    
    public static String[] getListOfPlayerUsernames() {
        try {
            final Minecraft mc = Minecraft.getMinecraft();
            if (mc == null || mc.getNetHandler() == null) {
                return EMPTY_ARRAY;
            }
            
            final Collection<NetworkPlayerInfo> players = mc.getNetHandler().getPlayerInfoMap();
            if (players == null || players.isEmpty()) {
                return EMPTY_ARRAY;
            }
            
            final ArrayList<String> names = new ArrayList<>(players.size());
            for (final NetworkPlayerInfo info : players) {
                if (info != null && info.getGameProfile() != null && info.getGameProfile().getName() != null) {
                    names.add(info.getGameProfile().getName());
                }
            }
            return names.toArray(EMPTY_ARRAY);
        } catch (Exception e) {
            return EMPTY_ARRAY;
        }
    }
}