package pro.sky.schedulefortelegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ScheduleTasks {

    private final TelegramBot telegramBot;
    private final BotService service;

    public ScheduleTasks(TelegramBot telegramBot, BotService service) {
        this.telegramBot = telegramBot;
        this.service = service;
    }

    @Scheduled(cron = "0 18 40 * 2 SUN")
    public void run() {
        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        service.getNotifications(dateTime).forEach(task ->
                telegramBot.execute(new SendMessage(task.getChatId(),
                        String.format("%s %s", task.getDate(), task.getTextNotification())))
        );
    }
}
