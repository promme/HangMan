package Hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
//used to read the whole file and put a delimiter between the word in this case "/"
	String readfile(){
		String AllWords = "";
		//Wordlist stolen from http://pastebin.com/RE5UaYW4, didnt include everything
		try (BufferedReader br = new BufferedReader(new FileReader("WordList")))
		{
 
			String sCurrentLine;
 
			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				AllWords += sCurrentLine + "/";
			}
//			System.out.println(AllWords);
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return AllWords;
	}
}
