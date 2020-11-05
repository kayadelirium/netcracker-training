package contract_entities;

import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;

public class ClientTest extends TestCase {

    public void testGetAge() {
        Date first = new Date(2000, Calendar.FEBRUARY,15);

        Client client = new Client(1,"Sophie", first, "", Client.Sex.FEMALE);

        assertEquals(20, client.getAge());
    }
}