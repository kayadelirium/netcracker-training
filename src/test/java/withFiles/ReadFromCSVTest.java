package withFiles;

import MyArrays.ContractArray;
import junit.framework.TestCase;

public class ReadFromCSVTest extends TestCase {

    public void testReadFrom() {
        ContractArray contractArray = ReadFromCSV.readFrom("input.csv");
        System.out.println(contractArray);
        assertEquals(5, contractArray.size());
        assertEquals(contractArray.get(1).getClient(), contractArray.get(2).getClient());
    }
}