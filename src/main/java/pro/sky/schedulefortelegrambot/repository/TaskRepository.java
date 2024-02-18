package pro.sky.schedulefortelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.schedulefortelegrambot.model.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<NotificationTask, Integer> {

}
