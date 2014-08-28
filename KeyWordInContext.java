import java.util.*;

public class KeyWordInContext {
	Data title;
	Data ignoreWords;
	ConsolePrint view = new ConsolePrint();
	Processor controller = new Processor();
	
	public static String pathToIgnoredWordsFile = System.getProperty("user.dir")+"\\_ignored-words.dat";//"C:\\Users\\CS\\Documents\\testFile02.txt";
	public static String pathToTitleFile = System.getProperty("user.dir")+"\\_titles.dat"; //"C:\\Users\\CS\\Documents\\testFile01.txt";
	public static final String ERROR_FAIL_TO_LOAD_IGNORED_WORDS = "Something went wrong while loading the ignored words. Check if the file exists at " + pathToIgnoredWordsFile;
	public static final String ERROR_FAIL_TO_LOAD_TITLE = "Something went wrong while loading the title words. Check if the file exists at " + pathToTitleFile;
	public static final String ERROR_FAIL_TO_LOAD_PROCESS_DATA = "Something went wrong while processing the data. Our bad. That shouldn\'t have happened.";
	public static final String ERROR_INVALID_ENTRY = "That was not a valid entry. Please try again!";
	
	boolean ignoreWordsLoadSuccessful = false;
	boolean titleLoadSuccessful = false;

	public KeyWordInContext() {
		//System.out.println("BEGIN\n");
		
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
		
		
		try {
			this.ignoreWords.loadData();
			this.ignoreWordsLoadSuccessful = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			this.ignoreWordsLoadSuccessful = false;
		}
		
		try {
			this.title.loadData();
			this.titleLoadSuccessful = true;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			this.titleLoadSuccessful = false;
		}
		
		
	//	System.out.println("\nEND");
	}
	
	public static void main(String[] args) {
		Scanner userCommand = new Scanner(System.in);
		KeyWordInContext ini = new KeyWordInContext();
		
		ini.view.initialize();
		String command = userCommand.next().replaceAll("[^1-4]", "");
		while(!command.isEmpty()){
			switch(command){
			
			case "1":
				try {
					if(ini.ignoreWordsLoadSuccessful == true) {
						ini.view.printIgnoreWordArray(ini.ignoreWords.getData());
						main(args);
				}
				} catch (Exception ex) {
					System.out.println(KeyWordInContext.ERROR_FAIL_TO_LOAD_IGNORED_WORDS);
				}
				break;
			case "2":
				try{
					if(ini.titleLoadSuccessful == true) {
						ini.view.printTitleArray(ini.title.getData());
					}
				} catch (Exception ex) {
					System.out.println(KeyWordInContext.ERROR_FAIL_TO_LOAD_TITLE);
				}
				main(args);
				break;
			case "3":
				try {
					ini.view.printProcessed(
						ini.controller.getProcessed(ini.title.getData(), ini.ignoreWords.getData()),
						ini.controller.getPostProcessedTitleSize()
					);
				} catch (Exception ex) {
					System.out.println(KeyWordInContext.ERROR_FAIL_TO_LOAD_PROCESS_DATA);
				}
				main(args);
				break;
			case "4":
				System.out.println("Exit now :)");
				System.exit(0);
				break;
			default:
				System.out.println(KeyWordInContext.ERROR_INVALID_ENTRY);
				System.exit(0);
				break;
			}
		}
	}
}