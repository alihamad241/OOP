/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.DrawingEngine;
import backend.Shape;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author mrali
 */
public class DrawingCanvas extends javax.swing.JPanel implements DrawingEngine {

    ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * Creates new form Canvas
     */
    public DrawingCanvas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void refresh(Graphics canvas) {
        // Redraw all shapes
        canvas.clearRect(0, 0, getWidth(), getHeight());
        for (Shape shape : getShapes()) {
            shape.draw(canvas);
        }
    }

    @Override
    public void addShape(Shape shape) {
        // Add shape to the list of shapes
        shapes.add(shape);

    }

    @Override
    public void removeShape(Shape shape) {
        // Remove shape from the list of shapes
        shapes.remove(shape);

    }

    @Override
    public ArrayList<Shape> getShapes() {
        // Return the list of shapes
        return shapes;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        refresh(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
