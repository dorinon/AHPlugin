package plugin.paper.marketplace.offers.transctions.types;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.paper.marketplace.offers.transctions.Transaction;

import java.util.Map;

@DatabaseTable(tableName = "Auction")
public class Auction extends Transaction {

    @DatabaseField()
    private double highestBid = 0;
    private Map<Player, Double> bidders;

    public Auction() {
    }

    @Override
    public void sold() {

    }

    //TODO: check if exception if player does not exit in bidders
    public void removeBidder(Player player){bidders.remove(player);}
    public void addBidder(Player bidder, double bid) {
        bidders.put(bidder, bid);
        if (bid > highestBid) {
            highestBid = bid;
        }
    }

    public double getHighestBid() {
        return highestBid;
    }
    public Map<Player, Double> getBidders() {
        return bidders;
    }

}