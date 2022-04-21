package ca.seneca.A1;

import java.util.Vector;

/**
 * Interacts with Books
 * Can Borrow & Return them
 */
public class Student extends User {
    private Vector<LibraryItem> m_borrowList;

    public Student(final int id, final String name, final String pass){
        super(id, name, pass);
    }

    /**
     * Adds item to Student's borrow list
     *
     * @param item Item to be Borrowed
     */
    public void addItem(LibraryItem item) {
        m_borrowList.add(item);
    }

    /**
     * Returns a borrowed book from the borrow list of the Student
     * @param item Item to be returned
     */
    public void returnItem(LibraryItem item) {
        m_borrowList.remove(item);
        item.returnItem();
    }
}
