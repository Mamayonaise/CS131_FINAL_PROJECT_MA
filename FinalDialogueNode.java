
public class FinalDialogueNode extends DialogueNode{
	
	private Boolean requirement2;
	
	public FinalDialogueNode() {
		this.requirement2 = false;
	}
	
	 public FinalDialogueNode(String id, String playerResponse, String interrogatorResponse,Boolean requirement, Boolean requirement2, String knowledge) {
		 super(id, playerResponse, interrogatorResponse, requirement, knowledge);
		 this.requirement2 = requirement2;
	 }
	 
	 @Override
	 public String getInterrogatorResponse() {
		 return super.getInterrogatorResponse() + "\nYOU ESCAPED\n"
				 								+ "Well Done!";
	 }
	 
	 public Boolean getRequirement2() {
			return requirement2;
		}

		public void setRequirement2(Boolean requirement2) {
			this.requirement2 = requirement2;
		}
 
	
}
