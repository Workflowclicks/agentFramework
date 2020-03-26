package com.research.software.messaging;
/**
 *
 * @author yehiakotb
 */
public class Message {
    protected static int messageCount=0;
    protected int message_id;
    protected String message;
    protected int sender_id;
    protected int receiver_id;
    public Message()
    {
     message_id=(messageCount++);
     message="";
     sender_id=-1;
     receiver_id=-1;
    }
    public Message(String message)
    {
     message_id=(messageCount++);
     this.message=message;
    }
    public void setSenderId(int sender_id)
    {
     this.sender_id=sender_id;
    }
     public void setReceiverId(int receiver_id)
    {
     this.receiver_id=receiver_id;
    }
    public int getSenderId()
    {
      return sender_id;
    }
    public int getReceiverId()
    {
      return receiver_id;
    }
    public void setMessage(String message)
    {
     this.message=message;
    }
    public int getMessageID()
    {
     return message_id;
    }
     public String getMessage()
    {
     return message;
    }
     @Override
     public String toString()
     {
       return "Message ID: "+ message_id+" message :"+ message;
     }
      @Override
     public boolean equals(Object o)
     {
       if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Message)) { 
            return false; 
        } 
        Message message = (Message) o; 
        return ((message_id==message.message_id) 
                && (this.message.equals(message.message))); 
     }
}
