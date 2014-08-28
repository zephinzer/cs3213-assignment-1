import java.util.*;

public class Processor{
	
	private ArrayList<String> PostProcessedTitle = new ArrayList<String>();
	private ArrayList<String> List;
	private String title;
	
	public int getPostProcessedTitleSize(){
		return PostProcessedTitle.size();
	}
	
	public ArrayList<String> getProcessed(ArrayList<String> title, ArrayList<String> ignoreList){
		getProcessedTitle(title, ignoreList);
		return PostProcessedTitle; 
	}
	
	public ArrayList<String> getProcessedTitle(ArrayList<String> title, ArrayList<String> ignoreList){
		for(int i = 0; i < title.size(); i++ ){
			List = listOfVariant(title.get(i), ignoreList);
			addToProcessedList(List, ignoreList);
		}
		sortList();
		return PostProcessedTitle;
	}
	
	private String removeAndAppendFirstWord(String title){
		String [] arr = title.split(" ", 2);
		return (arr[1] +" " + arr[0]).trim();
	}
	
	private String getFirstWord(String title){
		String [] arr = title.split(" ", 2);
		return arr[0].trim();
	}
	
	private String setFirstLetterToUpperCase(String title){
		String otherLetter = title.substring(1);
		String firstLetter = title.substring(0,1);
		return firstLetter.toUpperCase() + otherLetter.toLowerCase();

	}
	
	private String capitaliseWord(String sentence, ArrayList<String> ignoreList){
		String arr[] = sentence.trim().split(" ");
		String endTitle= "";
		String word;
		for(int i = 0; i < arr.length; i++){
			if(!isWordToIgnore(arr[i], ignoreList)){
				word = setFirstLetterToUpperCase(arr[i]);
			}else{
				word = arr[i].toLowerCase();
			}
			endTitle = endTitle + " " + word;
		}
		
		return endTitle.trim();
	}
	
	private ArrayList<String> listOfVariant(String sentence, ArrayList<String> ignoreList){
		
		sentence = capitaliseWord(sentence, ignoreList);
		
		String arr[] = sentence.trim().split(" ");
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(sentence);
		String newTitle = sentence;
		for(int i = 1; i < arr.length; i++){
			
			newTitle = removeAndAppendFirstWord(newTitle);
			list.add(newTitle);
		}
		
		return list;
	}
	
	private void addToProcessedList(ArrayList<String> list, ArrayList<String> ignoreList){
		for (int i = 0; i < list.size(); i ++){
			if(!isWordToIgnore(list.get(i), ignoreList)){
				PostProcessedTitle.add(list.get(i));
			}
		}
	}
	
	private boolean isWordToIgnore(String sentence, ArrayList<String> ignoreList){
		for(int i = 0; i < ignoreList.size(); i++){
			if(ignoreList.get(i).toLowerCase().equals(getFirstWord(sentence).toLowerCase()))
				return true;
		}
		return false;
	}
		
	private void sortList(){
	
		Collections.sort(PostProcessedTitle);
		
	}
	
}