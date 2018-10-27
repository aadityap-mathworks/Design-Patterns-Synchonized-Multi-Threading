package workerThreads.myWorkers;

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
	
	public ThreadPool(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		MyLogger.writeOuput("Constructor of ThreadPool is called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}
	
	public void addThreads(int maxThreads)
	{
		try 
		{		
			//System.out.println("adding in pool");
			for(int i=0 ; i<maxThreads; i++)
			{		
				Thread threads = new Thread( new WorkerThread(fp,res,prime)); 
				//System.out.println(threads);
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
	
	public Thread borrowThreads()
	{
		try 
		{		
			if(pool.isEmpty())
			{
				//nahi milega
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
