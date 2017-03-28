package by.epam.tunnel.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.logging.log4j.Level.INFO;


public class StringDataParser {
    static Logger logger = LogManager.getLogger();

    public static ArrayList<Integer> readSchedule (ArrayList<String> stringData) {
        ArrayList<Integer> data = new ArrayList<>();
        String REGEX = "\\d+";

        Pattern p = Pattern.compile(REGEX);
        for (String s : stringData) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                data.add(Integer.parseInt(m.group()));
            }
        }

        logger.log(INFO, "String data parsing done. Schedule received.");

        return data;
    }
}
