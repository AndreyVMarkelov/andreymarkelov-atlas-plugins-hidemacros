package ru.andreymarkelov.atlas.plugins;

import java.util.Map;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.velocity.VelocityContext;
import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;

/**
 * Render hider macro.
 * 
 * @author Andrey Markelov
 */
public class BlockHiderMacro
    implements Macro
{
    /**
     * Template.
     */
    private static final String TEMPLATE = "templates/hider-body-template.vm";

    /**
     * Parser.
     */
    private HiderMacroParameterParser hiderMacroParameterParser;

    /**
     * Constructor.
     */
    public BlockHiderMacro(
        HiderMacroParameterParser hiderMacroParameterParser)
    {
        this.hiderMacroParameterParser = hiderMacroParameterParser;
    }

    @Override
    public String execute(
        Map<String, String> parameters,
        String body,
        ConversionContext context)
    throws MacroExecutionException
    {
        HiderMacroParams params = hiderMacroParameterParser.parseParameters(parameters);

        String cssSelector = StringEscapeUtils.escapeHtml(params.getBlockName());
        Boolean isId = (cssSelector != null && cssSelector.startsWith("#")) ? Boolean.TRUE : Boolean.FALSE;

        VelocityContext contextMap = new VelocityContext(MacroUtils.defaultVelocityContext());
        contextMap.put("label", StringEscapeUtils.escapeHtml(params.getLabel()));
        contextMap.put("blockName", cssSelector);
        contextMap.put("isId", isId);
        contextMap.put("hideOnCheck", params.getHideOnCheck());
        contextMap.put("id", "hider" + Utils.getCurrentMills());

        return VelocityUtils.getRenderedTemplate(TEMPLATE, contextMap);
    }

    @Override
    public BodyType getBodyType()
    {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType()
    {
        return OutputType.BLOCK;
    }
}
