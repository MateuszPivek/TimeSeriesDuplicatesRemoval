import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class IOReaderTest {


    IOStreamer testStreamer = new IOStreamer();

    @Test
        void shouldReturnLastRecordKey() {
            //given
            String record = "1615560000: 1";
            //when
            final LinkedHashMap<Integer, Integer> validationRecord = testStreamer.inputRecordFromString(record);
            //then
            assertEquals(1615560000,validationRecord.keySet().toArray()[0]);

        }

        @Test
        void shouldReturnLastRecordValue() {
            //given
            String record = "1615560000: 1";
            //when
            final LinkedHashMap<Integer, Integer> validationRecord = testStreamer.inputRecordFromString(record);
            //then
            assertEquals(1, validationRecord.get(validationRecord.keySet().toArray()[0]));
        }
}