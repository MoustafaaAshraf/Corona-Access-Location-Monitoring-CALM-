 
/**
 * A class inherited from Pass class
 * Represents a pass which belongs to a researcher working at a given site
 * A Pass of a reasercher has an id number, name, a protection rating 
 * and number of hours, code of the project, name of the project.
 * @param id - The ID number of certain pass holder
 * @param protection_rating as an integer
 * @param The protection rating allowed for certain danger rooms as an integer
 * @param The allowable hours of working of the pass within the site as an integer
 * @param The hours left for this pass in the site as an integer
 * @param The name of the project team as a String
 * @param The number of the project team as an Integer
 * 
 * @author Moustafa Mahmoud
 * @version 10/1/2021
 */
public class Researcher extends Pass
{
    int code_of_project_team;
    String name_of_project_team;
    /**Initializes new instance/object of class Researcher which is a subclass of Pass
     * 
     * @param ID - The number of the id of the created pass
     * @param Protection_rating - The level of protection that the pass allowed to acces, ranges from 1 to 10s
     * @param Allowable_hours - The number of hours allowed for a certain pass in the site
     * @param Name_of_project_team - The name of the project team of a given assistance which is the pass holder, in the form of String
     * @param Code_of_project_team - The numerical representation of the project team that a given researcher belongs to, as an Integer
     */
    public Researcher(int ID, int Protection_rating, int Allowable_hours, 
    int Code_of_project_team, String Name_of_project_team)
    {
        super(ID, Protection_rating, Allowable_hours);
        this.code_of_project_team = Code_of_project_team;
        this.name_of_project_team = Name_of_project_team;
    }
    
    /**Accesses the string representaion of a certain Researcher pass
     * @return a string representation of the Researcher object as a String
     */
    public String toString(){
        return "This Pass ID number is "+ id +
        ", number of moves so far today is "+number_of_moves+
        ", number of hours left is "+hours_left +
        ", the protection rating is "+ protection_rating+
        ", the project team name is "+ name_of_project_team+
        ", the Code of the project team is "+ code_of_project_team+
        "\n*******\n";
    }
    
    /**Accesses the string representaion of a name of the team that the researcher belongs to
     * @return a string representation of the name of the team that the researcher belongs to
     */
    public String getProjectTeamName(){
        return "The name of the project of this researcher is "+
        name_of_project_team +
        "\n*******\n";
    }
}
