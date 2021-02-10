
public class chosenVaule {
	int idfrom;
	int idTo;
	int flag;
	
	public chosenVaule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chosenVaule(int idfrom, int idTo) {
		super();
		this.idfrom = idfrom;
		this.idTo = idTo;
		this.flag = 0;
	}
	@Override
	public String toString() {
		return "chosenVaule [idfrom=" + idfrom + ", idTo=" + idTo + ", flag=" + flag + "]";
	}
	public int getIdfrom() {
		return idfrom;
	}
	public void setIdfrom(int idfrom) {
		this.idfrom = idfrom;
	}
	public int getIdTo() {
		return idTo;
	}
	public void setIdTo(int idTo) {
		this.idTo = idTo;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	

}
