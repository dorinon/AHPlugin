package plugin.paper.marketplace.sqlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import net.ricecode.similarity.JaroWinklerStrategy;
import net.ricecode.similarity.SimilarityStrategy;
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

    private Dao<Auction, Integer> actionDao;
    @Before
    public void testDatabase() {
        Database.init();
        actionDao = Database.getAuctionDao();
    }

    @Test
    public void testReadWrite() throws SQLException, IOException {
        Auction auction = new Auction(new ItemStack(Material.DIAMOND), UUID.randomUUID(), 100, new Date());
        actionDao.create(auction);
        Assert.assertEquals(auction.getId(), actionDao.queryForId(auction.getId()).getId());
    }

    @Test
    public void testDelete() throws SQLException {
        Auction auction = new Auction(new ItemStack(Material.DIAMOND), UUID.randomUUID(), 100, new Date());
        actionDao.create(auction);
        actionDao.delete(auction);

        Assert.assertNull(actionDao.queryForId(auction.getId()));
    }

    @Test
    public void testUpdate() throws SQLException {
        Auction auction = new Auction(new ItemStack(Material.DIAMOND), UUID.randomUUID(), 100, new Date());
        actionDao.create(auction);
        auction.setPrice(200);
        actionDao.update(auction);

        Assert.assertEquals(200, actionDao.queryForId(auction.getId()).getPrice(), 0);
    }

    @Test
    public void testQueryByName() throws SQLException {
        Auction auction = new Auction(new ItemStack(Material.DIAMOND), UUID.randomUUID(), 100, new Date());
        actionDao.create(auction);
        QueryBuilder<Auction, Integer> queryBuilder = actionDao.queryBuilder();
        queryBuilder.where().like("name", "te%");
        Assert.assertFalse(actionDao.query(queryBuilder.prepare()).isEmpty());
    }
}