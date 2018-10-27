package workerThreads.util;


public class IsPrime {
	
	public IsPrime() {
		MyLogger.writeOuput("Constructor of IsPrime is called", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public synchronized boolean findPrime(int num)
	{
		try 
		{
			if(num%2==0)
				return false;
			else
				return true;
			
		}
		catch(Exception e)
		{
			MyLogger.writeOuput("Exception occured in IsPrime \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
		}
		return false;
	}
	
	
	
	

}
