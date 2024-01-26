package ct250.backend.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping({ "/", "" })
    public String getAllNotification() {
        notificationService.findAllNotifications();
        String notificationList = "";
        for (Notification notification : notificationService.getNotifications()) {
            notificationList += "\n" + notification.toString();
        }
        return "Call find all notifications function " + notificationList;
    }

    @GetMapping("/id={id}")
    public String getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.findNotificationById(id);
        if (notification == null) {
            return "Call find notification by ID " + id + " function\nCan not found notification with id " + id;
        }
        return "Call find notification by ID " + id + " function\n" + notification.toString();
    }

    @DeleteMapping("/delete-id={id}")
    public String deleteNotificationById(@PathVariable Long id) {
        if (notificationService.deleteNotification(id)) {
            return "Call delete notification by ID " + id + " function\nNotification with id " + id
                    + " has been deleted!";
        } else if (notificationService.findNotificationById(id) == null) {
            return "Call delete notification by ID " + id + " function\nCan not found notification with id " + id;
        }

        return "Call delete notification by ID " + id + " function\n" + "Can not delete notification has id " + id;

    }

    @PutMapping("/update-id={id}")
    public String updateNotificationById(@PathVariable Long id, @RequestBody Notification notification) {
        if (notificationService.updateNotification(id, notification) != null) {
            return "Call update notification by ID " + id + " function\n"
                    + notificationService.updateNotification(id, notification).toString();
        }
        return "Call update notification by ID " + id + " function\n" + "Failed Update!!!Not found Notification";
    }

    @PostMapping("/add")
    public String addNotification(@RequestBody Notification notification) {
        notification = notificationService.addNotification(notification);
        if (notification == null) {
            return "Call add notification function \n" + "Add notification failed";
        }
        return "Call add notification function \n" + notification.toString();
    }
}
