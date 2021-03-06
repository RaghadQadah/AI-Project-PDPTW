import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;




import com.sun.javafx.runtime.SystemProperties;
import com.sun.media.jfxmedia.events.NewFrameEvent;

public class driver {

	static ArrayList<chosenVaule> chosenVaules;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int capcity = 0;
		int timer = 0;

		ArrayList<pickupNode> Pickups = new ArrayList<pickupNode>();
		ArrayList<deliveryNode> deliverys = new ArrayList<deliveryNode>();
		ArrayList<travelTime> travelTime = new ArrayList<travelTime>();

		File deliveryFile = new File("delivery.txt");
		File pickupFile = new File("pickup.txt");
		File travelTimeFile = new File("travelTime.txt");

		// read
		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(deliveryFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			String strArray[] = sc.nextLine().split(",");
			int id = Integer.parseInt(strArray[0]);
			int pickup_id = Integer.parseInt(strArray[1]);
			int load = Integer.parseInt(strArray[2]);
			int e_time = Integer.parseInt(strArray[3]);
			int l_time = Integer.parseInt(strArray[4]);

			deliverys.add(new deliveryNode(id, pickup_id, load, e_time, l_time));
		}

		// read pickup
		try {
			sc = new Scanner(pickupFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			String strArray[] = sc.nextLine().split(",");
			int id = Integer.parseInt(strArray[0]);
			int load = Integer.parseInt(strArray[1]);
			int e_time = Integer.parseInt(strArray[2]);
			int l_time = Integer.parseInt(strArray[3]);
			Pickups.add(new pickupNode(id, load, e_time, l_time));
		}

		// read travel time
		try {
			sc = new Scanner(travelTimeFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			String strArray[] = sc.nextLine().split(",");
			int idFrom = Integer.parseInt(strArray[0]);
			int idTo = Integer.parseInt(strArray[1]);
			int Time = Integer.parseInt(strArray[2]);
			travelTime.add(new travelTime(idFrom, idTo, Time));
		}

		
		chosenVaules = new ArrayList<chosenVaule>();

		

	    boolean res = csp(Pickups, deliverys, travelTime, timer, capcity);
		System.out.println(res);
		
//		System.out.println(next(3, travelTime, deliverys));
//		System.out.println(chosenVaules);
//		System.out.println(next(3, travelTime ,deliverys));
//		System.out.println(chosenVaules);
//		
	
			

	}

	public static int firstIndex(int id, ArrayList<travelTime> travelTime) {

		for (travelTime t : travelTime) {
			if (id == t.idFrom) {
				return travelTime.indexOf(t);
			}
		}
		return -1;
	}

	public static boolean isAllVisted(ArrayList<Boolean> visitisd) {

		for (Boolean d : visitisd) {
			if (d == false)
				return false;
		}
		return true;

	}

	public static int getTravelTime(int idfrom, int idto, ArrayList<travelTime> travelTime) {

		for (travelTime t : travelTime) {
			if (t.idFrom == idfrom && t.idTo == idto) {

				return t.Time;

			}
		}
		return -1;

	}

	public static boolean isChosen(int fromid, int toid) {

		for (chosenVaule c : chosenVaules) {
			if (fromid == c.idfrom && toid == c.idTo) {
				return true;
			}
		}

		return false;
	}

	public static nextState next(int id, ArrayList<travelTime> travelTime,ArrayList<deliveryNode> deliverys) {
		nextState temp = new nextState(travelTime.get(firstIndex(id, travelTime)).idFrom,
				travelTime.get(firstIndex(id, travelTime)).Time);
		

		int nextId = travelTime.get(firstIndex(id, travelTime)).idTo;	
		int time = getTravelTime(id, travelTime.get(firstIndex(id, travelTime)).idTo, travelTime);
		
	
		for (travelTime t : travelTime) {
			if (id == t.idFrom && time > getTravelTime(id, t.idTo, travelTime)
					&& (isChosen(id, t.idTo) == false && isChosen(t.idTo, id)==false)) {
               

				System.out.println("raghaaaaaaaaaaaaad");
				time = getTravelTime(id, t.idTo, travelTime);
				nextId = t.idTo;
			}

		}
		
		if(isChosen(id, nextId) == false &&isChosen(nextId, id) == false) {
		chosenVaules.add(new chosenVaule(id, nextId));
		chosenVaules.add(new chosenVaule(nextId, id));
		}
		
//		for (int i=travelTime.get(firstIndex(id, travelTime)).idFrom; i<= (deliverys.size()+1)+travelTime.get(firstIndex(id, travelTime)).idFrom ;i++) {
//			
//			for(chosenVaule c : chosenVaules) {
//			 if(travelTime.get(i).idTo!=c.idTo && travelTime.get(i).idFrom!=c.idfrom ) {
//				 temp = new nextState(nextId, time);
//					return temp;
//					 
//				 }
//				 
//        	 }    
//		}
//		
		 temp = new nextState(nextId, time);
		 return temp;

	}

	public static boolean isPickup(int id, ArrayList<pickupNode> Pickups) {

		for (pickupNode p : Pickups) {
			if (id == p.id) {
				return true;
			}
		}

		return false;
	}

	public static boolean isServe(int Pid, int Did, ArrayList<deliveryNode> deliverys,
			ArrayList<Integer> currentPickups) {

		for (deliveryNode d : deliverys) {
			if (Did == d.id && Pid == d.pickup_id && currentPickups.contains(Pid) == true) {
				return true;
			}
		}

		return false;
	}

	public static int getLateTime(int id, ArrayList<deliveryNode> deliverys) {

		for (deliveryNode d : deliverys) {
			if (id == d.pickup_id || id==d.id) {
				return d.l_time;

			}

		}
		return -1;
	}

	public static int getPickup(int id, ArrayList<deliveryNode> deliverys) {

		for (deliveryNode d : deliverys) {
			if (id == d.id) {
				return d.pickup_id;

			}

		}
		return -1;
	}

	public static int getEralyTime(int id, ArrayList<deliveryNode> deliverys) {

		for (deliveryNode d : deliverys) {
			if (id == d.id || id == d.pickup_id ) {
				return d.e_time;

			}

		}
		return -1;
	}
	
	
	public static ArrayList<Integer> removePickup(int id, ArrayList<Integer> currentPickups) {
	int index=-1;
		for(Integer c : currentPickups) {
			if (id==c) {
				 index=currentPickups.indexOf(c);
				
			}
		}
		
		if(index!=-1)
		currentPickups.remove(index);
		
		return currentPickups;

		
	}
	
public static void removeChosen(int id) {
		

		
		Iterator<chosenVaule> iterator = chosenVaules.iterator();
		while (iterator.hasNext()) {
		    if (iterator.next().idfrom==id) {
		    	System.out.println("remove");
		        iterator.remove();
		        
		    }
		  
		}

		
		
	}



	public static boolean csp(ArrayList<pickupNode> Pickups, ArrayList<deliveryNode> deliverys,
			ArrayList<travelTime> travelTime, int timer, int capicty) throws EmptyStackException {

		// System.out.println("before while");

		Stack<route> path = new Stack<route>();
		route temp = new route(0, 0, timer);

		path.push(temp);

		nextState temp2;

		ArrayList<Boolean> visitisd = new ArrayList<Boolean>(Arrays.asList(new Boolean[(Pickups.size() * 2) + 1]));

		Collections.fill(visitisd, Boolean.FALSE);
		System.out.println(visitisd);

		visitisd.set(0, true);

		ArrayList<Integer> currentPickups = new ArrayList<Integer>();

		while (!(path.isEmpty())) {

			System.out.println(path);

			temp = path.peek();
			int id = temp.Id; // current id
			int time = temp.totalTime;
			int c = temp.currentCapcity;

			int saveId = id;
			int savedTime = time;
			int savedC = c;

			temp2 = next(id, travelTime,deliverys);
			//System.out.println();
           // System.out.println(chosenVaules);
		
            if (temp2.Id == id ) {
			path.pop();
			continue;
			}
           
			
			if (isPickup(temp2.Id, Pickups)) {
				c = c + 20;
			}

			time = time + temp2.travelTime;

			temp = new route(temp2.Id, c, time);

			path.push(temp);
			
			System.out.println(temp2);


			
		    if (isPickup(temp.Id, Pickups) == true && time < getLateTime(temp.Id, deliverys) && c < 50
					&& visitisd.get(temp.Id) == false) {

				visitisd.set(temp.Id, true);
				currentPickups.add(temp.Id);
		
			}

			else if (time < getLateTime(temp.Id, deliverys) && c < 50 && visitisd.get(temp.Id) == false
					&& isServe(getPickup(temp.Id, deliverys), temp.Id, deliverys, currentPickups) == true) {

		

				if (time < getEralyTime(temp.Id, deliverys))
					time = time + (getEralyTime(temp.Id, deliverys) - temp.totalTime);
				

				visitisd.set(temp.Id, true);
				c = c - 20;
				route temp4 = path.peek();
				temp4.currentCapcity = c;
				path.pop();
				path.push(temp4);

			//	System.out.println(getPickup(temp.Id, deliverys));

				// currentPickups.remove(getPickup(temp.Id, deliverys));
				currentPickups.remove(new Integer(getPickup(temp.Id, deliverys)));
				// currentPickups= removePickup(getPickup(temp.Id, deliverys), currentPickups);

			}
			

			else {
				System.out.println(" else ");
				// visitisd.set(temp.Id, false);
				time = savedTime;
				c = savedC;
				//System.out.println(path);
				//System.out.println(chosenVaules);
				path.pop();
				
			}
		
		    
		    
		    if (isAllVisted(visitisd) == true) {
		    	
				System.out.println(path);
				
				return true;
			}

		    
		    
		}
			
			
	

		return false;

	}
}