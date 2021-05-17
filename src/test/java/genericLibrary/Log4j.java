package genericLibrary;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j
{
	public Logger log = Logger.getLogger(Log4j.class);
	public Log4j()
	{
		log.setAdditivity(true);
//		BasicConfigurator.configure();
//		DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("Log4j.properties");
		
		
	}
	public void startTestCase(String testCaseName)
	{
		log.info("*********************************************************");
		log.info("<<<<<=======  '"+testCaseName+ "' STARTED =======>>>>>");
		
	}

	public  void endTestCase(String testCaseName)
	{
	
		log.info("<<<<<=======  '"+testCaseName+ "' ENDED   =======>>>>>");
		log.info("*********************************************************");
	}

	public  void fatal(String message)
	{
		log.fatal(message);
	}

	public  void error(String message)
	{
		log.error(message);
	}

	public  void warn(String message)
	{
		log.warn(message);
	}

	public void info(String message)
	{
		log.info(message);
	}

	public  void debug(String message)
	{
		log.debug(message);
	}

	public  void trace(String message)
	{
		log.trace(message);
	}

}
