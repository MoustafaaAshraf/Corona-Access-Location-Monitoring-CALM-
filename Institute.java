import java.util.*;

/**
 * An institute represents a site which consists of number of rooms and
 * and doors
 * There are regular doors and emergency doors which allows evacuation in the case
 * of emergency
 * @author Moustafa Mahmoud 
 * @version 8/1/2012
 **/
public class Institute implements CALM
{
    // declare your ArrayLists here
    public ArrayList<Pass> PASS = new ArrayList<Pass>();
    public ArrayList<Room> ROOM = new ArrayList<Room>();
    public ArrayList<Door> DOOR = new ArrayList<Door>();
    public ArrayList<Door> EDOOR = new ArrayList<Door>();
    
    /**Initializes new instance/object of class Institute
       * the constructor when deployed creates and loads a set of rooms and door and emergency door to the site
       * and addes them to lists for easy access to rooms and doors and emer
       * the constructor takes no parameters
       */
    public Institute() 
    {
        loadRooms();
        setUpDoors();
        loadPasses();
        setUpEmergencyDoors();
        // Now,add all passes to the Outside - Room 100
        for (Pass pass : PASS)
        {
            ROOM.get(0).enter(pass);
        }
    }
    
    /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     * @return all of the details of all rooms including location 
     * of all passes currently in each room, or "No passes" 
     */
    public String toString()
    {   
        String s = "";
        for (Room room: ROOM)
        {
            if (room.is_the_room_free() == false)
            {
                s = s + room.toString() + "\n\n" + room.who_is_in_room() + "\n*************\n" ;
            }
            else
            {
                s = s + room.toString() + "\n\n" + "No passes" + "\n*************\n" ;
            }
        }
        return s;
    }
    
    /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     * @return all of the details of all rooms including location 
     * of all passes currently in each room, or "No passes" 
     */
    public String roomsInInstitue()
    {   
        String s = "";
        for (Room room: ROOM)
        {
            s = s + room.toString() + "\n*************\n";
        }
        return s;
    }

    /**Returns a String representation of all the passes in all rooms
     * @return a String representation of all passes in all rooms, room code
     * and name should be included at the start of the list
     **/
    public String getAllPassesInAllRooms()
    {
        for (Room room: ROOM)
        {
            return room.who_is_in_room();
        }
        return "Can't do it";
    } 
 
    
    /**Returns the name of the room which contains the specified pass or null
     * @param ps - the specified pass
     * @return the number of the Room which contains the pass, or -1
     **/
    public int findPass(int ps)
    {
        for (Room room : ROOM)
        {
            if (room.is_this_pass_in_room(getPass(ps)))
            {
                return room.get_room_number();
            }
        }
        return -1;
    }
    
    /** Given the name of a room, returns the room code
     * or null if room does not exist
     * @param name of room
     * @return number of room, or -1 if the room does not exist
     */
    public int getRoomNo(String rm)
    {
        for (Room room : ROOM)
        {
            if (room.room_name == rm)
            {
                return room.room_number;
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all the passes in specified room
     * @roomCode the room code
     * @return a String representation of all passes in specified room, or
     * "No such room"
     **/
    public String getAllPassesInRoom(int rmNo)
    {
        for (Room room : ROOM)
        {
            if (room.room_number == rmNo)
            {
                return room.who_is_in_room();
            }
        }
        return "Can't do it";
    } 

    /** Returns a String with all of the details of a Pass
     * @param passNo is the pass number
     * @return all details of the Pass, or "No such Pass"
     */
    public String showPass(int pNo)
    {
        for (Pass pass : PASS)
        {
            if (pass.id == pNo)
            {
                return pass.toString();
            }
        }
        return "No such Pass";
    }
    
    /** Returns a String with all of the details of a Door
     * @param doorNo is the door number
     * @return all details of the door, or "No such Door"
     */
    public String showDoor(int dNo)
    {
        for (Door door : DOOR)
        {
            if (door.door_number == dNo)
            {
                return door.toString();
            }
        }
        return "No such Door";
    }
    
    /**Returns true if a Pass is allowed to move using the door, false otherwise
     * A move can be made if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return true if the pass is allowed in the move, false otherwise 
     **/
    public boolean canMove(int psId, int doorNo)
    {   //other checks optional
        Door door = getDoor(doorNo);
        Pass pass = getPass(psId);
        if (door.is_pass_allowed(pass)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }     

    /**Returns the result of a pass requesting to move by Door.
     * A move will be successful if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has sufficient hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * If the move can be made, the pass information is removed from the source
     * room, added to the destination room and a suitable message returned.
     * If move cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int psId, int doorNo)
    {   //other checks optional
        Door door = getDoor(doorNo);
        Pass pass = getPass(psId);
        if (door.is_pass_allowed(pass)==true)
        {
            door.move(pass);
            return "Access Accepted";
        }
        return "Can't do this";
    } 
         
    // These methods are for Task 6 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following number
   
    /** Resets all passes 
     */
    public void resetPasses()
    {
        for (Pass pass : PASS)
        {
            pass.reset_pass();
        }
    }
    
    /** Evacuates all passes from all rooms of the site into the outside in the case of emergency
     * if the room has no one in it or the room is the gathering point in the case of emergency, the 
     * room is ignored, however, is all other cases, every pass within any other room will be transfered through
     * the proper emergency door into the outside, which is the gathering point in the case 
     * of emergency
     */
    public void evacuation()
    {
        for (Room room : ROOM)
        {
            if (room.passes_in_room != 0 | room.room_number != 100)
            {
                ArrayList<Pass> copy = new ArrayList<Pass>();
                copy.addAll(room.list_passes_in_room);
                for (Pass pass : copy)
                {
                    for (Door edoor : EDOOR)
                    {
                        if (edoor.door_number == room.room_number)
                        {
                            edoor.move(pass);
                        }
                    }
                }
            }
            else
            {
                continue;
            }
        }
    }
   
 
    //***************private methods**************
    private void loadRooms()
    {
        //declare & create all Appendix A rooms
        Room Outside = new Room(100,"Outside" , 0, 0, 1000);
        Room Staff_room = new Room(101,"Staff Room" , 1, 1, 100);
        Room Lab1 = new Room(102,"Lab1" , 3, 3, 10);
        Room Virus_lab = new Room(103,"Virus Lab" , 5, 4, 2);
        Room Decontamination = new Room(104,"Decontamination " , 0, 0, 1);
        //add to collection of rooms
        ROOM.add(Outside);
        ROOM.add(Staff_room);
        ROOM.add(Lab1);
        ROOM.add(Virus_lab);
        ROOM.add(Decontamination);
    }
    
    private void setUpDoors()
    {
        //declare & create all Appendix A doors
        Door Door0 = new Door(0, ROOM.get(0), ROOM.get(1));
        Door Door1 = new Door(1, ROOM.get(1), ROOM.get(0));
        Door Door2 = new Door(2, ROOM.get(1), ROOM.get(2));
        Door Door3 = new Door(3, ROOM.get(2), ROOM.get(1));
        Door Door4 = new Door(4, ROOM.get(3), ROOM.get(1));
        Door Door5 = new Door(5, ROOM.get(1), ROOM.get(4));
        Door Door6 = new Door(6, ROOM.get(4), ROOM.get(1));
        Door Door7 = new Door(7, ROOM.get(2), ROOM.get(3));
        Door Door8 = new Door(8, ROOM.get(1), ROOM.get(3));
        
        //add to collection of rooms
        DOOR.add(Door0);
        DOOR.add(Door1);
        DOOR.add(Door2);
        DOOR.add(Door3);
        DOOR.add(Door4);
        DOOR.add(Door5);
        DOOR.add(Door6);
        DOOR.add(Door7);
        DOOR.add(Door8);
    }
    
    private void loadPasses()
    {
        //declare & create all Appendix A passes
        Pass Ali = new Pass(1000, 5, 10);
        Pass Bert = new Pass(1001, 3, 20);
        Pass Ceri = new Pass(1002, 10, 20);
        Pass Dana = new Pass(1003, 2, 12);
        Pass Eli = new Pass(1004, 3, 3);
        Pass Fred = new Pass(1005, 1, 5);
        Pass Gani = new Pass(1006, 10, 6);
        Pass Hui = new Pass(1007, 7, 20);
        Pass Imran = new Pass(1008, 6, 24);
        Assistant Sam = new Assistant(1009,7,20,"Dr.Hana");
        Researcher Jas = new Researcher(1010,7,15,333,"Queens");
        TeamLeader Sara = new TeamLeader(1011,5,10,35,300);
        //add to collection of passes
        PASS.add(Ali);
        PASS.add(Bert);
        PASS.add(Ceri);
        PASS.add(Dana);
        PASS.add(Eli);
        PASS.add(Fred);
        PASS.add(Gani);
        PASS.add(Hui);
        PASS.add(Imran);
        PASS.add(Sam);
        PASS.add(Jas);
        PASS.add(Sara);
    }
    
    private void setUpEmergencyDoors()
    {
        //declare & create all Appendix A passes
        Door emergency_door1 = new Door(101, ROOM.get(1), ROOM.get(0));
        Door emergency_door2 = new Door(102, ROOM.get(2), ROOM.get(0));
        Door emergency_door3 = new Door(103, ROOM.get(3), ROOM.get(0));
        Door emergency_door4 = new Door(104, ROOM.get(4), ROOM.get(0));
        //add to collection of passes
        EDOOR.add(emergency_door1);
        EDOOR.add(emergency_door2);
        EDOOR.add(emergency_door3);
        EDOOR.add(emergency_door4);
    }
 
    // some useful private methods for you to write the code
    /** Returns the pass with the pass id specified by the parameter
     * @return the pass with the specified id number
     **/
    public Pass getPass(int id)
    {
        for (Pass pass : PASS)
        {
            if (pass.id == id)
            {
                return pass;
            }
        }
        return null;
    }
    
    
    /** Returns the room with the name specified by the parameter
     * @param roomNo is the number of the required room
     * @return the room with the specified name
     **/
    private Room getRoom(int roomNo)
    {
        for (Room room : ROOM)
        {
            if (room.room_number == roomNo)
            {
                return room;
            }
        }
        return null;
    }
    
    /** Returns the room with the name specified by the parameter
     * @return the room with the specified name
     **/
    private Door getDoor(int dr)
    {
        for (Door door : DOOR)
        {
            if (door.door_number == dr)
            {
                return door;
            }
        }
        return null;
    }
}