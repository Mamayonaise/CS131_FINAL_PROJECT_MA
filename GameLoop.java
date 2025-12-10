import java.util.InputMismatchException;
import java.util.Scanner;
	
public class GameLoop {
	
	Scanner scnr = new Scanner(System.in);
	NodeManager nm;
	PlayerKnowledge pKnowledge;
	
	private int loopCount;
	private boolean loopRunning;
	private boolean introHasRan;
	private boolean nodeValidity;
	private boolean specialResponse;
	
//	DialogueManager manager = new DialogueManager();
//	Player player = new Player("n/a");
//	Interrogator gunner = new Gunman("Gunther", "Wild");
//	Interrogator ruleGiver = new RuleGiver("Raul", "Temperant");
//	StateManager state = new StateManager();
		
	public GameLoop(NodeManager nm, PlayerKnowledge pKnowledge) {
		this.nm = nm;
		this.pKnowledge = pKnowledge;
		this.loopCount = 1;
		this.loopRunning = true;
		this.introHasRan = false;
		this.nodeValidity = false;
		this.specialResponse = false;
		
		nm.setGameLoop(this);
	}
		
	public void addAndGetLoopCount() {
		loopCount++;
		if (loopCount > 1) {
			System.out.println("\n" + "<<Loop " + loopCount + ">>\n");
		}
	}

	public void loop() {
		while (loopRunning) {
			if (!introHasRan) {
				NodeManager.introStatement(); // Introduction Statement plays only once
			} else {
				addAndGetLoopCount(); //tells you what loop you're on
				System.out.println("\"Any last words?\"\n"); // says the Gunner's recurring phrase
			}
			System.out.println("CHOOSE A RESPONSE:");
			nm.printResponses(); // shows all general dialogue options
			String playerInput = scnr.nextLine(); // assigns the player's next input in playerInput
			nodeValidity = nm.isValidNode(playerInput);
			specialResponse = (playerInput.equals("rules") 
			    		    || playerInput.equals("resetLoop") 
			    		    || playerInput.equals("knowledge"));
			    
			if (nodeValidity || specialResponse) { //checks if the node is valid or is a specialResponse
				System.out.print("\n");
				try { //hypothetical scenario since I already cover all exceptions
					nm.Choice(playerInput);// processes the choice and outputs player and gunner responses
				}
				catch (InputMismatchException e) { //hypothetical scenario since I already cover all exceptions
					System.out.println("Invalid Input: " + playerInput + "returns a " + e.getMessage() + "error.\n"); 
					nodeValidity = false;
				}
			} else {
				while (!nodeValidity) { //until the node is valid, i will keep asking you to change it
					System.out.println("Type in |rules| for the rules,\n"
									 + "Type in the id of the response you want to choose (NUMBER WITHIN PARENTHESES)");
					playerInput = scnr.nextLine();
					try {
						nm.Choice(playerInput);// processes the choice and outputs player and gunner responses
						nodeValidity = true;
					}
					catch (InputMismatchException e) {
						System.out.println("Invalid Input: " + playerInput + "returns a " + e.getMessage() + "error.\n");
						nodeValidity = false;
					}
				}	
				System.out.print("\n");
			}
				
						/*
						 * if (the specific scenario(s) have been met) {
						 *     loopRunning = false;
						 *     System.out.println("END LOOP SEQUENCE");
						 * } else {
						 *     Gunner kills player
						 *     loop replays
						 * }
						 */
			if (pKnowledge.isGunmanAlone() && !nm.bsRes4.getNextNodes().isEmpty()) {
				System.out.println("SNEAK IN A RESPONSE:");
				nm.printFinalResponses(); // only shows 4a, 4b, 4c options
				playerInput = scnr.nextLine();
				if (nodeValidity || specialResponse) {
					nm.Choice(playerInput);
				} else {
					while (!nodeValidity) {
						System.out.println("Invalid Input!\n"
										 + "Type in the id of the response you want to choose (NUMBER WITHIN PARENTHESES)");
						playerInput = scnr.nextLine();
					}
					nm.Choice(playerInput);
				}
			} 
				if (pKnowledge.getWinCondition()) {
					loopRunning = false;
				} else {
		 			System.out.println(NodeManager.death); //You have been killed
					introHasRan = true;
					pKnowledge.setGunmanAlone(false);
				}
		}
	}

	
	public void resetLoop(String playerResponse) {
		if (playerResponse.equals("y")) {
			loopCount = 0;
			introHasRan = false;
			pKnowledge.knowledge.clear(); //clears the playerKnowledge
			
			pKnowledge.resetStates(); // sets all states to false
			nm.resetNodeRequirements(); //sets all the nodeRequirements in NodeManager to false
			
		} else if (playerResponse.equals("n")){
			System.out.println("-------------------\n"
							 + "You are back in the loop\n"
							 + "-------------------\n");
		} else {
			System.out.println("Type in either |y| or |n| to continue");
		}
	}


		//All states set to false, 
		//loopCount set to 1
		//etc maybe?
	}

			


