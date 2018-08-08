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
package br.jpe.dip.utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

/**
 * Read and convert images into matrixes
 */
public class Images {

    // Shortcut to read from a filename
    public static BufferedImage read(String filename) throws IOException {
        return read(new File(filename));
    }

    // Shortcut to read from a filename
    public static final int[][] getAsGrayscaleMatrix(String src) throws IOException {
        return getAsGrayscaleMatrix(new File(src));
    }

    // Shortcut to read from a filename
    public static int[][] getAsMatrix(String filename) throws IOException {
        return getAsMatrix(new File(filename));
    }

    /**
     * Reads an image
     *
     * @param src
     * @return BufferedImage
     * @throws IOException
     */
    public static final BufferedImage read(File src) throws IOException {
        return ImageIO.read(src);
    }

    /**
     * Reads an image and returns that as a matrix
     *
     * @param src
     * @return int[][]
     * @throws IOException
     */
    public static final int[][] getAsMatrix(File src) throws IOException {
        return processImageAsMatrix(src, (read, raster, i, j) -> raster.getSample(i, j, 0));
    }

    /**
     * Reads an image and returns that as a grayscale matrix
     *
     * @param src
     * @return int[][]
     * @throws IOException
     */
    public static final int[][] getAsGrayscaleMatrix(File src) throws IOException {
        return processImageAsMatrix(src, (read, raster, i, j) -> {
            Color color = new Color(read.getRGB(i, j));
            return ((color.getRed() + color.getGreen() + color.getBlue()) / 3);
        });
    }

    /**
     * Process an image as a matrix
     *
     * @param src
     * @param script
     * @return int[][]
     * @throws IOException
     */
    private static int[][] processImageAsMatrix(File src, Script script) throws IOException {
        // Checks if the file exists
        if (!src.exists()) {
            throw new IIOException("Isto Non Exziste! " + src.getAbsolutePath());
        }

        BufferedImage read = read(src);
        WritableRaster raster = read.getRaster();

        // Validate the number of bands
        int numBands = raster.getNumBands();
        if (numBands <= 0) {
            throw new IIOException("Not a valid image.");
        }

        int iLen = raster.getWidth();
        int jLen = raster.getHeight();
        int[][] mtz = new int[iLen][jLen];

        // Loads the samples of the first band into an integer bi-array
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                mtz[i][j] = script.run(read, raster, i, j);
            }
        }
        return mtz;
    }

    @FunctionalInterface
    private interface Script {

        // Script to proccess an image
        public int run(BufferedImage read, WritableRaster raster, int i, int j);
    }

}
