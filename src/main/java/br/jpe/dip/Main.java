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

import br.jpe.dip.challenges.Challenge1;
import br.jpe.dip.core.utils.Systems;
import br.jpe.dip.screen.DigitalImageProcessingApp;
import javafx.application.Application;
import javax.swing.UIManager;

/**
 * Main Entry Point
 *
 * @author joaovperin
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

//        args = new String[]{
//            "Figura_Desafio_1.png"
//        };
        // Command line or window based
        if (args == null || args.length == 0) {
            startGraphicalUserInterfaceApplication();
        } else {
            // TODO: Create a command line args parser to select exercise
            String fn = args[0];
            new Challenge1(fn).run();
        }
    }

    /**
     * Starts the GUI application
     *
     * @param args
     * @throws Exception
     */
    private static void startGraphicalUserInterfaceApplication(String... args) throws Exception {
        final String lookAndFeel = Systems.isWindows()
                ? "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"
                : "javax.swing.plaf.metal.MetalLookAndFeel";
        UIManager.setLookAndFeel(lookAndFeel);
        Application.launch(DigitalImageProcessingApp.class, args);
    }

}
