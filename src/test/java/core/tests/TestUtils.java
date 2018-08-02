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
package core.tests;

import static org.junit.Assert.assertEquals;

/**
 * A helper class for unit tests
 */
public class TestUtils {

    /**
     * Asserts that two bidimensional arrays are equal
     *
     * @param expected
     * @param received
     */
    public static final void assertArrayEqual(int[][] expected, int[][] received) {
        assertEquals("Wrong number of rows", expected.length, received.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals("Wrong number of columns at row " + i, expected[i].length, received[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals("Wrong value on row/column " + i + ":" + j, expected[i][j], received[i][j]);
            }
        }
    }

}
