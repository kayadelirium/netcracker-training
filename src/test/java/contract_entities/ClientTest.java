package contract_entities;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.Calendar;

public class ClientTest extends TestCase {

    public void testGetAge() {
        LocalDate first = LocalDate.of(2000, Calendar.FEBRUARY,15);

        Client client = new Client(1,"Sophie", first, "", Client.Sex.FEMALE);

        assertEquals(20, client.getAge());
    }
}