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

import br.jpe.dip.model.Matrix;

/**
 * Helpful class to work with matrixes
 */
public class MatrixUtils {

    /**
     * Check's if a matrix is a square and returns true if so
     *
     * @param src
     * @return boolean
     */
    public static final boolean isSquare(Matrix src) {
        int[][] mtz = src.get();
        int s = mtz.length;
        for (int[] row : mtz) {
            if (row.length != s) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtain and returns the mean of the matrix
     *
     * @param src
     * @return double
     */
    public static final double calcMean(Matrix src) {
        // TODO: Test that.
        int[][] mtz = src.get();
        int tLen = mtz.length;
        double iLen = 0;
        double sum = 0;
        for (int i = 0; i < iLen; i++) {
            int jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                iLen++;
                sum += mtz[i][j];
            }
        }
        return (sum / tLen);
    }

    /**
     * Obtain and returns the median of the matrix
     *
     * @param src
     * @return double
     */
    public static final double calcMedian(Matrix src) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     * Obtain and returns the variancy of the matrix
     *
     * @param src
     * @return double
     */
    public static final double calcVariancy(Matrix src) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}
