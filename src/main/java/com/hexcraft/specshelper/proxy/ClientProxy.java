package com.hexcraft.specshelper.proxy;

import com.hexcraft.specshelper.BlocksRegister;
import com.hexcraft.specshelper.CraftingRegister;
import com.hexcraft.specshelper.WindowsCMD;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import static com.hexcraft.specshelper.helper.bytesToHuman.bytesToHuman;

public class ClientProxy extends CommonProxy
{
    private static Logger logger;

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        logger = event.getModLog();
        WindowsCMD systemConsole = new WindowsCMD();
        logger.info("---------HEX-CRAFT-SPECS-HELPER---------");
        String systemName = System.getProperty("os.name");
        if (systemName.toLowerCase().contains("windows")) {
            logger.info("Free JVM memory: " + bytesToHuman(Runtime.getRuntime().freeMemory()));

            long maxMemory = Runtime.getRuntime().maxMemory();

            logger.info("Allocated JVM memory: " + (maxMemory == Long.MAX_VALUE ? "no limit" : bytesToHuman(maxMemory)));
            logger.info("Total JVM memory: " + bytesToHuman(Runtime.getRuntime().totalMemory()));

            logger.info("WindowsSystemInformation function:");
            try {
                logger.info(systemConsole.getInfo("wmic cpu get name, numberofcores, maxclockspeed, status"));
                logger.info(systemConsole.getInfo("wmic memorychip get devicelocator, speed, capacity"));
            } catch (Exception e) {
                logger.error("WindowsSystemInformation Exception.");
            }
        } else {
            logger.info("OS is not a Windows, system info getting aborted.");
        }
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        logger.info("---------HEX-CRAFT-SPECS-HELPER---------");
        BlocksRegister.registerRender();
        logger.info("Blocks registered.");
        CraftingRegister.register();
        logger.info("Crafts registered.");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
