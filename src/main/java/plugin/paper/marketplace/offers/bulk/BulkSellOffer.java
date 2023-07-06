package plugin.paper.marketplace.offers.bulk;

import java.util.List;
import java.util.UUID;

public class BulkSellOffer {

    private int id;
    private int bulkItemId;
    private int amount;
    private int pricePerItem;
    private UUID sellerUUID;


    public BulkSellOffer(int bulkItemId, int amount, int pricePerItem, UUID sellerUUID) {
        this.bulkItemId = bulkItemId;
        this.amount = amount;
        this.pricePerItem = pricePerItem;
        this.sellerUUID = sellerUUID;
    }

}
