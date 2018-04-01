package graphs;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by vasant on 3/31/18.
 */
public class PeopleConnectionGraph {

    public static class Person{
        private String name;
        private Set<Person> connections;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Person> getConnections() {
            return connections;


        }

        public void setConnections(Set<Person> connections) {
            this.connections = connections;
        }

        public Person(String name) {
            this.name=name;
            this.connections = new HashSet<>();
        }
    }

    public class GraphValidationException extends Exception {

        public GraphValidationException(String message) {
            super(message);
        }
    }


    public PeopleConnectionGraph( Map<String,List<String>> connections) throws GraphValidationException {

        for(String name : connections.keySet()) {
            connectedPersons.put(name,new Person(name));
        }

        if(connectedPersons.keySet().size() < 10) {
            throw new GraphValidationException("Graph should contain minimum 10 people");
        }
        for(String name : connections.keySet()) {
            Person person = connectedPersons.get(name);
            person.setConnections(new HashSet<>());
            if(person == null ) {
                throw new GraphValidationException("Invalid input");
            }
            for(String connectionName : connections.get(person.getName())) {
                Person connectedPerson = connectedPersons.get(connectionName);
                if(connectedPerson==null) {
                    throw new GraphValidationException("Invalid input");
                }
                person.getConnections().add(connectedPerson);
            }
        }

    }

    //Graph implemtation using Adjacency list

    private Map<String, Person> connectedPersons = new HashMap<>();

    private Map<String,Boolean> onStack = new HashMap<>();

    private Map<String,Boolean> visited = new HashMap<>();

    private Map<String,String> parents = new HashMap<>();
    private int size =0;


    private boolean hasCycle(String name) {

        Person person = connectedPersons.get(name);
        onStack.put(name,true);
        for( Person connection : person.getConnections()) {
            if(!visited.containsKey(connection.getName())) {
                visited.put(connection.getName(),true);
            }
            else if(onStack.containsKey(connection.getName())) {
                return true;
            }
            hasCycle(connection.getName());
        }

        onStack.put(name,false);
        return false;
    }

    private boolean dfsCycle() {
        for(String name : connectedPersons.keySet()) {
            if(visited.containsKey(name) && !visited.get(name)) {
                if(hasCycle(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Person,List<Person>> findConnections(String name) {
        visited=new HashMap<>();
        Map<Person,List<Person>> personAndConnections = new HashMap<>();
        personAndConnections.put(connectedPersons.get(name), new ArrayList<>());

        visited = new HashMap<>();
        Map<Integer,List<Person>> personByLevel = new HashMap<>();
        List<Person> start = new LinkedList<>();
        start.add(connectedPersons.get(name));
        personByLevel.put(0, start);

        visited.put(name, true);

        int level =0;
        while(!personByLevel.get(level).isEmpty()) {
            if(level==2) {
                break;
            }
            int newlevel = level + 1;
            personByLevel.put(newlevel,new LinkedList<>());
            for (Person person : personByLevel.get(level)) {

                for (Person connection : person.getConnections()) {
                    if (!visited.containsKey(connection.getName())) {
                        personByLevel.get(newlevel).add(connection);
                        visited.put(connection.getName(), true);
                        personAndConnections.get(connectedPersons.get(name)).add(connection);
                    }

                }

            }
            level=newlevel;
        }
        return personAndConnections;
    }

    public int connected(String p1,String p2) {
        visited = new HashMap<>();
        Queue<Person> bfsQueue = new LinkedList<>();
        Map<Integer,List<Person>> personByLevel = new HashMap<>();
        List<Person> start = new LinkedList<>();
        start.add(connectedPersons.get(p1));
        personByLevel.put(0, start);

        visited.put(p1, true);
        parents.put(p1,"");
        boolean connected=false;


        int level =0;
        while(!personByLevel.get(level).isEmpty()) {
            int newlevel = level + 1;
            personByLevel.put(newlevel,new LinkedList<>());
            for (Person person : personByLevel.get(level)) {
                if (person.getName().equalsIgnoreCase(p2)) {
                    connected = true;
                    break;
                }

                for (Person connection : person.getConnections()) {
                    if (!visited.containsKey(connection.getName())) {
                        personByLevel.get(newlevel).add(connection);
                        visited.put(connection.getName(), true);
                        parents.put(connection.getName(), person.getName());
                    }

                }

            }
            level=newlevel;
        }

        if(connected) {
            Stack<String> path = new Stack<String>();
            String person = parents.get(p2);
            while (person != "") {
                path.add(person);
                person = parents.get(person);
            }

            while (!path.isEmpty()) {
                System.out.print(path.pop() + "  ");
            }
            return level-1;
        }
        else{
            return -1;
        }


    }


}
