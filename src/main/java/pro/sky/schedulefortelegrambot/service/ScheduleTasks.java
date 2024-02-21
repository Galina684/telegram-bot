package pro.sky.schedulefortelegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ScheduleTasks {

    private final TelegramBot telegramBot;
    private final BotService service;
    private Logger logger = LoggerFactory.getLogger(ScheduleTasks.class);

    public ScheduleTasks(TelegramBot telegramBot, BotService service) {
        this.telegramBot = telegramBot;
        this.service = service;
    }

    @Scheduled(cron = "0 0/30 8-10 * * *")
    public void run() {
        logger.info("Выпоняется метод run");
        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        service.getNotifications(dateTime).forEach(task ->
                telegramBot.execute(new SendMessage(task.getChatId(),
                        String.format("%s %s", task.getDate(), task.getTextNotification())))
        );
    }
}
