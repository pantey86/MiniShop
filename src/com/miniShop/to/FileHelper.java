package com.miniShop.to;

import java.io.*;

public class FileHelper {

    public String readFromFile(String path) throws IOException{
        StringBuilder result = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null)
                result.append(line);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }


    public boolean writeToFile(String str, String path) throws IOException{

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
