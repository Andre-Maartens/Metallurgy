package rebelkeithy.mods.metallurgy.metals;

import java.util.Random;

import net.minecraft.world.World;
import rebelkeithy.mods.keithyutils.metablock.IDisplayListener;
import rebelkeithy.mods.keithyutils.particleregistry.ParticleRegistry;

public class DisplayListenerOreParticles implements IDisplayListener
{
    private final String name;
    private final double r;
    private final double g;
    private final double b;

    DisplayListenerOreParticles(final String name, final double red, final double green,
            final double blue)
    {
        this.name = name;
        r = red;
        g = green;
        b = blue;
    }

    @Override
    public void randomDisplayTick(final World world, final int x, final int y, final int z,
            final Random rand)
    {
        final double margin = 0.0625D;

        for (int i = 0; i < 6; ++i)
        {
            if (Math.random() < 0.3) continue;

            double spawnX = x + rand.nextDouble();
            double spawnY = y + rand.nextDouble();
            double spawnZ = z + rand.nextDouble();

            if (i == 0 && !world.isBlockOpaqueCube(x, y + 1, z)) spawnY = y + 1 + margin;

            if (i == 1 && !world.isBlockOpaqueCube(x, y - 1, z)) spawnY = y + 0 - margin;

            if (i == 2 && !world.isBlockOpaqueCube(x, y, z + 1)) spawnZ = z + 1 + margin;

            if (i == 3 && !world.isBlockOpaqueCube(x, y, z - 1)) spawnZ = z + 0 - margin;

            if (i == 4 && !world.isBlockOpaqueCube(x + 1, y, z)) spawnX = x + 1 + margin;

            if (i == 5 && !world.isBlockOpaqueCube(x - 1, y, z)) spawnX = x + 0 - margin;

            if (spawnX < x || spawnX > x + 1 || spawnY < 0.0D || spawnY > y + 1 || spawnZ < z
                    || spawnZ > z + 1)
                ParticleRegistry.spawnParticle(name, world, spawnX, spawnY, spawnZ, r, g, b);
        }

    }

}
