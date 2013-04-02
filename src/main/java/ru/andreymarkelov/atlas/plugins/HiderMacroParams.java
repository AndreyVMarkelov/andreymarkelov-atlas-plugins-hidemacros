package ru.andreymarkelov.atlas.plugins;

/**
 * This is parameters of hider macros.
 * 
 * @author Andrey Markelov
 */
public class HiderMacroParams
{
    /**
     * HTML block name.
     */
    private String blockName;

    /**
     * Label.
     */
    private String label;

    /**
     * Is hide on checked state?
     */
    private Boolean hideOnCheck;

    /**
     * Default constructor.
     */
    public HiderMacroParams() {}

    /**
     * Constructor.
     */
    public HiderMacroParams(
        String blockName,
        String label,
        Boolean hideOnCheck)
    {
        this.blockName = blockName;
        this.label = label;
        this.hideOnCheck = hideOnCheck;
    }

    public String getBlockName()
    {
        return blockName;
    }

    public Boolean getHideOnCheck()
    {
        return hideOnCheck;
    }

    public String getLabel()
    {
        return label;
    }

    public void setBlockName(String blockName)
    {
        this.blockName = blockName;
    }

    public void setHideOnCheck(Boolean hideOnCheck)
    {
        this.hideOnCheck = hideOnCheck;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    @Override
    public String toString()
    {
        return "HiderMacroParams[blockName=" + blockName + ", label=" + label + ", hideOnCheck=" + hideOnCheck + "]";
    }
}

