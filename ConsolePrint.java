import java.util.*;

public class ConsolePrint{
	public static void initialize(){
		System.out.println("Hello " + System.getProperty("user.name") + "!\n"
				+ "Select one of the option by typing the index:\n"
				+ "1. Output the list of ignored words\n"
				+ "2. Output the list of raw titles\n"
				+ "3. Output the list of processed titles\n"
				+ "4. To exit");
				
	}
	
	public void printIgnoreWordArray(ArrayList<String> ignoreWordsArray){
		Integer tempLength = ignoreWordsArray.size();
		for(Integer i = 0; i < tempLength; ++i) {
			System.out.print(i+1 + ". ");
			System.out.println(ignoreWordsArray.get(i));
		}
		System.out.println("\n");
	}
	
	public void printTitleArray(ArrayList<String> titleArray){
		Integer tempLength = titleArray.size();
		for(Integer i = 0; i < tempLength; ++i) {
			System.out.print(i+1 + ". ");
			System.out.println(titleArray.get(i));
		}
		System.out.println("\n");
	}
	
	public void printProcessed(ArrayList<String> processedArray, int size){
		for(int i = 0; i < size; i++){
			System.out.print(i+1 + ". ");
			System.out.println(processedArray.get(i));
		}
		System.out.println("\n");
	}
	
	
}