
package frontend;

import backend.LineSegment;
import backend.Shape;
import backend.Validation;

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
                    System.out.println("Invalid number of arguments for resizing a Circle.");
                }
            }
            case "Square" -> {
                if (size.length == 1)
                this.shape.setProperties(Map.of("side", Double.parseDouble(size[0])));
                else {
                    System.out.println("Invalid number of arguments for resizing a Square.");
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
                    System.out.println("Invalid number of arguments for resizing a Rectangle.");
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
                    System.out.println("Invalid number of arguments for resizing a LineSegment.");
                }
            }
        }

        this.drawingCanvas1.refresh(drawingCanvas1.getGraphics());
    }
}