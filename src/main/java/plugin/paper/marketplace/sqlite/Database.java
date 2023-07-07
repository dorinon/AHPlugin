package plugin.paper.marketplace.sqlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import plugin.paper.marketplace.offers.transaction.types.Auction;
import plugin.paper.marketplace.offers.transaction.types.BulkTransaction;
import plugin.paper.marketplace.offers.transaction.types.BIN;

import java.sql.SQLException;

public class Database {

    private static String url = "jdbc:sqlite:D:/Documents/dor/coding/sqlite/marketplace";
    private static Dao<Auction, Integer> auctionDao;
    private static Dao<BIN, Integer> fixedPriceDao;
    private static Dao<BulkTransaction, Integer> BulkDao;

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    private static ConnectionSource connectionSource = null;

    public static void init() {
        connect();
        setupTables();
    }

    private static void connect(){
        try {
            connectionSource = new JdbcConnectionSource(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setupTables() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Auction.class);
            TableUtils.createTableIfNotExists(connectionSource, BIN.class);
            TableUtils.createTableIfNotExists(connectionSource, BulkTransaction.class);

            auctionDao = DaoManager.lookupDao(connectionSource, Auction.class);
            fixedPriceDao = DaoManager.lookupDao(connectionSource, BIN.class);
            BulkDao = DaoManager.lookupDao(connectionSource, BulkTransaction.class);
        } catch (SQLException e) {
            throw new RuntimeException("Error setting up tables");
        }
    }
    public static void disconnect(){
        try {
            connectionSource.close();
        } catch (Exception e) {
            throw new RuntimeException("Error disconnecting from database");
        }
    }
    public static Dao<Auction, Integer> getAuctionDao() {
        return auctionDao;
    }

    public static Dao<BIN, Integer> getFixedPriceDao() {
        return fixedPriceDao;
    }

    public static Dao<BulkTransaction, Integer> getBulkDao() {
        return BulkDao;
    }

}
