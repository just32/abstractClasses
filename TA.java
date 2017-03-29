
package taManager;

//This abstract class represents a generic TA, not specified between undergraduate or graduate 
public abstract class TA {
	
	private String firstName;
	private String lastName;
	private double salary;
	private int hours;
	private int projects;
	
	//creates an object with type TA
	public TA(String fn, String ln, double sal){
		firstName = fn;
		lastName = ln;
		salary = sal;
		hours = 0;
		projects = 0;
	}
	
	//returns TA's first name
	public String getFirstName(){
		return firstName;
	}
	
	//returns TA's last name
	public String getLastName(){
		return lastName;
	}
	
	//returns TA's salary
	public double getSalary(){
		return salary;
	}
	
	//returns number of hours worked by TA
	public int getHours(){
		return hours;
	}
	
	//returns number of projects graded by TA
	public int getProjects(){
		return projects;
	}
	
	//adds the given amount to projects
	public void addProjects(int proj){
		projects += proj;
	}
	
	//returns total hours worked
	public double getHoursWorked(){
		double time = 0;
		time = hours + projects * .5; //calculates total hours worked
		return time;
	}
	
	//adds given hours to "hours" variable if total hours does not exceed 20 
	public boolean officeHours(int time){
		if (getHoursWorked() + time > 20.0)
			return false;  //returns false if total is over 20
		else{
			hours += time;
			return true; //returns true if time is added
		}
	}
	
	public boolean gradeProj(int proj){
		if (getHoursWorked() + proj * .5 > 20) //checks to see if the new projects go over the limit 
			return false; //returns false if it goes over the limit
		else{
			projects += proj; //adds the projects if it does not go over
			return true; 
		}
	}
	
	//adds the given number of hours to "hours"
	public void addHours(int h){
		hours += h; 
	}
	
	//compares first and last names of TAs. returns zero if they are the same. returns -1 if compareTo() returns negative 
	//and returns positive if compareTo returns positive
	public int compareNames(TA other){
		if (this.getLastName().toLowerCase().equals(other.getLastName()) && this.getFirstName().toUpperCase()
				.equals(other.getFirstName()))
			return 0;       //returns zero if both names are the same
		else if(this.getLastName().toLowerCase().equals(other.getLastName().toLowerCase()))
			if (this.getFirstName().toLowerCase().compareTo(other.getFirstName().toLowerCase()) < 0) //checks to see which name 
				return -1;																		//comes first alphabetically 
			else 
				return 1;
		else
			if(this.getLastName().toLowerCase().compareTo(other.getLastName().toLowerCase()) < 0) //checks to see which name 
				return -1;																		//comes first alphabetically 
			else
				return 1;
	}
	
	//abstract method
	public abstract TAManager.TAType getType();
	
	//abstract method
	public abstract double payPeriod();
	
	
	
	
}



