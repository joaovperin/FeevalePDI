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
package br.jpe.dip;

import br.jpe.dip.screen.Window;
import javafx.application.Application;
import javax.swing.UIManager;

/**
 * Main Entry Point
 */
public class Main {

    /**
     * Main program entry point
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("*** Welcome to Digital Image Processing (DIP).");
        if (args == null || args.length == 0) {
            startWindow();
        }
    }

    private static void startWindow(String... args) throws Exception {
        final String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
        UIManager.setLookAndFeel(lookAndFeel);
        Application.launch(Window.class, args);
    }

}
