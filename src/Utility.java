import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utility {

    public static String readQuery1() {
	String query = "";
	
	try {
	    Scanner input = new Scanner(new File("query1.txt"));
	    while(input.hasNext()) {
		query += input.nextLine() + "\n";
	    }
	    input.close();
	} 
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	return query;
    }

}
