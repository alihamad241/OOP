package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Rectangle extends Shapes {


    public Rectangle(Point point , double width, double height, int id) {
        super(point, id);
        this.properties.put("width", width);
        this.properties.put("height", height);
    }

    @Override
    public void draw(Graphics canvas) {
        
        if(this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillRect(this.position.x, this.position.y, this.properties.get("width").intValue(), this.properties.get("height").intValue());
        }
        canvas.setColor(this.color);
        canvas.drawRect(this.position.x, this.position.y,this.properties.get("width").intValue(), this.properties.get("height").intValue() );
}}
