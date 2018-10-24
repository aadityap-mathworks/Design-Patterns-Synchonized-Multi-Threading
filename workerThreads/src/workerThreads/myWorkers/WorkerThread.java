package workerThreads.myWorkers;

import workerThreads.util.FileProcessor;
import workerThreads.util.IsPrime;
import workerThreads.util.Results;

public class WorkerThread implements Runnable{

	
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	
	public WorkerThread(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		
	}

	@Override
	public void run() 
	{
		try
		{		
			String currentline;
			while ((currentline = fp.readInputLine()) != null) 
			{
				//System.out.println(currentline);
				int number = Integer.parseInt(currentline);
				if(prime.findPrime(number))
				{
					res.storeFinalResult(currentline);
				}
			}
			Thread.sleep(100);
		}
		catch(InterruptedException e)
		{
		    e.printStackTrace();
		    System.exit(1);
		}
		finally {}
	}

}
