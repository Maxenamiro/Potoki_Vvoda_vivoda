package com.gmail.maxenamiro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileService {

  public static long copyFile(File fileIn, File fileOut) throws IOException {
    try (InputStream is = new FileInputStream(fileIn); OutputStream os = new FileOutputStream(fileOut)) {
      return is.transferTo(os);
    }
  }

  public static void copyAllFiles(File folderIn, File folderOut) throws IOException {
    File[] files = folderIn.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        File fileOut = new File(folderOut, files[i].getName());
        System.out.println(copyFile(files[i], fileOut));
      }
    }
  }

  public static void copyAllSFiles(File folderIn, File folderOut, String rashirenie) throws IOException {
    File[] files = folderIn.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        File fileOut = new File(folderOut, files[i].getName());
        String path = files[i].getName();
        if (path.endsWith(rashirenie)) {
          System.out.println(copyFile(files[i], fileOut));
        }
      }
    }
  }
}