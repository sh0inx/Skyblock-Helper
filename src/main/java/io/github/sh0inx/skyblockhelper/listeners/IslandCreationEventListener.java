package io.github.sh0inx.skyblockhelper.listeners;

import com.iridium.iridiumskyblock.api.IslandCreateEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class IslandCreationEventListener implements Listener {

    @EventHandler
    public void onIslandCreateEvent(IslandCreateEvent event) {

        Player player = event.getUser().getPlayer();

        if(!player.hasPermission("skyblockHelper.islandCreation")) {
            event.setCancelled(true);
            player.sendMessage("Sorry, you can't do that - lacking permission \"skyblockHelper.islandCreation\".");
            return;
        }

        player.sendMessage("You're creating an island, good job!");
    }

}
