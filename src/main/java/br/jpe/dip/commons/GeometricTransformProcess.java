/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.jpe.dip.commons;

import java.awt.image.BufferedImage;

/**
 *
 * @author Perin
 */
public abstract class GeometricTransformProcess {

    public final BufferedImage process(BufferedImage image) {

        // Create a newiamge
        BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        // Calculate the transformation on the matrix
        int halfX = image.getWidth() / 2;
        int halfY = image.getHeight() / 2;
        // For each pixel
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                double[][] transformMatrix = getTransformMatrix(image, x, y);

                int tmpX = x - halfX;
                int tmpY = y - halfY;
                int newX = (int) Math.round(tmpX * transformMatrix[0][0] + tmpY * transformMatrix[0][1] + 1
                        * transformMatrix[0][2]);
                int newY = (int) Math.round(tmpX * transformMatrix[1][0] + tmpY * transformMatrix[1][1] + 1
                        * transformMatrix[1][2]);
                newX += halfX;
                newY += halfY;

                // If it fits the image, sets  the pixels
                if (newX < image.getWidth() && newY < image.getHeight() && newX >= 0 && newY >= 0) {
                    int oldRgb = image.getRGB(newX, newY);
                    img.setRGB(x, y, oldRgb);
                }

            }
        }
        return img;
    }

    public abstract double[][] getTransformMatrix(BufferedImage image, double x, double y);

    protected static final double sin(double n) {
        return Math.sin(n);
    }

    protected static final double cos(double n) {
        return Math.cos(n);
    }
}
