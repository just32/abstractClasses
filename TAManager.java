//I pledge on my honor that I have not given or received any unauthorized assistance on this assignment/examination.
//Justin Frankle
//UID:114637642
//username:jfrankle
//section:0101

package taManager;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

public interface TAManager {

  public enum TAType { GRADUATE, UNDERGRADUATE }

  public String getCourseName();
  public boolean hireUndergraduateTA(String firstName, String lastName,
                                     double hourlySalary);
  public boolean hireGraduateTA(String firstName, String lastName,
                                double yearlySalary);
  public int numTAs();
  public int numTAs(TAType whichType);
  public int taCapacity();
  public boolean increaseTACapacity(int numTAsToAdd);
  public String getTANames();
  public boolean holdOfficeHours(String firstName, String lastName,
                                 int numHours);
  public int numOfficeHours(String firstName, String lastName);
  public boolean gradeProjects(String firstName, String lastName,
                               int numProjects);
  public int numProjectsGraded(String firstName, String lastName);
  public double getPay(String firstName, String lastName);

}
