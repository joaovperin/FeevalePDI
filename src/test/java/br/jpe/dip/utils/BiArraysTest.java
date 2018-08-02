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

import java.util.Arrays;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import static core.tests.TestUtils.*;

/**
 * Unit tests of the BiArrays util class
 */
public class BiArraysTest {

    /** Sample for the tests */
    final int[][] sample = new int[][]{
        new int[]{3, 6, 9},
        new int[]{2, 4, 8},
        new int[]{1, 2, 3}
    };

    /**
     * Tests the copy method
     */
    @Test
    public void copy() {
        int[][] expected = new int[][]{
            new int[]{3, 6, 9},
            new int[]{2, 4, 8},
            new int[]{1, 2, 3}
        };
        assertArrayEqual(expected, BiArrays.copy(sample));
    }

    /**
     * Asserts the reference is not the same
     */
    @Test
    public void reference() {
        assertFalse(sample == BiArrays.copy(sample));
    }

    /**
     * Asserts the reference is not the same
     */
    @Test
    public void equality() {
        assertFalse(Arrays.equals(sample, BiArrays.copy(sample)));
    }

}
