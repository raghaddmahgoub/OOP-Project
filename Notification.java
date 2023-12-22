import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Notification {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    protected static int notificationID;
    protected String Content;
    protected Timestamp TimeStamp;
    protected boolean Recipient;




    //    Status
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Notification() {
        notificationID++;
    }
    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////////
    public static int getNotificationID() {
        return notificationID;
    }

    public Timestamp getTimeStamp() {
        return TimeStamp;
    }
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        //if user comment or reply or reacted or added or accepted or tagged another user (in the main class)
        Content = content;
    }

    public boolean isRecipient() {
        return Recipient;
    }

    public void setRecipient(boolean recipient) {
        Recipient = recipient;
    }


}
