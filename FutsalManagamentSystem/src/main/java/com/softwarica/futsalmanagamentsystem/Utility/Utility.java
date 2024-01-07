/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Utility;

import java.sql.ResultSetMetaData;
import java.nio.file.Path;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rishan
 */
public class Utility {

    public static void showDialogMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static String getAssetImagePath(String fileName) {
        return Path.of("src/main/java/com/softwarica/futsalmanagamentsystem/assets", fileName).toString();
    }

    public static void addImageToLabel(JLabel label, String fileName) {
        try {
            ImageIcon icon = new ImageIcon(Utility.getAssetImagePath(fileName));
            var image = icon.getImage();
            var height = label.getSize().height;
            var width = label.getSize().width;
            var newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT); // scale it the smooth way  
            icon = new ImageIcon(newimg);
            label.setIcon(icon);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static boolean existsColumnInResult(String columnName, ResultSet result) {

        // Check if the  column exists
        try {
            ResultSetMetaData metaData = result.getMetaData(); 
            int columnCount = metaData.getColumnCount();
            boolean columnExists = false;

            for (int i = 1; i <= columnCount; i++) {
                var currentColName =metaData.getColumnName(i);
                if (columnName.equalsIgnoreCase(currentColName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

}
