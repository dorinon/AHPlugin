package plugin.paper.marketplace;

import com.samjakob.spigui.SpiGUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class Marketplace extends JavaPlugin {

    public static SpiGUI spigui;
    @Override
    public void onEnable() {
        // Plugin startup logic
        spigui = new SpiGUI(this);
    }

    @Override
    public void onDisable() {
    }
}
