import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import java.util.Scanner;

public class NodeManager extends NodeHolder{
	Scanner scnr = new Scanner(System.in);
	
	GameLoop gLoop;
	
//	DialogueNode bsRes1;
//	DialogueNode bsRes1_a;
//	DialogueNode bsRes1_a_1;
//	DialogueNode bsRes1_b;
//	DialogueNode bsRes1_b_1;
//	
//	DialogueNode bsRes2;
//	DialogueNode bsRes2_a;
//	DialogueNode bsRes2_a_1;
//	
//	DialogueNode bsRes3;
//	
//	DialogueNode bsRes4;
//	DialogueNode bsRes4_a;
//	DialogueNode bsRes4_b;
//	
//	DialogueNode bsRes5;
	
	ArrayList<DialogueNode> nodeList = new ArrayList<>();	
	
	static String death = "<<YOU HAVE BEEN KILLED>>\n---------------------------------------------\n";
	
	public static void introStatement() {
		System.out.println("__________________________________\n"
						+ "You are in a chair,"
				        + "\nhands tied"
				        + "\nin a damp room with flat, unflattering walls.\n"
				        + "\nThere is a singular light directly above you\n"
				        + "\nAnd a door in front of you.\n");
		System.out.println("Two figures come through a door: "
						+ "\nOne holding a pistol,"
						+ "\nand the other holding a clipboard.");
		System.out.println("The Gunman sees you, points his gun, and says, \n"
						+ "\n\"Any Last Words?\"\n"
						+ "\nWhat do you say?\n");
	}
	
	
	
	
	public NodeManager(PlayerKnowledge player) {
		super(player);
		
//			bsRes1 = new DialogueNode("1", // node id
//									  "\"Who are you?\" -> Gunman", //player Response
//			                          "GUNMAN: \"My name is Gunther, and I'm here to execute you for your crimes!\"\n"
//			                        + "        \"Bye.\"\n", //gunnerResponse
//									  null, //knowledge required to access this node
//									  "Gunman's name: Gunther"); //knowledge gained
//			
//			bsRes1_a = new DialogueNode("1a",
//										"\"What is your mom's name?\"", //player Response
//					  					"GUNMAN: \"What?\"\n" //gunner response
//					  				  + "        \"Those are your last words?\"\n"
//					  				  + "        \"You want to know my mom's name?\"\n\n"
//					  				  + "        [The Gunman places his free hand on his face and lets out a sigh.]\n\n"
//					  				  + "        \"Well, you're dead anyway.\"\n"
//					  				  + "        \"Her name is Ellan.\"\n",
//					  				  player.isKnowsGunmanName(), //requirements to access node
//					  				  "Gunman mothers's name: Ellan"); //knowledge gained
//			
//			bsRes1_a_1 = new DialogueNode("1a1",
//										  "\"Ellan wouldn't want you to do this, Gunther\"", //player Response
//										  "GUNMAN: \"How do you...\"\n\n"
//										+ "        [The Gunman feels the Enforcer's gaze on his back]\n\n" //gunner Response
//									    + "        \"What!?\"\n"
//										+ "        \"No, no,\"\n"
//									    + "        \"I am NOT entertaining this\"\n"
//										+ "        \"Bye\"\n",
//										player.isKnowsGunmanMomName(), //requirements to access node
//										"The Gunman is afraid of the Enforcer?"); //knowledge gained
//			
//			bsRes1_b = new DialogueNode("1b",
//										"\"Don't kill me Gunther!\"", // player Response
//										"        [The Gunman hesitates and becomes irritated]\n"// gunner Response
//									  + "        [He looks at the Enforcer, then back at you]\n\n"
//									  + "GUNMAN: \"You think knowing my name will save you, huh?\"\n"
//									  + "        \"I'm a little curious on how you know, but I don't care too much to be honest.\"\n"
//									  + "        \"Goodbye now stranger.\"\n", 
//									  player.isKnowsGunmanName(), //requirements to access node
//									  null); // knowledge gained
//			
//			bsRes2 = new DialogueNode("2",
//									  "\"Who am I?\"",
//									  "GUNMAN: \"You serious?\"\n"
//									+ "        [He looks to the Enforcer]\n"
//									+ "        \"This person got dementia or something?\"\n\n"
//									+ "ENFORCER: \"Perhaps\"\n\n"
//									+ "GUNMAN: \"Well, who are you making me kill?\"\n\n"
//									+ "ENFORCER: \"Lets see their records...\"\n"
//									+ "          \"Prisoner, you have committed:\n\n"
//									+ "          \"Sharing your NETFLIX password in Tennessee\"\n"
//									+ "          \"Skateboarding in Florida without a licence\"\n\n"
//									+ "          [The Enforcer audibly gasps]\n\n"
//									+ "          \"And worst of all,\"\n"
//									+ "          \"Jaywalking\"\n\n"
//									+ "        [The Gunman audibly gasps]\n"
//									+ "GUNMAN: \"Shame on you, you definitely deserve what's coming.\"\n"
//									+ "        \"Sayonara fool!\"\n",
//									  null,
//									  "I've done some terrible things");
//			
//			bsRes2_a = new DialogueNode("2a",
//										  "\"I'm a pretty bad person, just kill me.\"",
//										  "GUNMAN: \"Huh?\"\n"
//									    + "        [He faces the Enforcer]\n"
//									    + "        \"What were his crimes?\"\n\n"
//									    + "          [The Enforcer shows him your records]\n\n"
//									    + "        [The Gunman skims through them]\n"
//									    + "GUNMAN: \"SHEEEESH, you're evil huh?\"\n"
//									    + "        \"I don't think of myself as a hero,\"\n"
//									    + "        \"but the world will definitely improve without you in it.\"\n"
//									    + "        \"You couldn't've figured it out before you did all THAT?\"\n"
//									    + "        \"No matter now anyway,\"\n"
//									    + "        \"bye now.\"\n",
//										player.isKnowsSelf(),
//										"I really suck");
//			
//			bsRes2_a_1 = new DialogueNode("2a1",
//										  "\"I've been living the same scenario over and over. Is there really no way out of this?\"",
//										  "GUNMAN: \"Huh?\"\n"
//										+ "        \"In a time loop now, huh?\"\n"
//										+ "        \"I'll bite.\"\n"
//										+ "        \"If you really are, convice me to not kill you somehow\"\n"
//										+ "        \"Gaslight me or something, you have all the time in the world right?\"\n"
//										+ "        \"Good luck!\"\n",
//										  player.isRegretsActions(),
//										  "I should try to convince the Gunman not to kill me.");
//			
//			bsRes3 = new DialogueNode("3",
//									  "\"Who are you?\" -> Enforcer",
//									  "ENFORCER: \"No, I reject the question.\"\n"
//									+ "          [He turns to the Gunman]\n"
//									+ "          \"Kill him\"\n\n"
//									+ "GUNMAN: \"Got it boss!\"\n"
//									+ "        \"See ya!\"\n",
//									  null,
//									  "Enforcer doesn't want to disclose themself");
//			bsRes4 = new DialogueNode("4",
//					  				  "\"Could you get me a tissue paper? My nose is stuffy.\"",
//					  				  "GUNMAN: \"Uh, Sure\"\n"
//					  				+ "         [He gestures to the Enforcer]\n"
//					  				+ "         [The Enforcer leaves the room]\n"
//					  				+ "        \"He'll get it.\"\n",
//					  				  null, //this pauses the loop and keeps it going, and only outputs the responses underneath
//					  				  "When asking for tissue paper, the Enforcer leaves the room");
//			
//			bsRes4_a = new DialogueNode("4a",
//									   "\"Who is the other guy?\"",
//									   "GUNMAN: \"Uhh, well,\"\n"
//									 + "        \"Some Warden of this prison I guess.\"\n"
//									 + "        \"I think his name is Raul?\"\n"
//									 + "        \"I was commissioned here to execute you so they don't have to get their hands dirty\"\n"
//									 + "        \"Very strange folk.\"\n\n"
//									 + "          [The Enforcer comes back with some tissues]\n\n"
//									 + "ENFORCER: \"I got a few just in case\"\n\n"
//									 + "          [He cleans your face]\n\n"
//									 + "          \"Nice right?\"\n"
//									 + "          \"Alright, thats your life!\"\n\n"
//									 + "GUNNER: \"That it is.\"\n"
//									 + "        \"Have a good one!\"", //Enforcer comes back, cleans your nose, and lets the gunman kill you
//									   player.isGunmanAlone(),
//									   "Enforcer's Name: Raul\n"
//										+ "Enforcer's Occupation: Warden\n"
//										+ "Enforcer does not want to kill by their own hands\n"
//										+ "Gunman's Occupation: Commissioned Executioner");
//			
//			bsRes4_b = new FinalDialogueNode("4b",
//									   bsRes1_a_1.getPlayerResponse(),
//									   
//									   "GUNMAN: \"How did you...\"\n\n"
//									 + "        [The Gunman looks to the door the Enforcer went through]\n\n"
//									 + "        \"...\"\n"
//									 + "        \"Ok, you got me on your side\"\n"
//									 + "        \"The paycheck is NOT worth the risk\"\n\n"
//									 + "          [The Enforcer comes back with some tissues]\n\n"
//									 + "ENFORCER: \"I got a few just in ca-\"\n\n"
//									 + "        [The Gunman shoots and kills the Enforcer]\n"
//									 + "        [He unties you after]\n\n"
//									 + "GUNMAN: \"Lets go,\"\n"
//									 + "        \"I got you in my sights for now, don't play with me\"\n"
//									 + "        \"You better tell me how you know that name\"\n"
//									 + "        \"but lets get out of here just to be safe.\"\n",
//									   player.isGunmanAlone(),
//									   player.isKnowsGunmanMomName(), // second requirement (overloaded dialogueNode)
//									   null);
//			
//			bsRes5 = new DialogueNode("5",
//									  "\"What?\"",
//									  "ENFORCER: \"Is that single word good enough for you?\"\n"
//									+ "          [He turns to the Gunman]\n\n"
//									+ "GUNMAN: \"*sighs*\"\n"
//									+ "        \"Yeah sure, it does\"\n"
//									+ "        \"Lame response\"\n"
//									+ "        [He points the gun at you and shoots, disappointingly]\n",
//									  null,
//									  "Don't be stupid"); //foolish
			

		
		
		bsRes1.setNextNodes(bsRes1_a); //
		bsRes1.setNextNodes(bsRes1_b);
		nodeList.add(bsRes1);
		
		bsRes1_a.setNextNodes(bsRes1_a_1);
		bsRes1_a.setPreviousNodes(bsRes1);
		nodeList.add(bsRes1_a);
		
		bsRes1_a_1.setPreviousNodes(bsRes1_a);
		nodeList.add(bsRes1_a_1);
		
		bsRes1_b.setPreviousNodes(bsRes1);
		nodeList.add(bsRes1_b);
		//---------------------------------------------
		bsRes2.setNextNodes(bsRes2_a);
		nodeList.add(bsRes2);
		
		bsRes2_a.setNextNodes(bsRes2_a_1);
		bsRes2_a.setPreviousNodes(bsRes2);
		nodeList.add(bsRes2_a);
		
		bsRes2_a_1.setPreviousNodes(bsRes2_a);
		nodeList.add(bsRes2_a_1);
		//---------------------------------------------
		nodeList.add(bsRes3);
		//---------------------------------------------
		bsRes4.setNextNodes(bsRes4_a);
		bsRes4.setNextNodes(bsRes4_b);
		nodeList.add(bsRes4);
		
		bsRes4_a.setPreviousNodes(bsRes4);
		nodeList.add(bsRes4_a);
		
		bsRes4_b.setPreviousNodes(bsRes4);
		nodeList.add(bsRes4_b);
		//---------------------------------------------
		nodeList.add(bsRes5);
	}
	
	public void setGameLoop(GameLoop gLoop) { //not entirely sure, maybe instantiates GameLoop? Regardless it prevents infinite recursion
		this.gLoop = gLoop;
	}
	
	public DialogueNode getNode(String playerInput) {//picks which node based on player input
		for (DialogueNode node : nodeList) {
			 if (playerInput.equals(node.getId())) {
				 return node;
			 }
		}
		return null;
	}
	
	public boolean isValidNode(String id) { //returns the validity of a node
		for (DialogueNode node: nodeList) {
			if (node.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void Choice(String playerInput) { //processes the players choice and outputs the correct option
		switch (playerInput) {
			case "rules":
				System.out.println("<1> To choose a response, type in the ID within the parentheses.\n"
								 + "For example: for the response |(1) Who are you? - Gunner|, type in |1|\n\n"
								 + "<2> Type in |knowledge| to view a list of what you have learned\n\n"
								 + "<3> Type in |resetLoop| to completely reset the game, erasing your knowledge and all");
				return; //make it so the loop continues
			case "knowledge":
				if (player.knowledge == null || player.knowledge.isEmpty()) {
					System.out.println("You know nothing");
					return;
				} else {
					player.getAllKnowledge();
					return;
				}
			case "resetLoop":
				System.out.println("-------------------------\n"
						 + "Are you sure you want to reset the loop?\n"
						 + "Type in |y| for yes OR |n| for no\n"
						 + "-------------------------\n");
				String pAnswer = scnr.nextLine();
				gLoop.resetLoop(pAnswer); // 
				return;
		}
		
		
		DialogueNode playerChoice = getNode(playerInput);
		ArrayList<DialogueNode> prevNode = new ArrayList<DialogueNode>(playerChoice.getPreviousNodes());
		ArrayList<DialogueNode> nextNodes = new ArrayList<>(playerChoice.getNextNodes());
		
		
			if (prevNode == null || prevNode.isEmpty()) {//only the base responses or respos that don't have previous respos
				System.out.println("YOU: " + playerChoice.getPlayerResponse() + "\n");
				System.out.println(playerChoice.getInterrogatorResponse());
/********************************************************************************************************************************
 *  * The following lines check a very specific scenario*/
				if (playerChoice.getId().equals("1a")) { //if the player knows the mother's name, response 4b will have that requirement open
			        bsRes4_b.setRequirement2(true);
			    } 
				
				if (playerChoice.getId().equals("4")) { //if the player picks option 4, the gunman Alone will be set to true
					player.gunmanAlone = true;
					for (DialogueNode child : playerChoice.getNextNodes()) {
				        child.setRequirement(true);  // sets the first requirement of 4's children (gunmanAlone) to true
				    }

				    return;
				}

				if (playerChoice.getId().equals("4b")) { //turns on the win condition!
					player.setWinCondition(true);
				}
/*****************************************************************************************/
				
				
				if (playerChoice.getKnowledge() != null && !player.knowledge.contains(playerChoice.getKnowledge())) { //checks if the knowledge in playerChoice is in the knowledge array and if there's anything in the array at all
					player.addKnowledge(playerChoice.getKnowledge());
					for (DialogueNode node: nextNodes) {
						node.setRequirement(true);
					}
				} 
				else {
					System.out.println("Invalid input!");
				}
			}
			
			ArrayList<DialogueNode> choicePrevRespos = new ArrayList<DialogueNode>(playerChoice.getPreviousNodes()); //takes the previous nodes and places them in choicePrevRespos
			for (DialogueNode node: choicePrevRespos) { // for each item of choicPrevRespos,
				
				if(node.getRequirement() == null || node.getRequirement() == true) { //if any have been met,
					System.out.println("YOU: " + playerChoice.getPlayerResponse() + "\n"); //prints 
					System.out.println(playerChoice.getInterrogatorResponse());
/********************************************************************************************************************************
 * The following lines check a very specific scenario*/
					if (playerChoice.getId().equals("1a")) {
				        bsRes4_b.setRequirement2(true);
				    }
					
					if (playerChoice.getId().equals("4")) {
						player.gunmanAlone = true;
						return;
					}

					if (playerChoice.getId().equals("4b")) {
						player.setWinCondition(true);
					}
/*****************************************************************************************/
					if (playerChoice.getKnowledge() != null && !player.knowledge.contains(playerChoice.getKnowledge())) { //checks if the knowledge in playerChoice is in the knowledge array and if there's anything in the array at all
						player.addKnowledge(playerChoice.getKnowledge());
						for (DialogueNode nextNode: nextNodes) {
							nextNode.setRequirement(true);
						}
					}
					
					playerChoice.setRequirement(true);
				} else {
					System.out.println("Invalid input!");
				}
			}


	}
	
	public void printResponses() {
		
		/*GOAL:*
		 *		Start at the base Response <<CHECK>>
		 *		Indent each response depending on the layer <<CHECK>>
		 *		Optional: Reorganize the child Dialogue to go from a to z*/ 
		
		Stack<DialogueNode> generalStack = new Stack<DialogueNode>();
		Set<DialogueNode> printed = new HashSet<>();
		
		for (DialogueNode node: nodeList) { // checking every node
			if (node.getPreviousNodes() == null || node.getPreviousNodes().isEmpty()) { //iterating through only baseNodes
		    	generalStack.push(node); //pushes baseNodes the top 
//		    	indentAmount++; //iA = 1
			}
		    while(!generalStack.isEmpty()) {
			    	node = generalStack.pop(); //pops the current node up top off the stack
			    	
		            if (!node.getPreviousNodes().isEmpty() && "4".equals(node.getPreviousNodes().get(0).getId())) { //skips the children of bsRes4
		                continue;
		            }
		            
			    	System.out.println(Indentation(node) + "(" + node.getId() + ")" + node.getPlayerResponse()); //dynamically adds indentations and prints the current nodes response
			    	printed.add(node);
			    	
			    	ArrayList<DialogueNode> nextNodes = new ArrayList<>(node.getNextNodes()); //nextNodes are the next nodes of the currentNode
			    	if((nextNodes != null && !nextNodes.isEmpty())) { //checking if the current node has more nodes
			    		for (DialogueNode nexterNode: nextNodes) { //checking each next node of nextNodes
							if (nexterNode.getRequirement() == null || nexterNode.getRequirement() == true) { //if the requirements are met
								generalStack.push(nexterNode);
							}
						}
			    	}
		    }
		}
	}
	
	public void printFinalResponses() {
		for (DialogueNode node: nodeList) {
			ArrayList<DialogueNode> prevNodes = new ArrayList<>(node.getPreviousNodes());
			if (!prevNodes.isEmpty() && prevNodes.get(0).getId().equals("4")) { // if the previous node is bsRes4
				boolean req = node.getRequirement() == null || node.getRequirement() == true;
				boolean req2 = node.getRequirement2() == null || node.getRequirement2();
				
				if (req && req2) {
					System.out.println("(" + node.getId() + ")" + node.getPlayerResponse());
				}
			}
		}
	}
	
	public void resetNodeRequirements() { //resets the node requirements back to false
	    for (DialogueNode node : nodeList) {
	        node.setRequirement(false);
	        node.setRequirement2(false);
	    }
	}
	

	public String Indentation(DialogueNode node) { //indents the correct amount
		int indentAmount = node.getId().length() - 1; //gets the length of an id
		String indent = "   "; //an indent
		for (int i = 0; i<indentAmount;i++) { //for the length of a nodes id,
			indent += indent; //print out an indent
		}
		if (indentAmount == 0) {
			return "";
		}
		else if (node.getId() == "rules") {
			indent += indent;
			return indent;
		} else {
			return indent;
		}
	}
	
//	public int getLadderSize(DialogueNode node) { //completely useless method in the end
//		int ladderSize = 0;
//		ArrayList<DialogueNode> nextNodes = new ArrayList<>(node.getNextNodes());
//		while (nextNodes != null && !nextNodes.isEmpty()) {
//			ladderSize++;
//			DialogueNode firstNode = nextNodes.get(0);
//			nextNodes = new ArrayList<>(firstNode.getNextNodes());
//		}
//		return ladderSize;
//	}
}
