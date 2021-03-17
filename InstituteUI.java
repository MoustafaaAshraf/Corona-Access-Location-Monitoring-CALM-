import java.util.*;
/**
 * A class used to test CALM program.
 * It test all scenarios that could be faced when running a
 * site management situation
 * 
 * @author Moustafa Mahmoud
 * @version 9/1/2021
 */
public class InstituteUI
{
    
    private Scanner reader = new Scanner(System.in);
    private CALM corona = new Institute();
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllRooms();}
            else if (choice == 2){listAllPassesbyRoom();}
            else if (choice == 3){listOneRoom();}
            else if (choice == 4){findAPass();}
            else if (choice == 5){showAPass();}
            else if (choice == 6){tryMove();}
            else if (choice == 7){moveNow();}
            else if (choice == 8){resetAllPasses();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all room details");
       System.out.println("2. List all passes on each room");
       System.out.println("3. List all passes on one room");
       System.out.println("4. Find the current room of a pass");
       System.out.println("5. Show details of a pass");
       System.out.println("6. Say if pass can move through a door");
       System.out.println("7. Move a pass through door");
       System.out.println("8. ResetAllPasses");
       
       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllRooms()
    {
        System.out.println(corona.toString());
    }
    
    // provide the code here  
    private void listAllPassesbyRoom()
    {   
        System.out.println(corona.toString());
    }
   
    // provide the code here
    private void listOneRoom()
    {
        System.out.println("Enter room number");
        int rmNo = reader.nextInt();
        System.out.println(corona.getAllPassesInRoom(rmNo));
    }
    
    // provide the code here
    private void findAPass()
    {
        System.out.println("Enter pass id");
        int ps = reader.nextInt();
        System.out.println(corona.findPass(ps));
    }
    
    private void showAPass()
    {
        System.out.println("Enter pass id");
        int ps = reader.nextInt();
        System.out.println(corona.showPass(ps));
    }
    
    // provide the code here
    private void tryMove()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.canMove(trav,door));
    }
    
    // This one has been done for you 
    private void moveNow()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.move(trav,door));
    }
    
    // This one has been done for you 
    private void resetAllPasses()
    {
        corona.resetPasses();
    }
    
    
    public static void main(String[] args)
    {
        InstituteUI xx = new InstituteUI();
        xx.runUI();
    }
}
