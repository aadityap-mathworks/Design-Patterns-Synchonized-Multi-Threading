package workerThreads.driver;

import java.io.File;

import workerThreads.myWorkers.CreateWorkers;
import workerThreads.util.FileProcessor;
import workerThreads.util.IsPrime;
import workerThreads.util.MyLogger;
import workerThreads.util.Results;


/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Driver {
	/**
	 * Main method
	 * @param Commandline args
	 * @return none
	 */
	public static void main(String[] args) {
		try {
			
			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value specified in
			 * build.xml. To avoid that, below condition is used
			 */
			if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) 
			{
				System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
				System.exit(0);
			}
			
			/**
			 *Storing command line arguments
			 */
			String inputFile=args[0];
			int noOfThreads = Integer.parseInt(args[1]);
			int debugValue = Integer.parseInt(args[2]);
			
			/**
			 *argument validation
			 *check if file exists
			 *check if input file is empty
			 */
			File file1 = new File(inputFile);
			if (!file1.exists()) 
			{
				System.err.println("Error: Input file does not exist.");
				System.exit(1);
			}
			else if(file1.length() == 0)
			{
				System.err.println("Error: Input file is empty.");
				System.exit(1);
			}
			
			/**
			 *argument validation
			 *check if the Number of argument is between 1 to 5
			 */
			if(noOfThreads<1 || noOfThreads>5)
			{
				System.err.println("Error: Wrong no of threads. \n It must be between 1 to 5");
				System.exit(1);
			}
			
			/**
			 *argument validation
			 *check if the debug value is between 0 to 4
			 */
			if(debugValue<0 || debugValue>4)
			{
				System.err.println("Error: Wrong debug value. \n It must be between 0 to 4");
				System.exit(1);
			}
			
			MyLogger.setDebugValue(debugValue);
			IsPrime prime=new IsPrime();
			FileProcessor fp= new FileProcessor(inputFile);
			Results res =new Results();
			CreateWorkers cw = new CreateWorkers(fp, res, prime);
			cw.startWorkers(noOfThreads);
			res.writeSumToScreen();

		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	
	}

	@Override
	public String toString() {
		return "Driver [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}

