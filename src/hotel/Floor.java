package hotel;

import java.util.ArrayList;

public class Floor {
  private int floorID;
  private int numOfRooms;
  private ArrayList<Room> rooms;
  public Floor()
  {
    floorID = -1;

  }

  public int getFloorID() {
    return floorID;
  }

  public void setFloorID(int floorID) {
    this.floorID = floorID;
  }

  public int getNumOfRooms() {
    return numOfRooms;
  }

  public void setNumOfRooms(int numOfRooms) {
    this.numOfRooms = numOfRooms;
  }

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public void setRooms(ArrayList<Room> rooms) {
    this.rooms = rooms;
  }

}