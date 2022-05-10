package lemmensthijmen.mcopeneco;

import lemmensthijmen.DataBase.Database;
import lemmensthijmen.Events.CheckPlayerInDataBase;
import org.bukkit.plugin.java.JavaPlugin;

public final class McOpenEco extends JavaPlugin {

    private static McOpenEco main;

    @Override
    public void onEnable() {
        McOpenEco.main = this;
        Database.connectDataBase();

        new CheckPlayerInDataBase(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static McOpenEco getMain() {
        return main;
    }
}
