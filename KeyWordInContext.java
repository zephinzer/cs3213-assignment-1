import java.util.*;

public class KeyWordInContext {
	Data title;
	Data ignoreWords;
	public static String pathToIgnoredWordsFile = "C:\\Users\\CS\\Documents\\testFile02.txt";
	public static String pathToTitleFile = "C:\\Users\\CS\\Documents\\testFile01.txt";
	
	public KeyWordInContext() {
		System.out.println("BEGIN\n");
		
		// initialization
		IStorage iStorageIgnoredWords = new FileStorage();
		IStorage iStorageTitles = new FileStorage();
		iStorageIgnoredWords.setFilename(KeyWordInContext.pathToIgnoredWordsFile);
		iStorageTitles.setFilename(KeyWordInContext.pathToTitleFile);
		
		this.ignoreWords = new Data();
		this.title = new Data();
		this.ignoreWords.setStorageEngine(iStorageIgnoredWords);
		this.title.setStorageEngine(iStorageTitles);
		this.ignoreWords.setDelimiter(System.lineSeparator());
		this.title.setDelimiter(System.lineSeparator());
		
		boolean ignoreWordsLoadSuccessful = false;
		boolean titleLoadSuccessful = false;
		ArrayList<String> ignoreWordsArray = new ArrayList<String>();
		ArrayList<String> titleArray = new ArrayList<String>();
		
		try {
			this.ignoreWords.loadData();
			ignoreWordsArray = this.ignoreWords.getData();
			ignoreWordsLoadSuccessful = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			this.title.loadData();
			titleArray = this.title.getData();
			titleLoadSuccessful = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		if(ignoreWordsLoadSuccessful == true) {
			Integer tempLength = ignoreWordsArray.size();
			for(Integer i = 0; i < tempLength; ++i) {
				System.out.println(ignoreWordsArray.get(i) + ", ");
			}
		}
		
		System.out.println("\n");
		
		if(titleLoadSuccessful == true) {
			Integer tempLength = titleArray.size();
			for(Integer i = 0; i < tempLength; ++i) {
				System.out.println(titleArray.get(i) + ", ");
			}
		}
		
		System.out.println("\nHere comes the list!");
		Processor abc = new Processor();
		ArrayList<String> lalala = abc.getProcessed(titleArray,ignoreWordsArray);
		
		for(int i = 0; i < abc.getPostProcessedTitleSize(); i++){
			System.out.print(i+1 + ". ");
			System.out.println(lalala.get(i));
		}
		
		System.out.println("\nEND");
	}
	
	public static void main(String[] args) {
		KeyWordInContext ini = new KeyWordInContext();
	}
}