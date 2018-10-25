package workerThreads.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Aaditya Sakharam Patil
 *
 */

public class FileProcessor 
{
	private BufferedReader inputReader = null;
	
	/**
	 *To process a file
	 *@param filename
	 */
	public FileProcessor(String filename)
	{
		try {
			MyLogger.writeOuput("Constructor of FileProcessor is called", MyLogger.DebugLevel.CONSTRUCTOR);
			File input = new File(filename);
			inputReader = new BufferedReader(new FileReader(input));
		}
		catch(IOException e){
		    e.printStackTrace();
		    System.exit(1);
		}
		finally{ 
		}
	}
	
	/**
	 *Reads line from input file
	 */
	 public synchronized String readInputLine() 
	 {
			try{
				//System.out.println("in process is "+Thread.currentThread().getName());
				String currentline;
				while ((currentline = inputReader.readLine()) != null) 
				{	
					//System.out.println("in process is "+Thread.currentThread().getName()+" reads "+currentline);
					if(currentline.equals(""))
					{
						return null;
					}
					else
						return currentline;
				}
			} catch (IOException ex)
	        {
	            System.out.println("Error occureed while reading the file '");
	            ex.printStackTrace();
	            System.exit(0);
	
	        }	
			finally {
				    
			}
			return null;
		}
	
	 /**
	 * to close buffered reader
	 */
	 public void close(){
	    	try{
		    inputReader.close();
	    	}catch(IOException e){
		    e.printStackTrace();
	    	}
	    	finally {}
	}
	
}