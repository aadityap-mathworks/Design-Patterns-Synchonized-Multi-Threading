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
			MyLogger.writeOuput("Exception occured while reading file in FieProcessor \n"+e.toString(), MyLogger.DebugLevel.NONE);
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
				
				String currentline;
				while ((currentline = inputReader.readLine()) != null) 
				{	
					if(currentline.equals(""))
					{
						return null;
					}
					else
						return currentline;
				}
			} catch (IOException ex)
	        {
				MyLogger.writeOuput("Exception occured while reading file in FieProcessor \n"+ex.toString(), MyLogger.DebugLevel.NONE);
				System.exit(1);
	
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
	    		MyLogger.writeOuput("Exception occured while closing file in FieProcessor \n"+e.toString(), MyLogger.DebugLevel.NONE);
				System.exit(1);
	    	}
	    	finally {}
	}
	
}