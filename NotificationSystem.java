abstract class Notification {
    public abstract void send(String message);
}

class EmailNotification extends Notification {
    public void send(String message) {
        System.out.println("Sending Email Notification" + message);
    }
}

class SMSNotification extends Notification {
    public void send(String message) {
        System.out.println("Sending SMS Notification" + message);
    }
}

class PushNotification extends Notification {
    public void send(String message) {
        System.out.println("Sending Push Notification" + message);
    }
}


class NotificationInfo {
    public static Notification getNotification(String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}


class NotificationSender {
    private final Notification notification;

    public NotificationSender(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification(String message) {
        notification.send(message);
    }
}


public class NotificationSystem {
    public static void main(String[] args) {
        Notification NewPolicy  = NotificationInfo.getNotification("email");
        NotificationSender hrSender = new NotificationSender(NewPolicy);
        hrSender.sendNotification("New policy update");

    
        Notification eventReminder = NotificationInfo.getNotification("sms");
        NotificationSender eventSender = new NotificationSender(eventReminder);
        eventSender.sendNotification("Reminder");

        Notification systemAlert = NotificationInfo.getNotification("push");
        NotificationSender itSender = new NotificationSender(systemAlert);
        itSender.sendNotification("Scheduled downtime");
    }
}