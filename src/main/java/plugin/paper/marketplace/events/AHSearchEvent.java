package plugin.paper.marketplace.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AHSearchEvent extends Event implements Cancellable {
    private boolean isCancelled;
    private static final HandlerList handlers = new HandlerList();

    public AHSearchEvent(String search) {


        isCancelled  = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
