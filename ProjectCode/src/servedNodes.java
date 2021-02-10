
public class servedNodes {
  
	int pickupId;
	int deleveryId;
	int ServeTime;
	
	
	
	public servedNodes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public servedNodes(int pickupId, int deleveryId, int serveTime) {
		this.pickupId = pickupId;
		this.deleveryId = deleveryId;
		ServeTime = serveTime;
	}



	public int getPickupId() {
		return pickupId;
	}
	public void setPickupId(int pickupId) {
		this.pickupId = pickupId;
	}
	public int getDeleveryId() {
		return deleveryId;
	}
	public void setDeleveryId(int deleveryId) {
		this.deleveryId = deleveryId;
	}
	public int getServeTime() {
		return ServeTime;
	}
	public void setServeTime(int serveTime) {
		ServeTime = serveTime;
	}

	@Override
	public String toString() {
		return "servedNodes [pickupId=" + pickupId + ", deleveryId=" + deleveryId + ", ServeTime=" + ServeTime + "]";
	}
	
	
	
	
	
}
