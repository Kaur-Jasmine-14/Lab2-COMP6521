import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitMap {
	
	public void getData(String filePath) throws IOException {
		// String S1="457522172015-03-10Orelia Boswell           1010223218265 Albuquerque NM 87180 West";
		
        String FixedLengths = "8,10,25,1,3,9,43";
        List<String> items = Arrays.asList(FixedLengths.split("\\s*,\\s*"));
        List<String> content = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
         try {
        	
            String line1;
            while ((line1 = reader.readLine()) != null) {
                // process the line.
            	
                int n = 0;
                String line = "";
                for (String i : items) {
                    // System.out.println("Before"+n);
                    if (i == items.get(items.size() - 1)) {
                        line = line + line1.substring(n, n + Integer.parseInt(i)).trim();
                    } else {
                        line = line + line1.substring(n, n + Integer.parseInt(i)).trim() + ",";
                    }
                    // S1.substring(n,n+Integer.parseInt(i)));
                    n = n + Integer.parseInt(i);
                    // System.out.println("After"+n);
                }
                System.out.println(line);
                content.add(line);
            }
        } finally {
			
		}
		
         
		/*
		 File file = new File("inputfile.txt");
	        FileInputStream fin = null;
	        try {
	            // create FileInputStream object
	            fin = new FileInputStream(file);
	 
	            byte fileContent[] = new byte[(int)file.length()];
	             
	            // Reads up to certain bytes of data from this input stream into an array of bytes.
	            fin.read(fileContent);
	            //create string from byte array
	            String s = new String(fileContent);
	            System.out.println("File content: " + s);
	        }*/
		

	}

}
