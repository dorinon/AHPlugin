package plugin.paper.marketplace.sqlite;

import com.j256.ormlite.dao.Dao;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import plugin.paper.marketplace.offers.transaction.types.Auction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class DatabaseTest {
    @Before
    public void testDatabase() {
        Database.init();
    }

    @Test
    public void testReadWrite() throws SQLException, IOException {
        Dao<Auction, Integer> actionDao = Database.getAuctionDao();
        Auction auction = new Auction(new ItemStack(Material.DIAMOND), UUID.randomUUID(), 100, new Date());
        actionDao.create(auction);
        Assert.assertEquals(auction, actionDao.queryForId(auction.getId()));
        Assert.assertEquals(auction, actionDao.queryForEq("id", auction.getId()).get(0));
    }


}