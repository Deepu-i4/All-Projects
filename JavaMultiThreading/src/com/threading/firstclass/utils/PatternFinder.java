package com.threading.firstclass.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatternFinder {

	public List<Integer> findPattern(File file, String pattern) {
		List<Integer> lineNumber = new ArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			int lineNo = 1;
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(pattern)) {
					lineNumber.add(lineNo);
				}
				lineNo++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// just introduce to delay...suppose file is big
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return lineNumber;
	}

}
