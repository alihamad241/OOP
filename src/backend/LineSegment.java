package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LineSegment extends Shapes {
    public LineSegment(Point position, String endPosition) {
        super(position);
        this.properties.put("EndX", Double.parseDouble(endPosition.split(",")[0]));
        this.properties.put("EndY", Double.parseDouble(endPosition.split(",")[1]));
    }

    public void setEndPosition(Point position) {
        this.properties.put("EndX", position.getX());
        this.properties.put("EndY", position.getY());
    }

    public Point getEndPosition() {
        return new Point(this.properties.get("EndX").intValue(), this.properties.get("EndY").intValue());
    }


   @Override
public void draw(Graphics canvas) {
    canvas.setColor(this.color);
    canvas.drawLine((int) this.position.getX(), (int) this.position.getY(), this.getProperties().get("EndX").intValue(), this.getProperties().get("EndY").intValue());
}
}
