package dev.shyzouka.bungeesystem.commands;

import com.google.common.base.Joiner;
import dev.shyzouka.bungeesystem.BungeeSystem;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Broadcast extends Command {
    public Broadcast(){
        super("broadcast", "bungee.bc", "bc");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) commandSender;

        if(args.length == 0){
            player.sendMessage(BungeeSystem.getUsage() + "/bc <message>");
        } else {
            String message = Joiner.on(' ').join(args).replace("&", "§");

            for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()){

                all.sendMessage(BungeeSystem.getBroadcast());
                all.sendMessage(BungeeSystem.getBroadcast() + message);
                all.sendMessage(BungeeSystem.getBroadcast());

            }

        }

    }
}
