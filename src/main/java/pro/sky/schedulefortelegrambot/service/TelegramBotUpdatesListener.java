package pro.sky.schedulefortelegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    @Autowired
    private TelegramBot bot;
    @Autowired
    private BotService botService;


    @PostConstruct
    public void init() {
        bot.setUpdatesListener(this);
    }

    public int process(List<Update> updates) {
        for (Update update : updates) {
            Message msg = update.message();
            long chatId = update.message().chat().id();
            String taskMessage = msg.text();

            if ("/start".equals(taskMessage)) {
                String txtHello = "Приветствую! Чего изволите?";
                SendMessage sendMessage = new SendMessage(chatId, txtHello);
                bot.execute(sendMessage);
                    }
                    else{
                bot.execute(new SendMessage(chatId, "Ошибка формата ввода."));
                    }
                }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
