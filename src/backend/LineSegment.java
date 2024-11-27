package backend;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LineSegment extends Shapes {

    private Point endPosition;
    


    public LineSegment(Point position, Point endPosition) {
        super(position);
        this.endPosition = endPosition;
    }

    public void setEndPosition(Point position) {
        this.endPosition = position;
    }

    public Point getEndPosition() {
        return this.endPosition;
    }


    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawLine((int) this.position.getX(), (int) this.position.getY(), (int) this.endPosition.getX(), (int) this.endPosition.getY());
    }
}
