package mdi;
import java.util.Scanner;
import library.Library;
import library.Publication;
import library.Patron;
import library.Video;
import library.InvalidRuntimeException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class LibraryManager{
	private Library library;
	
	public LibraryManager(Library library)
	{
		this.library = library;
	
	}
	
	public void saveLibrary(Library l)
	{
		try{
		
		 		Scanner scanner = new Scanner(System.in);
		 		System.out.print("Enter the filename to save the library data: ");
         		String filename = scanner.nextLine();
         		try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))){
         			library.save(br);
         	
         		}
         	} catch (IOException e){
         		System.err.println("Error: Could not write to the file");
         	}
         		
	}
	
	public Library openLibrary(Library l)
	{
		try{
				Scanner scanner = new Scanner(System.in);
		 		System.out.print("Enter the filename to open the library data: ");
         		String filename = scanner.nextLine();
         		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
         			library = new Library(br);
         			return library;
			     }
		}catch (IOException e){
			System.err.println("Error: Could not open the file ");
		}
		return null;
	
	}
	public static void main(String[] args){
		Library library = new Library("Khushi's Small Library");
		LibraryManager manager = new LibraryManager(library);
		
		int choice;
		try{
	    //  Publication book1 = new Publication("To Kill a Mockingbird", "Harper Lee", 1960);
		//	Publication book2 = new Publication("Harry Potter and the Order of the Phoenix", "J.K Rowling", 												2002);
		//	Publication book3 = new Publication("The Alchemist", "Paulo Coelho", 1990);
			
			//Video video1 = new Video("The Matrix", "The Wachowskis", 1999, 136);
			//Video video2 = new Video("Inception","Christopher Nolan",2010, 148);
			//Video video3 = new Video("Avatar"," James Cameron",2009, 162);
		
		
		
			//Patron patron1 = new Patron("Sunny Gauli", "sunnygauli@gmail.com");
			//Patron patron2 = new Patron("Elon Musk", "spaceX@hotmail.com"); 
			//Patron patron3 = new Patron("Aaron Sanchez", "axs2344@yahoo.com");
			//Patron patron4 = new Patron("Linda Vista", "leslie766@gmail.com");
		
		
		
			//library.addPatron(patron1);
			//library.addPatron(patron2);
			//library.addPatron(patron3);
			//library.addPatron(patron4);
		
			//library.addPublication(book1);
			//library.addPublication(book2);
			//library.addPublication(book3);
		
			//library.addPublication(video1);
			//library.addPublication(video2);
			//library.addPublication(video3);
		
		
			
			
		
			 Scanner scanner = new Scanner(System.in);
			 do {
            		System.out.println("\nLibrary Menu:");
            		System.out.println("1. Add Publication");
            		System.out.println("2. Add Video");
            		System.out.println("3. Add Patron");
            		System.out.println("4. Check Out Publication");
            		System.out.println("5. Check In Publication");
            		System.out.println("6. List Patrons");
            		System.out.println("7. List Publications");
            		System.out.println("8. Open");
            		System.out.println("9. Save");
            		System.out.println("0. Exit");
            		System.out.print("Enter your choice: ");

            		choice = scanner.nextInt();
            		scanner.nextLine();
            		
            		switch (choice){
            			case 1:
            				  System.out.println("Enter new publication's title: ");
            				  String pTitle = scanner.nextLine();
            				  
            				  System.out.println("Enter new publication's author: "); 
            				  String pAuthor = scanner.nextLine();
            				  
            				  System.out.println("Enter new publication's copyright: "); 
            				  int publicationCR = scanner.nextInt();
            				  scanner.nextLine();
            				  
            				  Publication book = new Publication(pTitle,pAuthor,publicationCR);
            				  library.addPublication(book);
            				  break;
            				  
            		   case 2:
            		         System.out.println("Enter new Video's title: ");
            				 String vTitle = scanner.nextLine();
            				  
            				 System.out.println("Enter new Video's's director: "); 
            				 String vAuthor = scanner.nextLine();
            				  
            				 System.out.println("Enter new Video's copyright: "); 
            				 int VidCR = scanner.nextInt();
            				 
            				 System.out.println("Enter new Video's playtime in minutes: "); 
            				 int Vidtime = scanner.nextInt();
            				 scanner.nextLine();
            				  
            				 Video vid = new Video(vTitle,vAuthor,VidCR, Vidtime);
            				 library.addPublication(vid);
            				 break;
            		   
            		   
            		   case 3:
            		         System.out.println("Enter new patron's name: ");
            				 String name = scanner.nextLine();
            				  
            				 System.out.println("Enter new patron's email address: "); 
            				 String email = scanner.nextLine();
            				 
            				 Patron patron = new Patron(name, email);
            				 library.addPatron(patron);
            				 break;
            				 
            				 
            		   
            		   
            		   
            		   case 4:
            		   		 System.out.println(library);
            		         System.out.print("Enter the index of the publication to check out: ");
			                 int publicationIndex = scanner.nextInt();
			                 scanner.nextLine();
		
			                 System.out.println(library.Menu());
			                 System.out.print("Who are you?(Enter index): ");
			                 int patronIndex = scanner.nextInt();
			                 scanner.nextLine();
			
			              
			                 library.checkout(publicationIndex, patronIndex);
			                 System.out.println(library);//currentPatron);
			                 break;
            		   
            		   
            		   case 5:
            		         System.out.println(library);
            		         System.out.print("Enter the index of the publication to check in: ");
			                 int pubIndex = scanner.nextInt();
			                 scanner.nextLine();
			                 
			                 System.out.println(library.Menu());
			                 System.out.print("Who are you?(Enter index): ");
			                 int patIndex = scanner.nextInt();
			                 scanner.nextLine();
			                 
			                 library.checkin(pubIndex,patIndex);//find the position of the string                   
			              
			                 break;
			              
            		   
            		   case 6:
            		         System.out.println(library.Menu());
            		        
            		         break;
            			
            				  
            		   case 7:
            		         System.out.println(library );
            		         break;
            		         
            		   case 8:
            		   		library = manager.openLibrary(library);
            		   		break;
            		   	
            		   case 9:
            		   		manager.saveLibrary(library);
            		   		break;
            		   	
            		     
            		   case 0:
            		         System.out.println("Exiting...");
                             break;
                       
                        default:
                               System.out.println("Invalid choice. Please enter a valid option.");
            		   				  
            			
            		}
            		
            		
            		
            	}while (choice != 0);
			
			
			
		}
			catch(Exception e){
			System.err.println("Unable to check out\n" + e);
			System.exit(-1);
		}				
		
		
	}
}