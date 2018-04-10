/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package password_demo;

/**
 *
 * @author Tharindu Werasinghe
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileUtil {

    DataOutputStream dos;

  /*
   * Utility method to write a text to a file
   */
  public boolean writeToFile(String fileName, String dataLine,
      boolean isAppendMode, boolean isNewLine) {
    if (isNewLine) {
      dataLine = "\n" + dataLine;
    }
    else{
      dataLine = dataLine;
    }

    try {
      File outFile = new File(fileName);
      if (isAppendMode) {
        dos = new DataOutputStream(new FileOutputStream(fileName, true));
      } else {
        dos = new DataOutputStream(new FileOutputStream(outFile));
      }

      dos.writeBytes(dataLine);
      dos.close();
    } catch (FileNotFoundException ex) {
      return (false);
    } catch (IOException ex) {
      return (false);
    }
    return (true);

  }

  /*
   * Reads data from a given file
   */
  public String readFromFile(String fileName) {
    String DataLine = "";
    try {
      File inFile = new File(fileName);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          new FileInputStream(inFile)));

      DataLine = br.readLine();
      br.close();
    } catch (FileNotFoundException ex) {
      return (null);
    } catch (IOException ex) {
      return (null);
    }
    return (DataLine);

  }

  public boolean isFileExists(String fileName) {
    File file = new File(fileName);
    return file.exists();
  }

  public boolean deleteFile(String fileName) {
    File file = new File(fileName);
    return file.delete();

}
}
