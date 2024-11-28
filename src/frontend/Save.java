package frontend;

import backend.*;
import backend.Rectangle;
import backend.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
    DrawingCanvas drawingCanvas1;
    File file;

    public Save(DrawingCanvas drawingCanvas1 , File file) {
        this.drawingCanvas1 = drawingCanvas1;
        this.file = file;
        save();
    }


    private void save() {
        try (FileWriter writer = new FileWriter(file)) {
            for (Shape shape : drawingCanvas1.getShapes()) {
                String shapeData = getShapeData(shape);
                writer.write(shapeData + System.lineSeparator());
            }
            JOptionPane.showMessageDialog(null, "Shapes saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving shapes: " + e.getMessage());
        }
    }

    private String getShapeData(Shape shape) {
        StringBuilder sb = new StringBuilder();
        sb.append(shape.getId()).append(",");
        sb.append(shape.getClass().getSimpleName()).append(" ");
        sb.append(shape.getPosition().x).append(",").append(shape.getPosition().y);

        switch (shape) {
            case Circle circle -> sb.append(",").append(shape.getProperties().get("radius"));
            case Square square -> sb.append(",").append(shape.getProperties().get("side"));
            case Rectangle rectangle -> {
                sb.append(",").append(shape.getProperties().get("width"));
                sb.append(",").append(shape.getProperties().get("height"));
            }
            case LineSegment line ->
                    sb.append(",").append(line.getEndPosition().x).append(",").append(line.getEndPosition().y);
            default -> {
            }
        }
        sb.append(",");
        Color color = shape.getColor();
        if (color != null) {
            sb.append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue());
        } else {
            sb.append("null");
        }
        sb.append(",");

        Color fillColor = shape.getFillColor();
        if (fillColor != null) {
            sb.append(fillColor.getRed()).append(",").append(fillColor.getGreen()).append(",").append(fillColor.getBlue());
        } else {
            sb.append("null");
        }


        return sb.toString();
    }
}

