package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
  private static Scanner scn = new Scanner(System.in);
  static ArrayList<Floor> hotel = new ArrayList<Floor>();
  public static void main(String[] args) {
    System.out.println("Enter number of floors in hotel");
    int numOfFoolrs = scn.nextInt();
    for(int i = 0;i< numOfFoolrs;i++)
    {
      Floor floor = new Floor();
      System.out.print("Enter number of rooms in floor number #" + (i+1) + ": ");
      ArrayList<Room> rooms = new ArrayList<>();
      int numofrooms = scn.nextInt();
      for(int j = 1 ; j <= numofrooms; j++)
      {
        Room rom = new Room();
        System.out.println("Enter information about the room");
        System.out.print("Enter room number-> " );
        int rn = scn.nextInt();
        System.out.print("Enter room Rate-> " );
        int roomRate = scn.nextInt();
        rom.setRoomNum(rn);
        rom.setRoomRate(roomRate);
        rom.setReservationStatus(false);
        rooms.add(rom);
      }
      floor.setRooms(rooms);
      hotel.add(floor);
    }
    while (true)
    {
      System.out.print("\nEnter your choice-> " );
      int choice = scn.nextInt();
      switch(choice)
      {
        case 1:
          System.out.print("\nEnter floor number-> " );
          int fn = scn.nextInt();
          System.out.print("\nEnter room number-> " );
          int rn = scn.nextInt();
          System.out.print("\nEnter room price-> " );
          double rp = scn.nextDouble();
          System.out.print("\nEnter number of days-> " );
          int days = scn.nextInt();
          int res = reserveRoom(fn,rn,rp,days);
          if(res != -1)
            System.out.println("\nOk, room is reserved");
          else
            System.out.println("\nsome thing error!");
          break;
        case 2:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          System.out.print("\nEnter room number-> " );
          rn = scn.nextInt();
          res = checkOut(fn,rn);
          if (res != -1 )
            System.out.println("\nOk, room is checked out");
          break;

        case 3:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          boolean ok = checkFloor(fn);
          if(ok)
            System.out.println("\nthe is room free");
          else
            System.out.println("\nthe is not room free");
          break;
        case 4:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          System.out.print("\nEnter room number-> " );
          rn = scn.nextInt();
          ok = checkRoom(fn,rn);
          if(ok)
            System.out.print("\nRoom is occuped" );
          else
            System.out.print("\nRoom is free" );break;
        case 5:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          int numOfFreeRoom = getFreeRooms(fn);
          if(numOfFreeRoom !=-1)
            System.out.println("\nnumber of free rooms in floor number # "+fn+" is: "+numOfFreeRoom);
          break;

        case 6:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          System.out.print("\nfloor number #" + fn + " has: \n" );
          showRoomsStatus(fn);
          break;

        case 7:
          System.out.print("\nEnter floor number-> " );
          fn = scn.nextInt();
          System.out.print("\nEnter room number-> " );
          rn = scn.nextInt();
          double charge = roomCharge(fn,rn);
          break;
        case 8: System.exit(0); break;
        default : System.out.println("Enter valid choice!" );break;
      }
    }
  }

  private static int reserveRoom(int fn, int rn,double numofdays,int days) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    int ret = 0;
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
      ret = -1;
    } else {
      Room r = null;
      ArrayList<Room> rom = f.getRooms();
      for (int i = 0; i < rom.size(); i++) {
        if (rom.get(i).getRoomNum()== rn) {
          r = rom.get(i);
          break;
        }
      }
      if (r == null) {
        System.out.println("\nsorry, room does not exist.");
        ret = -1;
      } else {
        if (r.isReservationStatus()) {
          System.out.println("\nsorry, room is already reserved.");
          ret = -1;
        } else {
          r.setReservationStatus(true);
          r.setNumOfDays(days);
          ret = 1;
        }
      }
    }
    return ret;
  }

  private static int checkOut(int fn, int rn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    int ret = 0;
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
      ret = -1;
    } else {
      Room r = null;
      ArrayList<Room> rom = f.getRooms();
      for (int i = 0; i < rom.size(); i++) {
        if (rom.get(i).getRoomNum()== rn) {
          r = rom.get(i);
          break;
        }
      }
      if (r == null) {
        System.out.println("\nsorry, room does not exist.");
        ret = -1;
      }
      else
      {
        if(r.isReservationStatus())
        {
          r.setReservationStatus(false);
          ret = 1;
        }
        else
        {
          System.out.println("room is already clear");
          ret = -1;
        }
      }
    }
    return ret;
  }

  private static boolean checkRoom(int fn, int rn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
    } else {
      Room r = null;
      ArrayList<Room> rom = f.getRooms();
      for (int i = 0; i < rom.size(); i++) {
        if (rom.get(i).getRoomNum()== rn) {
          r = rom.get(i);
          break;
        }
      }
      if (r == null) {
        System.out.println("\nsorry, room does not exist.");
      }
      else
      {
        if(r.isReservationStatus())
          return true;
        else
          return false;
      }
    }
    return false;
  }

  private static boolean checkFloor(int fn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    boolean ret = false;
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
    } else
    {
      for(int i = 0 ;i <f.getRooms().size();i++)
        if(f.getRooms().get(i).isReservationStatus() == false)
        {
          ret = true;
          break;
        }
    }
    return ret;
  }

  private static int getFreeRooms(int fn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    int ret = 0;
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
      ret = -1;
    } else
    {
      for(int i = 0 ;i <f.getRooms().size();i++)
        if(f.getRooms().get(i).isReservationStatus() == false)
        {
          ret++;
        }
    }
    return ret;
  }

  private static void showRoomsStatus(int fn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }

    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
    }
    else
    {
      ArrayList<Room> rms = f.getRooms();
      for(int i = 0; i < rms.size();i++)
      {
        Room r = rms.get(i);
        System.out.println("Room number is "+r.getRoomNum() + (r.isReservationStatus()?"occuped\n":"free\n"));
      }
    }

  }

  private static double roomCharge(int fn, int rn) {
    Floor f = null;
    for (int i = 0; i < hotel.size(); i++) {
      if (hotel.get(i).getFloorID() == fn) {
        f = hotel.get(i);
        break;
      }
    }
    double charge = 0.0;
    if (f == null) {
      System.out.println("\nsorry, floor does not exist.");
    } else {
      Room r = null;
      ArrayList<Room> rom = f.getRooms();
      for (int i = 0; i < rom.size(); i++) {
        if (rom.get(i).getRoomNum()== rn) {
          r = rom.get(i);
          break;
        }
      }

      if (r == null) {
        System.out.println("\nsorry, room does not exist.");
      }
      else
      {
        charge = r.getNumOfDays() * r.getRoomRate();
      }
    }
    return charge;

  }
}