import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    public Main() {
        try {
            JDA jda = JDABuilder.createDefault(new Token().getBotToken()).build();
            jda.addEventListener(new Task());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}