package plugin.paper.marketplace.events.ah;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AHCloseEvent extends Event implements Cancellable {

    private boolean isCancelled;
    private final Player player;
    private static final HandlerList handlers = new HandlerList();

    public AHCloseEvent(Player player) {
        this.player = player;

        isCancelled  = false;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    public Player getPlayer() {
        return player;
    }
}

