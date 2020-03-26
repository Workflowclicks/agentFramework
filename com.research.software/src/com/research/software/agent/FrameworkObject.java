package com.research.software.agent;

/**
 *
 * @author yehiakotb
 */
import  com.research.software.error.Error;
import  com.research.software.error.ErrorManager;
public class FrameworkObject extends Thread 
{
   private static long objectCount;
   private long ObjectID;
   protected ErrorManager errorManager;
   
   public FrameworkObject(ErrorManager manager)
   {
    errorManager=manager;
    ObjectID=(objectCount++);
   }
   public void run() 
    { 
        
    } 
   protected long getID()
   {
     return ObjectID;
   }
   public void logError(Error error)
   {
    errorManager.addError(error);
   } 
}
