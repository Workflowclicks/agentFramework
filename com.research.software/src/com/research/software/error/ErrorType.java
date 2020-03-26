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
public class ErrorType {
  private String errorCode;
  private String errorTypeMessage;
  public ErrorType(String errorCode, String errorTypeMessage)
  {
   this.errorCode=errorCode;
   this.errorTypeMessage=errorTypeMessage;
  }
  @Override
  public String toString()
  {
   return "Error code:"+ errorCode+"-"+errorTypeMessage+".";
  }
  
  @Override
  public boolean equals(Object o)
  {
   if(this!=o) 
   {  
       return false;
   }
   if (!(o instanceof ErrorType))
   {
     return false;
   }
   ErrorType t =(ErrorType)o;
   if(!t.errorCode.equals(this.errorCode)) 
   {
        return false;
   }
   
   if(!t.errorTypeMessage.equals(this.errorTypeMessage))
   {
       return false;
   }
   return true;
  }
}
