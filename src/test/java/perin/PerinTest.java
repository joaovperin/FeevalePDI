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
package perin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Perin
 */
public class PerinTest {

    public static void main(String[] args) throws Exception {
        new PerinTest().run();
    }

    public void run() throws Exception {
        System.out.println("*** IMG: ");
        BufferedImage img = getFromResources("lena.jpg");
        System.out.println("((WID: " + img.getWidth());;
//        img.
    }

    private BufferedImage getFromResources(String imgName) throws IOException {
        URL url = getClass().getClassLoader().getResource(imgName);
        BufferedImage img = ImageIO.read(url);
        return img;
    }

}
