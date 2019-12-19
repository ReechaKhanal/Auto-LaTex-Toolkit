package BIB;
import java.io.*;
import java.util.*;
public class Mapping_File{
	
	static Map<String, String> words = new HashMap<>();
	static Map<String, String> sentences = new HashMap<>();
	
	public Mapping_File(){
		
		//this.words = words;
		
		String filePath = "E:\\Eclipse\\Workspace\\Pursue_Research\\src\\BIB\\HashMap.txt";		
		
		String line;
		
		BufferedReader reader = null;
		
		try{
			reader =new BufferedReader(new FileReader(filePath));
			while((line = reader.readLine())!=null){
			
				String[] parts = line.split("=", 2);
			    
			   	String key = parts[0];
				String value = parts[1];	
				words.put(key, value);
				sentences.put(value,key);
			}// end while
		}// end try block
		
		catch(Exception e){
			System.out.println("Couldnot find the requested file.");
		}// end catch block
					
		}// end constructor
		
		public Map<String, String> getWordsMap(){
			
			return words;
		}// end get method getWordsMap
		
		public Map<String, String> getSentencesMap(){
			
			return sentences;
		}// end get method getWordsMap
		
}// end of class Mapping_file