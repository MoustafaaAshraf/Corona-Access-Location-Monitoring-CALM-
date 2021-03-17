import java.util.*;
/**
 * Each room has a name,  a protection rating, and a capacity which represents 
 * the maximum number of people(passes) who can be on the room at any one time. Each 
 * room must maintain a list of all people (passes)currently on the room. These lists 
 * are updated whenever passes enter or leave a room,so that it is always possible 
 * to say how many people (passes) are on the room and who they are.
 * 
 * @author Moustafa Mahmoud
 * @version 8/1/2021
 */

public class Room 
{
      int room_number;
      int protection_rating;
      int allowable_min_hours;
      int capacity;
      String room_name;
      public ArrayList<Pass> list_passes_in_room = new ArrayList<Pass>();
      public int passes_in_room = list_passes_in_room.size();
      /**Initializes new instance/object of class Door
         * @param Room_number - the number of the room created
         * @param Protection_rating - The level of protection rating or danger rating of the room, ranges from 1 to 10s
         * @param Room_name - a string represents the name of the room
         * @param Allowable_min_hours - the number of minimum hours allowed for any pass in the created
         * @param Capacity - the maximum number of people that could be in a room on a single instance 
         */
      public Room(int Room_number,String Room_name, int Protection_rating, int Allowable_min_hours, int Capacity) {
         this.room_number = Room_number;
         this.room_name = Room_name;
         this.protection_rating = Protection_rating;
         this.allowable_min_hours = Allowable_min_hours;
         this.capacity = Capacity;
      }
      
      
      
      //modifiers
      /**logs a pass into and updates the list of passes in room when a pass moved into the room
         * @param pass - an object of Class Pass, that has just been given access and moved into a specific room
         */
      public void enter(Pass pass)
      {
          list_passes_in_room.add(pass);
      }
      
      /**logs a pass out of and updates the list of passes in room when a pass moved out of the room
         * @param pass - an object of Class Pass, that has just been given access out of the room and moved into another room
         * prints out a message confirming that the pass has been granted access outside of the room
         */
      public void leave(Pass pass)
      {
          list_passes_in_room.remove(pass);
          System.out.println("Access outside of the room is Granted");
      }
      
      //accessors
      /**returns the number of passes logged into the list of passes in a room
         * @return an integer representing the number of rooms within a specific room object 
         */
      public int number_of_passes_in_room()
      {
          return list_passes_in_room.size();
      }
      
      /**returns whether a room is full or not
         * @return an boolean representation whether a room is true of not
         * true - the room is full
         * false - the room still has capacity
         */
      public boolean is_the_room_full()
      {
          if (passes_in_room == capacity){
          return true;
          }
          return false;
      }
      
      /**returns whether a certain pass is in room or not
         * @return an boolean representation whether the pass in the room or not
         * true - the pass is in the room
         * false - the pass is not in the room
         */
      public boolean is_pass_in_room(Pass pass)
      {
          if (list_passes_in_room.contains(pass))
          {
              return true;
          }
          return false;
      }
      
      /**returns whether a certain pass is in room or not
       * @return an boolean representation whether the pass in the room or not
       * true - the pass is in the room
       * false - the pass is not in the room
       */
      public boolean is_this_pass_in_room(Pass pass)
      {
          return list_passes_in_room.contains(pass);
      }
      
      /**returns whether a certain pass is in room or not
       * @return an boolean representation whether the pass in the room or not
       * true - the pass is in the room
       * false - the pass is not in the room
       */
      public boolean is_the_room_free()
      {
          return list_passes_in_room.size()==0;
      }
      
      /**returns string representations of all passes within this specific room
       * @return an string representation of all the passes in the room
       * if there is not passes in the room it return an empty string
       */
      public String who_is_in_room()
      {
          String s = "";
          for (Pass pass : this.list_passes_in_room)
          {
              s = s + pass.toString();
          }
          return s;
      }
      
      /**Accesses the room number of a certain room
       * @return room number of a room as integer
       */
      public int get_room_number()
      {
          return this.room_number;
      }
      
      /**Accesses the room name of a certain room
       * @return the name of a room as String
       */
      public String get_name()
      {
          return this.room_name;
      }
      
      /**Accesses the protection rating of a certain room
       * @return protection rating of a room as integer
       */
      public int get_protection_rating()
      {
          return this.protection_rating;
      }
      
      /**Accesses the allowable minimum hours of working of a certain room
       * @return the allowable minimum hours of a room as integer
       */
      public int get_allowable_min_hours()
      {
          return this.allowable_min_hours;
      }
      
      /**Accesses the capacity of a certain room, how many people could exist in a certain room at the same time
       * @return capacity of a room as integer
       */
      public int get_capacity()
      {
          return this.capacity;
      }
      
      /**Accesses the string representaion of a certain room
      * @return a string representation of the room as a String
      */
      public String toString()
      {
          return "1- This Room number is "+ room_number +"\n2- The room name is is "+room_name+"\n3- The protection rating of this room is "+protection_rating+"\n4- The capacity of this room is "+ capacity;
      }
}
