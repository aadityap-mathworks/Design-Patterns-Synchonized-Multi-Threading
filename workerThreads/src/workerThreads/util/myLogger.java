package workerThreads.util;

public class myLogger {

	public myLogger() {
		// TODO Auto-generated constructor stub
	}
	

    public static enum DebugLevel { CONSTRUCTOR, 
    	RUN_METHOD, 
    	NONE ,
    	CONTENT_OF_RESULT, 
    	ADDITION_TO_RESULT };

    private static DebugLevel debugLevel;
   
    public static void setDebugValue (int levelIn) {
		switch (levelIn) 
		{
			case 4: 
				debugLevel = DebugLevel.CONSTRUCTOR; 
				break;
			case 3: 
				debugLevel = DebugLevel.RUN_METHOD; 
				break;
			case 2: 
				debugLevel = DebugLevel.ADDITION_TO_RESULT; 
				break;
			case 1: 
				debugLevel = DebugLevel.CONTENT_OF_RESULT; 
				break;
			default: 
				debugLevel = DebugLevel.NONE; 
				break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeOuput (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }

}
