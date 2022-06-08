package fun.LSDog.BukkRoom;

import fun.LSDog.BukkRoom.level.level_0.Level_0_ChunkGenerator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkRoom extends JavaPlugin {

    public static BukkRoom inst;
    public BukkRoom() {inst = this;}

    @Override
    public void onEnable() {
        // some things are not work because we are load too early (config.yml->load: STARTUP)
    }

    @Override
    public void onDisable() {

    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String levelId) {
        return new Level_0_ChunkGenerator();
    }
}
