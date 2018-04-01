package graphs;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by vasant on 4/1/18.
 */
public class PeopleConnectionGraphTest {

    @Test
    public void testGraphCreation  () {
        Map<String,List<String>> persons = new HashMap<>();
        persons.put("John", Arrays.asList("Rob", "Ryan", "Nick"));
        persons.put("Rob", Arrays.asList("John", "Kobe", "Nick", "Harry", "Ryan", "Rob"));
        persons.put("Eddie", Arrays.asList("Emma", "Harry", "Nick"));
        persons.put("Harry", Arrays.asList("Rob", "Nickie", "Nick", "Kobe", "John"));
        persons.put("Red", Arrays.asList("Kobe", "Doe", "Nick"));
        persons.put("Tim", Arrays.asList("John", "Eddie", "Doe"));
        persons.put("Emma", Arrays.asList("Rob", "Eddie", "Nick"));
        persons.put("Nickie", Arrays.asList("Doe", "Tim", "Harry", "John", "Red"));
        persons.put("Doe", Arrays.asList("Red", "Ryan", "Eddie", "Tim"));
        persons.put("Kobe", Arrays.asList("Tim", "Harry", "Nick", "Emma", "Nickie"));
        persons.put("Ryan", Arrays.asList("Nick","Emma","Eddie"));
        persons.put("Nick",Arrays.asList("Emma","Ryan","Harry"));

        try {
            PeopleConnectionGraph graph = new PeopleConnectionGraph(persons);

            Map<PeopleConnectionGraph.Person,List<PeopleConnectionGraph.Person>> connections = graph.findConnections("Emma");
            Assert.assertNotNull(connections);
            Assert.assertEquals(graph.connected("Nick","Doe"),3);


        }
        catch(PeopleConnectionGraph.GraphValidationException e) {
            Assert.fail();
        }


    }
}
