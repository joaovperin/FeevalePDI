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
package br.jpe.dip.utils;

import java.io.File;
import java.io.IOException;

/**
 * Reads and manipulates files
 */
public class Files {

    /**
     * Reads a file
     *
     * @param src
     * @return byte[]
     * @throws IOException
     */
    public static final byte[] read(String src) throws IOException {
        return read(new File(src));
    }

    /**
     * Reads a file
     *
     * @param src
     * @return byte[]
     * @throws IOException
     */
    public static final byte[] read(File src) throws IOException {
        if (!src.exists() || !src.isFile()) {
            throw new IOException();
        }
        return java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(src.toURI()));
    }

}
