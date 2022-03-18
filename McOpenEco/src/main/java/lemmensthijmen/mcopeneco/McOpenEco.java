package lemmensthijmen.mcopeneco;

import org.bukkit.plugin.java.JavaPlugin;

public final class McOpenEco extends JavaPlugin {

    private static McOpenEco main;

    @Override
    public void onEnable() {
        McOpenEco.main = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static McOpenEco getMain() {
        return main;
    }
}
