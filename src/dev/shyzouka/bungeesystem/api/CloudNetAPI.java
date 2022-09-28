package dev.shyzouka.bungeesystem.api;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.ext.bridge.ServiceInfoSnapshotUtil;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class CloudNetAPI {

    public CloudNetAPI(){

    }

    public String getProxyCloudRank(ProxiedPlayer player){
        return CloudNetDriver.getInstance().getPermissionManagement().getHighestPermissionGroup(CloudNetDriver.getInstance().getPermissionManagement().getUser(player.getUniqueId())).getColor().replaceAll("&","§") + CloudNetDriver.getInstance().getPermissionManagement().getHighestPermissionGroup(CloudNetDriver.getInstance().getPermissionManagement().getUser(player.getUniqueId())).getName();
    }

    public String getSpigotCloudRank(Player player){
        return CloudNetDriver.getInstance().getPermissionManagement().getHighestPermissionGroup(CloudNetDriver.getInstance().getPermissionManagement().getUser(player.getUniqueId())).getColor().replaceAll("&","§") + CloudNetDriver.getInstance().getPermissionManagement().getHighestPermissionGroup(CloudNetDriver.getInstance().getPermissionManagement().getUser(player.getUniqueId())).getName();
    }

    public Integer getGroupOnlineCount(final String group){
        int count = 0;
        final Collection<ServiceInfoSnapshot> collection = (Collection<ServiceInfoSnapshot>) CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServicesByGroup(group);
        for (final ServiceInfoSnapshot serviceInfoSnapshot : collection) {
            count += ServiceInfoSnapshotUtil.getOnlineCount(serviceInfoSnapshot);
        }
        return count;
    }

    public Integer getServiceOnlineCount(final String service){
        int count = 0;
        final Collection<ServiceInfoSnapshot> collection = (Collection<ServiceInfoSnapshot>) CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName(service);
        for(final ServiceInfoSnapshot serviceInfoSnapshot : collection){
            count += ServiceInfoSnapshotUtil.getTaskOnlineCount(service);
        }
        return count;
    }

}
