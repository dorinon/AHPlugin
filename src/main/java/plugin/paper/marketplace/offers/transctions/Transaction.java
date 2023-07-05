package plugin.paper.marketplace.offers.transctions;

import com.j256.ormlite.field.DatabaseField;
import org.bukkit.inventory.ItemStack;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public abstract class Transaction {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "itemStack")
    private ItemStack itemStack;
    @DatabaseField(columnName = "Price")
    private double Price;
    @DatabaseField(columnName = "startTime",  format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DatabaseField(columnName = "endTime", format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @DatabaseField(canBeNull = false)
    private UUID seller;
    @DatabaseField(columnName = "isRunning")
    private boolean isRunning = true;
    @DatabaseField(columnName = "isSold")
    private boolean isSold = false;
    @DatabaseField(columnName = "isCancelled")
    private boolean isCancelled = false;


    protected Transaction() {
    }

    public Transaction(ItemStack itemStack, double price, Date endTime, UUID playerUUID){
        this.seller = playerUUID;
        this.itemStack = itemStack;
        this.Price = price;
        this.startTime = Date.from(Instant.now());
        this.endTime = endTime;
    }

    public abstract void sold();
    public int getId() {
        return id;
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

    public UUID getSeller() {
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

    public Date getStartTime() {
        return startTime;
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

