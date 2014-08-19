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
			List = listOfVariant(title.get(i));
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
	
	private String setFirstWordToUpperCase(String title){
		String [] arr = title.split(" ", 2);
		if(arr.length >1){
		return (arr[0].toUpperCase() +" " + arr[1].toLowerCase()).trim();
		}
		else
			return title.toUpperCase();
	}
	
	private ArrayList<String> listOfVariant(String sentence){
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
				PostProcessedTitle.add(setFirstWordToUpperCase(list.get(i)));
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