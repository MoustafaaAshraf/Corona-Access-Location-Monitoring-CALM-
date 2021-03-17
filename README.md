# Corona-Access-Location-Monitoring-CALM-

## Background

The Corona Institute, which is engaged in vital medical research, wishes to monitor and control access to the rooms and labs in its research division. This facility has a number of rooms connected by doors. Due to "social distancing" the doors are one-way only, providing a link FROM one room TO another. All rooms also have an emergency one-way door to the Outside, which can be used at any time. The doors are controlled by inserting a "Pass" into a pass reader which controls whether the doors will open to let staff through to the room on the other side, or not.

Staff members have a Pass which specifies the protection level of their personal equipment and the allowable number of hours which they can spend in the research facility in one day. They use their pass to control the doors. Each room has a danger rating. Staff are only allowed into the room if the protection level on their pass is greater than or equal to the danger level of the room they wish to enter. There are also a number of other safety regulations.

The Corona Institute must at all times know who is where in the research facility, in case an emergency occurs and personnel need to be evacuated.  In addition, it is vital that staff keep to health and safety regulations and do not exceed the number of hours allowed by the pass they have. When staff leave the research facility at the end of the day, their passes are reset to their allowable hours and zero moves

## System Requirements

1. The following basic functional requirements have been established for the proposed system:       
- List the location of all passes in all rooms at the Institute
- List all passes currently in a specified room
- Find the current location of a pass
- Authorise a door to open, if the required conditions are met
- Maintain information about hours worked and moves made  using a pass
- Reset passes
- Display information about passes

2. The application will have the following classes:

- Pass – used by staff for moving between rooms. A pass includes: a pass ID number, staff name, its protection rating, the allowable working hours, number of hours left to work and the number of moves made.
    - The Pass class constructor uses parameters to set the id, protection protection rating and allowable hours. It also sets the number of moves to zero and the number of working hours left to allowable hours. The protection protection rating (1 to 10) determines the rooms which the person with a pass is allowed to enter e.g. a pass with a protection rating of 3 is allowed to enter to all rooms with a danger rating of 3 or below.
    - Each move through a door increments "moves" by 1 and deducts a number of hours from hours left. To minimise contamination, staff are limited to 6 moves in one day. At the end of the day, passes are reset so that moves is set to zero and the hours left to allowable hours.


- Room – an Institute has a network of roomsEach room has a room number, a name, a danger rating, a capacity (the maximum number of passes that can be in the room at any one time) and the minimum allowable hours which a pass must have to enter a room. If the allowable hours left on a pass < the room's minimum hours, staff will not be allowed into the room.
    - Each room should maintain a collection of passes currently in that room. This collection should be updated whenever a pass enters or leaves a room, so that it is always possible to say who is currently in a room and to find the room that a pass is in. 
    
    
- Door – connects two rooms at the Institute
    - Each door has a number and connects a "from" room and a "to" room. It allows a move in one direction only. To make a move, certain conditions must be met.  If these conditions are met, the system allows the person with the pass through the door to move to the "to" room. It updates its records to show that a pass has left the "from" room and has gone into the "to" room. It also updates the pass's hours left by using the destination room's minimum hours and add 1 to the number of moves on the pass
        - A request for a pass to move through a door to a room, will produce one of the following results: 
        -   Refuse entry, because ONE of the conditions below are true
        -   the pass's protection rating is less than the danger rating of the "to" room. 
        -   the pass has insufficient hours left for work in the "to" room  (allowable hours < room's hours)
        -   the arrival of the pass would exceed the maximum capacity of the "to" room.
        -   the pass is NOT listed in the "from" room of the door 
        -   the pass has reached the 6 moves allowed 
        -   the pass id is NOT in the system
        -   the door number is NOT in the systemThese conditions can be handled by the Door, by calling methods in Pass, or Room classes
        -   Successful entry to the room, because none of the above conditions is true
        
        
- Institute - implements the CALM interface
    - The Institute has a network of rooms joined by one-way doors. It also has a collection of passes. An Institute must always have a room.100 with the name  "Outside" ,  a danger rating of 0 and a large maximum capacity. All passes at an Institute are initially added to this “Outside” room 100
    
    
![Capture](https://user-images.githubusercontent.com/75096393/111551756-d38d2500-8778-11eb-82ba-b9eeee3c50d5.JPG)
![Capture1](https://user-images.githubusercontent.com/75096393/111551796-eb64a900-8778-11eb-8f7e-541219027908.JPG)
