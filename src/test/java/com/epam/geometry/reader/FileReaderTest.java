package com.epam.geometry.reader;

import com.epam.geometry.exceptions.DataMissingException;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class FileReaderTest {

    private static final String PATH = "C:\\geometry\\src\\test\\resources\\fileForFileReader.txt";
    private static final String WRONG_PATH = "C:\\geometry\\src\\test\\resources\\wrong.txt";

    private static final List<String> EXPECT_LIST = Arrays.asList(
            "text1",
            "",
            "text 2"
    );

    FileReader reader = new FileReader();

    @Test
    public void testForSuccessfulReadFile() throws DataMissingException {

        List<String> actualList = reader.getList(PATH);

        MatcherAssert.assertThat(actualList, is(equalTo(EXPECT_LIST)));
    }

    @Test(expected = DataMissingException.class)
    public void testForTrowDataMissingException() throws DataMissingException {

        reader.getList(WRONG_PATH);

    }
}