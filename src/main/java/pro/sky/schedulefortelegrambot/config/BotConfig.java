package pro.sky.schedulefortelegrambot.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Objects;

@Configuration
@PropertySource("application.properties")
public class BotConfig {
    @Value("${telegram.bot.name}")
    String botName;
    @Value("${telegram.bot.token}")
    String token;

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BotConfig botConfig = (BotConfig) o;
//        return Objects.equals(botName, botConfig.botName) && Objects.equals(token, botConfig.token);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(botName, token);
//    }
//
//    @Override
//    public String toString() {
//        return "BotConfig{" +
//                "botName='" + botName + '\'' +
//                ", token='" + token + '\'' +
//                '}';
//    }

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

}
