package me.uchks.slashping;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.command.*;
import net.minecraft.util.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class PingCommand extends CommandBase
{

    @Override
    public String getCommandName() {
        return "ping";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public String getCommandUsage(final ICommandSender sender) {
        return "/ping [player]";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        final Minecraft mc = Minecraft.getMinecraft();
        final String name = args.length > 0 ? args[0] : mc.getSession().getUsername();
        final int ping = getPingValue(name);
        
        final String message = ping == -1 
            ? EnumChatFormatting.RED + "Player '" + name + "' not found or offline."
            : EnumChatFormatting.AQUA + name + EnumChatFormatting.GRAY + " has a ping of " + PingUtils.formatPingWithCategory(ping);
        
        mc.thePlayer.addChatMessage(new ChatComponentText(message));
    }

    @Override
    public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
        return (args.length == 1) ? getListOfStringsMatchingLastWord(args, OnlinePlayers.getListOfPlayerUsernames()) : null;
    }

    private int getPingValue(String name) {
        final Collection<NetworkPlayerInfo> players = Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap();
        for (NetworkPlayerInfo info : players) {
            if (info.getGameProfile().getName().equals(name)) {
                return info.getResponseTime();
            }
        }
        return -1;
    }
    
}