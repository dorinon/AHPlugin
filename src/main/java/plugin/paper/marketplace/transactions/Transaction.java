package plugin.paper.marketplace.transactions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public abstract class Transaction {
    private final UUID transactionID = UUID.randomUUID();
    private final ItemStack itemStack;
    private final double Price;
    private final Date endTime;
    private final Player seller;
    private boolean isRunning = true;
    private boolean isSold = false;
    private boolean isCancelled = false;
    public Transaction(ItemStack itemStack, double price, Player seller, Date endTime) {
        this.itemStack = itemStack;
        this.Price = price;
        this.endTime = endTime;
        this.seller = seller;
    }
    public abstract void sold();
    public UUID getTransactionID() {
        return transactionID;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public double getPrice() {
        return Price;
    }
    public Date getEndTime() {
        return endTime;
    }

    public Player getSeller() {
        return seller;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setSold(boolean sold) {isSold = sold;}

    public boolean isSold() {
        return isSold;
    }
    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    //TODO: Check if date is correct
    public boolean isExpired() {
        if (endTime.before(Date.from(Instant.EPOCH))) {
        isRunning = false;
        return true;
    } else {
        return false;
        }
    }
}

