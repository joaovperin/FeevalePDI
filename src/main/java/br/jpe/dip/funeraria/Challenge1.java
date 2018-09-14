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
package br.jpe.dip.funeraria;

import br.jpe.dip.utils.Images;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Perin
 */
public class Challenge1 extends FunerariaChallenge {

    @Override
    public Image getProcessedImage(String imgName) {
        BufferedImage img = toBufferedImage(imgName);
//        int[][] mtz = Images.getAsGrayscaleMatrix(x);

//        int width = 30, height = 30;
//        WritableImage wimg = new WritableImage(width, height);
//        PixelWriter pw = wimg.getPixelWriter();
//        pw.setPixels(0, 0, width, height, PixelFormat.getIntArgbInstance(), mtz[0], 0, width);
//        Image img = new Image(new ByteArrayInputStream(buffer));
//        Images.getAsGrayscaleMatrix(new File(img.));
        return toFxImage(img);
    }

}
