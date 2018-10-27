package workerThreads.util;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class IsPrime {
	
	/**
	 * Constructor
	 * Stores message to logger
	 */
	public IsPrime() {
		MyLogger.writeOuput("Constructor of IsPrime is called", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Method to check if number is prime
	 * @param number
	 * returns true if the number is prime
	 */
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

	@Override
	public String toString() {
		return "IsPrime [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
