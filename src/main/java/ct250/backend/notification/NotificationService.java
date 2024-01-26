package ct250.backend.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.ArrayList;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    private ArrayList<Notification> notifications;

    public NotificationService(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public NotificationService() {
        this.notifications = new ArrayList<>();
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setPayments(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Notification> findAllNotifications() {
        System.out.println("Call find all notifications function");
        this.notifications = (ArrayList<Notification>) notificationRepository.findAll();
        for (Notification a : notifications) {
            System.out.println(a.toString());
        }
        return notifications;
    }

    public Notification findNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @Transactional
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Transactional
    public Notification updateNotification(Long id, Notification notification) {
        Notification existingNotification = findNotificationById(id);
        if (existingNotification != null) {
            // Update fields based on your requirements
            existingNotification.setTitle(notification.getTitle());
            existingNotification.setContent(notification.getContent());
            // existingNotification.setDateTime(notification.getDateTime());
            existingNotification.setStatus(notification.getStatus());

            notificationRepository.save(existingNotification);
            return existingNotification;
        }
        return null;
    }

    @Transactional
    public boolean deleteNotification(Long id) {
        Notification resultFindNotification = findNotificationById(id);
        if (resultFindNotification != null) {
            notificationRepository.delete(resultFindNotification);
            return true;
        } else {
            return false;
        }
    }
}