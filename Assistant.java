
/**
 * Represents a pass which belongs to an indiviual of the designation "Assistant" working at a given site
 * Assistant is a subclass inherited from from class Pass
 * An Assistant object has an id number, a protection rating, a number of hours and the name of her/his supervisor.
 * @param id - The ID number of certain pass holder
 * @param protection_rating as an integer
 * @param The protection rating allowed for certain danger rooms as an integer
 * @param The allowable hours of working of the pass within the site as an integer
 * @param The hours left for this pass in the site as an integer
 * @param The name of the Supervisor as a string
 * @author Moustafa Mahmoud 
 * @version 10/1/2021
 */
public class Assistant extends Pass
{
    String name_of_supervisor;
    /**Initializes new instance/object of class Assistant which is a subclass of Pass
     * 
     * @param ID - The number of the id of the created pass
     * @param Protection_rating - The level of protection that the pass allowed to acces, ranges from 1 to 10s
     * @param Allowable_hours - The number of hours allowed for a certain pass in the site
     * @param Name_of_supervisor - The name of the supervisor of a given assistance which is the pass holder, in the form of String
     */
    public Assistant(int ID, int Protection_rating, int Allowable_hours,
    String Name_of_supervisor)
    {
        super(ID, Protection_rating, Allowable_hours);
        this.name_of_supervisor = Name_of_supervisor;
        this.allowable_hours = 7;
        this.hours_left = 7;
    }
    
    /**Accesses the string representaion of a certain Assistant pass
     * @return a string representation of the assistant object as a String
     */
    public String toString(){
        return "This Pass ID number is "+ id +
        ", number of moves so far today is "+number_of_moves+
        ", number of hours left is "+hours_left +
        ", the protection rating is "+ protection_rating+
        ", the name of supervisor is "+ name_of_supervisor+
        "\n*******\n";
    }
    
    /**A modifier aimed to change the name of the supervisor of an assitant object
     * @param supervisor - the string representation of the name of the new supervisor of an already existant assitant object with a previously set supervisor name
     */
    public void changeNameOfSupervisor(String supervisor)
    {
        this.name_of_supervisor = supervisor;
    }
    
}
