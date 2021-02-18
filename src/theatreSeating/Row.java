package theatreSeating;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class which represents a row in a theatre.
 */
public class Row {

  private char name;
  private int seatsEmpty;
  private int indexFilled;
  private boolean isFilled;


  /**
   * constructor for the class which initializes the row with 20 empty seats and a name.
   * @param name Name of the row.
   */
  public Row(char name) {
    this.name = name;
    this.seatsEmpty = 20;
    this.indexFilled = -1;
  }

  /**
   * method to fill the seats in a particular row of the theatre.
   * @param numberOfSeats number of seats
   * @param reservationNumber reservation number
   * @param totalSeats total seats available before the booking
   * @return return a string representation of the booking
   */
  public String fillSeats(int numberOfSeats, String reservationNumber, AtomicInteger totalSeats) {

    StringBuilder result = new StringBuilder();
    int iterations = Math.min(numberOfSeats, seatsEmpty);
    result.append(name).append(++indexFilled);
    for (int i = 1; i < iterations; i++) {
      result.append("," + name).append(++indexFilled);
    }
    this.indexFilled += 3;

    this.seatsEmpty = this.seatsEmpty - (iterations + 3);
    totalSeats.set(totalSeats.intValue() - (iterations + (seatsEmpty < 0 ? (seatsEmpty + 3) : 3)));
    if (this.seatsEmpty < 0) {
      isFilled = true;
    }

    return result.toString();
  }

  /**
   * getter method to check whether the row is filled completely.
   * @return returns true if no more seats in the row are free.
   */
  public boolean isFilled() {
    return isFilled;
  }

  /**
   * method to get the name of the row.
   * @return name of the row.
   */
  public char getName() {
    return name;
  }

  /**
   * method to get the number of empty seats.
   * @return number of empty seats.
   */
  public int getSeatsEmpty() {
    return seatsEmpty;
  }

}
