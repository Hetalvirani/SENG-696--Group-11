package agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

import java.util.Scanner;

import jade.core.AID;

public class SecondAgent extends Agent{
    protected void setup(){
    
    addBehaviour(new AgentB_ReceiveMessage());
    }
    public class AgentB_ReceiveMessage extends CyclicBehaviour{
    
            @Override
            public void action(){
                ACLMessage remsg = myAgent.receive();
                
                    if(remsg!=null){
                        System.out.println(remsg.getContent());
                        
                    }else{
                        block();
                    }
            }
    }
}