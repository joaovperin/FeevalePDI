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
package br.jpe.dip.ui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Perin
 */
public class MessageBoxes {

    public static void showInfoDialog(String msg) {
        Alert alert = new Alert(AlertType.INFORMATION, msg, ButtonType.OK);
        alert.setTitle("Information");
        alert.show();
    }

    private static void showAskingDialog(String msg) {
//        Alert alert = new Alert(AlertType.INFORMATION, "Delete " + selection + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
//        alert.showAndWait();
//
//        if (alert.getResult() == ButtonType.YES) {
//            //do stuff
//        }
//        System.out.println("**msg: " + msg);
    }

}
