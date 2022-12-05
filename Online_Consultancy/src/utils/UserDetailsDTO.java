package utils;



public class UserDetailsDTO {

	public static String Name;
	public static String EmailID;
	public static String mobileNO;
	public static String Password;
	public static String RePassword;
	
	
	public static String Fees;
	public static String ProgramName;
	
	public static String CourseName;
	public static String CourseTerm;
	
	
	public static String Univ1;
	
	public static String Univ2;

	public String[] strcanada = {"University Of Calgary", "University Of Toronto", "University Of Waterloo", "University Of Northeastern"};
    //initialize an immutable list from array using asList method
	public String[] strUSA = {"Texas University", "NorthEastren University", "Boston University", "Hardward University"};

	public String[] UOT = {"University_Ranking :  1", "University_Fee : $35,000", "Course_Ranking : 10"};
	public String[] UOC = {"University_Ranking :27", "University_Fee :$45,000", "Course_Ranking :92"};
	public String[] UOA = {"University_Ranking :4", "University_Fee :$43,000", "Course_Ranking :48"};

	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getRePassword() {
		return RePassword;
	}
	public void setRePassword(String rePassword) {
		this.RePassword = rePassword;
	}
	public String getFees() {
		return Fees;
	}
	public void setFees(String fees) {
		this.Fees = fees;
	}
	public String getProgramName() {
		return ProgramName;
	}
	public void setProgramName(String programName) {
		this.ProgramName = programName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		this.CourseName = courseName;
	}
	public String getCourseTerm() {
		return CourseTerm;
	}
	public void setCourseTerm(String courseTerm) {
		this.CourseTerm = courseTerm;
	}
	public  String getUniv1() {
		return Univ1;
	}
	public  void setUniv1(String univ1) {
		this.Univ1 = univ1;
	}
	public  String getUniv2() {
		return Univ2;
	}
	public  void setUniv2(String univ2) {
		this.Univ2 = univ2;
	}
	

}
