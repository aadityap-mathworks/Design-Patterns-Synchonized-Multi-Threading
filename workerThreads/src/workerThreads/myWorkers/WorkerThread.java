package workerThreads.myWorkers;

import workerThreads.util.FileProcessor;
import workerThreads.util.IsPrime;
import workerThreads.util.MyLogger;
import workerThreads.util.Results;

public class WorkerThread implements Runnable{

	
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	
	public WorkerThread(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		MyLogger.writeOuput("Constructor of WorkerThread is called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}

	@Override
	public void run() 
	{
		try
		{		
			MyLogger.writeOuput("run method of "+Thread.currentThread().getName()+" started",MyLogger.DebugLevel.RUN_METHOD);
			String currentline;
			while ((currentline = fp.readInputLine()) != null) 
			{
				//System.out.println("in run is "+Thread.currentThread().getName()+" reads "+currentline);
				int number = Integer.parseInt(currentline);
				if(prime.findPrime(number))
				{
					res.storeFinalResult(currentline);
				}
				Thread.sleep((int) (Math.random() * 200));
				
			}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		    System.exit(1);
		}
		finally {}
	}

}
