package ru.andreymarkelov.atlas.plugins;

import com.atlassian.renderer.v2.macro.basic.validator.MacroParameterValidationException;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

/**
 * Panel macro parameter parser.
 * 
 * @author Andrey Markelov
 */
public class PanelMacroParameterParser
{
    private static final String BLOCK_NAME = "blockName";

    private static final String CLASS_NAME = "className";

    /**
     * Constructor.
     */
    public PanelMacroParameterParser() {}

    /**
     * Parse input parameters.
     */
    public PanelMacroParams parseParameters(
        Map<String, String> parameters)
    throws MacroParameterValidationException
    {
        PanelMacroParams params = new PanelMacroParams();

        String blockNameParm = parameters.get(BLOCK_NAME);
        if (!StringUtils.isEmpty(blockNameParm))
        {
            params.setBlockName(blockNameParm);
        }

        String classNameParm = parameters.get(CLASS_NAME);
        if (!StringUtils.isEmpty(classNameParm))
        {
            params.setClassName(classNameParm);
        }

        return params;
    }
}
