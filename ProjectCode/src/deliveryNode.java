
public class deliveryNode {
int id;
int pickup_id;
int load;
int e_time;
int l_time;


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

public int getl_time() {
	return e_time;
}

public void setl_time(int e_time) {
	this.e_time = e_time;
}
public int getPickup_id() {
	return pickup_id;
}

public void setPickup_id(int pickup_id) {
	this.pickup_id = pickup_id;
}




public deliveryNode() {
	super();
	// TODO Auto-generated constructor stub
}



public deliveryNode(int id, int pickup_id, int load, int e_time, int l_time) {
	super();
	this.id = id;
	this.pickup_id = pickup_id;
	this.load = load;
	this.e_time = e_time;
	this.l_time = l_time;
}

@Override
public String toString() {
	return "deliveryNode [id=" + id + ", pickup_id=" + pickup_id + ", x_coordinate=" 
			 + ", load=" + load + ", e_time=" + e_time + ", l_time=" + l_time + "]";
}



}