package library;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;


/**
 * A library resource that can be checked out by a patron
 *
 */
public class Publication{
	
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
	private LocalDate dueDate;
	private boolean checkout;
/**
 * Constructs Pulication class
 *
 */
	public Publication(String title, String author, int copyright){
		this.title = title;
		this.author = author;
		this.checkout = false;
		this.copyright = copyright;
		if (this.copyright < 1900 || this.copyright > LocalDate.now().getYear())
			throw new IllegalArgumentException("Copyright year must be between 1900 and " + LocalDate.now().getYear());
		
		this.loanedTo = null;
		this.dueDate = null;
	}
	
	public void save(BufferedWriter bw)  throws IOException 
	{
		 bw.write(title + '\n');
	     bw.write(author + '\n');
	     bw.write(""+ copyright + '\n');
	     
	    	 
		 if (checkout == false) {
        	bw.write("checked in\n");
        	//checkout = false;
    	} else {
       	 // Publication is checked out
        	bw.write("checked out\n");
            //checkout = true;
            
        	// Write loanedTo object data
        	loanedTo.save(bw);
        
        	// Write dueDate
        	bw.write(dueDate.toString() + '\n');
    	}
    
    	// Flush the BufferedWriter to ensure the data is written immediately
    	bw.flush();

	
	}
		
	public Publication( BufferedReader br) throws IOException
	{
		
		
		this.title = br.readLine();
		this.author = br.readLine();
		this.copyright = Integer.parseInt(br.readLine());
		String Checkedin = br.readLine();
		
		if("checked in".equals(Checkedin)){
			this.loanedTo = null;
			this.dueDate = null;
			this.checkout = false;

		} else{
			loanedTo = new Patron (br);
			String dueDateLine =  br.readLine();
			this.checkout = true;	
			this.dueDate = LocalDate.parse(dueDateLine);
			
		}
		
	}
	
	
	
/**
 * Calculates the Due date 
 *
 */	
	public void checkOut(Patron patron){
		if (checkout == false){
			this.checkout = true;
			this.loanedTo = patron;
		}
		else{
				System.out.println("The publication/video is already checkout by someone else ");
		}
	}
	
	public void checkIn(Patron patron){
	    
		if(checkout==true){
				checkout = false;
				System.out.println (title +" is checked in successfully by "+ loanedTo);
				loanedTo = null;
				
		}
		else{
		 System.out.println("Publication was not checked out.");
		}
	}

/**
 * Returns string
 *
 */	
	@Override
	public String toString(){
		this.dueDate = LocalDate.now().plusDays(14);
		String publicationData;
		if (!checkout){
			publicationData = "\"" + title +"\" by " + author + ", copyright " + copyright;
		}
		else {
			 publicationData = "\"" + title +"\" by " + author + ", copyright " + copyright + " is loaned to " 									+ loanedTo + " until " + dueDate;
		}	 
		return publicationData;
	}
	
	
}