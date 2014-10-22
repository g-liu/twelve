/**
 * 
 */
package main;

/**
 * @author Geoffrey
 *
 */
public class Twelve {

	/**
	 * @param args
	 */
	public static void main(String[] argv) {
		// TODO Auto-generated method stub
		if(argv[0] == "--help" || argv[0] == "-h") {
			printHelp();
		}
	}
	
	public static void printHelp() {
		System.out.println("Usage: java Twelve [args]");
	}

}
