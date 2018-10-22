package workerThreads.driver;

import java.io.File;

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
			 *argument validation
			 *check if file exists
			 *check if input file is empty
			 */
			File file1 = new File(args[0]);
			if (!file1.exists()) 
			{
				System.out.println("Input file does not exist.");
				System.exit(1);
			}
			else if(file1.length() == 0)
			{
				System.out.println("input file is empty.");
				System.exit(1);
			}
			
			/**
			 *Storing command line arguments
			 */
			String inputFile=args[0];
			String noOfThreads = args[1];
			String debugValue = args[2];
			System.out.println(inputFile);
			System.out.println(noOfThreads);
			System.out.println(debugValue);
			
			
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

