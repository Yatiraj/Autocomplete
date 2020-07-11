package com.powerschool.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {
	public HashSet<String> read() throws IOException {
		HashSet<String> valueSet = new HashSet<String>();
		try (InputStream inputStream = getClass().getResourceAsStream("/input.txt");
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				valueSet.add(line);
			}
		}
		return valueSet;
	}
}