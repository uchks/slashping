package me.uchks.slashping;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Ping.MODID, name = Ping.NAME, version = Ping.VERSION)
public final class Ping {
    public static final String MODID = "slashping";
    public static final String NAME = "SlashPing";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new PingCommand());
    }
}
