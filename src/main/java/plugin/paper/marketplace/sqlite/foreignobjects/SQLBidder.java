package plugin.paper.marketplace.sqlite.foreignobjects;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import plugin.paper.marketplace.offers.transaction.types.Auction;

import java.util.UUID;

@DatabaseTable(tableName = "bidders")
public class SQLBidder {

    @DatabaseField()
    private double bid;

    @DatabaseField()
    private UUID bidder;
    @DatabaseField(foreign = true)
    private Auction auction;
    public SQLBidder() {
    }

    public SQLBidder(UUID bidder, double bid) {
        this.bidder = bidder;
        this.bid = bid;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public UUID getBidder() {
        return bidder;
    }

    public void setBidder(UUID bidder) {
        this.bidder = bidder;
    }
}
