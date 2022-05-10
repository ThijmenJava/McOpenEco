package lemmensthijmen.Events;

import lemmensthijmen.DataBase.Database;
import lemmensthijmen.mcopeneco.McOpenEco;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.*;

public class CheckPlayerInDataBase implements Listener {

    private ResultSet query;
    private McOpenEco main;

    public CheckPlayerInDataBase(McOpenEco main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Connection con = Database.getCon();
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mcaccounts WHERE uuid ='" + player.getUniqueId() + "'");
            main.getLogger().info(String.valueOf(resultSet));
//            query = stat.execute("SELECT * FROM mcaccounts WHERE uuid=+'"+player.getUniqueId()+"'");
            if (!resultSet.absolute(1)) {
                PreparedStatement prepareAccount = con.prepareStatement("INSERT INTO mcaccounts(uuid, naam, geld) VALUES (???)");
                prepareAccount.setString(1, String.valueOf(player.getUniqueId()));
                prepareAccount.setString(2, player.getName());
                prepareAccount.setInt(3, 500);
                prepareAccount.executeQuery();
                main.getLogger().info("account made!");
            } else {
                main.getLogger().info("error!");
//                query = stat.executeQuery("SELECT geld FROM mcaccounts where");
//                player.sendMessage("Welcome " + player.getName() + ", geld: " + );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
