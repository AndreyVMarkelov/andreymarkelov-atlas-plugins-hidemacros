package ru.andreymarkelov.atlas.plugins;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.renderer.v2.macro.MacroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

/**
 * Render named panel macro.
 * 
 * @author Andrey Markelov
 */
public class NamedPanelMacro
    implements Macro
{
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NamedPanelMacro.class);

    /**
     * Parser.
     */
    private PanelMacroParameterParser panelMacroParameterParser;

    /**
     * Constructor.
     */
    public NamedPanelMacro(
        PanelMacroParameterParser panelMacroParameterParser)
    {
        this.panelMacroParameterParser = panelMacroParameterParser;
    }

    public String execute(
        Map<String, String> parameters,
        String macroBody,
        ConversionContext conversionContext)
    throws MacroExecutionException
    {
        try
        {
            return render(parameters, macroBody, conversionContext);
        }
        catch (MacroException e)
        {
            return renderErrorBlock(ConfluenceActionSupport.getTextStatic("ru.andreymarkelov.atlas.plugins.hidemacros.unable-to-render"), e.getMessage());
        }
        catch (Exception e)
        {
            LOGGER.warn("The Numbered Headings plugin threw an unexpected exception...", e);
            return renderErrorBlock(ConfluenceActionSupport.getTextStatic("ru.andreymarkelov.atlas.plugins.hidemacros.unexpected-error"), ConfluenceActionSupport.getTextStatic("ru.andreymarkelov.atlas.plugins.hidemacros.unable-to-render"));
        }
    }

    public BodyType getBodyType()
    {
        return BodyType.RICH_TEXT;
    }

    public OutputType getOutputType()
    {
        return OutputType.BLOCK;
    }

    /**
     * Render page macros body.
     */
    private String render(
        Map<String, String> parameters,
        String macroBody,
        ConversionContext conversionContext)
    throws MacroException
    {
        PanelMacroParams parsedParameters = panelMacroParameterParser.parseParameters(parameters);

        return new HeadingRenderer(parsedParameters).render(macroBody).getResult();
    }

    private String renderErrorBlock(
        String title,
        String message)
    {
        StringBuilder errorBlock = new StringBuilder();
        errorBlock.append("<div class=\"aui-message warning\">");
        errorBlock.append("<p class=\"title\">");
        errorBlock.append("<span class=\"aui-icon icon-warning\"></span>");
        errorBlock.append("<strong>").append(title).append("</strong>");
        errorBlock.append("</p>");
        errorBlock.append("<p>").append(message).append("</p>");
        errorBlock.append("</div>");

        return errorBlock.toString();
    }
}
