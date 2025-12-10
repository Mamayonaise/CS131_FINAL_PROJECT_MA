import java.util.ArrayList;

public class PlayerKnowledge {
	
	public ArrayList<String> knowledge;
//	public String playerName;
	public Boolean knowsGunmanName;
	public Boolean knowsGunmanMomName;
	public Boolean knowsSelf;
	public Boolean regretsActions;
	public Boolean knowsEnforcer;
	public Boolean gunmanAlone;
	
	public Boolean winCondition;
	
	public ArrayList<Boolean> allStates;
		
	public PlayerKnowledge() {
		this.knowledge = new ArrayList<>();
//		this.playerName = "";
		this.knowsGunmanName = false;
		this.knowsGunmanMomName = false;
		this.knowsSelf = false;
		this.regretsActions = false;
		this.knowsEnforcer = false;
		this.gunmanAlone = false;
		this.winCondition = false;
		
		allStates = new ArrayList<Boolean>();
		allStates.add(knowsGunmanName);
		allStates.add(knowsGunmanMomName);
		allStates.add(knowsSelf);
		allStates.add(regretsActions);
		allStates.add(knowsEnforcer);
		allStates.add(gunmanAlone);
		allStates.add(winCondition);


	}
	
	public void resetStates() {
		for (int i = 0; i < allStates.size(); i++) {
			allStates.set(i, false);
		}
	}
	
	public String getKnowledge(int index) {
		if (index >= 0 && index < knowledge.size()) {
			return knowledge.get(index);
		}
		else {
			return "Type in a positive number correlating to the amount of options";
		}
	}
		
	public void getAllKnowledge() {
		for (int i = 0; i<knowledge.size(); i++) {
			System.out.println(knowledge.get(i));
		}
	}
		
	public void addKnowledge(String response) {
		knowledge.add(response);
//		tempSet[tempSet.length-1] = response;
//		knowledge = tempSet; //add to the knowledge array
	}
	
//	public String getPlayerName() {
//		return playerName;
//	}
//	
//	public void setPlayerName(String playerName) {
//		this.playerName = playerName;
//	}

	public Boolean isKnowsGunmanName() {
		return knowsGunmanName;
	}

	public void setKnowsGunmanName(boolean b) {
		this.knowsGunmanName = b;
	}

	public Boolean isKnowsGunmanMomName() {
		return knowsGunmanMomName;
	}

	public void setKnowsGunmanMomName(boolean b) {
		this.knowsGunmanMomName = b;
	}
	
	public Boolean isKnowsSelf() {
		return knowsSelf;
	}

	public void setKnowsSelf(Boolean knowsSelf) {
		this.knowsSelf = knowsSelf;
	}
	
	public Boolean isRegretsActions() {
		return knowsSelf;
	}

	public void setRegretsActions(Boolean regretsActions) {
		this.regretsActions = regretsActions;
	}

	public Boolean isKnowsEnforcer() {
		return knowsEnforcer;
	}

	public void setKnowsEnforcer(Boolean knowsEnforcer) {
		this.knowsEnforcer = knowsEnforcer;
	}

	public Boolean isGunmanAlone() {
		return gunmanAlone;
	}

	public void setGunmanAlone(Boolean gunmanAlone) {
		this.gunmanAlone = gunmanAlone;
	}
	
	public Boolean getWinCondition() {
		return winCondition;
	}
	
	public void setWinCondition(Boolean b) {
		this.winCondition = b;
	}

//	public String checkEnforcerCondition() {
//		if (gunmanAlone) {
//			return "Enforcer's Name: Raul\\n\"\r\n"
//					+ "									 + \"Enforcer's Occupation: Warden\\n\"\r\n"
//					+ "									 + \"Enforcer does not want to kill by their own hands\\n\"\r\n"
//					+ "									 + \"Gunman's Occupation: Commissioned Executioner\"";
//		} else {
//			return "Enforcer: n/a";
//		}
//	}


	
	
}
