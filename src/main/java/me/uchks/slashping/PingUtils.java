package me.uchks.slashping;

import net.minecraft.util.EnumChatFormatting;

public final class PingUtils {
    
    private PingUtils() {}
    
    public static String formatPingWithCategory(int ping) {
        if (ping < 0) {
            return EnumChatFormatting.GRAY + "Unknown" + EnumChatFormatting.RESET;
        }
        
        final EnumChatFormatting color;
        final String category;
        
        if (ping < 50) {
            color = EnumChatFormatting.GREEN;
            category = "Excellent";
        } else if (ping < 100) {
            color = EnumChatFormatting.YELLOW;
            category = "Good";
        } else if (ping < 200) {
            color = EnumChatFormatting.GOLD;
            category = "Fair";
        } else {
            color = EnumChatFormatting.RED;
            category = "Poor";
        }
        
        return color.toString() + ping + "ms" + EnumChatFormatting.GRAY + " (" + category + ")" + EnumChatFormatting.RESET;
    }
}