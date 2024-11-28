package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Shapes implements Shape {
    protected Point position;
    protected Map<String, Double> properties;
    protected Color color;
    protected Color fillColor;
    protected int id;

    public Shapes(Point position, int id) {
        this.id = id;
        this.position = position;
        this.properties = new HashMap<>();
        this.color = Color.BLACK;
        this.fillColor = null;
    }

    @Override
    public void setPosition(Point position)
    {
        this.position = position;
    }

    @Override
    public Point getPosition()
    {
        return this.position;
    }

    @Override
    public void setProperties(Map<String, Double> properties)
    {
        this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties()
    {
        return this.properties;
    }

    @Override
    public void setColor(Color color)
    {
        this.color = color;
    }

    @Override
    public Color getColor()
    {
        return this.color;
    }

    @Override
    public void setFillColor(Color color)
    {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor()
    {
        return this.fillColor;
    }

    @Override
    public abstract void draw(Graphics canvas);

    @Override
    public int getId()
    {
        return this.id;
    }

}
