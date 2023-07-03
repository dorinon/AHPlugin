package plugin.paper.marketplace.transactions.types;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.paper.marketplace.transactions.Transaction;

import java.util.Date;

public class Bulk extends Transaction {

    public Bulk(ItemStack itemStack, double pricePerItem, Player seller, Date endTime, int buyAmount) {
        super(itemStack, pricePerItem, seller, endTime);
    }
    @Override
    public void sold() {
    }
}
