import java.time.LocalDateTime;

public class Notification {
    ////////////////////////////////////////////**ATTRIBUTES**//////////////////////////////////////
    private static int notificationID;
    private String Content;
    private LocalDateTime TimeStamp;
    private boolean Recipient;


    //    Status
    //////////////////////////////////////////**CONSTRUCTORS**///////////////////////////////////////////
    public Notification() {
        notificationID++;
    }
    ////////////////////////////////////////////**METHODS**//////////////////////////////////////////////
    public static int getNotificationID() {
        return notificationID;
    }

    public LocalDateTime getTimeStamp() {
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
