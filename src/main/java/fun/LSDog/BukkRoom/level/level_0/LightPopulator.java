package fun.LSDog.BukkRoom.level.level_0;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * 1*3灯管的生成
 */
public class LightPopulator extends BlockPopulator {

    BlockFace[] positiveFaces = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};

    @Override
    public void populate(World world, Random random, Chunk source) {
        if (random.nextDouble() < 0.5) {

            int x = random.nextInt(13)+1;
            int z = random.nextInt(13)+1;

            Block centerBlock = source.getBlock(x, Level_0_ChunkGenerator.CEILING_Y, z);
            BlockFace anotherFace = positiveFaces[random.nextInt(positiveFaces.length)];

            centerBlock.getRelative(0,1,0).setType(Material.REDSTONE_BLOCK);
            centerBlock.setType(Material.REDSTONE_LAMP_ON);

            centerBlock.getRelative(anotherFace).getRelative(0,1,0).setType(Material.REDSTONE_BLOCK);
            centerBlock.getRelative(anotherFace).setType(Material.REDSTONE_LAMP_ON);

            centerBlock.getRelative(anotherFace.getOppositeFace()).getRelative(0,1,0).setType(Material.REDSTONE_BLOCK);
            centerBlock.getRelative(anotherFace.getOppositeFace()).setType(Material.REDSTONE_LAMP_ON);

        }
    }

}
