package plugin.paper.marketplace.offers.transctions.types;

import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.paper.marketplace.offers.transctions.Transaction;

import java.util.Date;

@DatabaseTable(tableName = "bulk_transactions")
public class BulkTransaction extends Transaction {

    public BulkTransaction() {
    }
    @Override
    public void sold() {
    }
}