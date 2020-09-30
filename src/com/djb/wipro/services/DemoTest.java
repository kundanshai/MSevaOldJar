package com.djb.wipro.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoTest {

	
	public static void main(String[] args) {
		try {
			testExceptions();
		} catch (FileNotFoundException   e) {
			e.printStackTrace();
		}catch(IOException d) {
			
		}
	}
	
	
	
	public static void testExceptions() throws IOException, FileNotFoundException{
		

}
}