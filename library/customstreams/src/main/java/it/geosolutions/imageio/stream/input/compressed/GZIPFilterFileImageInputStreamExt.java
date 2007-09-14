/*
 *    JImageIO-extension - OpenSource Java Image translation Library
 *    http://www.geo-solutions.it/
 *    (C) 2007, GeoSolutions
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package it.geosolutions.imageio.stream.input.compressed;

/*
 *    Geotools2 - OpenSource mapping toolkit
 *    http://geotools.org
 *    (C) 2002, Geotools Project Managment Committee (PMC)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 */

import it.geosolutions.imageio.stream.input.FileImageInputStreamExt;
import it.geosolutions.imageio.stream.input.FileImageInputStreamExtImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Daniele Romagnoli
 * @author Simone Giannecchini(Simboss)
 */

public class GZIPFilterFileImageInputStreamExt extends GZIPImageInputStream
		implements FileImageInputStreamExt {
	private File file;

	public GZIPFilterFileImageInputStreamExt(File file)
			throws FileNotFoundException, IOException {
		super(new GZIPImageInputStream(new FileImageInputStreamExtImpl(file)));
		this.file = file;
	}

	public GZIPFilterFileImageInputStreamExt(FileImageInputStreamExtImpl fiis)
			throws FileNotFoundException, IOException {
		super(new GZIPImageInputStream(fiis));
		this.file = fiis.getFile();
	}

	/**
	 * return the associated file
	 * 
	 * @return DOCUMENT ME!
	 */
	public File getFile() {
		return file;
	}
}