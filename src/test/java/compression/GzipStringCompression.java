package compression;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @author William Walsh
 * @version 23 Nov 2022
 */
public class GzipStringCompression {

    @Test
    public void testCompressString() throws IOException {

        System.out.println("System default file encoding: " + System.getProperty("file.encoding"));

        String str = "Hello World! - compression style.";
        int charSizeOfString = str.length();
        int byteSizeOfString = str.getBytes().length;

        String compressedString = compress(str);
        int charSizeAfterCompression = compressedString.length();
        int byteSizeAfterCompression = compressedString.getBytes().length;

        System.out.println("String: " + str);
        System.out.println("Compressed String: " + compressedString);

        System.out.println("String char length: " + charSizeOfString);
        System.out.println("String char length after compression: " + charSizeAfterCompression);

        System.out.println("String byte array length: " + byteSizeOfString);
        System.out.println("String byte array length after compression: " + byteSizeAfterCompression);
    }

    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        String outStr = out.toString("UTF-8");
        return outStr;
    }
}
