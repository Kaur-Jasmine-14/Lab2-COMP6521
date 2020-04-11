import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
               // System.out.println(line);
                content.add(line);
            }
        } finally {
        	System.out.println(content);
		}
		
	}
	
	// bitmap key
	public static class BIKey {
		private String group; // attribute name
	    private String value; // all distinct values
		
		public BIKey(String group, Object value) {
			this.group = group;
			if(value != null) {
				//this.value = Utils.toString(value);
				toString(value);
			}
			else
				this.value = "";
		}
		
		public String getGroup() {
			return group;
		}
		
		public String getValue() {
			return value;
		}
      
		public static String toString(Object value) {
			if (value == null)
				return null;

			if (value instanceof Float)
				return new BigDecimal((Float) value).stripTrailingZeros().toPlainString();
			else if (value instanceof Double)
				return new BigDecimal((Double) value).stripTrailingZeros().toPlainString();
			else
				return String.valueOf(value);
		}
		
		@Override
		public int hashCode() {               // test
			int result = group.hashCode();
			result = 31 * result + value.hashCode();

			return result;
		}
}
	
	
}
