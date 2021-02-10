
public class route {
   int Id;
   int currentCapcity;
   int totalTime;
 //  boolean vistid;

   
   
   public route() {
	super();
	// TODO Auto-generated constructor stub
}



public route(int id, int currentCapcity, int totalTime) {
	super();
	Id = id;
	this.currentCapcity = currentCapcity;
	this.totalTime = totalTime;
	//this.vistid = false;
}










public int getCurrentCapcity() {
	return currentCapcity;
}





public void setCurrentCapcity(int currentCapcity) {
	this.currentCapcity = currentCapcity;
}





public int getFromId() {
	return Id;
}



public void setFromId(int fromId) {
	this.Id = fromId;
}







public int getTotalTime() {
	return totalTime;
}



public void setTotalTime(int totalTime) {
	this.totalTime = totalTime;
}





@Override
public String toString() {
	return "route [Id=" + Id + ", currentCapcity=" + currentCapcity + ", served at = " + totalTime + "]\n";
}




}
