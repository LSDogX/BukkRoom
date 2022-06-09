package fun.LSDog.BukkRoom.level.level_0;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// @SuppressWarnings("deprecation")
public class Level_0_ChunkGenerator extends ChunkGenerator {


    // TODO 别让世界下雨



    private static final Random RANDOM = new Random();

    protected static final int FLOOR_Y = 0;
    protected static final int CEILING_Y = 5;
    protected static final MaterialData yellowWool = new MaterialData(Material.WOOL);

    static {
        yellowWool.setData(DyeColor.YELLOW.getWoolData());
    }

    @Override
    public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
        ChunkData chunk = createChunkData(world);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                chunk.setBlock(x, FLOOR_Y, z, yellowWool);
                chunk.setBlock(x, CEILING_Y, z, yellowWool);
            }
        }
        return chunk;
    }



    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        List<BlockPopulator> blockPopulatorList = new ArrayList<BlockPopulator>();
        blockPopulatorList.add(new LightPopulator());
        blockPopulatorList.add(new WallPopulator());
        return blockPopulatorList;
    }
}
