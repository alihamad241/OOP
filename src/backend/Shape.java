
package backend;

import java.awt.*;
import java.util.Map;

public interface Shape {
    public void setPosition(Point position);
    public Point getPosition();
    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();
    public void draw(Graphics canvas);
}
