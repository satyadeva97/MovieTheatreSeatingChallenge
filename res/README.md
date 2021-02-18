# Movie Theatre Seating Challenge

This program implements an algorithm for assigning seats within a movie theatre to fulfill 
reservation requests. This program is designed giving the maximum preference to customer 
satisfaction and customer safety while assigning the seats.

## Usage

Run the .jar file MovieTheatreSeatingChallenge.jar using the below command
java -jar MovieTheatreSeatingChallenge.jar C:\Users\satya\Documents\Companies\Walmart\MovieTheatreSeatingChallenge\walmart\input.txt
This will run the program and the path to the output file will be printed on the console.



## Functionalities Available

It allows the users to book their seats and return them with the tickets or appropriate message if 
the seats are not available.

#### Classes:

1. Node: It represents a row in the theatre.
2. Theatre: It represents a theatre and contains a collection of multiple rows
3. TheatreInterface: represents an interface for the theatre which contains the necessary methods 
   to be implemented by all the classes extending this.
4. TheatreTest: test class to test different scenarios in the program.
5. Driver: This is where the execution of the program begins.

## Assumptions

1. Seats will be booked on a first-come first-serve basis.
2. People booking the seats first will get the seats far away from the screen and vice versa given 
   that those number of seats are available in those rows.
3. Preference will be given to book the seats in the same row for a particular booking if the seats 
   are available in a single row.
4. If the seats are not available in a single row, rows with maximum empty seats will be allotted 
   first and this continues until they get the required seats.
5. If the seats required are more than the number of empty seats, user will be informed that the
   required number of seats are not available.
6. If the number of seats required are more than 20, it comes under bulk booking and user will be
   asked to contact the customer directly to do bulk bookings.
   





