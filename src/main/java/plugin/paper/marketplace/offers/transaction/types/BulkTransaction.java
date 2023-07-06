package plugin.paper.marketplace.offers.transaction.types;

import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.entity.Player;
import plugin.paper.marketplace.offers.transaction.Transaction;

@DatabaseTable(tableName = "bulk_transactions")
public class BulkTransaction extends Transaction {

    public BulkTransaction() {
    }
    @Override
    public void sold(Player buyer) {
    }
}