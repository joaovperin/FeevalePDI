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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test class for the MatrixUtils
 */
public class MatrixUtilsTest {

    /** Sample for the tests */
    final Matrix sample = Matrix.of(new int[][]{
        new int[]{3, 6, 9},
        new int[]{2, 4, 8},
        new int[]{1, 2, 3}
    });

    /**
     * Test of IsRegular method, of class MatrixUtils.
     */
    @Test
    public void testIsRegular() {
        // 3x3 matrix
        assertTrue(MatrixUtils.isRegular(sample));
        // 2x2+1 matrix
        assertFalse(MatrixUtils.isRegular(Matrix.of(new int[][]{
            new int[]{2, 8},
            new int[]{1, 2, 3}
        })));
        // 2x3 matrix
        assertFalse(MatrixUtils.isRegular(Matrix.of(new int[][]{
            new int[]{2, 8},
            new int[]{3, 5},
            new int[]{7, 4}
        })));
    }

    /**
     * Test of calcNumberElements method, of class MatrixUtils.
     */
    @Test
    public void testCalcNumberElements() {
        assertTrue(9 == MatrixUtils.calcNumberElements(sample));
        assertTrue(5 == MatrixUtils.calcNumberElements(Matrix.of(new int[][]{
            new int[]{200, 0, 200},
            new int[]{180, 0}
        })));
    }

    /**
     * Test of calcMean method, of class MatrixUtils.
     */
    @Test
    public void testCalcMean() {
        Matrix of = Matrix.of(new int[][]{
            new int[]{200, 0, 200},
            new int[]{180, 0, 200},
            new int[]{120, 0, 255}
        });
        assertTrue(128.33333333333334d == MatrixUtils.calcMean(of));
    }

    /**
     * Test of calcMedian method, of class MatrixUtils.
     */
    @Test
    public void testCalcMedian() {
        // Regular matrix
        double median = MatrixUtils.calcMedian(sample);
        assertTrue(4 == median);
        // Non-Regular matrix
        median = MatrixUtils.calcMedian(Matrix.of(new int[][]{
            new int[]{10, 20},
            new int[]{300}
        }));
        assertTrue(20 == median);
    }

    /**
     * Test of calcVariance method, of class MatrixUtils.
     */
    @Test
    public void testCalcVariance() {
        double variance = MatrixUtils.calcVariance(Matrix.of(new int[][]{
            new int[]{78, 78, 77, 76, 72},
            new int[]{78, 76, 76, 74, 60},
            new int[]{76, 71, 70, 68, 68},
            new int[]{72, 71, 70, 67, 68},
            new int[]{69, 67, 67, 65, 63}
        }));
        assertTrue(23 == variance);
    }

    /**
     * Test of calcVariance method, of class MatrixUtils.
     */
    @Test
    public void testCalcMode() {
        // Common matrix
        assertTrue(0 == MatrixUtils.calcMode(Matrix.of(new int[][]{
            new int[]{200, 0, 200},
            new int[]{180, 0, 200},
            new int[]{120, 0, 255}
        })));
        // A matrix with no values
        assertTrue(-1 == MatrixUtils.calcMode(Matrix.of(new int[][]{})));
    }

}
