package agent;


	import java.util.concurrent.TimeUnit;

	import jade.core.AID;
	import jade.core.Agent;
	import jade.wrapper.AgentContainer;
	import jade.wrapper.AgentController;

	public class MakerAgent extends Agent {

		protected void setup() {
			
			
			
			System.out.println("\nMakerAgent: Creating agents");

			createAgent("Interface-1", "agent.InterfaceAgent");
			
			createAgent("Service-1", "agent.ServiceAgent");
			System.out.println("======= START ======\n");
		}

		private void createAgent(String name, String className) {
			AID agentID = new AID(name, AID.ISLOCALNAME);
			AgentContainer controller = getContainerController();
			try {
				AgentController agent = controller.createNewAgent(name, className, null);
				agent.start();
				System.out.println("Initialized: " + agentID.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

