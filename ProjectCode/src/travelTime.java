
public class travelTime {
int idFrom;
int idTo;
int Time;


public travelTime() {
	super();
	// TODO Auto-generated constructor stub
}

public travelTime(int idFrom, int idTo, int time) {
	super();
	this.idFrom = idFrom;
	this.idTo = idTo;
	Time = time;

}

@Override
public String toString() {
	return "travelTime [idFrom=" + idFrom + ", idTo=" + idTo + ", Time=" + Time  +"]";
}




}
