
public class pickupNode {
	int id;
	int load;
	int e_time;
	int l_time;
	
	public pickupNode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}

	public int getE_time() {
		return e_time;
	}

	public void setE_time(int e_time) {
		this.e_time = e_time;
	}

	public int getL_time() {
		return l_time;
	}

	public void setL_time(int l_time) {
		this.l_time = l_time;
	}

	public pickupNode(int id, int load, int e_time, int l_time) {
		super();
		this.id = id;
		this.load = load;
		this.e_time = e_time;
		this.l_time = l_time;
	}
	@Override
	public String toString() {
		return "pickupNode [id=" + id + ", load=" + load + ", e_time=" + e_time + ", l_time=" + l_time + "]";
	}
	
	
	
	
}
