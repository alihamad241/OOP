package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Square extends Shapes{

    public Square(Point point, double side, int id) {
        super(point, id);
        this.properties.put("side", side);
    }


    @Override
    public void draw(Graphics canvas) {
        if(this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillRect(this.position.x, this.position.y, this.properties.get("side").intValue(), this.properties.get("side").intValue());
        }
        canvas.setColor(this.color);
        canvas.drawRect(this.position.x, this.position.y, this.properties.get("side").intValue(), this.properties.get("side").intValue());
        
    }
}
