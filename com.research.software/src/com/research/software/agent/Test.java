package com.research.software.agent;

/**
 *
 * @author yehiakotb
 */
import com.research.software.error.ErrorManager;
import com.research.software.error.Error;
import com.research.software.agent.Agent;
import com.research.software.agent.Communicator;
import com.research.software.messaging.CommunicationManager;
import com.research.software.messaging.Message;
import java.util.List;
import java.util.ArrayList;

public class Test {
   
     public static void main(String [] args)
    {
       Test programm = new Test();
       programm.start();
    
    }
  public void start() {
     TestErrorSystem();
     TestCommunication();
    }
   public void TestErrorSystem()
   {
    ErrorManager manager = new ErrorManager("error.log", 10);
     for(int i=0;i<100;i++)
     {
      Error error = new Error(this.toString(),"tempError"+i,"code"+i,"errorType"+i);
      manager.addError(error);
     }
     manager.StopLogging();
   }
   public void TestCommunication()
   {
     ErrorManager errorManager = new ErrorManager("communication.log", 100);
     CommunicationManager communicationManager = new CommunicationManager(errorManager);
     List<Agent> agents = new ArrayList();
     for(int i=0;i<100;i++)
     {
       Agent communicator= new Communicator(errorManager,communicationManager);
       agents.add(communicator);
       communicationManager.register(communicator);
     }
     
     for(int i=0;i< 100;i++)
     {
      int source = (int) agents.get(i).getAgentId();
      int destination = (int) (Math.random()*300);
      Message message= new Message();
      message.setSenderId(source);
      message.setReceiverId(destination);
      message.setMessage(" HELLOOO ");
      communicationManager.sendPeerToPeerMessage(message);
     }
     for(int i=0;i< 100;i++)
     {
      int source = (int) (Math.random()*300);
      int destination = (int) (Math.random()*300);
      Message message= new Message();
      message.setSenderId(source);
      message.setReceiverId(destination);
      message.setMessage(" HELLOOO ");
      communicationManager.sendBroadcastMessage(message);
     }
   }
}