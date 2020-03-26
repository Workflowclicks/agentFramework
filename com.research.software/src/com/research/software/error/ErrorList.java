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
import com.research.software.error.Error;
import java.util.List;
import java.util.ArrayList;

public class ErrorList {
  List<Error> errors = new ArrayList();
  public ErrorList()
  {
  
  }
  public List<Error> getList()
  {
   return errors;
  }
  public void flush()
  {
    errors.clear();
  }
  public int size()
  {
   return errors.size();
  }
  public void addError(Error e)
  {
   errors.add(e);
  }
  public void addError(String causer , String errorMessage, String errorCode, String errorTypeMessage  )
  {
   errors.add(new Error(causer , errorMessage, errorCode, errorTypeMessage  ));
  }
  public void removeError(Error e)
  {
   errors.remove(e);
  }
  public void removeError(String causer , String errorMessage, String errorCode, String errorTypeMessage)
  {
   errors.remove(new Error(causer , errorMessage, errorCode, errorTypeMessage  ));
  }
  public boolean areThereAnyErrors()
  {
   return (errors.size()>0);
  }
  public boolean doesErrorExist(Error e)
  {
   return errors.contains(e);
  }
  public boolean doesErrorExist(ErrorType et)
  {
   for(Error e : errors)
   {
     ErrorType t=(ErrorType)e;
     if(t.equals(e)) 
     {
      return true;
     }
   }
   return false;
  }
  @Override
  public String toString()
  {
   String s="";
   for(Error r : errors)
   {
    s=s+r.toString();
   }
   return s;
  }
}
