package ru.andreymarkelov.atlas.plugins;

/**
 * Utility methods.
 * 
 * @author Andrey Markelov
 */
public class Utils
{
    /**
     * Private constructor.
     */
    private Utils() {}

    /**
     * Get current mills.
     */
    public static synchronized long getCurrentMills()
    {
        return System.currentTimeMillis();
    }
}
