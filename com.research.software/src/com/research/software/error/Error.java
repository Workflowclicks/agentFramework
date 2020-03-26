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
public class Error extends ErrorType {
 
 String errorMessage;
 String causer;
    
 public Error(String causer , String errorMessage, String errorCode, String errorTypeMessage  )
 {
  super(errorCode,errorTypeMessage);
  this.causer=causer;
  this.errorMessage=errorMessage;
 }
  @Override
  public String toString()
  {
   return super.toString()+" causer:" + causer+ " Error Message :"+ errorMessage+".";
  }
  
  @Override
  public boolean equals(Object o)
  {
   if(this!=o) 
   {  
       return false;
   }
   if (!(o instanceof Error))
   {
     return false;
   }
   Error t =(Error)o;
   ErrorType type =(ErrorType)o;
   ErrorType thisObject= (ErrorType) this;
   if(!type.equals(thisObject)) 
   {
        return false;
   }
   
   if(!t.errorMessage.equals(this.errorMessage))
   {
       return false;
   }
   if(!t.causer.equals(this.causer))
   {
       return false;
   }
   return true;
  }
}
