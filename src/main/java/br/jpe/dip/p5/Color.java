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
package br.jpe.dip.p5;

/**
 * Enum to hold colors
 */
public enum Color {

    RED(200, 30, 20),
    BLACK(0, 0, 0),
    WHITE(255, 255, 255);

    /** Red. Green and Blue 0-255 bytes */
    public int r, g, b;

    /**
     * Constructor
     *
     * @param r
     * @param g
     * @param b
     */
    private Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

}
