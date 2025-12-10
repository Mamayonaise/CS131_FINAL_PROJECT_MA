public class Game {
	public static void main(String[] args) {
		PlayerKnowledge pKnowledge = new PlayerKnowledge();
		NodeManager nm = new NodeManager(pKnowledge);
		
		
		GameLoop game = new GameLoop(nm, pKnowledge); // instantiates game
		game.loop(); // plays the game loop
//		pKnowledge.knowledge.add(nm.bsRes1_a.getKnowledge());
//		pKnowledge.knowledge.add(nm.bsRes1.getKnowledge());
//		pKnowledge.getAllKnowledge();
		
//		nm.printFinalResponses();
		
	}
}