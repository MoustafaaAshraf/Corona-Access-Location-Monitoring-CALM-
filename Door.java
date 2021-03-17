
/**
 * A door provides a one-way connection between two rooms. It
 * has a Door number and information about both the "from" and
 * the "to" room
 * 
 * @author Moustafa Mahmoud 
 * @version 8/1/2021
 */
public class Door
{
      int door_number;
      Room from_room;
      Room to_room;
      /**Initializes new instance/object of class Door
       * All door are one way for social distancing
       * @param Door_number - the number of the door created
       * @param From_room - an object of type Room, which indicates the room the person coming from
       * @param To_room - an object of type Room, which indicates the room the person going to
       */
      public Door(int Door_number, Room From_room, Room To_room) {
          this.door_number = Door_number;
          this.from_room = From_room;
          this.to_room = To_room;
      }
    
      /**Moves a pass requesting to move by Door.
       * A move will be successful if:  
       * the protection rating of the pass  >= the danger rating of the destination room
       * AND the destination room is not full
       * AND the pass has sufficient hours left >= limit of the destination room
       * AND the pass is currently in the source room
       * AND the pass id is for a pass in the system
       * AND the door number is the number for a door in the system
       * If the move can be made, the pass information is removed from the source
       * room, added to the destination room.
       * If move cannot be made, the state of the system remains unchanged
       * @param pass which is an object of type Pass, which is the pass trying to move from a room to another
       **/
      public void move(Pass pass)
      {
          if (pass.get_pass_protection_rating() >= to_room.get_protection_rating() &
          to_room.number_of_passes_in_room() < to_room.get_capacity() &
          pass.get_pass_hours_left() > to_room.get_allowable_min_hours() &
          from_room.is_this_pass_in_room(pass) == true &
          pass.get_pass_number_of_moves() <= 6 )
          {
              from_room.leave(pass);
              to_room.enter(pass);
              pass.new_move(to_room.allowable_min_hours);
          }
      }
      
      /**Returns true if a Pass is allowed to move using the door, false otherwise
       * A move can be made if:  
       * the protection rating of the pass  >= the danger rating of the destination room
       * AND the destination room is not full
       * AND the pass has hours left >= limit of the destination room
       * AND the pass is currently in the source room
       * AND the pass id is for a pass in the system
       * AND the door number is the number for a door in the system
       * @param and object if type Pass, which is the pass requesting the move
       * @return true if the pass is allowed in the move, false otherwise 
       **/
      public boolean is_pass_allowed(Pass pass)
      {
          if (pass.get_pass_protection_rating() >= to_room.get_protection_rating() &
          to_room.number_of_passes_in_room() < to_room.get_capacity() &
          pass.get_pass_hours_left() > to_room.get_allowable_min_hours() &
          from_room.is_this_pass_in_room(pass) == true &
          pass.get_pass_number_of_moves() <= 6 )
          {
              return true;
          }else{
              return false;
          }
      }
      
      /**Accesses the string representaion of a certain Door
       * @return a string representation of the Door as a String
       */
      public String toString()
      {
          return "The door gives access from room number "+from_room.room_number+" with name of "+from_room.room_name+"/nTo room number "+from_room.room_number+"with the name of "+to_room.room_name;
      }
}
