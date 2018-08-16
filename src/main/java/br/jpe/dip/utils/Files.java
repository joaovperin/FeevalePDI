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
import br.jpe.dip.core.utils.Systems;

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

    // Resolves file name without adding file protocol prefix
    public static String resolveFileName(String filename) throws IOException {
        return resolveFileName(filename, true);
    }

    /**
     * Resolves the filename
     *
     * @param filename
     * @param resolveFileProtocol
     * @return String
     * @throws IOException
     */
    public static String resolveFileName(String filename, boolean resolveFileProtocol) throws IOException {
        // Checks file name
        if (filename == null || filename.trim().isEmpty()) {
            throw new IOException("*** Invalid filename");
        }
        // Checks file exists
        if (new File(filename).exists()) {
            return resolveFileProtocol ? resolveFileProtocolPrefix(filename) : filename;
        }

        // Resolves path
        String path = Files.class.getClassLoader().getResource(filename).getPath();
        if (Systems.isWindows() && path != null && path.startsWith("/")) {
            path = path.replaceFirst("\\/", "");
        }
        System.out.println("*** -> Using path: " + path);

        // Return the name as is, for using as a resource
        return resolveFileProtocol ? resolveFileProtocolPrefix(path) : path;
    }

    /**
     * Resolves the prefix of the 'file://' protocol
     *
     * @param filename
     * @return String
     */
    public static String resolveFileProtocolPrefix(String filename) {
        final String file = "file://";
        if (filename.startsWith(file)) {
            return filename;
        }
        return file.concat(filename);
    }

}
