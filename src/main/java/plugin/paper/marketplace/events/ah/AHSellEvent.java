package plugin.paper.marketplace.events.ah;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class AHSellEvent extends Event implements Cancellable {


    private final ItemStack itemStack;
    private final UUID auctionID;
    private final Player seller;
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

    public AHSellEvent(ItemStack itemStack, UUID auctionID, Player seller, double price) {
        this.itemStack = itemStack;
        this.auctionID = auctionID;
        this.seller = seller;
        this.price = price;
        this.isCancelled = false;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }


    public ItemStack getItemStack() {return itemStack;}
    public UUID getAuctionID() {return auctionID;}
    public Player getSeller() {return seller;}
    public double getPrice() {return price;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
