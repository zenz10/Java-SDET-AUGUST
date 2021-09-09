package userregistration;

public class UserArray {
	
	private String fname;
	private String lname;
	private long pnumber;
	private String eaddress;
	private String uname;
	
	UserArray(String fname, String lname, long pcheck, String eaddress, String uname){
		this.fname = fname;
		this.lname = lname;
		this.pnumber = pcheck;
		this.eaddress = eaddress;
		this.uname = uname;
	}
	
		public String getFname() {
			return fname;
		}
		
		public String getLname() {
			return lname;
		}
		
		public long getPnumber() {
			return pnumber;
		}
	
		public String getEaddress() {
			return eaddress;
		}
		
		public String getUname() {
			return uname;
		}
		
		public String toString() {
			return fname+" "+lname+" "+pnumber+" "+eaddress+" "+uname;
		}
		
		
	public static void main(String[] args) {



	}

}
