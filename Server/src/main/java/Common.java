package main.java;

import java.io.*;

public class Common {
    public static String readBytes(InputStream stream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            int length = reader.read();

            String string = "";
            for (int i = 0; i < length; ++i) {
                string += (char)reader.read();
            }

            return string;
        }
        catch (IOException ex) {
            System.out.println("I/O Error!");
        }
        return null;
    }

    public static void writeBytes(OutputStream stream, String string) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
            writer.write(string.length());
            writer.write(string);
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println("I/O Error!");
        }
    }

}
