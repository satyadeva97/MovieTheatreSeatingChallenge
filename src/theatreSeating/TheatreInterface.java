package theatreSeating;

import java.util.List;

/**
 * Interface which represents a theatre.
 */
public interface TheatreInterface {

  /**
   * This method fills the available seats in the theatre based on the availability. Inorder to
   * maintain the safety, only alternate rows are filled and a minum gap of 3 seats is maintained
   * between two different bookings in the same row.
   * @param reservationNumber reservation number
   * @param numberOfSeats number of seats to be booked
   * @return returns a string representation of the tickets booked
   */
  String fillRows(String reservationNumber, int numberOfSeats);

  /**
   * method to get the total available seats in the theatre.
   * @return returns the total number of available seats.
   */
  int getTotalSeats();

  /**
   * method to find the available rows and their current status of booking.
   * @return returns all the available rows in the form of a list.
   */
  List<Row> getRows();

}
