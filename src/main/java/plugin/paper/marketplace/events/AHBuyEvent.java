package plugin.paper.marketplace.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AHBuyEvent extends Event implements Cancellable {

    private final ItemStack itemStack;
    private final UUID transactionID;
    private final Player seller;
    private final Player  buyer;
    private final double price;
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    public AHBuyEvent(ItemStack itemStack, UUID transactionID, Player seller, Player buyer, double price) {
        this.itemStack = itemStack;
        this.transactionID = transactionID;
        this.seller = seller;
        this.buyer = buyer;
        this.price = price;
        this.isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public ItemStack getItemStack() {return itemStack;}
    public UUID getTransactionID() {return transactionID;}
    public Player getSeller() {return seller;}
    public Player getBuyer() {return buyer;}
    public double getPrice() {return price;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
