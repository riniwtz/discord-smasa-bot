import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Task extends ListenerAdapter {
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if (!event.getMessage().getAuthor().isBot()) {
            if (event.getChannel().getName().equals("smasa-bot")) {
                if (event.getMessage().getContentRaw().equals("-getEmbed genyo-archives illustratingPermutationOfObjects")) {
                    TextChannel textChannelList = event.getJDA().getTextChannelsByName("genyo-archives", false).get(0);
                    textChannelList.sendMessageEmbeds(createTaskEmbed("Naanep, Maricel",
                            "https://idiwa.com.ph/Genyolm006/Task/TK_NTasksByTeacherList.aspx?tpuid=eCViSfGCXeSt9YBDBdc12H6zXxLuthrMhS0UEIVd9MHK%2fiZRmWJrsA%3d%3d&backurl=TK_NTasksGrid.aspx",
                            "female RS",
                            "https://idiwa.com.ph/Genyolm006/homework/HW_NPreview.aspx?id=24386",
                            """
                                    Feb 2 and 4 Async task          
                                    Please Read Module 2 and answer and answer Activity 1,  Activity 2 and Evaluation and Assessment Part 1 and Part\s                       
                                    Compile your answer in a MS document
                                    """,
                            020202,
                            "https://media.discordapp.net/attachments/856920177270063134/942024142818009128/unknown.png",
                            "https://lh3.googleusercontent.com/fife/AAWUweV_ER7TO_zNTxMUKctoIjL1EV7Fh1MnBhO2l9HiH8mbD49UNOdUkGyPsDkIjtv4UwuEvs8oTpBxp5WfTga8nyXLfUycz1MOShEI2sYCnDzRLxZpzcdFp1ZE0UkafUiAjhKi68x_7D4jDf-EGP6BokPI4Gtq0toy5HsDdHkOZnkiVlAoTkaUOnIuC1wR8GzOHqOxu1GJcBJhT0LeXUVKj63c1l56i0baVK37cDQsHBpVtzV3Rr5ZFJypWDi0lw2bgnsiEL7DxiP9WNjG4K2xFeH4oElrcHot9XNYz001zT3jYuFdMPZKdsQ0v8D1hJoQyXEsJ8jpqKrWGCMJVBerOdERPIm4wWcRRCuKmgAaJHDAI3QYFqyN51PuL3JO2aqd3Uk14dDRbCYRwxjYBfrcuZLWWwi1cZTaQdVfGmrRoRCV2BOFCEElYphoK7MJD9ue_jAFed_R-KxqmpedDwRt-UYwEwpqmphBb2W0XbMuIRo_tqSWAcLmQVkLKt9NjDvMKIScFhc712bZ2eBe8ajTi_B48rZNCGBkKJVFTQJlpruCXCy4WUmfKWJ6eEGoS3ZeEINI7tXBGJCTxXfgabWR83eIcKLgS_cSIFwyBSDp5OI-BChbLvP0PuBaJCvIsDCEGIUPtUKlQbJfYpcHuwd9HTHgO-UnnSdAnAgCU-MUGgOnn5DaCmdVcIrRBwujQzTu4Ugi0we2ayZoL2rjwN0sR6lCQkFM8SaLpQ=w1920-h929-ft",
                            "February 12, 2022 11:59 PM").build()).queue();
                }
            }
        }
    }

    public EmbedBuilder createTaskEmbed(String authorName, String authorUrl, String titleName, String titleUrl, String description, int color, String imageUrl, String thumbnailUrl, String expiryDate) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor(authorName, authorUrl);
        eb.setTitle(titleName, titleUrl);
        eb.setDescription(description);
        eb.setColor(color);
        eb.setImage(imageUrl);
        eb.setThumbnail(thumbnailUrl);
        eb.addField("Expiry Date:", expiryDate, false);
        return eb;
    }

    public boolean exists(String task) {
        return false;
    }
}
