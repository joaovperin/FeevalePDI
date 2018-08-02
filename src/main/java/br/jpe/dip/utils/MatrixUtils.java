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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Helpful class to work with matrixes
 */
public class MatrixUtils {

    /**
     * Check's if a matrix is regular and returns true if so
     *
     * @param src
     * @return boolean
     */
    public static final boolean isRegular(Matrix src) {
        int[][] mtz = src.get();
        final int s = mtz.length;
        for (int[] row : mtz) {
            if (row.length != s) {
                return false;
            }
        }
        return true;
    }

    /**
     * Obtain and return the total number of elements in a matrix
     *
     * @param src
     * @return int
     */
    public static final int calcNumberElements(Matrix src) {
        // If it's a square, just return the values
        if (src.isRegular()) {
            return src.getWidth() * src.getHeight();
        }
        // Iterates all over elements to sum positions
        int[][] mtz = src.get();
        final double iLen = mtz.length;
        int tLen = 0;
        for (int i = 0; i < iLen; i++) {
            final double jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                tLen++;
            }
        }
        return tLen;
    }

    /**
     * Obtain and returns the arithmetic mean (average) of the matrix
     *
     * @param src
     * @return double
     */
    public static final double calcMean(Matrix src) {
        int[][] mtz = src.get();
        final int iLen = mtz.length;
        double tLen = 0, sum = 0;
        for (int i = 0; i < iLen; i++) {
            final int jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                tLen++;
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
        int[][] mtz = src.get();
        final double iLen = mtz.length;
        double tLen = calcNumberElements(src), n = 0;
        // Obtains the center value
        int v = (int) Math.round(tLen / 2);
        for (int i = 0; i < iLen; i++) {
            final double jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                if (++n == v) {
                    return mtz[i][j];
                }
            }
        }
        return -1;
    }

    /**
     * Obtain and returns the variance of the matrix
     *
     * @param src
     * @return double
     */
    public static final double calcVariance(Matrix src) {
        int[][] mtz = src.get();
        final int iLen = mtz.length;
        final double mean = calcMean(src);
        int sum = 0;
        for (int i = 0; i < iLen; i++) {
            final int jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                sum += (int) (Math.pow(mtz[i][j] - mean, 2));
            }
        }
        return (sum / calcNumberElements(src));
    }

    /**
     * Obtains the matrix histogram
     *
     * @param src
     * @return Map
     */
    private static Map<Integer, Integer> createHistogram(Matrix src) {
        Map<Integer, Integer> histogram = new HashMap<>();
        int[][] mtz = src.get();
        final double iLen = mtz.length;
        for (int i = 0; i < iLen; i++) {
            final double jLen = mtz[i].length;
            for (int j = 0; j < jLen; j++) {
                final int v = mtz[i][j];
                histogram.put(v, histogram.getOrDefault(v, -1) + 1);
            }
        }
        return histogram;
    }

    /**
     * Obtain and returns the mode of the matrix
     *
     * @param src
     * @return double
     */
    public static final int calcMode(Matrix src) {
        // Find's the value with the most occurrences on the histogram
        Map<Integer, Integer> histogram = createHistogram(src);
        Optional<Map.Entry<Integer, Integer>> max = histogram.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        return max.isPresent() ? max.get().getKey() : -1;
    }

}
