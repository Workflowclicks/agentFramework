package com.research.software.error;


import com.research.software.error.Error;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yehiakotb
 */
public class ErrorLogger {
    String FileName; 
    Writer writer= null;
    public ErrorLogger(String FileName)
    {
      createFile(FileName);
    }
    
    public void logError(Error error)
    {
        
      writeToFile(error.toString());
    }
  public void logError(String error)
    {
      writeToFile(error);
    }
  public void closeLog()
    {
      try
        {
            writer.close();
        }
      catch (IOException ex) 
        {
           System.out.printf("Error: Could not close log file  "+ FileName+":");
        } 
    }
 //----------------- private    
    private void createFile(String FileName)
    {
     try{
           this.FileName=FileName;
           writer = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(FileName), "utf-8"));
        }
      catch (IOException ex) 
        {
           System.out.printf("Error: could not create log file "+ FileName);
           this.FileName="";
        } 
    }
    private void writeToFile(String errorText)
    {
     try{
           errorText="\n"+errorText;
           writer.append(errorText);
        }
      catch (IOException ex) 
        {
           System.out.printf("Error: The following error has not been logged  to file "+ FileName+":" + errorText);
        } 
    }
    
}