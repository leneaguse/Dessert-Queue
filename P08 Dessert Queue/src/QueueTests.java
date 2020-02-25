//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Dessert Queue
// Files:           N/A
// Course:          CompSci 300, Spring 2019
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class QueueTests {
	public static void main(String[] args) {
		System.out.println(addTooManyGuests());
		System.out.println(removeGuests());
		System.out.println(testToString());
		System.out.println(DessertSolvers.firstDessertVariableCourses(8, 3).toString());
		// System.out.println(DessertSolvers.firstDessertVariableSkips(8, 1));
	}

	/**
	 * Tests the implementation of adding too many guests to a table and catches the
	 * exception
	 * 
	 * @boolean test failed or test passed
	 */
	public static boolean addTooManyGuests() {
		// sets up parameters
		boolean tryCatch = false;
		ServingQueue newTable = new ServingQueue(3);
		Guest guestOne = new Guest();
		Guest guestTwo = new Guest();
		Guest guestThree = new Guest();
		Guest guestFour = new Guest();
		// adds three guests to table
		newTable.add(guestOne);
		newTable.add(guestTwo);
		newTable.add(guestThree);
		// tries to add a fourth guest
		try {
			newTable.add(guestFour);
		}
		// catches the exception that should be thrown
		catch (IllegalStateException e) {
			tryCatch = true;
		}
		// resets index
		guestThree.resetNextGuestIndex();
		return tryCatch;
	}

	/**
	 * Tests the implementation of removing a guest from a table
	 * 
	 * @boolean test failed or test passed
	 */
	public static boolean removeGuests() {
		// initializes parameters
		boolean tryCatch = false;
		boolean test3 = true;
		ServingQueue newTable = new ServingQueue(3);
		// tries to remove a guest from a empty table
		try {
			newTable.remove();
		}
		// correctly catches the exception
		catch (IllegalStateException e) {
			tryCatch = true;
		}
		// creates three new guests
		Guest guestOne = new Guest();
		Guest guestTwo = new Guest();
		Guest guestThree = new Guest();
		// adds the three guests to the table
		newTable.add(guestOne);
		newTable.add(guestTwo);
		newTable.add(guestThree);
		// removes the guest
		Guest guestRemoved = newTable.remove();
		// checks if the guest removed is the one expected
		if (guestRemoved != guestOne) {
			test3 = false;
		}
		// resets guest index
		guestOne.resetNextGuestIndex();
		return (tryCatch && test3);
	}

	/**
	 * Tests the implementation of outputting a guest to string format
	 * 
	 * @boolean test failed or test passed
	 */
	public static boolean testToString() {
		// initializes parameters
		boolean test4 = false;
		Guest guestOne = new Guest();
		Guest guestTwo = new Guest("no dairy");
		ServingQueue newTable = new ServingQueue(3);
		// adds two guests to the table
		newTable.add(guestOne);
		newTable.add(guestTwo);
		// gets the string version of the guests
		String s = newTable.toString();
		// checks if the output is as expected
		if (s.equals("[#1, #2(no dairy)]")) {
			test4 = true;
		}
		// resets the guest index
		guestOne.resetNextGuestIndex();
		return test4;
	}
}
