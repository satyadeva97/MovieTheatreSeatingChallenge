package theatreSeating;

import java.util.concurrent.atomic.AtomicInteger;

public class TheatreTest {
  TheatreInterface theatre;

  public void testAll() {
    testConstructor();
    testFilling();
    testFillingInDifferentRows();
    testFillingMoreThanRemainingSeats();
    testFillingToCapacity();
    testSeatsGettingOver();
    testTotalSeats();
    testGetRows();
    testNotEnoughSeats();
    testNodeCreation();
    testFillInNode();
    testIllegalArguments();
  }

  public void testConstructor() {
    theatre = new Theatre(10);
    System.out.println(theatre.getTotalSeats()+"\n");
  }

  public void testTotalSeats() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    System.out.println(theatre.getTotalSeats()+"\n");
  }

  public void testGetRows() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    System.out.println(theatre.getRows().get(0).getSeatsEmpty()+"\n");
  }

  public void testFilling() {
    theatre = new Theatre(10);
    System.out.println(theatre.fillRows("R001", 15));
  }

  public void testFillingMoreThanRemainingSeats() {
    theatre = new Theatre(10);
    System.out.println(theatre.fillRows("R001", 200));
  }

  public void testFillingInDifferentRows() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R002", 15);
    theatre.fillRows("R003", 15);
    theatre.fillRows("R004", 15);
    theatre.fillRows("R005", 15);
    System.out.println(theatre.fillRows("R001", 4));
  }


  public void testSeatsGettingOver() {
    theatre = new Theatre(10);

    theatre.fillRows("R001", 15);
    theatre.fillRows("R002", 15);
    theatre.fillRows("R003", 15);
    theatre.fillRows("R004", 15);
    theatre.fillRows("R005", 15);
    theatre.fillRows("R006", 4);
    theatre.fillRows("R007", 4);
    theatre.fillRows("R008", 2);
    System.out.println(theatre.fillRows("R001",1 ));
  }


  public void testNotEnoughSeats() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 15);
    theatre.fillRows("R001", 4);
    theatre.fillRows("R001", 4);
    System.out.println(theatre.fillRows("R001",4 ));
  }


  public void testFillingToCapacity() {
    theatre = new Theatre(10);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    theatre.fillRows("R001", 20);
    System.out.println(theatre.fillRows("R001",1 ));
  }


  public void testNodeCreation() {
    Row row = new Row('A');
    System.out.println(row.getSeatsEmpty()+"\n");
  }

  public void testFillInNode() {
    Row row = new Row('A');
    System.out.println(row.fillSeats(2,"R001",new AtomicInteger(20))+"\n");
  }

  public void testIllegalArguments() {
    theatre = new Theatre(10);
    try {
      System.out.println(theatre.fillRows("R001", -200));
    } catch (IllegalStateException e) {
      System.out.println("Illegal argument exception");
    }

  }
}
