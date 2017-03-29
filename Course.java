
package taManager;

//this class represents a course at the university
//includes a department, course number, the max number of TAs, and an array of TA objects
public class Course implements TAManager{

	private String department;
	private int courseNumber;
	private int maxNumTAs;
	private TA[] TAs;
	
	public Course(String dep, int course, int max){
		department = dep;
		courseNumber = course;
		maxNumTAs = max;
		TAs = new TA[max];
	}

	//returns the course department and course number
	public String getCourseName() {
		return department + " " + courseNumber;
	}

	//adds an undergrad TA to TAs if it is not a duplicate and if there is space for a new TA
	public boolean hireUndergraduateTA(String firstName, String lastName, double hourlySalary) {
		if (firstName == null || lastName == null || hourlySalary <= 0)  
			return false;         //if either name is null or the salary is zero or below, return false
		for (TA t : TAs){
			if (t != null) //checks to make sure there is a TA object at this point in the array
				if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName))
					return false;   //if the names are both the same as a TA that already exists, return false
		}
		if (department.equals("CMSC")) //for CMSC classes
			if(TAs.length == this.numTAs()){  // if the TA array is full
				TA[] temp = new TA[TAs.length + 1];
				for (int i = 0; i < TAs.length; i++)
					temp[i] = TAs[i];  //copies TA array to new array that is one longer
				temp[TAs.length] = new UndergraduateTA(firstName, lastName, hourlySalary); //adds new TA
				TAs = temp;  
				maxNumTAs++; //adds one to the max number of TAs
				return true;
			}
			else{ // if TA array isn't full
				for (int i = 0; i < TAs.length; i++)
					if (TAs[i] == null){ // finds first empty index
						TAs[i] = new UndergraduateTA(firstName, lastName, hourlySalary); //adds new TA to that index
						return true;
					}
			}
		else{     //for non CMSC classes
			if (TAs.length == this.numTAs())//if TA array is full, return false
				return false;
			else{ // if TA array is not full
				for (int i = 0; i < TAs.length; i++)
					if (TAs[i] == null){ //finds first open index
						TAs[i] = new UndergraduateTA(firstName, lastName, hourlySalary); // adds new TA to index
						return true;
					}
			}
		}
		return false;
	}

	//adds a graduate TA to TAs if it is not a duplicate and if there is space for a new TA
	public boolean hireGraduateTA(String firstName, String lastName, double yearlySalary) {
		if (firstName == null || lastName == null || yearlySalary <= 0)  
			return false;         //if either name is null or the salary is zero or below, return false
		for (TA t : TAs){
			if (t != null) //checks to make sure there is a TA object at this point in the array
				if (t.getFirstName().equals(firstName) && t.getLastName().equals(lastName))
					return false;   //if the names are both the same as a TA that already exists, return false
		}
		if (department.equals("CMSC")) //for CMSC classes
			if(TAs.length == this.numTAs()){  // if the TA array is full
				TA[] temp = new TA[TAs.length + 1];
				for (int i = 0; i < TAs.length; i++)
					temp[i] = TAs[i];  //copies TA array to new array that is one longer
				temp[TAs.length] = new GraduateTA(firstName, lastName, yearlySalary); //adds new TA
				TAs = temp;  
				maxNumTAs++; //adds one to the max number of TAs
				return true;
			}
			else{ // if TA array isn't full
				for (int i = 0; i < TAs.length; i++)
					if (TAs[i] == null){ // finds first empty index
						TAs[i] = new GraduateTA(firstName, lastName, yearlySalary); //adds new TA to that index
						return true;
					}
			}
		else{     //for non CMSC classes
			if (TAs.length == this.numTAs())//if TA array is full, return false
				return false;
			else{ // if TA array is not full
				for (int i = 0; i < TAs.length; i++)
					if (TAs[i] == null){ //finds first open index
						TAs[i] = new GraduateTA(firstName, lastName, yearlySalary); // adds new TA to index
						return true;
					}
			}
		}
		return false;
	}

	// returns number of TAs in the course
	public int numTAs() {
		int num = 0;
		for (TA t : TAs)
			if(t != null)
				num++;  // adds one if the array index is not null
		return num;
	}

	//returns number of TAs in the course of the specified type 
	public int numTAs(TAType whichType) {
		int num = 0;
		for(int i = 0; i < TAs.length; i++)
			if (TAs[i] != null)  //checks to see if there is a TA at the index 
				if(TAs[i].getType() == whichType) //determines the TA's type
					num++;
		return num;
	}

	// returns the number of TAs possible for the course
	public int taCapacity() {
		return TAs.length;
	}

	//increases the capacity of TAs for a course by the given amount
	public boolean increaseTACapacity(int numTAsToAdd) {
		if (numTAsToAdd <= 0)
			return false; //returns false if "numTAsToAdd" is zero or less
		maxNumTAs += numTAsToAdd; //updates maxNumTAs
		TA[] temp = new TA[maxNumTAs];
		for (int i = 0; i < TAs.length; i++)
			if (TAs[i] != null)
				temp[i] = TAs[i]; //copies TAs from "TAs" to new array 
		TAs = temp; //makes "TAs" equal to the new sized array
		return true;
	}

	//returns all names of TAs in the course in alphabetical order by last name
	public String getTANames() {
		String names = "";
		int num = 0;
		for (int i = 0; i < TAs.length; i++)//finds number of TAs in array
			if (TAs[i] != null)
				num++;
		this.sortTAs(); //sorts TAs alphabetically
		for (int i = 0; i < num; i++){ //creates string with all TAs in alphabetical order
			if (i != num - 1)
				names += TAs[i].getFirstName() + " " + TAs[i].getLastName() + ", "; 
			if (i == num - 1)
				names += TAs[i].getFirstName() + " " + TAs[i].getLastName();  // for last TA so that there is no , at the end
		}
		return names;
	}

	//adds numHours hours to a TA's hours worked 
	public boolean holdOfficeHours(String firstName, String lastName, int numHours) {
		if (firstName == null || lastName == null || numHours <= 0)
			return false;              //if either name is null or numHours is zero or below return false
		for (TA t : TAs)
			if (t != null)
				if(isTA(firstName, lastName, t)) //checks to see if the ta exists
					return t.officeHours(numHours); 
		return false;  //returns false if the TA doesn't exist
	}

	//returns number of office hours held by the given TA if the TA exists 
	public int numOfficeHours(String firstName, String lastName) {
		if(firstName == null || lastName == null)
			return -1;  //returns -1 if firstname or lastname is null
		for (TA t : TAs)
			if (t != null)
				if (isTA(firstName, lastName, t)) //determines if the TA exists
					return t.getHours(); //returns TA's office hours 
		return -1; //returns -1 if the TA doesn't exist
	}

	//adds "numProjects" projects to the TA with the same names given
	public boolean gradeProjects(String firstName, String lastName, int numProjects) {
		if (firstName == null || lastName == null || numProjects <= 0) 
			return false;      //returns false if either name is null or numProjects is zero or below
		for (TA t : TAs)
			if (t != null)
				if (isTA(firstName, lastName, t)) //determines if the TA exists
					return t.gradeProj(numProjects); //returns true if the projects are added, false if they are not
		return false;       //returns false if the TA doesn't exist
	}

	//returns the number of projects graded by the TA with the given names
	public int numProjectsGraded(String firstName, String lastName) {
		if(firstName == null || lastName == null)
			return -1;  //returns -1 if either name is null
		for (TA t : TAs)
			if (t != null)
				if (isTA(firstName, lastName, t)) //determines if the TA exists
					return t.getProjects(); //returns the number of Projects graded
		return -1; //returns -1 if the TA doesn't exist
	}

	//gets the amount of money the given TA is payed for this pay period
	public double getPay(String firstName, String lastName) {
		if(firstName == null || lastName == null) 
			return 0.0; //returns 0.0 if either name is null
		for (TA t : TAs)
			if (t != null)
				if (isTA(firstName, lastName, t))//determines if the TA exists
					return t.payPeriod(); //returns the amount of money the TA is payed
		return 0.0; //returns 0.0 if the TA doesn't exist 
	}
	
	//sorts TAs in TA array alphabetically by last name
	private void sortTAs(){
		for (int i = 0; i < TAs.length - 1; i++)
			if (TAs[i] != null)
				for (int j = i + 1; j < TAs.length; j++)
					if (TAs[j] != null)
						if (TAs[i].compareNames(TAs[j]) > 0){ // compares the two TA's names 
							TA temp = TAs[i];
							TAs[i] = TAs[j];
							TAs[j] = temp;
						}
	}
	
	//returns true if a TA in the array has the specified first and last name, if not it returns false
	private boolean isTA(String first, String last, TA t){
			if (t != null)
				if (t.getFirstName().equals(first) && t.getLastName().equals(last))
					return true; // returns true if both names are the same
		return false;  //returns false if they are not the same
	}
	
}
