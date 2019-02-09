package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log=LogManager.getLogger(Main.class);
		log.info("log4j test");

	}

}
