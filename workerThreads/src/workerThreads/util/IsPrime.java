package workerThreads.util;


public class IsPrime {
	
	public IsPrime() {
		MyLogger.writeOuput("Constructor of IsPrime is called", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public synchronized boolean findPrime(int num)
	{
		try {
			//System.out.println("in prime "+Thread.currentThread().getName());
			if(num%2==0)
				return false;
			else
				return true;
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 System.exit(1);
		}
		finally {
		}
		return false;
	}
	
	
	
	

}
