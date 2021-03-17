
/**
 * A class inherited from Pass class
 * Represents a pass which belongs to a TeamLeader working at a given site
 * A Pass of a TeamLeader has an id number, name, a protection rating, number of staff, budget 
 * @param id - The ID number of certain pass holder
 * @param protection_rating as an integer
 * @param The protection rating allowed for certain danger rooms as an integer
 * @param The allowable hours of working of the pass within the site as an integer
 * @param The hours left for this pass in the site as an integer
 * @param number of staff is the number of people under the command of the given team leader
 * @param The budget of the team
 * 
 * @author Moustafa Mahmoud
 * @version 10/1/2021
 */
public class TeamLeader extends Pass
{
    int number_of_staff;
    int budget;
    //int Protection_rating = 10;
    /**Initializes new instance/object of class TeamLeader which is a subclass of Pass
     * 
     * @param ID - The number of the id of the created pass
     * @param Protection_rating - The level of protection that the pass allowed to acces, ranges from 1 to 10s
     * @param Allowable_hours - The number of hours allowed for a certain pass in the site
     * @param Number_of_staff - the number of people under the command of the given team leader as an integer
     * @param budget - The budget of the team, as an Integer
     */
    public TeamLeader(int ID, int Protection_rating, int Allowable_hours, int Number_of_staff, int Budget)
    {
        super(ID, Protection_rating, Allowable_hours);
        this.number_of_staff = Number_of_staff;
        this.budget = Budget;
        this.protection_rating = 10;
    }
    
    /**Accesses the string representaion of a certain TeamLeader
     * @return a string representation of the TeamLeader as a String
     */
    public String toString(){
        return "This Pass ID number is "+ id +
        ", number of moves so far today is "+number_of_moves+
        ", number of hours left is "+hours_left +
        ", the protection rating is "+ protection_rating+
        ", the number of staff in this team is "+ number_of_staff+
        ", the budget of the team is "+ budget+
        "\n*******\n";
    }
    
    /**A modifier aimed to change the number of the staff managed by a teamleader object
     * @param NoStaff - A new number of staff to be assigned to pre-existing TeamLeader object 
     */
    public void updateNumberOfStaff(int NoStaff)
    {
        this.number_of_staff = NoStaff;
    }
    
    /**A modifier aimed to change the amount of budget to a TeamLeader
     * @param NewBudget - A new amount of money to be assigned to pre-existing TeamLeader object 
     */
    public void updateBudget(int NewBudget)
    {
        this.budget = NewBudget;
    }
    
}
