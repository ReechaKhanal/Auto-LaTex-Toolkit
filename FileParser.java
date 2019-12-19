package BIB;
// importing all of java's input output operations from IO package
// importing all the contents of the java.util package
import java.io.*;
import java.util.*;


public class FileParser{
	
	// start class file parser
	
	static File outputFile;

	Map<String, String> word ;
	Map<String, String> sentence;

	Mapping_File mf = new Mapping_File();
	Mapping_File mfa = new Mapping_File();
	
	static String fileContents;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		new FileParser().proceed();
	}// end the main method
	
	
	public void proceed() {
	
			String convertedBooktitle=null;
			BufferedReader br = null;
			String line; //declare a string that represents current line we will be reading
			FileParser objfileParser =new FileParser();

			String fileName = input();
			String outputFileName = output();
			boolean userDecision = userChoice();
			
			try{ // START READING THE FILE
				 br = new BufferedReader(new FileReader(fileName));
			}	
			catch(Exception e){ // if file can't be found
				System.out.println(e.getMessage() + "The file  was not found");
				System.exit(0);
			}
			try{
				while((line= br.readLine()) != null){

					FileWriter writer = new FileWriter(outputFileName, true);
					if(!line.contains("Booktitle")){// increment if line contains no abbreviated or elaborated form
						writer.write(line + "\n");
						fileContents+=line; // go to next line
					}// end of if
					else{ 
						convertedBooktitle= objfileParser.BooktitleConversion(line,userDecision);
						String Readline = objfileParser.parser(line);
						String Line = line.replaceAll(Readline, convertedBooktitle);
						writer.write(Line + "\n");
						fileContents+=line;}
					
					writer.close();	
				}}// End of while and try

			catch(Exception e){
				System.out.println(e.getMessage() + "Error reading file.");
			} // end of catch	
			finally{
				System.exit(0);}// end finally
	}
	// method parser
	public String parser(String line){

		int i = line.indexOf('{');
		int j=  line.indexOf('}');
		String Readline = line.substring(i+1, j);
		return Readline;

	}// end method parser

	// method to convert Book title 
	public String BooktitleConversion(String line, boolean IsAbbreviationToElaboration) throws IOException{	

		String Readline = parser(line);
		String Converted = null;
		if(IsAbbreviationToElaboration == true){
			//We are making an HashMap called "word" to which we put the value of the hashMap "Words" form the class Mapping_File.java
			word = mf.getWordsMap();
			if(word.containsKey(Readline))
				Converted = word.get(Readline);				
			else if(word.isEmpty())
				Converted = "the map you are looking in is empty";	
			else {
				System.out.println( "Couldnot find the elaborated form. Please Type the elaborated form you would like to use for : " + "'"
						+ Readline + "'");
				String query  = scanner.nextLine();
				try(FileWriter fw = new FileWriter("E:\\Eclipse\\Workspace\\Pursue_Research\\src\\BIB\\HashMap.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)){

					out.println( Readline + "=" + query);
					word.put(Readline, query);}// end try
				catch(IOException e){
					System.out.println("ERROR!!");}
				Converted = query;	}
			return Converted;//get the Elaborated form			
		}
		else{ // get the abbreviated word
			sentence = mfa.getSentencesMap();

			if(sentence.containsKey(Readline))
				Converted = sentence.get(Readline);
			else if(sentence.isEmpty())
				Converted = "The map you are looking in is empty";
			else{
				System.out.println( "Couldnot find the abbreviated form. Please Type the abbreviated form you would like to use for : " + "'"+ Readline + "'");
				String query  = scanner.next();
				try(FileWriter fw = new FileWriter("E:\\Eclipse\\Workspace\\Pursue_Research\\src\\BIB\\HashMap.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter out = new PrintWriter(bw)){
							out.println(query + "=" + Readline);
							sentence.put(query,Readline); }// end try
				catch(IOException e){
					System.out.println("ERROR!!");}
				Converted = query;
			}
			return Converted; //converted form of book title will be returned;	 
		}}
	
	public String input(){
		
		System.out.println("Please enter file name to be read: \n");
		String fileName = scanner.next();
		return fileName;
		
	}
	
	public String output(){
		System.out.println("Please enter filename you want your new file to be saved in : ");

		String outputFileName = scanner.next();
		 return outputFileName;
	}
	
	public boolean userChoice(){
		System.out.println("Enter What do you want to do with the file:"
				+ "\nEnter 1 for converting from abbreviated to elaborated form" + 
					"\nEnter 0 for converting from elaborated to abbreviated form\n");

		int userChoice = scanner.nextInt();
		
		boolean userDecision = true;
		if(userChoice == 0){
			userDecision = true;
		}
		else if(userChoice == 1){
			userDecision = false;
		}
		return userDecision;
		
		
	}
}// end of class file Parser