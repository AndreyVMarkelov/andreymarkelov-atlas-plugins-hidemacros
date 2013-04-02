package ru.andreymarkelov.atlas.plugins;

/**
 * Render results.
 * 
 * @author Andrey Markelov
 */
public class RenderResult
{
    private final String result;

    /**
     * Constructor.
     */
    public RenderResult(
        String result)
    {
        this.result = result;
    }

    public String getResult()
    {
        return result;
    }

    @Override
    public String toString()
    {
        return "RenderResult[result=" + result + "]";
    }
}
