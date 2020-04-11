import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// Input files
		System.out.println("Enter path for first file: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName1 = keyboard.nextLine();
        System.out.println("Enter path for second file: ");
        keyboard = new Scanner(System.in);
        String fileName2 = keyboard.nextLine();
        
       BitMap bitMap = new BitMap();
       bitMap.getData(fileName1);
       
       
       
	}

}
