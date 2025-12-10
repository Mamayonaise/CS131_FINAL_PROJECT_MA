
public class NodeHolder {

	PlayerKnowledge player;
	
	DialogueNode bsRes1;
	DialogueNode bsRes1_a;
	DialogueNode bsRes1_a_1;
	DialogueNode bsRes1_b;
	DialogueNode bsRes1_b_1;
	
	DialogueNode bsRes2;
	DialogueNode bsRes2_a;
	DialogueNode bsRes2_a_1;
	
	DialogueNode bsRes3;
	
	DialogueNode bsRes4;
	DialogueNode bsRes4_a;
	DialogueNode bsRes4_b;
	
	DialogueNode bsRes5;

	
	public NodeHolder(PlayerKnowledge player) {
			this.player = player;
			
				bsRes1 = new DialogueNode("1", // node id
										  "\"Who are you?\" -> Gunman", //player Response
				                          "GUNMAN: \"My name is Gunther, and I'm here to execute you for your crimes!\"\n"
				                        + "        \"Bye.\"\n", //gunnerResponse
										  null, //knowledge required to access this node
										  "Gunman's name: Gunther"); //knowledge gained
				
				bsRes1_a = new DialogueNode("1a",
											"\"What is your mom's name?\"", //player Response
						  					"GUNMAN: \"What?\"\n" //gunner response
						  				  + "        \"Those are your last words?\"\n"
						  				  + "        \"You want to know my mom's name?\"\n\n"
						  				  + "        [The Gunman places his free hand on his face and lets out a sigh.]\n\n"
						  				  + "        \"Well, you're dead anyway.\"\n"
						  				  + "        \"Her name is Ellan.\"\n",
						  				  player.isKnowsGunmanName(), //requirements to access node
						  				  "Gunman mothers's name: Ellan"); //knowledge gained
				
				bsRes1_a_1 = new DialogueNode("1a1",
											  "\"Ellan wouldn't want you to do this, Gunther\"", //player Response
											  "GUNMAN: \"How do you...\"\n\n"
											+ "        [The Gunman feels the Enforcer's gaze on his back]\n\n" //gunner Response
										    + "        \"What!?\"\n"
											+ "        \"No, no,\"\n"
										    + "        \"I am NOT entertaining this\"\n"
											+ "        \"Bye\"\n",
											player.isKnowsGunmanMomName(), //requirements to access node
											"The Gunman is afraid of the Enforcer?"); //knowledge gained
				
				bsRes1_b = new DialogueNode("1b",
											"\"Don't kill me Gunther!\"", // player Response
											"        [The Gunman hesitates and becomes irritated]\n"// gunner Response
										  + "        [He looks at the Enforcer, then back at you]\n\n"
										  + "GUNMAN: \"You think knowing my name will save you, huh?\"\n"
										  + "        \"I'm a little curious on how you know, but I don't care too much to be honest.\"\n"
										  + "        \"Goodbye now stranger.\"\n", 
										  player.isKnowsGunmanName(), //requirements to access node
										  null); // knowledge gained
				
				bsRes2 = new DialogueNode("2",
										  "\"Who am I?\"",
										  "GUNMAN: \"You serious?\"\n"
										+ "        [He looks to the Enforcer]\n"
										+ "        \"This person got dementia or something?\"\n\n"
										+ "ENFORCER: \"Perhaps\"\n\n"
										+ "GUNMAN: \"Well, who are you making me kill?\"\n\n"
										+ "ENFORCER: \"Lets see their records...\"\n"
										+ "          \"Prisoner, you have committed:\n\n"
										+ "          \"Sharing your NETFLIX password in Tennessee\"\n"
										+ "          \"Skateboarding in Florida without a licence\"\n\n"
										+ "          [The Enforcer audibly gasps]\n\n"
										+ "          \"And worst of all,\"\n"
										+ "          \"Jaywalking\"\n\n"
										+ "        [The Gunman audibly gasps]\n"
										+ "GUNMAN: \"Shame on you, you definitely deserve what's coming.\"\n"
										+ "        \"Sayonara fool!\"\n",
										  null,
										  "I've done some terrible things");
				
				bsRes2_a = new DialogueNode("2a",
											  "\"I'm a pretty bad person, just kill me.\"",
											  "GUNMAN: \"Huh?\"\n"
										    + "        [He faces the Enforcer]\n"
										    + "        \"What were his crimes?\"\n\n"
										    + "          [The Enforcer shows him your records]\n\n"
										    + "        [The Gunman skims through them]\n"
										    + "GUNMAN: \"SHEEEESH, you're evil huh?\"\n"
										    + "        \"I don't think of myself as a hero,\"\n"
										    + "        \"but the world will definitely improve without you in it.\"\n"
										    + "        \"You couldn't've figured it out before you did all THAT?\"\n"
										    + "        \"No matter now anyway,\"\n"
										    + "        \"bye now.\"\n",
											player.isKnowsSelf(),
											"I really suck");
				
				bsRes2_a_1 = new DialogueNode("2a1",
											  "\"I've been living the same scenario over and over. Is there really no way out of this?\"",
											  "GUNMAN: \"Huh?\"\n"
											+ "        \"In a time loop now, huh?\"\n"
											+ "        \"I'll bite.\"\n"
											+ "        \"If you really are, convice me to not kill you somehow\"\n"
											+ "        \"Gaslight me or something, you have all the time in the world right?\"\n"
											+ "        \"Good luck!\"\n",
											  player.isRegretsActions(),
											  "I should try to convince the Gunman not to kill me.");
				
				bsRes3 = new DialogueNode("3",
										  "\"Who are you?\" -> Enforcer",
										  "ENFORCER: \"No, I reject the question.\"\n"
										+ "          [He turns to the Gunman]\n"
										+ "          \"Kill him\"\n\n"
										+ "GUNMAN: \"Got it boss!\"\n"
										+ "        \"See ya!\"\n",
										  null,
										  "Enforcer doesn't want to disclose themself");
				bsRes4 = new DialogueNode("4",
						  				  "\"Could you get me a tissue paper? My nose is stuffy.\"",
						  				  "GUNMAN: \"Uh, Sure\"\n"
						  				+ "         [He gestures to the Enforcer]\n"
						  				+ "         [The Enforcer leaves the room]\n"
						  				+ "        \"He'll get it.\"\n",
						  				  null, //this pauses the loop and keeps it going, and only outputs the responses underneath
						  				  "When asking for tissue paper, the Enforcer leaves the room");
				
				bsRes4_a = new DialogueNode("4a",
										   "\"Who is the other guy?\"",
										   "GUNMAN: \"Uhh, well,\"\n"
										 + "        \"Some Warden of this prison I guess.\"\n"
										 + "        \"I think his name is Raul?\"\n"
										 + "        \"I was commissioned here to execute you so they don't have to get their hands dirty\"\n"
										 + "        \"Very strange folk.\"\n\n"
										 + "          [The Enforcer comes back with some tissues]\n\n"
										 + "ENFORCER: \"I got a few just in case\"\n\n"
										 + "          [He cleans your face]\n\n"
										 + "          \"Nice right?\"\n"
										 + "          \"Alright, thats your life!\"\n\n"
										 + "GUNNER: \"That it is.\"\n"
										 + "        \"Have a good one!\"", //Enforcer comes back, cleans your nose, and lets the gunman kill you
										   player.isGunmanAlone(),
										   "Enforcer's Name: Raul\n"
											+ "Enforcer's Occupation: Warden\n"
											+ "Enforcer does not want to kill by their own hands\n"
											+ "Gunman's Occupation: Commissioned Executioner");
				
				bsRes4_b = new FinalDialogueNode("4b",
										   bsRes1_a_1.getPlayerResponse(),
										   
										   "GUNMAN: \"How did you...\"\n\n"
										 + "        [The Gunman looks to the door the Enforcer went through]\n\n"
										 + "        \"...\"\n"
										 + "        \"Ok, you got me on your side\"\n"
										 + "        \"The paycheck is NOT worth the risk\"\n\n"
										 + "          [The Enforcer comes back with some tissues]\n\n"
										 + "ENFORCER: \"I got a few just in ca-\"\n\n"
										 + "        [The Gunman shoots and kills the Enforcer]\n"
										 + "        [He unties you after]\n\n"
										 + "GUNMAN: \"Lets go,\"\n"
										 + "        \"I got you in my sights for now, don't play with me\"\n"
										 + "        \"You better tell me how you know that name\"\n"
										 + "        \"but lets get out of here just to be safe.\"\n",
										   player.isGunmanAlone(),
										   player.isKnowsGunmanMomName(), // second requirement (overloaded dialogueNode)
										   null);
				
				bsRes5 = new DialogueNode("5",
										  "\"What?\"",
										  "ENFORCER: \"Is that single word good enough for you?\"\n"
										+ "          [He turns to the Gunman]\n\n"
										+ "GUNMAN: \"*sighs*\"\n"
										+ "        \"Yeah sure, it does\"\n"
										+ "        \"Lame response\"\n"
										+ "        [He points the gun at you and shoots, disappointingly]\n",
										  null,
										  "Don't be stupid"); //foolish
	
	}
}
