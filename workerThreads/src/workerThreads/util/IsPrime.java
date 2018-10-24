package workerThreads.util;

public class IsPrime {
	
	public IsPrime() {
		
	}

	public boolean findPrime(int num)
	{
		try {
			
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
