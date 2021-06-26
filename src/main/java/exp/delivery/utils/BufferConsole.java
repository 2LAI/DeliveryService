package exp.delivery.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferConsole {

    public static String readline() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        try {
            value = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}