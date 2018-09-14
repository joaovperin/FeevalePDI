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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Perin
 */
public abstract class FunerariaChallenge {

    public String getInformationText() {
        return "This Challenge hasn't an information text yet because the programmer is lazy. Please bother him until he create one :D";
    }

    public abstract Image getProcessedImage(String imgName);

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param imgName The Image to be converted
     * @return The converted BufferedImage
     */
    protected static BufferedImage toBufferedImage(String imgName) {
        try {
            return getFromResources(imgName);
        } catch (IOException ex) {
            throw new RuntimeException("fail to load image :/");
        }
    }

    protected static Image toFxImage(BufferedImage img) {
        return SwingFXUtils.toFXImage(img, null);
    }

    protected static BufferedImage getFromResources(String imgName) throws IOException {
        URL url = FunerariaChallenge.class.getClassLoader().getResource(imgName);
        return ImageIO.read(url);
    }

}
