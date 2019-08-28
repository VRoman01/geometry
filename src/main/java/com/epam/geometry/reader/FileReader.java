package com.epam.geometry.reader;

import com.epam.geometry.exceptions.DataMissingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileReader {

    public List<String> getList(String filePath) throws DataMissingException {

        List<String> result;

        try {

            Stream<String> stringStream = Files.lines(Paths.get(filePath));
            result = stringStream.collect(Collectors.toList());

        } catch (IOException e) {

            throw new DataMissingException(e.getMessage(), e);

        }

        return result;
    }
}
