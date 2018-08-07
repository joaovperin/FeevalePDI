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
package br.jpe.dip.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Perin
 */
public class MainWindow {

    private final JFrame frame;
    private final JPanel panel;
    private final JFileChooser chooser;

    private final JLabel labelFile;
    private final JTextField filename;

    private final Dimension winDimension;

    public MainWindow() {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.chooser = new JFileChooser();
        this.winDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.filename = new JTextField();
        this.labelFile = new JLabel();
        buildWindow();
    }

    public void show() {
        this.frame.setVisible(true);
    }

    // Build the window
    private void buildWindow() {
        this.frame.setTitle("Janela");
        this.frame.setSize(toDimension(0.92f, 0.86f));
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setLocation(winDimension.width / 2 - this.frame.getSize().width / 2, winDimension.height / 2 - this.frame.getSize().height / 2);

        this.panel.setBackground(new Color(40, 20, 30));
        this.frame.add(this.panel);

        this.labelFile.setText("Selecione a imagem: ");
        this.labelFile.setSize(toDimension(0.4f, 0.25f));
        this.labelFile.setLocation(toPoint(0.35f, 0.5f));
        this.labelFile.setForeground(Color.red);
        this.panel.add(this.labelFile);

        this.filename.setText("D:\\Samples\\");
        this.filename.setSize(toDimension(0.5f, 0.75f));
        this.filename.setLocation(toPoint(0.5f, 0.45f));
        this.labelFile.setForeground(Color.yellow);
        this.panel.add(this.filename);

//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", supportedExtensions());
//        this.chooser.setFileFilter(filter);
//        this.chooser.setCurrentDirectory(new File("D:\\Samples\\"));
//        this.chooser.setSize(toDimension(0.8f, 0.35f));
//        this.chooser.setLocation(this.panel.getWidth() / 2 - this.panel.getSize().width / 2, this.panel.getHeight() / 2 - this.panel.getSize().height / 2);
//        this.chooser.setVisible(false);
//        this.panel.add(this.chooser);
    }

    private Point toPoint(float wid, float hei) {
        return new Point(mul(winDimension.getWidth(), wid), mul(winDimension.getHeight(), hei));
    }

    private Dimension toDimension(float wid, float hei) {
        return new Dimension(mul(winDimension.getWidth(), wid), mul(winDimension.getHeight(), hei));
    }

    private int mul(double s, double y) {
        return (int) Math.round(s * y);
    }

    private int div(double s, double y) {
        return (int) Math.round(s / y);
    }

    private String[] supportedExtensions() {
        return new String[]{".jpg, .png", "jpg", "jpeg", "JPG", "JPEG", "png", "PNG", "BMP", "bmp"};
    }

}
