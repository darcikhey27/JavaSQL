import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utility {

    public static double getNumericGrade(String letterGrade) {

	switch (letterGrade) {
	case "A":
	    return 4.0;
	case "A-":
	    return 3.67;
	case "B+":
	    return 3.33;
	case "B":
	    return 3.0;
	case "B-":
	    return 2.67;
	case "C+":
	    return 2.33;
	case "C":
	    return 2.0;
	case "C-":
	    return 1.67;
	case "D+":
	    return 1.33;
	case "D":
	    return 1.0;
	case "D-":
	    return 0.67;
	// case "F" is implied
	}
	// A: 4.0; A-: 3.67; B+:3.33; B: 3; B-: 2.67;
	// C+: 2.33; C: 2; C-: 1.67; D+: 1.33; D: 1; D-: 0.67; F: 0
	return 0.0;
    }

    public static double getGPA(double numericGrade) {
	return 0;
    }

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
