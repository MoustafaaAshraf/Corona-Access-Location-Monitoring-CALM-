
/**
 * Represents a pass which belongs to an indiviual working at a given site
 * A Pass has an id number, name, a protection rating and number of hours.
 * @param id - The ID number of certain pass holder
 * @param protection_rating as an integer
 * @param The protection rating allowed for certain danger rooms as an integer
 * @param The allowable hours of working of the pass within the site as an integer
 * @param The hours left for this pass in the site as an integer
 * @param The name of the pass holder as a string
 * @author Moustafa Mahmoud 
 * @version 8/1/2021
 */
public class Pass 
{
    int id; //The ID number of certain pass holder//
    int protection_rating; // The protection rating allowed for certain danger rooms
    int allowable_hours; // 
    int number_of_moves = 0;
    int hours_left;
    String staff_name;

    //constructors
    /**Initializes new instance/object of class Pass
     * @param ID - the number of the id of the created pass
     * @param Protection_rating - The level of protection that the pass allowed to acces, ranges from 1 to 10s
     * @param Allowable_hours - the number of hours allowed for a certain pass in the site
     */
    public Pass(int ID, int Protection_rating, int Allowable_hours) {
        this.id = ID;
        this.protection_rating = Protection_rating;
        this.allowable_hours = Allowable_hours;
        this.hours_left = Allowable_hours;
    }

    /**Initializes new instance/object of class Pass
     * @param ID - the number of the id of the created pass
     * @param Protection_rating - The level of protection that the pass allowed to acces, ranges from 1 to 10s
     * @param Allowable_hours - the number of hours allowed for a certain pass in the site
     * @param Staff_name - The name of the pass holder
     */
    public Pass(int ID, int Protection_rating, int Allowable_hours, String Staff_name) {
        this.id = ID;
        this.protection_rating = Protection_rating;
        this.allowable_hours = Allowable_hours;
        this.hours_left = Allowable_hours;
        this.staff_name = Staff_name;
    }

    // modifiers
    /**increases the number of moves between rooms, when called, that is of every individual pass
     * @return the number of moves so far
     */
    private int increment_moves()
    {
        number_of_moves+=1;
        return number_of_moves;
    }

    /**Logs in the details of every move, by incrementing the number of moves so far and deducting the hours worked of a specific room
     * @param min_of_room - The minimum number of hours allowed in a specific room on the site
     */
    public void new_move(int min_of_room) {
        number_of_moves = this.increment_moves();
        hours_left -= min_of_room;
    }

    /**Resetting the details of a pass to the original configuration when the object was craeted, gets called at the end of a working day
     */
    public void reset_pass(){
        this.hours_left = allowable_hours;
        this.number_of_moves = 0;
    }
    
    
    /**Modifies the hours left of working of a certain pass
     * @param the number of hours to be deducted from a certain pass
     * 
     */
    public void deductHours(int hours) {
        hours_left -= hours;
    }
    // accessors
    /**Accesses the id number of a certain pass
     * @return id number of a pass as integer
     */
    public int get_pass_id(){
        return this.id;
    }

    /**Accesses the protection rating of a certain pass
     * @return the protection rating of a pass as integer
     */
    public int get_pass_protection_rating(){
        return this.protection_rating;
    }

    /**Accesses the hours left of working of a certain pass
     * @return the hours left of working of a pass as integer
     */
    public int get_pass_hours_left(){
        return this.hours_left;
    }

    /**Accesses the number of moves around the site so far today of a certain pass
     * @return the number of moves around the site so far today of a pass as integer
     */
    public int get_pass_number_of_moves(){
        return number_of_moves;
    }
    
    /**Accesses the hours left of working of a certain pass
     * @return whether the pass has hours left of working or not as boolean
     * 
     */
    public boolean does_pass_has_hours_left(){
        if (this.hours_left > 0)
        {
            return true;
        }
        return false;
    }

    /**Accesses the string representaion of a certain pass
     * @return a string representation of the pass as a String
     */
    public String toString(){
        return "This Pass ID number is "+ id +", number of moves so far today is "+number_of_moves+", number of hours left is "+hours_left +" The protection rating is "+ protection_rating+ "\n*******\n";
    }
}

