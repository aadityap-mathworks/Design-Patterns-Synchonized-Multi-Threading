
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
		
	}
	
	public static ArrayList<String> finalList = new ArrayList<String>();
	
	public void storeFinalResult(String res)
	{
		finalList.add(res);
	}

	public void clearResult()
	{
		finalList.clear();
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
			myLogger.writeOuput("The sume of all the prime numbers is: "+sum+ "", myLogger.DebugLevel.NONE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	}

	
	
	
}
