package com.kko.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

	public Integer fileReadTemplate(String path, BufferedReaderCallback callback) throws IOException {
		BufferedReader br = null;
		Integer result = 0;
		
		try {
			br = new BufferedReader(new FileReader(path));
			result = callback.doSomethingWithReader(br);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		
		return result;
	}
	
	public <T> T lineReadTemplate(String path, LineCallback<T> callback, T initVal) throws IOException {
		BufferedReader br = null;
		String line = null;
		T result = initVal;
		
		try {
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null){
				result = callback.doSomethingWithLine(line, result);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
		
		return result;
	}
	
	public int calSum(String path) throws IOException {
		BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
			
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer sum = 0;
				String line = null;
				
				while((line = br.readLine()) != null){
					sum += Integer.valueOf(line);
				}
				
				return sum;
			}
		};
		
		return fileReadTemplate(path, sumCallback);
		
	}
	public int calSumLine(String path) throws IOException{
		LineCallback<Integer> sumLineCallback = new LineCallback<Integer>() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(path, sumLineCallback, 0);
	}

	public Object calMult(String path) throws IOException {
		BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
			
			@Override
			public Integer doSomethingWithReader(BufferedReader br) throws IOException {
				Integer sum = 1;
				String line = null;
				
				while((line = br.readLine()) != null){
					sum *= Integer.valueOf(line);
				}
				
				return sum;
			}
		};
		
		return fileReadTemplate(path, sumCallback);
	}
	public int calMultLine(String path) throws IOException{
		LineCallback<Integer> sumLineCallback = new LineCallback<Integer>() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) {
				return value * Integer.valueOf(line);
			}
		};
		
		return lineReadTemplate(path, sumLineCallback, 1);
	}
	
	public String concatenate(String path) throws IOException{
		LineCallback<String> concatCallback = new LineCallback<String>() {
			
			@Override
			public String doSomethingWithLine(String line, String value) {
				return value + line;
			}
		};
		
		return lineReadTemplate(path, concatCallback, "");
	}
}
