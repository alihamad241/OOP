package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Circle extends Shapes {

    public Circle(Point position, double radius, int id) {
        super(position, id);
        this.properties.put("radius", radius);
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawOval(this.position.x, this.position.y, this.properties.get("radius").intValue(), this.properties.get("radius").intValue());
        if(this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillOval(this.position.x, this.position.y, this.properties.get("radius").intValue(), this.properties.get("radius").intValue());
        }
    }
}
