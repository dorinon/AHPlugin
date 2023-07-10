package plugin.paper.marketplace.gui;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.PatternPane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.github.stefvanschie.inventoryframework.pane.util.Pattern;
import net.kyori.adventure.text.Component;
import org.apache.maven.model.Resource;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.paper.marketplace.Marketplace;

public class MarketGui {

    private final ChestGui gui = ChestGui.load(this, Marketplace.plugin.getResource("gui/market.xml"));
    private final Pattern background = new Pattern(
            "322222223",
            "100000001",
            "100000001",
            "100000001",
            "100000001",
            "100000001"
    );
    OutlinePane ItemsPane = new OutlinePane(1, 1, 8, 5);
    StaticPane SettingBar = new StaticPane(1, 5, 8, 1);

    public MarketGui() {
        gui.setOnTopDrag(event -> {
            event.setCancelled(true);
        });
        gui.setOnTopClick(event -> {
            event.setCancelled(true);
        });
        gui.setOnGlobalClick(event -> {
            if(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
                event.setCancelled(true);
            }
        });

    }

    public void open(Player player){

    }

    private void initBackground(){
        PatternPane backgroundPane = new PatternPane(0, 0, 9, 6, Pane.Priority.LOWEST, background);

        ItemStack backgroundItem1 = new ItemStack(Material.PINK_STAINED_GLASS_PANE);
        ItemStack backgroundItem2 = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemStack backgroundItem3 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);

        ItemMeta backgroundItem1Meta = backgroundItem1.getItemMeta();
        ItemMeta backgroundItem2Meta = backgroundItem2.getItemMeta();
        ItemMeta backgroundItem3Meta = backgroundItem3.getItemMeta();
        backgroundItem1Meta.displayName(Component.text(" "));
        backgroundItem2Meta.displayName(Component.text(" "));
        backgroundItem3Meta.displayName(Component.text(" "));
        backgroundItem1.setItemMeta(backgroundItem1Meta);
        backgroundItem2.setItemMeta(backgroundItem2Meta);
        backgroundItem3.setItemMeta(backgroundItem3Meta);

        GuiItem backgroundItem1Gui = new GuiItem(backgroundItem1);
        GuiItem backgroundItem2Gui = new GuiItem(backgroundItem2);
        GuiItem backgroundItem3Gui = new GuiItem(backgroundItem3);

        backgroundPane.bindItem('1', backgroundItem1Gui);
        backgroundPane.bindItem('2', backgroundItem2Gui);
        backgroundPane.bindItem('3', backgroundItem3Gui);

        gui.addPane(backgroundPane);
    }
    private void initSettingBar(){
        ItemStack prevPageItem = new ItemStack(Material.ARROW);
        ItemStack nextPageItem = new ItemStack(Material.ARROW);
        ItemStack selectAuctionShowTypeItem = new ItemStack(Material.LECTERN);
        ItemStack sortItem = new ItemStack(Material.CLOCK);
        ItemStack resetItem = new ItemStack(Material.ANVIL);
        ItemStack searchItem = new ItemStack(Material.OAK_SIGN);
        ItemStack mainMenuItem = new ItemStack(Material.BARRIER);
        ItemMeta prevPageItemMeta = prevPageItem.getItemMeta();
        ItemMeta nextPageItemMeta = nextPageItem.getItemMeta();
        ItemMeta selectAuctionShowTypeItemMeta = selectAuctionShowTypeItem.getItemMeta();
        ItemMeta sortItemMeta = sortItem.getItemMeta();
        ItemMeta resetItemMeta = resetItem.getItemMeta();
        ItemMeta searchItemMeta = searchItem.getItemMeta();
        ItemMeta mainMenuItemMeta = mainMenuItem.getItemMeta();
        prevPageItemMeta.displayName(Component.text("previous page"));
        nextPageItemMeta.displayName(Component.text("next page"));
        selectAuctionShowTypeItemMeta.displayName(Component.text("AUCTION/BUY NOW/ALL"));
        sortItemMeta.displayName(Component.text("ending soon/highest price/lowest price"));
        resetItemMeta.displayName(Component.text("reset"));
        searchItemMeta.displayName(Component.text("search"));
        mainMenuItemMeta.displayName(Component.text("main menu"));
        prevPageItem.setItemMeta(prevPageItemMeta);
        nextPageItem.setItemMeta(nextPageItemMeta);
        selectAuctionShowTypeItem.setItemMeta(selectAuctionShowTypeItemMeta);
        sortItem.setItemMeta(sortItemMeta);
        resetItem.setItemMeta(resetItemMeta);
        searchItem.setItemMeta(searchItemMeta);
        mainMenuItem.setItemMeta(mainMenuItemMeta);

        GuiItem prevPage = new GuiItem(prevPageItem, event -> {});
        GuiItem nextPage = new GuiItem(nextPageItem, event -> {});
        GuiItem selectAuctionShowType = new GuiItem(selectAuctionShowTypeItem, event -> {});
        GuiItem sort = new GuiItem(sortItem, event -> {});
        GuiItem reset = new GuiItem(resetItem, event -> {});
        GuiItem search = new GuiItem(searchItem, event -> {});
        GuiItem mainMenu = new GuiItem(mainMenuItem, event -> {});
        SettingBar.addItem(prevPage, 0, 0);
        SettingBar.addItem(search, 1, 0);
        SettingBar.addItem(sort, 2, 0);
        SettingBar.addItem(mainMenu, 3, 0);
        SettingBar.addItem(selectAuctionShowType, 4, 0);
        SettingBar.addItem(reset, 5, 0);
        SettingBar.addItem(nextPage, 6, 0);
        gui.addPane(SettingBar);
    }
}
