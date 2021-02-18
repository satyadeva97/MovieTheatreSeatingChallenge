import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import theatreSeating.Row;
import theatreSeating.Theatre;
import theatreSeating.TheatreInterface;

import static org.junit.Assert.assertEquals;

/**
 * test class to test different scenarios in filling the theatre.
 */
public class TheatreTest {

  TheatreInterface theatre;

  @Test
  public void testConstructor() {
    theatre = new Theatre(10);
    assertEquals(100, theatre.getTotalSeats());
  }

  @Test
  public void testTotalSeats() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    assertEquals(82, theatre.getTotalSeats());
  }

  @Test
  public void testGetRows() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    assertEquals(2, theatre.getRows().get(0).getSeatsEmpty());
  }

  @Test
  public void testFilling() {
    theatre = new Theatre(10);
    assertEquals("R001 A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,A13,A14\n",
            theatre.fillRows("R001", 15));
  }

  @Test
  public void testFillingMoreThanRemainingSeats() {
    theatre = new Theatre(10);
    assertEquals("R001 For bulk bookings, contact the customer service directly\n",
            theatre.fillRows("R001", 200));
  }

  @Test
  public void testIllegalArguments() {
    theatre = new Theatre(10);
    assertEquals("Either reservationNumber is null or number of seats is negative\n",
            theatre.fillRows("R001", -200));
  }

  @Test
  public void testFillingInDifferentRows() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    assertEquals("R001 A18,A19,C18,C19\n",
            theatre.fillRows("R001", 4));
  }

  @Test
  public void testSeatsGettingOver() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 4);
    theatre.fillRows("R001", 4);
    theatre.fillRows("R001", 2);
    assertEquals("R001 Sorry, the required number of seats are not available\n",
            theatre.fillRows("R001",1 ));
  }

  @Test
  public void testNotEnoughSeats() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 4);
    theatre.fillRows("R001", 4);
    assertEquals("R001 Sorry, the required number of seats are not available\n",
            theatre.fillRows("R001",4 ));
  }

  @Test
  public void testFillingToCapacity() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    assertEquals("R001 Sorry, the required number of seats are not available\n",
            theatre.fillRows("R001",1 ));
  }

  @Test
  public void testNodeCreation() {
    Row row = new Row('A');
    assertEquals(20, row.getSeatsEmpty());
  }

  @Test
  public void testFillInNode() {
    Row row = new Row('A');
    assertEquals("A0,A1",
            row.fillSeats(2,"R001",new AtomicInteger(20)));
  }

}
