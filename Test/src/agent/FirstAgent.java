package agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;



import jade.core.AID;

public class FirstAgent extends Agent{
	  
    protected void setup(){
    
    
    addBehaviour(new AgentA_SendMessage());
    
    }
    
    public FirstAgent()
    {
    	new SignUp()
    }
    
    public class AgentA_SendMessage extends OneShotBehaviour{
        @Override
        public void action(){
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID("Second-1",AID.ISLOCALNAME));
            msg.setContent("hello");
            send(msg);
        }
    }
    
    
    
  
    
}