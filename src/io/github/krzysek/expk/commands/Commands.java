package io.github.krzysek.expk.commands;

import io.github.krzysek.expk.ExParkour;
import io.github.krzysek.expk.utils.Lobby;
import io.github.krzysek.expk.utils.User;
import io.github.krzysek.expk.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    protected final String tag = "&8[&6˟&8]&r";
    protected final FileConfiguration config = new ExParkour().getConfig(ExParkour.cType.CONFIG);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("exparkour") || label.equalsIgnoreCase("expk")) {
            Utils utils = new Utils((Player) sender);
            User user = new User(((Player) sender).getUniqueId());
            if(args.length == 0 || args[0].equalsIgnoreCase("help") || (!(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("stats") || args[0].equalsIgnoreCase("join") || args[0].equalsIgnoreCase("leave") || args[0].equalsIgnoreCase("restart") || args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("setlobby") || args[0].equalsIgnoreCase("setspawn") || args[0].equalsIgnoreCase("setpoints") || args[0].equalsIgnoreCase("author")))) {
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
                utils.send("&6/&7expk &ehelp &6- &7Need help ?"); // @done
                utils.send("&6/&7expk &estats &6- &7Wanna check stats ?"); // @done
                utils.send("&6/&7expk &ejoin &6- &7Join to the parkour");
                utils.send("&6/&7expk &eleave &6- &7Leave parkour");
                utils.send("&6/&7expk &erestart &6- &7Bugged ? Let's try again");
                utils.send("&6/&7expk &ecreate &6- &7Create parkour");
                utils.send("&6/&7expk &edelete &6- &7Delete parkour");
                utils.send("&6/&7expk &esetlobby &6- &7Set lobby for parkours"); // @done
                utils.send("&6/&7expk &esetspawn &6- &7Set spawn for parkour");
                utils.send("&6/&7expk &esetpoints &6- &7Set points for parkour");
                utils.send("&6/&7expk &eauthor &6- &7Infos about author"); // @done
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
            }
            if(args[0].equalsIgnoreCase("author")) {
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
                utils.send("&6Author&7: &6krzysek (aka. steel, loonypl)");
                utils.send("&6Github&7: &6http://www.github.com/loonypl");
                utils.send("&6Project Github&7: &6http://www.github.com/loonypl/ExParkour");
                utils.send("&6Version&7: &62.0");
                utils.send("&a© by krzysek (aa. steel, loonypl)");
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
            }
            if(args[0].equalsIgnoreCase("stats")) {
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
                utils.send("&6Name&7: &6" + utils.getPlayer().getName());
                utils.send("&6Points&7: &6" + user.getPoints());
                utils.send("&6Rank&7: &6" + user.getStatus());
                utils.send("&6Finished parkours&7: &6" + user.getFinishedParkours());
                utils.send("&6Started parkours&7: &6" + user.getStartedParkours());
                utils.send("&6< &7============ &6ExParkour &7============ &6>");
            }
            if(args[0].equalsIgnoreCase("setlobby")) {
                if(utils.getPlayer().hasPermission("expk.admin")) {
                    new Lobby().setLocation(utils.getPlayer().getLocation());
                } else {
                    utils.send(tag + "&cYou don't have permission to this.");
                }
            }
        }
        return true;
    }
}
