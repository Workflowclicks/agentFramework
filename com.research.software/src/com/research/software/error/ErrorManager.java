package com.research.software.error;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yehiakotb
 */

import com.research.software.error.ErrorLogger;
import com.research.software.error.ErrorList;
import com.research.software.error.Error;
import java.util.Calendar;
public class ErrorManager 
{
   ErrorList errorList = new ErrorList();
   ErrorLogger logger ;
   int limit=0;
   public ErrorManager(String FileName,int limit)
   {
    this.limit=limit;
    createLogFile(FileName);
   }
    public void StopLogging()
    {
     logErrorsToFile();
     errorList.flush();
     logger.closeLog();
    }
    public void addError(Error error)
   {
     errorList.addError(error);
     checkLoggingPossibility();
   }
 //---------------------- private    
   private void createLogFile(String FileName)
   {
     logger = new ErrorLogger(FileName);
   }
   private void logErrorsToFile()
   {
     Calendar now=Calendar.getInstance();
     for(Error r : errorList.getList())
     {
       String tobeLogged= "Date\\Time: "+ now.getTime().toString();
       tobeLogged= tobeLogged+ " " + r.toString();
       logger.logError(tobeLogged);
     }
     errorList.flush();
   }
    private void  checkLoggingPossibility()
    {
      if(errorList.size()>=limit)
      {
        logErrorsToFile();
        errorList.flush();
      }
    }
}