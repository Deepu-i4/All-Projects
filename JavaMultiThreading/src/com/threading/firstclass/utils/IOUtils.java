package com.threading.firstclass.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

	public static void copy(InputStream src, OutputStream dest) throws IOException {
		int value;
		while ((value = src.read()) != -1) {
			dest.write(value);
		}
	}

	public static void copyFile(String sourceFile, String destFile) throws IOException {
		FileInputStream fin = new FileInputStream(sourceFile);
		FileOutputStream fos = new FileOutputStream(destFile);

		IOUtils.copy(fin, fos);

		fin.close();
		fos.close();
	}

}
