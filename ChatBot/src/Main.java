import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

	public static void main(String[] args) throws IOException, SQLException {

		Scanner scanner = new Scanner(new File("Dracula"));
		String data = "";
		String text = "";

		while(scanner.hasNextLine()) {
			text = scanner.nextLine();
		}

		
		SearchCriteria sc = new SearchCriteria(); 
		String delimiter1 = " ";
		String delimiter2 = ",";
		text = text.replaceAll(delimiter2, delimiter1);
		System.out.println(text);
		for(String word : text.split(delimiter1)){
		    sc.processWord(word, sc);
		//    System.out.println(word);
		}
		
		ArrayList<ArrayList<String>> date = new ArrayList<>();
		Scanner scanData= new Scanner(new File("intrebare"));
		while(scanData.hasNextLine()) {
			data = scanData.nextLine();
			ArrayList<String> aux = new ArrayList<>();
			for(String word : data.split(",")){
			    aux.add(word);
			}
			date.add(aux);
		}
		
		for(int i = 0; i < date.size(); i++) {
			System.out.println(date.get(i).get(0));
		}
		
	 new AddBot(date);
			
	}
	
}
