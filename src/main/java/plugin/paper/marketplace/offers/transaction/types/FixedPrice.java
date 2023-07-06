package plugin.paper.marketplace.offers.transaction.types;

import org.bukkit.entity.Player;
import plugin.paper.marketplace.offers.transaction.Transaction;
import plugin.paper.marketplace.sqlite.Database;

import java.sql.SQLException;

public class FixedPrice extends Transaction {
    @Override
    public void sold(Player buyer) {
        try {
            Database.getFixedPriceDao().delete(this);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete FixedPrice " + getId() + " from database after sold");
        }
    }
}
