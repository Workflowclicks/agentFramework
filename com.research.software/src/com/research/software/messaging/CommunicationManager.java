package com.research.software.messaging;


import com.research.software.error.ErrorManager;
import com.research.software.error.Error;
import com.research.software.agent.Communicator;
/**
 *
 * @author yehiakotb
 */
import com.research.software.agent.Agent;
import java.util.List;
import java.util.ArrayList;
public class CommunicationManager extends Communicator {
  List<Agent> registeredAgents = new ArrayList();  
    
    public CommunicationManager(ErrorManager manager )
    {
     super(manager);
    }
    public void register(Agent agent)
    {
     if(!exists(agent.getAgentId()))
     {
      registeredAgents.add(agent);
     }
     else
     {
      Error error = new Error(" agent:"+agent.getAgentId(),"Communication manager", " Registeration", " agent is already registered.");
      errorManager.addError(error);
     }
    }

    public void sendPeerToPeerMessage(Message message)
    {
       if(checkPeerToPeerMessageValidity(message))
       {
        ((Communicator)getAgent(message.receiver_id)).receiveMessage(message);
       }
       else
       {
        String errorMessage="message not sent because it is not valid.Check Message attributes.";
        String causer="Communication Manager";
        String errorTypeMessage="Some or all message attributes are wrong";
        String errorCode="Messaging";
        Error error = new Error(causer,errorMessage,errorCode,errorTypeMessage);
        errorManager.addError(error);
       }
    }
    public void sendBroadcastMessage(Message message)
    {
       if(checkBroadcastMessageValidity(message))
       {
        for(Agent agent : registeredAgents)
        {
         agent.receiveMessage(message);
        }
       }
       else
       {
        String errorMessage="message not sent because it is not valid.Check Message attributes.";
        String causer="Communication Manager";
        String errorTypeMessage="Some or all message attributes are wrong";
        String errorCode="Messaging";
        Error error = new Error(causer,errorMessage,errorCode,errorTypeMessage);
        errorManager.addError(error);
       }
    }
    //------------------ private
    private boolean checkPeerToPeerMessageValidity(Message message)
    {
     boolean errorExists= false;
       String errorMessage="";
       String causer="";
       String errorTypeMessage="";
       String errorCode="";
       if(!exists(message.sender_id))
       {
        errorMessage="  Sender with id"+message.sender_id+" not identified";
        causer="Communication Manager";
        errorTypeMessage= " Agent not registered or does not exists";
        errorCode=" Registeration ";
        errorExists=true;
       }
       else if(!exists(message.receiver_id))
       {
        errorMessage="  Sender with id"+message.receiver_id+" not identified";
        causer="Communication Manager";
        errorTypeMessage= " Agent not registered or does not exists";
        errorCode=" Registeration ";
        errorExists=true;
       }
       else if(message.receiver_id==message.sender_id)
       {
        errorMessage="  Sender id"+message.receiver_id+" ncannot send a message to itself";
        causer="Communication Manager";
        errorTypeMessage= " message self cycling";
        errorCode=" messaging ";
        errorExists=true;
       }
       else if(message.sender_id==-1)
       {
        errorMessage="  sender not defined. ID -1";
        causer="Communication Manager";
        errorTypeMessage= " Message not properly defined";
        errorCode=" messaging ";
        errorExists=true;
       }
       else if(message.receiver_id==-1)
       {
        errorMessage="  receiver not defined. ID -1";
        causer="Communication Manager";
        errorTypeMessage= " Message not properly defined";
        errorCode=" messaging ";
        errorExists=true;
       }
       if(errorExists)
      {
        Error error = new Error(causer,errorMessage,errorCode,errorTypeMessage);
        errorManager.addError(error);
      }
     return !errorExists;
    
    }
    
    private boolean checkBroadcastMessageValidity(Message message)
    {
     boolean errorExists= false;
       String errorMessage="";
       String causer="";
       String errorTypeMessage="";
       String errorCode="";
       if(!exists(message.sender_id))
       {
        errorMessage="  Sender with id"+message.sender_id+" not identified";
        causer="Communication Manager";
        errorTypeMessage= " Agent not registered or does not exists";
        errorCode=" Registeration ";
        errorExists=true;
       }
       else if(message.sender_id==-1)
       {
        errorMessage="  sender not defined. ID -1";
        causer="Communication Manager";
        errorTypeMessage= " Message not properly defined";
        errorCode=" messaging ";
        errorExists=true;
       }
       
       if(errorExists)
      {
        Error error = new Error(causer,errorMessage,errorCode,errorTypeMessage);
        errorManager.addError(error);
      }
     return !errorExists;
    }
    
    private void sendBroadCastMessage(Message message)
    {
    
    
    }
    private boolean exists(long id)
    {
     for(Agent agent : registeredAgents)
     {
      if(agent.getAgentId()==id)
      {
       return true;
      }
     }
     return false;
    }
    private Agent getAgent(long id)
    {
        for(Agent agent : registeredAgents)
         {
          if(agent.getAgentId()==id)
          {
             return agent;
          }
         }
     return null;
    }
}