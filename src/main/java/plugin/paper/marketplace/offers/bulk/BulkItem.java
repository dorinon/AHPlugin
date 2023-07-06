package plugin.paper.marketplace.offers.bulk;

import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class BulkItem {

    private String name;
    private int id;
    private ItemStack bulkType;
    private int amount;
    private int pricePerItem = 0;
    private List<UUID> players;

    public BulkItem(String name, int id, ItemStack bulkType, int amount) {
        this.name = name;
        this.id = id;
        this.bulkType = bulkType;
        this.amount = amount;
    }
}
