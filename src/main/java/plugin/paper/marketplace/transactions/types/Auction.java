package plugin.paper.marketplace.transactions.types;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import plugin.paper.marketplace.transactions.Transaction;

import java.util.Date;
import java.util.Map;

public class Auction extends Transaction {
    private double highestBid = 0;
    private Map<Player, Double> bidders;

    public Auction(ItemStack itemStack, double startingBid, Player seller, Date endTime) {
        super(itemStack, startingBid, seller, endTime);
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