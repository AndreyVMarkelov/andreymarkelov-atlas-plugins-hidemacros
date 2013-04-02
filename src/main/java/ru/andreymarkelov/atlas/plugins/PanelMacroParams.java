package ru.andreymarkelov.atlas.plugins;

/**
 * This is parameters of panel macros.
 * 
 * @author Andrey Markelov
 */
public class PanelMacroParams
{
    /**
     * HTML block name.
     */
    private String blockName;

    /**
     * HTML block class.
     */
    private String className;

    /**
     * Default constructor.
     */
    public PanelMacroParams() {}

    /**
     * Constructor.
     */
    public PanelMacroParams(
        String blockName,
        String className)
    {
        this.blockName = blockName;
        this.className = className;
    }

    public String getBlockName()
    {
        return blockName;
    }

    public String getClassName()
    {
        return className;
    }

    public void setBlockName(String blockName)
    {
        this.blockName = blockName;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    @Override
    public String toString()
    {
        return "PanelMacroParams[blockName=" + blockName + ", className=" + className + "]";
    }
}
