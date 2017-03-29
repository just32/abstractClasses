//I pledge on my honor that I have not given or received any unauthorized assistance on this assignment/examination.
//Justin Frankle
//UID:114637642
//username:jfrankle
//section:0101

package taManager;

//this class extends the TA class and represents a Graduate TA 
//adds TAType UNDERGRADUATE to the object
public class GraduateTA extends TA{
	
	private TAManager.TAType type;
	
	//creates instance of GraduateTA object
	public GraduateTA(String fn, String ln, double sal){
		super(fn, ln, sal);
		type = TAManager.TAType.GRADUATE;		
	}
	
	//gets hours worked for a Graduate TA object
	@Override
	public double getHoursWorked(){
		double time = 0;
		time = getHours() + getProjects() * .25; // calculates hours worked by TA
		return time;
	}
	
	//adds office hours to a Graduate TA object
	@Override
	public boolean officeHours(int time){
		addHours(time);
		return true;
	}
	
	//adds proj number of projects to "projects" if it doesn't go over the limit for a Graduate TA object
	@Override
	public boolean gradeProj(int proj){
		if (getProjects() + proj > 150) //checks to see if projects will go over its limit
			return false; //returns false if it goes over
		else{
			addProjects(proj); //adds specified number of projects 
			return true;
		}
	}
	
	//returns the TA's pay per period
	public double payPeriod(){
		double pay = 0.0;
		pay = getSalary() / 21; //calculates TA's pay for the current period
		return pay;
	}
	
	//returns the type of TA
	public TAManager.TAType getType(){
		return type;
	}
	
}
