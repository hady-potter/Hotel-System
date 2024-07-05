package hotel;
public class Room {
  private int roomNum;
  private boolean reservationStatus;
  private double roomRate;
  private int numOfDays;

  public double getRoomRate() {
    return roomRate;
  }

  public void setRoomRate(double roomRate) {
    this.roomRate = roomRate;
  }
  public Room()
  {

  }

  public int getRoomNum() {
    return roomNum;
  }

  public void setRoomNum(int roomNum) {
    this.roomNum = roomNum;
  }

  public boolean isReservationStatus() {
    return reservationStatus;
  }

  public void setReservationStatus(boolean reservationStatus) {
    this.reservationStatus = reservationStatus;
  }

  public int getNumOfDays() {
    return numOfDays;
  }

  public void setNumOfDays(int numOfDays) {
    this.numOfDays = numOfDays;
  }

}