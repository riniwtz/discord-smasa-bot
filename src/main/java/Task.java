import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.annotation.Nonnull;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task extends ListenerAdapter {
    String[] cmd;
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (!event.getMessage().getAuthor().isBot() && event.getChannel().getName().equals("smasa-bot")) {
            cmd = event.getMessage().getContentRaw().split(" ");
            switch (cmd[0]) {
                case "-getTask": {
                    if (cmd.length == 3) {
                        TextChannel textChannel = event.getJDA().getTextChannelsByName(cmd[1], false).get(0);
                        textChannel.sendMessageEmbeds(getEmbedTask(cmd[2]).build()).queue();
                    }
                }
            }
        }
    }

    public EmbedBuilder getEmbedTask(Object task) {
        try {
            File config = new File(System.getProperty("user.home") + "/Documents/SMASABot/config.json");
            if (config.exists()) {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(new FileReader(config));
                JSONObject jsonObject = (JSONObject) obj;
                JSONObject key = (JSONObject) jsonObject.get(task.toString());
                JSONObject title = (JSONObject) key.get("title");
                String titleName = title.get("name").toString();
                String titleUrl = title.get("url").toString();
                JSONObject authorObject = (JSONObject) key.get("author");
                String authorName = authorObject.get("name").toString();
                String authorUrl = authorObject.get("url").toString();
                String description = key.get("description").toString();
                String typeObject = key.get("type").toString().toUpperCase();
                String imageUrl = key.get("image").toString();
                String thumbnailUrl = key.get("thumbnail").toString();
                JSONObject fieldObject = (JSONObject) key.get("field");
                String fieldName = fieldObject.get("name").toString();
                String fieldValue = fieldObject.get("value").toString();

                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor(authorName, authorUrl);
                eb.setTitle(titleName, titleUrl);
                eb.setDescription(description);
                eb.setColor(54112207);
                eb.setImage(imageUrl);
                eb.setThumbnail(thumbnailUrl);
                eb.addField(typeObject, "", false);
                eb.addField(fieldName, fieldValue, false);
                return eb;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(String task) {
        return false;
    }
}

//
//                textChannel.sendMessageEmbeds(createTaskEmbed("Naanep, Maricel",
//                        "https://idiwa.com.ph/Genyolm006/Task/TK_NTasksByTeacherList.aspx?tpuid=eCViSfGCXeSt9YBDBdc12H6zXxLuthrMhS0UEIVd9MHK%2fiZRmWJrsA%3d%3d&backurl=TK_NTasksGrid.aspx",
//                        "female RS",
//                        "https://idiwa.com.ph/Genyolm006/homework/HW_NPreview.aspx?id=24386",
//                        """
//                                Feb 2 and 4 Async task
//                                Please Read Module 2 and answer and answer Activity 1,  Activity 2 and Evaluation and Assessment Part 1 and Part\s
//                                Compile your answer in a MS document
//                                """,
//                        020202,
//                        "https://media.discordapp.net/attachments/856920177270063134/942024142818009128/unknown.png",
//                        "https://lh3.googleusercontent.com/fife/AAWUweV_ER7TO_zNTxMUKctoIjL1EV7Fh1MnBhO2l9HiH8mbD49UNOdUkGyPsDkIjtv4UwuEvs8oTpBxp5WfTga8nyXLfUycz1MOShEI2sYCnDzRLxZpzcdFp1ZE0UkafUiAjhKi68x_7D4jDf-EGP6BokPI4Gtq0toy5HsDdHkOZnkiVlAoTkaUOnIuC1wR8GzOHqOxu1GJcBJhT0LeXUVKj63c1l56i0baVK37cDQsHBpVtzV3Rr5ZFJypWDi0lw2bgnsiEL7DxiP9WNjG4K2xFeH4oElrcHot9XNYz001zT3jYuFdMPZKdsQ0v8D1hJoQyXEsJ8jpqKrWGCMJVBerOdERPIm4wWcRRCuKmgAaJHDAI3QYFqyN51PuL3JO2aqd3Uk14dDRbCYRwxjYBfrcuZLWWwi1cZTaQdVfGmrRoRCV2BOFCEElYphoK7MJD9ue_jAFed_R-KxqmpedDwRt-UYwEwpqmphBb2W0XbMuIRo_tqSWAcLmQVkLKt9NjDvMKIScFhc712bZ2eBe8ajTi_B48rZNCGBkKJVFTQJlpruCXCy4WUmfKWJ6eEGoS3ZeEINI7tXBGJCTxXfgabWR83eIcKLgS_cSIFwyBSDp5OI-BChbLvP0PuBaJCvIsDCEGIUPtUKlQbJfYpcHuwd9HTHgO-UnnSdAnAgCU-MUGgOnn5DaCmdVcIrRBwujQzTu4Ugi0we2ayZoL2rjwN0sR6lCQkFM8SaLpQ=w1920-h929-ft",
//                        "February 12, 2022 11:59 PM").build()).queue();