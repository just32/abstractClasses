
package taManager;

//this class extends TA represents an undergraduate TA
//adds TAType UNDERGRADUATE to the object 
public class UndergraduateTA extends TA{
	
	private TAManager.TAType type;
	
	//creates instance of UndergraduateTA object
	public UndergraduateTA(String fn, String ln, double sal){
		super(fn, ln, sal);
		type = TAManager.TAType.UNDERGRADUATE;
	}
	
	//returns the type of TA
	public TAManager.TAType getType(){
		return type;
	}
	
	//returns the TA's pay for the current period
	public double payPeriod(){
		double pay = 0.0;
		pay = getHoursWorked() * getSalary(); //calculates pay for the pay period
		return pay;
	}
	
}
