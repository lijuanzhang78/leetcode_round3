package Google_Others;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ScannerTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan1 = new Scanner(new File("/Users/lijuan/development/Leetcode_round3/src/Google_Others/testScanner.txt"));
		while(scan1.hasNext()) {
			String s = scan1.next();
			System.out.println(s);
		}
		scan1.close();
	}
}
