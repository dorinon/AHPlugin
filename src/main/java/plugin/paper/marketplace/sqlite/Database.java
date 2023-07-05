package plugin.paper.marketplace.sqlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import plugin.paper.marketplace.offers.transctions.types.Auction;

public class Database {

    String url = "jdbc:sqlite:src/main/resources/Database/MarketPlace";
    private Dao<Auction, Integer> AuctionDao;

    public Database() {

    }

    public void setup(String name) throws Exception {

        try (ConnectionSource connectionSource = new JdbcConnectionSource(url)) {

            AuctionDao = DaoManager.createDao(connectionSource, Auction.class);
            TableUtils.createTable(connectionSource, Auction.class);

        } catch (Exception e) {
            System.out.println("Error setting up database");
        }
    }
}
