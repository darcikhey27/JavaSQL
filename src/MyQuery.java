
/*****************************
Query the University Database
*****************************/
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.Date;
import java.lang.String;
// driver is the middle man
// Driver manager ( load JDBC driver )
// Driver (connects to data source, tansmists and returns
// translates results and error codoes
public class MyQuery {

    // test right here
    // initiates and terminates connections, submits sql statements
    //
    
    private Connection conn = null; 
    
    private Statement statement = null;
    private ResultSet resultSet = null;

    public MyQuery(Connection c) throws SQLException {
	conn = c;
	// Statements allow to issue SQL queries to the database
	statement = conn.createStatement();
    }

    public void findFall2009Students() throws SQLException {
	String query = "select distinct name "+
		 	"from student natural join takes "+
		 	"where semester = \'Fall\' and year = 2009;";

	resultSet = statement.executeQuery(query);
    }

    public void printFall2009Students() throws IOException, SQLException {
	System.out.println("******** Query 0 ********");
	System.out.println("name");
	while (resultSet.next()) {
	    // It is possible to get the columns via name
	    // also possible to get the columns via the column number which
	    // starts at 1
	    String name = resultSet.getString(1);
	    System.out.println(name);
	}
    }

    
    // 1
    public void findGPAInfo() throws SQLException {
	String query = "select ID, name, sum((select case ";
	query += "when takes.grade = 'A' then 4.0 when takes.grade = 'A-' then 3.67 ";
	query += "when takes.grade = 'B+' then 3.33 when takes.grade = 'B' then 3.0 ";
	query += "when takes.grade = 'B-' then 2.67 when takes.grade = 'C+' then 2.33 ";
	query += "when takes.grade = 'C' then 2.0 when takes.grade = 'C-' then 1.67 ";
	query += "when takes.grade = 'D+' then 1.33 when takes.grade = 'D' then 1.0 ";
	query += "when takes.grade = 'D-' then 0.67 when takes.grade = 'F' then 0.0 end ";
	query += ") * course.credits) / sum(course.credits) as GPA ";
	query += "from student join takes using(ID) join course using(course_id) ";
	query += "where takes.grade is not null group by student.ID;";

	resultSet = statement.executeQuery(query);

    }
    // 1
    public void printGPAInfo() throws IOException, SQLException {
	System.out.println("******** Query 1 ********");
	System.out.printf("ID\tname\t\tGPA\n");
	
	while(resultSet.next()) {
	   String ID = resultSet.getString("ID");
	   String name = resultSet.getString("name");
	   String GPA = resultSet.getString("GPA");
	  
	   printColumns(ID, name, GPA);
	}
    }
    // 1
    private void printColumns(String ID, String name, String GPA) {
	System.out.printf("%s\t%s\t\t%s\n", ID, name, GPA);
    }

    // 2
    public void findMorningCourses() throws SQLException {

    }
    // 2
    public void printMorningCourses() throws IOException, SQLException {
	System.out.println("******** Query 2 ********");
    }
    // 3
    public void findBusyInstructor() throws SQLException {

    }
    // 3
    public void printBusyInstructor() throws IOException, SQLException {
	System.out.println("******** Query 3 ********");
    }
    // 4
    public void findPrereq() throws SQLException {

    }
    // 4
    public void printPrereq() throws IOException, SQLException {
	System.out.println("******** Query 4 ********");
    }

    public void updateTable() throws SQLException {

    }

    public void printUpdatedTable() throws IOException, SQLException {
	System.out.println("******** Query 5 ********");
    }

    public void findFirstLastSemester() throws SQLException {

    }

    public void printFirstLastSemester() throws IOException, SQLException {
	System.out.println("******** Query 6 ********");
    }

    public void findHeadCounts() throws SQLException {
	System.out.println("******** Query 7 ********");
    }
}
