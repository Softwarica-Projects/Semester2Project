/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Rishan
 */

    public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(String path) {
        try {
            // Load an image from file
            image = ImageIO.read(new File(path));
              System.out.println("image read success");
        } catch (IOException e) {
            //cannot load image
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
  System.out.println("Drawing Image");
        // Draw the image on the panel
        if (image != null) {
           
            g.drawImage(image, 0, 0, this);
        }
    }
}

