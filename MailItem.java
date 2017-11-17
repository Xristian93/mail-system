/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The text of the message.
    private String message;
    // The text of the subject.
    private String subject;
    private boolean encryptedMessage;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String subject, String message, boolean encryptedMessage)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.encryptedMessage = encryptedMessage;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The bollean of this message.
     */
    public boolean getBoolean()
    {
        return encryptedMessage;
    }

    /**
     * @return The subject of this message.
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
