package by.epam.tunnel.action;

import by.epam.tunnel.entity.TunnelComplex;
import by.epam.tunnel.exception.MissingFileException;
import by.epam.tunnel.parser.StringDataParser;
import by.epam.tunnel.reader.InputFileDataReader;

import java.util.ArrayList;

/**
 * Entry point
 */
public class TrafficMovement {
    public static void main(String[] args) throws MissingFileException {
        ArrayList<String> stringData = InputFileDataReader.getFileData(""); //reading file
        ArrayList<Integer> data = StringDataParser.readSchedule(stringData); //parsing
        TunnelComplex tunnelComplex = new TunnelComplex(data); //creating Tunnel Complex

        tunnelComplex.activate();
    }
}
