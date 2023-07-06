package plugin.paper.marketplace.offers.transaction.types;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.paper.marketplace.offers.transaction.Transaction;
import plugin.paper.marketplace.sqlite.Database;
import plugin.paper.marketplace.sqlite.foreignobjects.SQLBidder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@DatabaseTable(tableName = "Auction")
public class Auction extends Transaction {

    @DatabaseField()
    private double highestBid = 0;
    @ForeignCollectionField
    private ForeignCollection<SQLBidder> bidders;

    public Auction() {
    }
    public Auction(ItemStack item, UUID seller, double price, Date date) throws IOException {
        super(item, price, date, seller);
    }

    @Override
    public void sold(Player buyer) {
        try {
            Database.getAuctionDao().delete(this);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete auction " + getId() + " from database after sold");
        }
    }

    //TODO: check if exception if player does not exit in bidders
    public void removeBidder(Player player){bidders.remove(player);}
    public void addBidder(Player bidder, double bid) {
        bidders.add(new SQLBidder(bidder.getUniqueId(), bid));
        if (bid > highestBid) {
            highestBid = bid;
        }
    }

    public double getHighestBid() {
        return highestBid;
    }
    //TODO: change to return a map of bidders
    public ForeignCollection<SQLBidder> getBidders() {
        return bidders;
    }
}