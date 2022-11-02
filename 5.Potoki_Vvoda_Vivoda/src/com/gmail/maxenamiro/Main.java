package com.gmail.maxenamiro;

import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    File fileIn = new File("/Users/a1/Documents/Papka/");
    File fileOut = new File("/Users/a1/Documents/Another_Papka/");
    FileService copy = new FileService();
    FileService aa = new FileService();
    String rashirenie = ".jpg";

    try {
      aa.copyAllSFiles(fileIn, fileOut, rashirenie);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}