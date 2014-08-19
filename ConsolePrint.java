import java.util.*;

public class ConsolePrint{
	
	static Scanner userCommand = new Scanner(System.in);

	public static void main(String[] args) {
		
		run();
	
	}
	
	private static void run(){
		initialize();
		runProgram();
	
	}
	private static void initialize(){
		System.out.println("Hello user!\n"
				+ "Select one of the option by typing the index:\n"
				+ "1. Output the list of ignored words\n"
				+ "2. Output the list of raw titles\n"
				+ "3. Output the list of processed titles\n"
				+ "4. To exit");
				
	}
	
	private static void runProgram(){
		KeyWordInContext ini = new KeyWordInContext();
		String command = userCommand.next().replaceAll("[^1-4]", "");
		
		while(!command.isEmpty()){
			switch(command){
			
			case "1":
				 ini.printIgnoreWordArray();
				 run();
				break;
			case "2":
				ini.printTitleArray();
				run();
				break;
			case "3":
				ini.printProcessed();
				run();
				break;
			case "4":
				System.out.println("Exit now :)");
				System.exit(0);
				break;
				default:
					System.out.println("Something went wrong, please try again.");
					System.exit(0);
					
			}
		}
		
	}
	
	
}