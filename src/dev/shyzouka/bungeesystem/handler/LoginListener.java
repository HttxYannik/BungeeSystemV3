package dev.shyzouka.bungeesystem.handler;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginListener implements Listener {

    @EventHandler
    public void onJoin(PostLoginEvent event){
        ProxiedPlayer player = (ProxiedPlayer) event.getPlayer();



    }

}
