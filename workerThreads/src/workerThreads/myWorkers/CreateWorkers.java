package workerThreads.myWorkers;

import workerThreads.util.FileProcessor;
import workerThreads.util.IsPrime;
import workerThreads.util.Results;

public class CreateWorkers{
	
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	private ThreadPool pool=null;
	public CreateWorkers(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
		pool = new ThreadPool(fp,res,prime);
		pool.addThreads(10);
		
	}

	
	public void startWorkers(int numOfThreads)
	{
		for(int i=0; i<numOfThreads; i++)
		{
			WorkerThread wt = pool.borrowThreads();
			Thread t= new Thread(wt);
			t.start();
		}
	}
	
}
