package workerThreads.myWorkers;

import workerThreads.util.FileProcessor;
import workerThreads.util.Results;

public class CreateWorkers{
	
	private FileProcessor fp=null;
	private Results res= null;
	private IsPrime prime= null;
	
	public CreateWorkers(FileProcessor fpIn, Results resIn, IsPrime primeIn ) 
	{
		this.fp= fpIn; 
		this.res=resIn;
		this.prime= primeIn;
	}

	
	public void startWorkers(int numOfThreads)
	{
		WorkerThread wt = new WorkerThread(fp,res,prime);
		Thread t= new Thread(wt);
		t.start();
		
	}
	
}
