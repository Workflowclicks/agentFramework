package com.research.software.agent;

import com.research.software.messaging.Message;
import com.research.software.error.ErrorManager;
import com.research.software.messaging.CommunicationManager;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author yehiakotb
 */
public class Communicator extends Agent {
    List<Message> messageQ = new ArrayList();
   public Communicator(ErrorManager errorManager)
   {
     super(errorManager);
   }
    public Communicator(ErrorManager errorManager,CommunicationManager communicationManager)
    {
     super(errorManager,communicationManager);
    }
    
    //------------ protected and private 
   @Override
   protected void sendMessage(Message message)
   {
    communicationManager.sendPeerToPeerMessage(message);
    communicationManager.sendBroadcastMessage(message);
   };
   @Override
   public void receiveMessage(Message message)
   {
     putMessageInQueue(message);
   };
   @Override
   protected void putMessageInQueue(Message message)
   {
    messageQ.add(message);
   };
   
   @Override
   protected void ProcessMessage()
   {
    
   }
}
