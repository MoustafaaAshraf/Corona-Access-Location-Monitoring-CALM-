import java.util.*;
/**
 * PassTester is a class designed to test Pass class
 *
 * @author Moustafa Mahmoud
 * @version 8/1/2021
 */
public class PassTester
{
    public static void main(String[] args)
    {
        // Creating instances of Pass class with different configurations
        Pass pass1 = new Pass(1,5,10);
        Pass pass2 = new Pass(2,7,15);
        Pass pass3 = new Pass(3,8,20);
        Assistant assistant1 = new Assistant(0,0,0,"Dave");
        Researcher researcher1 = new Researcher(0,0,0,333,"Queens");
        TeamLeader teamleader1 = new TeamLeader(0,0,0,35,300);
        
        System.out.println(teamleader1.toString());
        System.out.println(assistant1.toString());
        
        // Testing specific attributes of the pre-defined instances
        System.out.println("pass1' protection rating is "+pass1.get_pass_protection_rating());
        System.out.println("pass2' id is "+pass2.get_pass_id());
        System.out.println("pass3' number of moves is "+pass3.get_pass_number_of_moves());
        
        // Moving a pass
        pass1.new_move(5);
        
        // Checking the pass details after one move
        System.out.println(pass2.toString());
        
        // checking specific attributes of a pass after one move
        System.out.println("pass1 number of moves after one move "+pass1.get_pass_number_of_moves());
        System.out.println("pass1 hours left after one move "+pass1.get_pass_hours_left());
        
        // restting a pass to its original configuration as initiated
        pass1.reset_pass();
        
        // Checking the number of movements of a pass after resetting
        System.out.println("pass1' number of moves is "+pass1.get_pass_number_of_moves());
    }
}
