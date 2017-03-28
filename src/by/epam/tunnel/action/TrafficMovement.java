package by.epam.tunnel.action;

import by.epam.tunnel.entity.TunnelComplex;
import by.epam.tunnel.exception.MissingFileException;
import by.epam.tunnel.exception.WrongInputException;
import by.epam.tunnel.parser.StringDataParser;
import by.epam.tunnel.reader.InputFileDataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Entry point
 */
public class TrafficMovement {
    public static void main(String[] args) throws MissingFileException, WrongInputException {
        ArrayList<String> stringData = InputFileDataReader.getFileData(""); //reading file
        ArrayList<Integer> data = StringDataParser.readSchedule(stringData); //parsing
        TunnelComplex tunnelComplex = new TunnelComplex(data); //creating Tunnel Complex

        tunnelComplex.activate();
    }
}
