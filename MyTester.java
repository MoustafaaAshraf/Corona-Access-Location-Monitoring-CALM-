import java.util.*;
/**
 * Write a description of class MyTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyTester
{
    private void doTest()
    {
        // write your tests here
        CALM site1 = new Institute();
        Scanner enter = new Scanner(System.in);
        
        // Showing all rooms in a given institute and showing passes within each room
        System.out.println("*********All Rooms**************");
        System.out.println(site1.toString());
        
        // Showing passes in a certain room
        System.out.println("****Passes in a certain room****");
        System.out.println("Checking passes in the outside where every one curruntly is");
        System.out.println(site1.getAllPassesInRoom(100));
        
        // Finding a Pass in which room, returns room number
        System.out.println("****Certain Pass in which room****");
        System.out.println("Checking pass id number 1000, should be in room number 100");
        System.out.println(site1.findPass(1000));
        
        // Getting details of a certain pass
        System.out.println("****Details of a certain Pass****");
        System.out.println("showing the details of pass number 1000 before any movement around the site");
        System.out.println(site1.showPass(1000));
        
        // Getting details of a certain door
        System.out.println("****Details of a certain Door****");
        System.out.println("showing the details of door number 0 that takes from outside to Staff room");
        System.out.println(site1.showDoor(0));
        
        // Asking if it is possible to move a certain pass through a certain door
        System.out.println("****Checking if a pass is allowed though a certain door****");
        System.out.println("is Bert allowed through door0?");
        System.out.println(site1.canMove(1001,0));
        
        // Actually moving a certain pass through a certain door
        System.out.println("****Moving a pass through a certain door****");
        System.out.println("moving Bert through door0 into room number 101");
        System.out.println(site1.move(1001,0));
        
        // Checking if Bert could be found in room number 101
        System.out.println("****Checking if Bert could be found in room number 101****");
        System.out.println("is Bert in room number 101?");
        System.out.println(site1.findPass(1001));
        
        // Getting details of a certain pass
        System.out.println("****Details of a Bert's Pass****");
        System.out.println("showing the details of pass number 1001 after one movement");
        System.out.println(site1.showPass(1001));
        
        // try moving a certain pass through a certain door into a room of higher protection level
        System.out.println("****trying to move a pass through a certain door to a room of higher protection rating****");
        System.out.println("try moving Bert through door8 into room number 103");
        System.out.println(site1.move(1001,8));
        
        // test if you can't move a pass into a room of full capacity
        System.out.println("Bert in is room 101");
        System.out.println("Moving Ali into room number 101, through door0");
        System.out.println(site1.move(1000,0));
        System.out.println("Bert and Ali are  in room 101");
        System.out.println("Moving Bert into room number 104, through door5");
        System.out.println(site1.move(1001,5));
        System.out.println("Room 104 is now full");
        System.out.println("Asking if it is possible to move Ali into room number 104, through door5");
        System.out.println("It should not be possible and the response is false");
        System.out.println(site1.canMove(1000,5));
        
        // Checking if a pass ran out of working hours 
        System.out.println("Moving Eli into room number 101, through door0");
        System.out.println(site1.move(1004,0));
        System.out.println("Asking if it is possible to move Eli into room number 102, through door2");
        System.out.println("It should not be possible and the response is false");
        System.out.println(site1.canMove(1004,2));
        
        //Moving as assistant into Staff Room through door0
        System.out.println("Moving Sam into room number 101, through door0");
        System.out.println(site1.move(1009,0));
        System.out.println("Moving Sam into room number 102, through door2");
        System.out.println(site1.move(1009,2));
        System.out.println("Moving Jas into room number 101, through door0");
        System.out.println(site1.move(1010,0));
        
        
        // Showing all rooms in a given institute and showing passes within each room
        System.out.println("*********All Rooms**************");
        System.out.println(site1.toString());
        
        // Evacuation of all people from the site into the outside
        System.out.println("Evacuation of all people from the site into the outside");
        site1.evacuation();
        
        // Showing all rooms in a given institute and showing passes within each room
        System.out.println("*********All Rooms**********");
        System.out.println("All passes should be on the outside");
        System.out.println(site1.toString());
        
        // Resetting all passes
        System.out.println("****Resetting all passes****");
        site1.resetPasses();
        
        // Getting details of a certain pass
        System.out.println("****Details of a certain Pass****");
        System.out.println("showing the details of pass number 1000 after resetting");
        System.out.println(site1.showPass(1000));
        
        // Getting details of a certain pass
        System.out.println("****Details of a certain Pass****");
        System.out.println("showing the details of pass number 1000 after resetting");
        System.out.println(site1.showPass(1009));
    }
     
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
