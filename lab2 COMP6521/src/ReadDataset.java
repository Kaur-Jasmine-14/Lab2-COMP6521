
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class to read the values from the file and divide it into buffers
 *
 */
public class ReadDataset extends BufferedReader {

    public int diskIO = 0;
    public File data;
    public boolean eof;
    public float memoryUsed;
    int count = 0;


    public ReadDataset(File data, Long memoryUsed) throws FileNotFoundException {
        super(new java.io.FileReader(data));
        this.data = data;
        this.memoryUsed = Runtime.getRuntime().maxMemory() * memoryUsed;
    }

    public Dataset eachRow() {
        try {
            String line = this.readLine();
            if (line == null) {
                eof = true;
                return null;
            }
            return tupleComponents(line);
        } catch (Exception e) {
            eof = true;
            return null;
        }
    }

    public ArrayList<Dataset> block() {
        ArrayList<Dataset> blockTuples = new ArrayList<Dataset>(40);
        if (Runtime.getRuntime().freeMemory() > memoryUsed) {
            int count = 0;
            if (count < 40) {
                do {
                    Dataset eachRow = eachRow();
                    if (eachRow == null) {
                        break;
                    }
                    blockTuples.add(eachRow);
                    if (blockTuples.size() != 0) {
                        diskIO++;
                    }
                    count++;
                } while (count < 40);
            }
        }
        return blockTuples;
    }

    public Dataset tupleComponents(String tuple) throws ParseException {
        String empID = tuple.substring(0, 8);
        int emp = Integer.parseInt(empID);
        String lastUpdate = tuple.substring(8, 18);
        Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastUpdate);
        String emName = tuple.substring(18, 43);
        String gender = tuple.substring(43, 44);
        String dept = tuple.substring(44, 47);
        String SIN = tuple.substring(47, 56);
        int sin = Integer.parseInt(SIN);
        String address = tuple.substring(56, 99);
        //System.out.println(emp);
        Dataset singleRow = new Dataset(emp, sDate, emName, Integer.parseInt(gender),
                Integer.parseInt(dept), sin, address);
        return singleRow;
    }


}
