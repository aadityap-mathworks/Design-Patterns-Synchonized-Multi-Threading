package workerThreads.myWorkers;


/**
 * @author Aaditya Sakharam Patil
 *
 */
import java.util.ArrayList;
import workerThreads.util.FileProcessor;
import workerThreads.util.IsPrime;
import workerThreads.util.MyLogger;
import workerThreads.util.Results;

public class ThreadPool {
	
	ArrayList<Thread> pool = new ArrayList<>();
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	
	/**
	 * Constructor
	 * @param FileProcessor fpIn, Results resIn, IsPrime primeIn
	 * Stores message to logger
	 */
	public ThreadPool(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		MyLogger.writeOuput("Constructor of ThreadPool is called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}
	
	/**
	 * Method to add threads to pool
	 * @param Max number of threads
	 */
	public void addThreads(int maxThreads)
	{
		try 
		{	
			for(int i=0 ; i<maxThreads; i++)
			{		
				Thread threads = new Thread( new WorkerThread(fp,res,prime)); 
				pool.add(threads);
			}
		}
		catch(Exception e)
		{
			MyLogger.writeOuput("Exception occured while adding threads in ThreadPool \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {}
	}	
	
	/**
	 * Method to borrow threads from pool
	 * returns threads
	 */
	public Thread borrowThreads()
	{
		try 
		{		
			if(pool.isEmpty())
			{
				System.err.println("Pool is empty");
				System.exit(1);
			}
			else
			{
				Thread t = pool.get(0);
				pool.remove(0);
				return t;
			}	
		}
		catch(Exception e)
		{
			MyLogger.writeOuput("Exception occured while borrowing threads in ThreadPool \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {}
		
		return null;
		
		
	}

}
