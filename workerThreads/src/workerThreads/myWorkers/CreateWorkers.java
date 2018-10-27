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

public class CreateWorkers{
	
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	private ThreadPool pool=null;
	
	/**
	 * Constructor
	 * @param FileProcessor fpIn, Results resIn, IsPrime primeIn
	 * Stores message to logger
	 */
	public CreateWorkers(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		MyLogger.writeOuput("Constructor of CreateWorker is called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}

	
	/**
	 * Method to Start Worker and join them
	 * borrows threads from thread pool and starts and join them
	 * @param number of threads
	 */
	public void startWorkers(int numOfThreads)
	{
		try {
				pool = new ThreadPool(fp,res,prime);
				pool.addThreads(numOfThreads);
				ArrayList<Thread> t= new ArrayList<Thread>();																																																																																																												
				for(int i=0; i<numOfThreads; i++)
				{
					Thread wt = pool.borrowThreads();
					t.add(wt);
					wt.start();
				}
	
				for(int x=0; x<t.size();x++)
				{
						t.get(x).join();	
				}
		}
		catch(Exception e)
		{
			MyLogger.writeOuput("Exception occured in StartWorkers \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
			
		}
	}
	
}