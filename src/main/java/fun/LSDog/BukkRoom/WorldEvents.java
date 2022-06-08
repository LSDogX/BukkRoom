package fun.LSDog.BukkRoom;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldLoadEvent;

import java.util.Random;

public class WorldEvents implements Listener {

    private static final Random RANDOM = new Random();

    @EventHandler
    public static void onLoadWorld(WorldInitEvent e) {
        World world = e.getWorld();
        world.setSpawnLocation(0, 1, 0);
        world.setDifficulty(Difficulty.PEACEFUL);
        world.setGameRuleValue("doWeatherCycle", "false");
        world.setMonsterSpawnLimit(0);
        world.setSpawnFlags(false, false);
    }


}
