package ca.seneca.A1;

import java.util.Vector;

/**
 * Defines the content type for the library item
 */
enum ItemType {
    DOCUMENT, MAGAZINE, BOOK, MOVIE
}

/**
 * Has common functionality for an item in a library
 * Can be borrowed, returned, categorized, add a waiting list for pickup
 */
public class LibraryItem {
    private final int m_itemID;
    private final String m_title;
    private final ItemType m_type;
    private boolean m_borrowed;
    private Vector<Student> m_waitingList;

    public LibraryItem(final int id, final ItemType type, final String title) {
        m_itemID = id;
        m_type = type;
        m_title = title;
        m_borrowed = false;
        m_waitingList = new Vector<>(0);
    }

    /**
     * Returns the current state of the library item
     *
     * @return Borrowed state
     */
    public final boolean isBorrowed() {
        return m_borrowed;
    }

    /**
     * Sets library item state to currently borrowed
     */
    public void borrowItem(Student student) {
        if(!m_borrowed && m_waitingList.elementAt(0) == student){
            m_borrowed = true;
            student.addItem(this);
        }
        else addStudent(student);
    }

    /**
     * Returns an item and removes the first student from the waiting list
     */
    public void returnItem() {
        if(m_borrowed) {
            m_borrowed = false;
            m_waitingList.remove(0);
        }
    }

    /**
     * Returns the library item ID
     *
     * @return Item ID
     */
    public final int getItemID(){
        return m_itemID;
    }

    /**
     * Returns the library item title
     *
     * @return Book title
     */
    public final String getTitle() {
        return m_title;
    }

    /**
     * Returns the library item type
     * @return Item type
     */
    public final ItemType getType() {
        return m_type;
    }

    /**
     * Returns the current student waiting list for the library item
     *
     * @return Waiting list
     */
    public final Vector<Student> getWaitingList() {
        return m_waitingList;
    }

    /**
     * Adds a student to the waiting list for a library item
     *
     * @param student student to be added to list
     */
    public void addStudent(Student student) {
        m_waitingList.add(student);
    }
}
