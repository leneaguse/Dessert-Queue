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

public class ServingQueue {
	private Guest[] array;
	private int guestsAtTable = 0;
	private int front = 0;
	private int back = 0;
	boolean firstGuest = true;

	/**
	 * Creates a new array based queue with a capacity of "seatsAtTable" guests.
	 * This queue should be initialized to be empty.
	 * 
	 * @param seatsAtTable the size of the array holding this queue data
	 */
	public ServingQueue(int seatsAtTable) {
		array = new Guest[seatsAtTable];
	}

	/**
	 * Checks whether there are any guests in this serving queue.
	 * 
	 * @return true when this queue contains zero guests, and false otherwise.
	 */
	public boolean isEmpty() {
		boolean isEmpty = false;
		// checks if the guest count is 0
		if (guestsAtTable == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

	/**
	 * Adds a single new guest to this queue (to be served after the others that
	 * were previously added to the queue).
	 * 
	 * @param newGuest is the guest that is being added to this queue.
	 * @throws IllegalStateException when called on a ServingQueue with an array
	 *                               that is full
	 */
	public void add(Guest newGuest) {
		// checks if the table is full
		if (guestsAtTable == array.length) {
			throw new IllegalStateException("Table is full");
		}
		// if table is empty, put the new guest at the first index
		if (firstGuest) {
			array[0] = newGuest;
			guestsAtTable++;
			firstGuest = false;
		}
		// if table has people, add to the back of the array
		else {
			// update back position
			back = (back + 1) % array.length;
			// put the guest at the back position
			array[back] = newGuest;
			guestsAtTable++;
		}
	}

	/**
	 * Accessor for the guest that has been in this queue for the longest. This
	 * method does not add or remove any guests.
	 * 
	 * @return a reference to the guest that has been in this queue the longest.
	 * @throws IllegalStateException when called on an empty ServingQueue
	 */
	public Guest peek() {
		// checks if array is empty
		if (isEmpty()) {
			throw new IllegalStateException("Table is empty");
		}
		// else return the guest at the front of the array
		return array[front];

	}

	/**
	 * Removes the guest that has been in this queue for the longest.
	 * 
	 * @return a reference to the specific guest that is being removed.
	 * @throws IllegalStateException when called on an empty ServingQueue
	 */
	public Guest remove() {
		// throws an exception if table is empty
		if (isEmpty()) {
			throw new IllegalStateException("No guests at table to be removed");
		}
		// gets guest from front position
		Guest guestToRemove = array[front];
		// changes that position to null
		array[front] = null;
		// update front index
		front = (front + 1) % array.length;
		// dec. guests at table
		guestsAtTable--;
		return guestToRemove;
	}

	/**
	 * The string representation of the guests in this queue should display each of
	 * the guests in this queue (using their toString() implementation), and should
	 * display them in a comma separated list that is surrounded by a set of square
	 * brackets. (this is similar to the formatting of
	 * java.util.ArrayList.toString()). The order that these guests are presented in
	 * should be (from left to right) the guest that has been in this queue the
	 * longest, to the guest that has been in this queue the shortest. When called
	 * on an empty ServingQueue, returns "[]".
	 * 
	 * @return string representation of the ordered guests in this queue
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// initialize string
		String s = "";
		// if empty, print []
		if (isEmpty()) {
			s = "[]";
		}
		// else print out guests according to format
		else {
			s = "[";
			for (int i = 0; i < guestsAtTable - 1; i++) {
				s += array[i].toString() + ", ";
			}
			s += array[guestsAtTable - 1].toString() + "]";
		}
		return s;
	}
}
