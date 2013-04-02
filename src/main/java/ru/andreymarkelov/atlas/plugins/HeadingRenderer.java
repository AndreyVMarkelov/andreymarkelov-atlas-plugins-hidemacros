package ru.andreymarkelov.atlas.plugins;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Render heading.
 * 
 * @author Andrey Markelov
 */
public class HeadingRenderer
{
    /**
     * Macros parameters.
     */
    private PanelMacroParams params;

    /**
     * Constructor.
     */
    public HeadingRenderer(
         PanelMacroParams params)
    {
        this.params = params;
    }

    public RenderResult render(
        String macroBody)
    {
        StringBuffer resultString = new StringBuffer();

        if (!StringUtils.isEmpty(params.getBlockName()) || !StringUtils.isEmpty(params.getClassName()))
        {
            resultString.append("<div");
            if (!StringUtils.isEmpty(params.getBlockName()))
            {
                resultString.append(" id='").append(StringEscapeUtils.escapeHtml(params.getBlockName())).append("'");
            }
            if (!StringUtils.isEmpty(params.getClassName()))
            {
                resultString.append(" class='").append(StringEscapeUtils.escapeHtml(params.getClassName())).append("'");
            }
            resultString.append(">");
            resultString.append(macroBody);
            resultString.append("</div>");
        }
        else
        {
            resultString.append(macroBody);
        }

        return new RenderResult(resultString.toString());
    }
}
