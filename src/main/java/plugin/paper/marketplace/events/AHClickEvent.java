package plugin.paper.marketplace.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AHClickEvent extends Event implements Cancellable {

    private boolean isCancelled;
    private final Player player;
    private final ClickType clickType;
    private final int slot;
    private final ItemStack itemStack;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    public AHClickEvent(Player player, ClickType clickType, int slot, ItemStack itemStack) {

        this.player = player;
        this.clickType = clickType;
        this.slot = slot;
        this.itemStack = itemStack;

        this.isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Player getPlayer() {return player;}
    public ClickType getClickType() {return clickType;}
    public int getSlot() {return slot;}
    public ItemStack getItemStack() {return itemStack;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
