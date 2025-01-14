package utils;

public class Utils {
	
	public static void timeout() {
		try {
			Thread.sleep(2500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
