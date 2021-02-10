
public class nextState {

	  int Id;
      int  flag;
	  int travelTime;

	public nextState() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nextState(int id, int travelTime) {
		super();
		Id = id;
		this.flag = 0;
		this.travelTime = travelTime;
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}
	
	@Override
	public String toString() {
		return "nextState [Id=" + Id + ", flag=" + flag + ", travelTime=" + travelTime +  "]";
	}
	   

	
	
}
