
package workerThreads.util;

import java.util.ArrayList;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Results implements StdoutDisplayInterface {
 
	/**
	 * Constructor
	 *
	 */
	public Results()
	{
		MyLogger.writeOuput("Constructor of Results is called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	
	public static ArrayList<String> finalList = new ArrayList<String>();
	
	
	public synchronized void storeFinalResult(String res)
	{
		try 
		{
			if(!finalList.contains(res))
			{
				finalList.add(res);
				MyLogger.writeOuput(Thread.currentThread().getName()+" stores "+res, MyLogger.DebugLevel.ADDITION_TO_RESULT);
			}
		}
		catch(Exception e)
		{
			
		}
		finally {}
		
	}
	
	@Override
	public void writeSumToScreen() 
	{
		try 
		{	int sum=0;
			for(int i =0; i<finalList.size();i++)
			{
				sum= sum + Integer.parseInt(finalList.get(i));
			}
			

			MyLogger.writeOuput("The sum of all the prime numbers is: "+sum+ "", MyLogger.DebugLevel.NONE);
			MyLogger.writeOuput("The sum of all the prime numbers is: "+sum+ "", MyLogger.DebugLevel.ADDITION_TO_RESULT);
			MyLogger.writeOuput("The sum of all the prime numbers is: "+sum+ "", MyLogger.DebugLevel.CONSTRUCTOR);
			MyLogger.writeOuput("The sum of all the prime numbers is: "+sum+ "", MyLogger.DebugLevel.RUN_METHOD);
			MyLogger.writeOuput("Content of Result\n"+finalList+"", MyLogger.DebugLevel.CONTENT_OF_RESULT);
			MyLogger.writeOuput("The sum of all the prime numbers is: "+sum+ "", MyLogger.DebugLevel.CONTENT_OF_RESULT);
		}
		catch(Exception e)
		{
			MyLogger.writeOuput("Exception occured while writing sum to screen"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
			
		}
	}

	
	
	
}