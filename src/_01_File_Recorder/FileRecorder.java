package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter a message:");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("src/_01_File_Recorder/test.txt");
			//inherited method from java.io.OutputStreamWriter 
			fileWriter.write(message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
	
	// Create a program that takes a message from the user and saves it to a file.


//Copyright © 2019 Ella Demarest