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
    /** Indicates if the matrix is a square */
    private Boolean isSquare;

    /**
     * Creates a matrix based on an bidimensional array
     *
     * @param mtz
     */
    public Matrix(int[][] mtz) {
        this.mtz = BiArrays.copy(mtz);
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
     * Returns true if the image is a square
     *
     * @return boolean
     */
    public boolean isSquare() {
        if (isSquare == null) {
            checkIsSquare();
        }
        return isSquare;
    }

    /**
     * Check if the image is a square
     */
    private void checkIsSquare() {
        isSquare = MatrixUtils.isSquare(this);
    }

}
