/*
 * This program takes in user's input and print their selections accordingly.
 */

import java.util.*;

public class ConsolePrint{
	private static final String _4_TO_EXIT = "4. To exit";
	private static final String _3_OUTPUT_THE_LIST_OF_PROCESSED_TITLES = "3. Output the list of processed titles\n";
	private static final String _2_OUTPUT_THE_LIST_OF_RAW_TITLES = "2. Output the list of raw titles\n";
	private static final String _1_OUTPUT_THE_LIST_OF_IGNORED_WORDS = "1. Output the list of ignored words\n";
	private static final String SELECT_OPTION = "Select one of the option by typing the index:\n";

	public static void initialize(){
		System.out.println("Hello " + System.getProperty("user.name") + "!\n"
				+ SELECT_OPTION
				+ _1_OUTPUT_THE_LIST_OF_IGNORED_WORDS
				+ _2_OUTPUT_THE_LIST_OF_RAW_TITLES
				+ _3_OUTPUT_THE_LIST_OF_PROCESSED_TITLES
				+ _4_TO_EXIT);
				
	}
	
	public void printIgnoreWordArray(ArrayList<String> ignoreWordsArray){
		printArrayList(ignoreWordsArray);
	}
	
	public void printTitleArray(ArrayList<String> titleArray){
		printArrayList(titleArray);
	}
	
	public void printProcessed(ArrayList<String> processedArray, int size){
		printArrayList(processedArray);
	}
	
	private void printArrayList(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(i+1 + ". ");
			System.out.println(list.get(i));
		}
		System.out.println("\n");
	}
	
}