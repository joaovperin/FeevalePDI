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
package br.jpe.dip.model;

import br.jpe.dip.utils.BiArrays;
import br.jpe.dip.utils.MatrixUtils;

/**
 * A model to represent a matrix
 *
 * It's immutable, so all the operations will return a new matrix
 */
public class Matrix {

    /** Integer bidimensional array to store columns and rows */
    private final int mtz[][];

    /** Matrix height */
    private Integer height;
    /** Matrix width */
    private Integer width;
    /** Indicates if the matrix is a square */
    private Boolean isRegular;

    /**
     * Creates a matrix based on an bidimensional array
     *
     * @param mtz
     */
    public Matrix(int[][] mtz) {
        this.mtz = BiArrays.copy(mtz);
    }

    /**
     * A helper to create new matrixes
     *
     * @param mtz
     * @return Matrix
     */
    public static final Matrix of(int[][] mtz) {
        return new Matrix(mtz);
    }

    /**
     * A helper to create new matrixes
     *
     * @param mtz
     * @return Matrix
     */
    public static final Matrix of(Matrix mtz) {
        return new Matrix(mtz.get());
    }

    /**
     * Returns the internal array
     *
     * @return
     */
    public int[][] get() {
        return BiArrays.copy(mtz);
    }

    /**
     * Returns the matrix height
     *
     * @return int
     */
    public int getHeight() {
        if (height == null) {
            obtainHeight();
        }
        return height;
    }

    /**
     * Returns the matrix row's width or -1 if it's not a regular matrix
     *
     * @return int
     */
    public int getWidth() {
        if (width == null) {
            obtainWidth();
        }
        return width;
    }

    /**
     * Returns true if the matrix is regular.
     *
     * A Regular matrix is a bidimensional array which all row columns length
     * are equal to the number of rows, like a square.
     *
     * @return boolean
     */
    public boolean isRegular() {
        if (isRegular == null) {
            checkIsRegular();
        }
        return isRegular;
    }

    /**
     * Check if the matrix is regular
     */
    private void checkIsRegular() {
        isRegular = MatrixUtils.isRegular(this);
    }

    /**
     * Obtains the width
     */
    private void obtainWidth() {
        width = isRegular() ? mtz.length : -1;
    }

    /**
     * Obtains the height
     */
    private void obtainHeight() {
        height = mtz.length;
    }

}
