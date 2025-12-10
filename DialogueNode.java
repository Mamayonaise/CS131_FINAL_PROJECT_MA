import java.util.ArrayList;
import java.util.List;

public class DialogueNode {
	
	private String id;
	private String playerResponse;
	private String interrogatorResponse;

	private List<DialogueNode> nextNodes; //nextNode(s)
	private List<DialogueNode> previousNodes; //previousNode(s)

	private Boolean requirement;
	private Boolean requirement2;
	private String Knowledge;

	
	public DialogueNode() {
		this.id = "";
		this.playerResponse = "";
		this.interrogatorResponse = "";
        this.nextNodes = null;
        this.previousNodes = null;
        this.requirement = null; //maybe change to false, not sure
        this.Knowledge = "";
	}
	
	public DialogueNode(String id, String playerResponse, String interrogatorResponse, Boolean requirement, String knowledge){
			this.id = id;
			this.playerResponse = playerResponse;
			this.interrogatorResponse = interrogatorResponse;
			this.nextNodes = new ArrayList<DialogueNode>();
	        this.previousNodes = new ArrayList<DialogueNode>();
	        this.requirement = requirement;
	        this.Knowledge = knowledge;
	        
	        
	        if (nextNodes != null) {
	        	for (int i = 0; i<nextNodes.size(); i++)
	        	setNextNodes((DialogueNode) nextNodes);
	        }
	        if (previousNodes != null) {
	        	for (int i = 0; i<previousNodes.size();i++) {
	        		setPreviousNodes((DialogueNode) nextNodes);	
	        	}
	        }
	        
	}
	
//	public DialogueNode(String id, String playerResponse, String interrogatorResponse, Boolean requirement, Boolean requirement2, String knowledge) {
//			this.id = id;
//			this.playerResponse = playerResponse;
//			this.interrogatorResponse = interrogatorResponse;
//			this.nextNodes = new ArrayList<DialogueNode>();
//	        this.previousNodes = new ArrayList<DialogueNode>();
//	        this.requirement = requirement;
//	        this.requirement2 = requirement2;
//	        this.Knowledge = knowledge;
//	        
//	        
//	        if (nextNodes != null) {
//	        	for (int i = 0; i<nextNodes.size(); i++)
//	        	setNextNodes((DialogueNode) nextNodes);
//	        }
//	        if (previousNodes != null) {
//	        	for (int i = 0; i<previousNodes.size();i++) {
//	        		setPreviousNodes((DialogueNode) nextNodes);	
//	        	}
//	        }
//	}



	public List<DialogueNode> getNextNodes() {
			return nextNodes;
	}



	public void setNextNodes(DialogueNode node) {
			this.nextNodes.add(node); //adds node as a nextNode
	}


	public List<DialogueNode> getPreviousNodes() {
		return previousNodes;
	}



	public void setPreviousNodes(DialogueNode node) {
		this.previousNodes.add(node);
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayerResponse() {
		return playerResponse;
	}

	public void setPlayerResponse(String playerResponse) {
		this.playerResponse = playerResponse;
	}

	public String getInterrogatorResponse() {
		return interrogatorResponse;
	}

	public void setInterrogatorResponse(String interrogatorResponse) {
		this.interrogatorResponse = interrogatorResponse;
	}
	
//	public String getEnforcerResponse() {
//		return enforcerResponse;
//	}
//
//	public void setEnforcerResponse(String enforcerResponse) {
//		this.enforcerResponse = enforcerResponse;
//	}

	public Boolean getRequirement() {
		return requirement;
	}

	public void setRequirement(Boolean requirement) {
		this.requirement = requirement;
	}
	
	public Boolean getRequirement2() {
		return requirement2;
	}

	public void setRequirement2(Boolean requirement2) {
		this.requirement2 = requirement2;
	}

	public String getKnowledge() {
		return Knowledge;
	}

	public void setKnowledge(String knowledge) {
		Knowledge = knowledge;
	}
	
	
	
}
