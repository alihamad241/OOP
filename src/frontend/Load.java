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
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String shape = parts[0];
            String[] values = parts[1].split(",");
            switch (shape) {
                case "Circle":
                    Circle circle = getCircle(values);
                    drawingCanvas1.addShape(circle);
                    circle.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Circle" + counter++);
                    break;
                case "LineSegment":
                    LineSegment line = getLineSegment(values);
                    drawingCanvas1.addShape(line);
                    line.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Line" + counter++);
                    break;
                case "Square":
                    Square square = getSquare(values);
                    drawingCanvas1.addShape(square);
                    square.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Square" + counter++);
                    break;
                case "Rectangle":
                    Rectangle rectangle = getRectangle(values);
                    drawingCanvas1.addShape(rectangle);
                    rectangle.draw(drawingCanvas1.getGraphics());
                    jComboBox1.addItem("Rectangle" + counter++);
                    break;
            }
        }
    }

    private static Rectangle getRectangle(String[] values) {
        Rectangle rectangle = new Rectangle(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]), Double.parseDouble(values[3]));
        rectangle.setColor(new Color(Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6])));
        if (!values[7].equals("null")) {
            rectangle.setFillColor(new Color(Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9])));
        }
        return rectangle;
    }

    private static LineSegment getLineSegment(String[] values) {
        LineSegment line = new LineSegment(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), values[2] + "," + values[3]);
        line.setColor(new Color(Integer.parseInt(values[4]), Integer.parseInt(values[5]), Integer.parseInt(values[6])));
        if (!values[7].equals("null")) {
            line.setFillColor(new Color(Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9])));
        }
        return line;
    }

    private static Circle getCircle(String[] values) {
        Circle circle = new Circle(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]));
        circle.setColor(new Color(Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5])));
        if (!values[6].equals("null")) {
            circle.setFillColor(new Color(Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])));
        }
        return circle;
    }

    private static Square getSquare(String[] values) {
        Square square = new Square(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])), Double.parseDouble(values[2]));
        square.setColor(new Color(Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5])));
        if (!values[6].equals("null")) {
            square.setFillColor(new Color(Integer.parseInt(values[6]), Integer.parseInt(values[7]), Integer.parseInt(values[8])));
        }
        return square;
    }
}
