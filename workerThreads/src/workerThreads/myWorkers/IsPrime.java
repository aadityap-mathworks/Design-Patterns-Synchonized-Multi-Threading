package workerThreads.myWorkers;

public class IsPrime {
	
	private int number;

	public IsPrime(String line) 
	{
		try 
		{
			number = Integer.parseInt(line);
		}
		catch(Exception e)
		{
	    e.printStackTrace();
	    System.exit(1);
		}
		finally {}
	}
	
	public IsPrime() {
		// TODO Auto-generated constructor stub
	}

	public boolean prime()
	{
		try {
			int num = number;
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
