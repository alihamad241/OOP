
package frontend;

import backend.LineSegment;
import backend.Shape;
import backend.Validation;

import javax.swing.*;
import java.util.Map;

public class Resize {
    Shape shape;
    DrawingCanvas drawingCanvas1;
    String[] size;

    public Resize(Shape shape, DrawingCanvas drawingCanvas1, String newSize) {
        this.shape = shape;
        this.drawingCanvas1 = drawingCanvas1;
        size = newSize.split(",");
        resize();
    }

    public void resize() {
        switch (this.shape.getClass().getSimpleName()) {
            case "Circle" -> {
                if (size.length == 1)
                this.shape.setProperties(Map.of("radius", Double.parseDouble(size[0])));
                else {
                    JOptionPane.showMessageDialog(null, "Invalid number of arguments for resizing a Circle.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case "Square" -> {
                if (size.length == 1)
                this.shape.setProperties(Map.of("side", Double.parseDouble(size[0])));
                else {
                    JOptionPane.showMessageDialog(null, "Invalid number of arguments for resizing a Square.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case "Rectangle" -> {
                if (size.length == 2) {
                    this.shape.setProperties(Map.of(
                            "width", Double.parseDouble(size[0]),
                            "height", Double.parseDouble(size[1])
                    ));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid number of arguments for resizing a Rectangle.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case "LineSegment" -> {
                if (size.length == 2) {
                    if (Validation.validatePosition(size[0] + "," + size[1], drawingCanvas1)) {
                        ((LineSegment) this.shape).setEndPosition(
                                new java.awt.Point(Integer.parseInt(size[0]), Integer.parseInt(size[1]))
                        );
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid number of arguments for resizing a Line Segment.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        this.drawingCanvas1.refresh(drawingCanvas1.getGraphics());
    }
}