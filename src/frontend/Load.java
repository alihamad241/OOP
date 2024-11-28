package frontend;

import backend.Circle;
import backend.LineSegment;
import backend.Rectangle;
import backend.Square;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static frontend.Main.counter;

public class Load {
    DrawingCanvas drawingCanvas1;
    File file;
    JComboBox<String> jComboBox1;

    public Load(DrawingCanvas drawingCanvas1, File file, JComboBox<String> jComboBox1) {
        this.drawingCanvas1 = drawingCanvas1;
        this.file = file;
        this.jComboBox1 = jComboBox1;
        load();
    }

    public void load() {
        // Clear the canvas and the combo box
        drawingCanvas1.getGraphics().clearRect(0, 0, drawingCanvas1.getWidth(), drawingCanvas1.getHeight());
        drawingCanvas1.getShapes().clear();
        jComboBox1.removeAllItems();
        jComboBox1.addItem("none");
        // Reset the counter
        counter = 0;


        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Read the file line by line and create shapes
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int id = Integer.parseInt(parts[0].split(",")[0]);
            String shape = parts[0].split(",")[1];
            String[] values = parts[1].split(",");
            counter = id + 1;
            switch (shape) {
                case "Circle":
                    Circle circle = getCircle(values, id);
                    drawingCanvas1.addShape(circle);
                    circle.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Circle" + id);
                    break;
                case "LineSegment":
                    LineSegment line = getLineSegment(values, id);
                    drawingCanvas1.addShape(line);
                    line.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Line" + id);
                    break;
                case "Square":
                    Square square = getSquare(values, id);
                    drawingCanvas1.addShape(square);
                    square.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Square" + id);
                    break;
                case "Rectangle":
                    Rectangle rectangle = getRectangle(values , id);
                    drawingCanvas1.addShape(rectangle);
                    rectangle.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Rectangle" + id);
                    break;
            }
        }
    }

    // Helper methods to create shapes
    private static Rectangle getRectangle(String[] values, int id) {
        Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]), Double.parseDouble(values[3]), id);
        rectangle.setColor(new Color(Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6])));
        if (!values[7].equals("null")) {
            rectangle.setFillColor(new Color(Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9])));
        }
        return rectangle;
    }

    private static LineSegment getLineSegment(String[] values, int id) {
        LineSegment line = new LineSegment(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), values[2] + "," + values[3], id);
        line.setColor(new Color(Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6])));
        if (!values[7].equals("null")) {
            line.setFillColor(new Color(Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9])));
        }
        return line;
    }

    private static Circle getCircle(String[] values, int id) {
        Circle circle = new Circle(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]), id );
        circle.setColor(new Color(Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5])));
        if (!values[6].equals("null")) {
            circle.setFillColor(new Color(Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])));
        }
        return circle;
    }

    private static Square getSquare(String[] values, int id) {
        Square square = new Square(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]), id);
        square.setColor(new Color(Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5])));
        if (!values[6].equals("null")) {
            square.setFillColor(new Color(Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])));
        }
        return square;
    }
}
