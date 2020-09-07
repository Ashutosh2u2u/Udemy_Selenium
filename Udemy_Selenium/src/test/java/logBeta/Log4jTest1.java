package logBeta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

public class Log4jTest1 
{
	public static Logger log=LogManager.getLogger(Log4jTest1.class.getName());
//if configuration file not created then it will provide log as per default nature i.e for errors
	public static void main(String[] args) 
	{
		log.debug("This is just to debug");
		log.error("my test get failed");
		log.fatal("Test gets fetal ");	
		log.info("my test works fine");
	}

}
