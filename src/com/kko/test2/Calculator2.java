package com.kko.test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator2 {

	public int calcuSum_old(String path) throws IOException {
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(path));
			Integer sum = 0;
			String line = null;
			while((line = br.readLine()) != null){
				sum += Integer.valueOf(line);
			}
			
			br.close();
			return sum;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null){
				try{
					br.close();
				} catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(filepath));
			Integer ret = callback.doSomethingWithReader(br);
			
			br.close();
			return ret;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null){
				try{
					br.close();
				} catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public Integer lineReadTemplate(String filepath, LineCallback callback, Integer initVal) throws IOException {
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(filepath));
			Integer res = initVal;
			String line = null;
			while((line = br.readLine()) != null){
				res = callback.doSomethingWithLine(line, res);
			}
			
			br.close();
			return res;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (br != null){
				try{
					br.close();
				} catch(IOException e){
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	public int calcuSum_old2(String path) throws IOException {
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

	public int calcuMultiply_old2(String path) throws IOException {
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
	
	public int calcuSum(String path) throws IOException {
		LineCallback sumCallback = new LineCallback() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) throws IOException {
				return value + Integer.valueOf(line);
			}
		};

		
		return lineReadTemplate(path, sumCallback, 0);
	}
	
	public int calcuMultiply(String path) throws IOException {
		LineCallback sumCallback = new LineCallback() {
			
			@Override
			public Integer doSomethingWithLine(String line, Integer value) throws IOException {
				return value * Integer.valueOf(line);
			}
		};
		
		LineCallback sumCallback2 = (String line, Integer value) -> {
			return value * Integer.valueOf(line);
		};
		
		return lineReadTemplate(path, sumCallback2, 1);
	}

}
