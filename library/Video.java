package library;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.time.Duration;
/**
 * A library video that can be checked out by a patron
 *
 */
public class Video extends Publication{
	private int runtime;
/**
 * Contructs Video subclass
 *
 */	
	public Video(String title, String author, int copyright, int runtime )	{
		super(title, author,copyright);
		
		if (runtime<=0){
			throw new InvalidRuntimeException(title, runtime);
		}
		
		this.runtime = runtime;
	}
	

	@Override
	public void save(BufferedWriter bw) throws IOException
	{
		super.save(bw);
		bw.write(""+runtime + '\n');
		bw.flush();
		
		
	}
	
	public Video(BufferedReader br) throws IOException
	{
		super(br);
		String runtimeString = br.readLine(); // Assuming the runtime data was saved as a single line
        this.runtime = Integer.valueOf(runtimeString);
	
	
	}
	
	
	
/**
 * Returns edited string with new runtime parameter
 *
 */	
	@Override 
	public String toString(){
		String message = super.toString();
		Duration videotime = Duration.ofMinutes(runtime);
		long hours = videotime.toHours();
		long remainingMinutes = videotime.toMinutes() % 60;
		message += ", Runtime:" + hours + "Hr " + remainingMinutes + "mins" ;
		
		return message;
	}

}