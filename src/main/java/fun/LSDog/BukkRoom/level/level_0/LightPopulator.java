package fun.LSDog.BukkRoom.level.level_0;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * 1*3灯管的生成，实际上就是三个一排的红石灯，上面放有红石块
 */
class LightPopulator extends BlockPopulator {

    BlockFace[] positiveFaces = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};

    @Override
    public void populate(World world, Random random, Chunk source) {
        if (random.nextDouble() < 0.6) {

            int x = random.nextInt(13)+1;
            int z = random.nextInt(13)+1;

            Block centerBlock = source.getBlock(x, Level_0_ChunkGenerator.CEILING_Y, z);
            BlockFace oneSide = positiveFaces[random.nextInt(positiveFaces.length)];

            generateLights(centerBlock, oneSide, random);
        }
    }

    private void generateLights(Block centerBlock, BlockFace oneSide, Random random) {

        // 中间的红石块有概率变成红石粉
        Material centerMaterial = Material.REDSTONE_BLOCK;
        if (random.nextDouble() < 0.1) {
            centerMaterial = Material.REDSTONE_WIRE;
        }

        centerBlock.getRelative(0,1,0).setType(centerMaterial);
        centerBlock.setType(Material.REDSTONE_LAMP_ON);

        centerBlock.getRelative(oneSide).getRelative(0,1,0).setType(Material.REDSTONE_WIRE);
        centerBlock.getRelative(oneSide).setType(Material.REDSTONE_LAMP_ON);

        centerBlock.getRelative(oneSide.getOppositeFace()).getRelative(0,1,0).setType(Material.REDSTONE_WIRE);
        centerBlock.getRelative(oneSide.getOppositeFace()).setType(Material.REDSTONE_LAMP_ON);

        // 随机搞一排同方向的灯 永远指向东西朝向
        if ((oneSide == BlockFace.NORTH || oneSide == BlockFace.SOUTH) && random.nextDouble() < 0.6) {
            int x = centerBlock.getX() % 15;
            if (2 < x && x < 13) {
                Block nextBlock = centerBlock.getRelative(-2,0,0);
                generateLights(nextBlock, oneSide, random);
            }
        }
    }

}
