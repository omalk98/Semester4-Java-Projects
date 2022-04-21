package ca.seneca.A1;

/**
 * Maintains Person properties such as name and id
 * Implements login interface
 * Acts as a super class for shared functionality for different levels of user
 */
public class User {
    private final int m_id;
    private final String m_name;
    private final String m_password;

    public User(final int id, final String name, final String pass) {
        m_id = id;
        m_name = name;
        m_password = pass;
    }

}
