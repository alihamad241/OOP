package frontend;

import backend.LineSegment;
import backend.Shape;
import backend.Validation;

import javax.swing.*;
import java.awt.*;

public class Move extends Component {
    Shape shape;
    DrawingCanvas drawingCanvas1;

    public Move(Shape shape, DrawingCanvas drawingCanvas1) {
        this.shape = shape;
        this.drawingCanvas1 = drawingCanvas1;
        move();
    }

    public void move() {
        // Get the new position from the user
        String position = JOptionPane.showInputDialog(null, "Enter the new position(separated by commas)", "Move Shapes", JOptionPane.PLAIN_MESSAGE);
        if(position == null){
            return;
        }
            if (!Validation.validatePosition(position, drawingCanvas1)) {
                return;
            }
        String[] positions = position.split(",");
        Point newPosition = new Point(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
        int x = newPosition.x - shape.getPosition().x;
        int y = newPosition.y - shape.getPosition().y;
        shape.setPosition(newPosition);
        if(shape.getClass().getSimpleName().equals("LineSegment")){
            Point end = new Point((shape.getProperties().get("EndX").intValue() + x), (shape.getProperties().get("EndY").intValue() + y));
            ((LineSegment)shape).setEndPosition(end);
        }
        drawingCanvas1.refresh(drawingCanvas1.getGraphics());
    }

}
