package plugin.paper.marketplace.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import plugin.paper.marketplace.gui.MarketGui;

public class PlayerShiftListener implements Listener {

    @EventHandler
    public void onShift(PlayerToggleSneakEvent event) {
        MarketGui gui = new MarketGui();
        gui.open(event.getPlayer());
    }
}
