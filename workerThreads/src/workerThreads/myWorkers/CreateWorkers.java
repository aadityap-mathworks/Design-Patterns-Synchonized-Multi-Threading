package workerThreads.myWorkers;

import java.lang.Thread.State;
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
	public enum States {
        NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED;
    }
	public CreateWorkers(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		MyLogger.writeOuput("Constructor of CreateWorker is called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}

	
	public void startWorkers(int numOfThreads)
	{
		try {
				pool = new ThreadPool(fp,res,prime);
				pool.addThreads(numOfThreads);
				ArrayList<Thread> t= new ArrayList<Thread>();																																																																																																												
				for(int i=0; i<numOfThreads; i++)
				{
					WorkerThread wt = pool.borrowThreads();
					Thread th = new Thread(wt);
					t.add(th);
					th.start();
				}
				
				for(int x=0; x<t.size();x++)
				{
						t.get(x).join();	
				}
			
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