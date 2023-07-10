package plugin.paper.marketplace;

import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import org.bukkit.plugin.java.JavaPlugin;

public final class Marketplace extends JavaPlugin {
    public static Marketplace plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new plugin.paper.marketplace.listeners.PlayerShiftListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
