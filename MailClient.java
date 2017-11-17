/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    private boolean encrypted;
    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else if (item.getBoolean() == true) {
            String message = "" + item.getMessage().replace("?\\", "a").replace("(\\", "e").replace(")\\", "i").replace("{\\", "o").replace("}\\", "u");
            boolean encryptedMessage = true;
            item = new MailItem(user, item.getTo(), item.getSubject(), message, encryptedMessage);
            server.post(item);
            item.print();
        }
        else if (item.getBoolean() == false){
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        boolean encryptedMessage2 = false;
        MailItem item = new MailItem(user, to, subject, message, encryptedMessage2);
        server.post(item);
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendEncryptedMailItem(String to, String subject, String message)
    {
        boolean encryptedMessage2 = true;
        String message2 = "?=?" + message.replace("a", "?\\").replace("e", "(\\").replace("i", ")\\").replace("o", "{\\").replace("u", "}\\");
        MailItem item = new MailItem(user, to, subject, message2, encryptedMessage2);
        server.post(item);
        encrypted = item.getBoolean();
    }
}
