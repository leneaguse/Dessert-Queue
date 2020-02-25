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

public class Guest {
	public static int numGuests = 0;
	private int index = 0;
	private String dietaryRestriction = "";

	/**
	 * Resets the counting of newly constructed guest indexes, so that the next new
	 * Guest that is created will be associated with the guest index of one.
	 * 
	 * Note: that this will be helpful when running several tests, or solving
	 * solving several dessert simulation problems. And that this should never be
	 * called from ServingQueue.java
	 */
	public static void resetNextGuestIndex() {
		numGuests = 0;
	}

	/**
	 * Constructs a new guest with no dietary restrictions. This guest should be
	 * associated with an index that is one larger than the previously constructed
	 * guest (or 1, if no prior guest, or if resetNextGuestIndex() was called more
	 * recently).
	 */
	public Guest() {
		numGuests++;
		this.index = numGuests;
	}

	/**
	 * Constructs a new guest with the specified dietary restrictions. This guest
	 * should be associated with an index that is one larger than the previously
	 * constructed guest (or 1, if no prior guest, or if resetNextGuestIndex() was
	 * called more recently).
	 * 
	 * @param dietaryRestriction describes requirements for what this guest can and
	 *                           cannot eat
	 */
	public Guest(String dietaryRestriction) {
		this.dietaryRestriction = dietaryRestriction;
		numGuests += 1;
		this.index = numGuests;
	}

	/**
	 * Access whether this guest has any dietary restrictions or not
	 * 
	 * @return true for guests constructed using new Guest(String), false otherwise
	 */
	public boolean hasDietaryRestriction() {
		if (this.dietaryRestriction.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * The string representation of a Guest should be formatted as, for examples:
	 * #3(no dairy) for a guest with a guest index of 3 and the dietary restriction
	 * of "no dairy", or: #4 for a guest with a guest index of 4 and no dietary
	 * restriction
	 * 
	 * @return string representing the guest index and any dietary restriction they
	 *         might have
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "#" + this.index;
		if (hasDietaryRestriction()) {
			s += "(" + this.dietaryRestriction + ")";
		}
		return s;
	}
}
