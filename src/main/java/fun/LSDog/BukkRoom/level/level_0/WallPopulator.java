package fun.LSDog.BukkRoom.level.level_0;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Random;

/**
 * 笑天犬: <br>
 * 随机间隔生成一长溜x平行线和y平行线 <br>
 * <br>
 * 笑天犬: <br>
 * 每条线随机间隔扣掉 <br>
 * <br>
 * 笑天犬: <br>
 * 问题来了，怎么写 <br>
 * <br>
 * ─@│@┘@└@┐@┌@┼@├@┤
 * <pre>
 * ──┼  ───┼─┼───
 * ──┼── ───  ─ ──
 * ───  ───┼──┼──
 *   ──┼ ───  ─ ──
 * ───  ────── ──
 * </pre>
 */
class WallPopulator extends BlockPopulator {

    private static final int minWallSpace = 1;
    private static final int maxWallSpace = 10;

    private static final int minSpace = 2;
    private static final int maxSpace = 20;

    @Override
    public void populate(World world, Random random, Chunk source) {
        int chunkX = source.getX();
        int chunkZ = source.getZ();
        SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        //generator.setScale(0.005D);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                if (generator.noise(chunkX * 16 + x, chunkZ * 16 + z, 0.5D, 0.5D, true) > 0.5) {
                    for (int y = Level_0_ChunkGenerator.FLOOR_Y+1; y < Level_0_ChunkGenerator.CEILING_Y; y++) {
                        Block block = source.getBlock(x, y, z);
                        block.setType(Material.WOOL);
                        block.setData(Level_0_ChunkGenerator.yellowWool.getData());
                    }
                }
            }
        }
    }


}
