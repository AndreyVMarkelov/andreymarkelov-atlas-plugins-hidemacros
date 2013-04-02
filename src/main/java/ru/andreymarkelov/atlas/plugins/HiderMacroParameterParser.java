package ru.andreymarkelov.atlas.plugins;

import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * Hider macro parameter parser.
 * 
 * @author Andrey Markelov
 */
public class HiderMacroParameterParser
{
    private static final String BLOCK_NAME = "blockName";

    private static final String HIDE_ON_CHECK = "hideOnCheck";

    private static final String LABEL = "label";

    /**
     * Constructor.
     */
    public HiderMacroParameterParser() {}

    /**
     * Parse input parameters.
     */
    public HiderMacroParams parseParameters(
        Map<String, String> parameters)
    {
        HiderMacroParams params = new HiderMacroParams();

        String blockNameParm = parameters.get(BLOCK_NAME);
        if (!StringUtils.isEmpty(blockNameParm))
        {
            params.setBlockName(blockNameParm);
        }

        String hideOnCheck = parameters.get(HIDE_ON_CHECK);
        if (!StringUtils.isEmpty(hideOnCheck))
        {
            params.setHideOnCheck(Boolean.valueOf(hideOnCheck));
        }

        String label = parameters.get(LABEL);
        if (!StringUtils.isEmpty(label))
        {
            params.setLabel(label);
        }
        else
        {
            params.setLabel("input");
        }

        return params;
    }
}
