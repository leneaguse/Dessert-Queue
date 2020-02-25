
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

import java.util.ArrayList;

public class DessertSolvers {
	/**
	 * Allows for an iteration of guests being served at a dinner table for one
	 * course
	 * 
	 * @param numberOfGuests - how many people at the table guestsSkipped - number
	 *                       of guests to skip to follow the algorithm
	 */
	public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) {
		// initializes parameter
		ServingQueue newTable = new ServingQueue(numberOfGuests);
		// creates the number of guests specified
		for (int i = 0; i < numberOfGuests; i++) {
			// creates new guest
			Guest guest = new Guest();
			// adds them to the table
			newTable.add(guest);
		}
		// initializes guestRemoved
		Guest guestRemoved = newTable.peek();
		// iterates through the numberOfGuests
		for (int i = 0; i < numberOfGuests - 2; i++) {
			// removes on guest
			newTable.remove();
			// iterates through the guests skipped
			for (int j = 0; j < guestsSkipped; j++) {
				// removes another guest
				guestRemoved = newTable.remove();
				// adds the guest back to continue the algorithm
				newTable.add(guestRemoved);
			}
		}
		return guestRemoved;

	}

	/**
	 * Allows for an iteration of guests being served at a dinner table for several
	 * courses, skipping one person
	 * 
	 * @param numberOfGuests - how many people at the table coursesServed - how many
	 *                       courses to be served
	 */
	public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) {
		// initializes parameters
		ServingQueue orgTable = new ServingQueue(numberOfGuests);
		ArrayList<Guest> newTable = new ArrayList<Guest>(numberOfGuests);
		Guest guestRemoved = null;
		Guest guestRemoved1 = null;
		// loops through and creates the number of guests
		for (int i = 0; i < numberOfGuests; i++) {
			// creates guests
			Guest guest = new Guest();
			// adds guests to the table
			orgTable.add(guest);
		}
		// loops through number of courses served
		for (int h = 0; h <= coursesServed; h++) {
			// loops through number of guests at the table
			for (int i = 0; i < numberOfGuests; i++) {
				// removes guest
				guestRemoved = orgTable.remove();
				// adds that removed guest to an arraylist
				newTable.add(guestRemoved);
				// checks if on last loops to avoid null pointer
				if (i == numberOfGuests - 1) {
					break;
				}
				// loops through number skipped (1)
				for (int j = 0; j < 1; j++) {
					// removes that person skipped
					guestRemoved1 = orgTable.remove();
					// adds back the person skipped
					orgTable.add(guestRemoved1);
				}
			}
			// reinitializes the orgtable
			orgTable = new ServingQueue(numberOfGuests);
			// loops through to adds from last served to first
			for (int i = (newTable.size() - 1); i >= 0; i--) {
				orgTable.add(newTable.get(i));
			}
			// reinitializes the newTable
			newTable = new ArrayList<Guest>(numberOfGuests);
		}
		return guestRemoved;
	}
}
