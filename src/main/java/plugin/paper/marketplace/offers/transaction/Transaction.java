package plugin.paper.marketplace.offers.transaction;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.json.simple.JSONObject;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public abstract class Transaction {

    public void setId(int id) {
        this.id = id;
    }
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String lore;
    @DatabaseField(columnName = "itemStack", dataType = DataType.BYTE_ARRAY)
    private byte[] itemStack;

    public void setPrice(double price) {
        Price = price;
    }

    @DatabaseField(columnName = "Price")
    private double Price;
    @DatabaseField(columnName = "startTime",  format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DatabaseField(columnName = "endTime", format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @DatabaseField(canBeNull = false)
    private UUID seller;
    @DatabaseField()
    private boolean isActive = true;
    protected Transaction() {
    }

    public Transaction(ItemStack itemStack, double price, Date endTime, UUID playerUUID) {

        name = "test";
        /*this.name = itemStack.getItemMeta().getDisplayName();
        if (itemStack.getItemMeta().hasLore()){
            for (Component line: itemStack.lore()) {
                this.lore += "\n" + line.examinableName();
                }
        }*/
        this.seller = playerUUID;
        this.Price = price;
        //this.itemStack = itemStack.serializeAsBytes();
        this.startTime = Date.from(Instant.now());
        this.endTime = endTime;
    }
    public abstract void sold(Player Buyer);
    public int getId() {
        return id;
    }
    //TODO: check if this works
    public ItemStack getItemStack() {
        return ItemStack.deserializeBytes(itemStack);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLore() {
        return lore;
    }
    public void setLore(String lore) {
        this.lore = lore;
    }
    public void setItemStack(byte[] itemStack) {
        this.itemStack = itemStack;
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
    public Date getStartTime() {
        return startTime;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    //TODO: Check if date is correct and add to database
    public boolean isExpired() {
        if (endTime.before(Date.from(Instant.EPOCH))) {
        return true;
    } else {
        return false;
        }
    }
}

