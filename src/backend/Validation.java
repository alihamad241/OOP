package backend;

import frontend.DrawingCanvas;

import javax.swing.*;



public class Validation {

    public static boolean validatePosition(String position, DrawingCanvas canvas2) {
        if (position.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Position is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (int i = 0; i < position.length(); i++) {
            if (!Character.isDigit(position.charAt(i)) && position.charAt(i) != ',') {
                JOptionPane.showMessageDialog(null, "Invalid position", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        String[] pos = position.split(",");
        if (pos.length != 2 || pos[0].isEmpty() || pos[1].isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid position", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(Integer.parseInt(pos[0]) > canvas2.getWidth() || Integer.parseInt(pos[1]) > canvas2.getHeight()){
            JOptionPane.showMessageDialog(null, "Position out of bounds",  "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public static boolean validateNumber(String length) {
        if (length.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Length/radius is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for (int i = 0; i < length.length(); i++) {
            if (!Character.isDigit(length.charAt(i)) && length.charAt(i) != '.') {
                JOptionPane.showMessageDialog(null, "Invalid length/radius", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if(Double.parseDouble(length) <= 0){
            JOptionPane.showMessageDialog(null, "Length/radius must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
