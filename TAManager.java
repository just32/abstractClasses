
package taManager;

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
