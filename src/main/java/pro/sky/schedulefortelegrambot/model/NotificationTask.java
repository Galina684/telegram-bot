package pro.sky.schedulefortelegrambot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "notification_task")
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "chat_id")
    private Integer chatId;
    @Column(name = "text_Notification")
    private String textNotification;
    @Column(name = "date")
    private LocalDateTime date;

    public NotificationTask() {
    }

    public NotificationTask(Integer chatId, String textNotification, LocalDateTime date) {
        this.chatId = chatId;
        this.textNotification = textNotification;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getTextNotification() {
        return textNotification;
    }

    public void setTextNotification(String textNotification) {
        this.textNotification = textNotification;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return id == that.id && Objects.equals(chatId, that.chatId) && Objects.equals(textNotification, that.textNotification) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, textNotification, date);
    }

    @Override
    public String toString() {
        return "NotificationTask{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", textNotification='" + textNotification + '\'' +
                ", date=" + date +
                '}';
    }
}
