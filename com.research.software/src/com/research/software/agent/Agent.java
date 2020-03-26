package com.research.software.agent;

import com.research.software.error.Error;
import com.research.software.error.ErrorManager;
import com.research.software.messaging.CommunicationManager;
import com.research.software.messaging.Message;
/**
 *
 * @author yehiakotb
 */
public abstract class Agent extends FrameworkObject 
{
    protected CommunicationManager communicationManager;
    
   public Agent(ErrorManager errorManager)
   {
     super(errorManager);
     this.communicationManager=null;
   }
   public Agent(ErrorManager errorManager, CommunicationManager communicationManager)
   {
     super(errorManager);
     this.communicationManager=communicationManager;
   }
   public long getAgentId()
   {
    return getID();
   }
   
   
   protected abstract void sendMessage(Message message);
   public abstract void receiveMessage(Message message);
   protected abstract void putMessageInQueue(Message message);
   protected abstract void ProcessMessage();
   protected void activateTimer()
   {
   
   }
   public void stopTimer()
   {
   
   }
      @Override
    public String toString()
     {
       return "agent Id: "+ getAgentId();
     }
      @Override
     public boolean equals(Object o)
     {
       if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Agent)) { 
            return false; 
        } 
        Agent agent = (Agent) o; 
        return (getAgentId()==agent.getAgentId());  
     }
}

