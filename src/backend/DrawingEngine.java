package backend;

import java.awt.*;
import java.util.List;

public interface DrawingEngine {
    public void refresh(Graphics canvas);
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public List<Shape> getShapes();

}
