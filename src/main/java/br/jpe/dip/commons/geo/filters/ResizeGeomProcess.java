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
package br.jpe.dip.commons.geo.filters;

import br.jpe.dip.commons.GeometricTransformProcess;
import java.awt.image.BufferedImage;

/**
 *
 * @author Perin
 */
public class ResizeGeomProcess extends GeometricTransformProcess {

    private final double xTimes;
    private final double yTimes;

    public ResizeGeomProcess(double xTimes, double yTimes) {
        this.xTimes = xTimes;
        this.yTimes = yTimes;
    }

    @Override
    public double[][] getTransformMatrix(BufferedImage image, double x, double y) {
        return new double[][]{
            new double[]{1 / xTimes, 0, 0},
            new double[]{0, 1 / yTimes, 0},
            new double[]{x, y, 1}
        };
    }

}
