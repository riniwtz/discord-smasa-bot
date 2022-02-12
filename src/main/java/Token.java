import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Token {
    private String botToken;

    public Token() {
        try {
            File directory = new File(System.getProperty("user.home") + "/Documents/SMASABot");
            FileReader reader = new FileReader(directory + "/config.json");
            JSONParser parser = new JSONParser();
            Object parserObject = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) parserObject;
            botToken = jsonObject.get("botToken").toString();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getBotToken() {
        return botToken;
    }
}
