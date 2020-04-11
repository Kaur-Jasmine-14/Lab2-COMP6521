import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class MainClass {

    public static String outputPath = System.getProperty("user.dir") + "\\output\\";
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        long memoryUsed = rt.totalMemory();
        // Input files
        System.out.println("Enter path for first file: ");
        Scanner keyboard = new Scanner(System.in);
        String fileName1 = keyboard.nextLine();
        System.out.println("Enter path for second file: ");
        keyboard = new Scanner(System.in);
        String fileName2 = keyboard.nextLine();
        String outFile = mergeFiles(fileName1, fileName2);
        BitMap bitMap = new BitMap();
        bitMap.getData(outFile,memoryUsed);
    }
    public static String mergeFiles(String f1, String f2) throws IOException {
        String outputFile = outputPath+"output.txt";
        String[] arg = {f1, f2, outputFile};
        Path outFile = Paths.get(arg[arg.length - 1]);
        try (FileChannel out = FileChannel.open(outFile, CREATE, WRITE)) {
            for (int ix = 0, n = arg.length - 1; ix < n; ix++) {
                Path inFile = Paths.get(arg[ix]);
                try (FileChannel in = FileChannel.open(inFile, READ)) {
                    for (long p = 0, l = in.size(); p < l; )
                        p += in.transferTo(p, l - p, out);
                }
            }
        }
        System.out.println("Merged the files into "+outputFile);
        return (outputFile);
    }

}
