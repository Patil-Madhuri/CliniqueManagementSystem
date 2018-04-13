package com.bridgelabz.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class ReadDataFromFile 
{
	public static <T>ArrayList<T> readFile(File fileName,Class<T[]>className)
	{
		ArrayList<T> arrayList=null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
		FileReader reader=new FileReader(fileName);
		BufferedReader br=new BufferedReader(reader);
		String data=br.readLine();
		List<T>list = new LinkedList<T>(Arrays.asList(objectMapper.readValue(data, className)));
		arrayList = new ArrayList<T>(list);
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return arrayList;
		
}
}
