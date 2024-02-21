package pro.sky.schedulefortelegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.schedulefortelegrambot.model.NotificationTask;
import pro.sky.schedulefortelegrambot.repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BotService {
    private final static Pattern PATTERN = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)");

    private final TaskRepository repository;

    public BotService(TaskRepository repository) {
        this.repository = repository;
    }

    public boolean addTask(String task, int chatId){
        Matcher matcher = PATTERN.matcher(task);
        boolean result = matcher.matches();
        if (result) {
            String date = matcher.group(1);
            String item = matcher.group(3);
            LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            NotificationTask newTask = new NotificationTask(chatId, item, localDateTime);
            repository.save(newTask);
        }
        return result;
    }


    public List<NotificationTask> getNotifications(LocalDateTime dateTime) {
        return repository.findTaskByDate(dateTime);
    }
}


