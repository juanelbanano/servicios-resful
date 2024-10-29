package co.edu.unipiloto.testws.testws_20242.services;

import co.edu.unipiloto.testws.testws_20242.entidad.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author juan felipe barreto 
 */
@Path("services")
public class Service {
    private static Map<Integer, Person> persons = new HashMap<>();
    static{
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i+1;
            person.setId(id);
            person.setFullname("Apreciado amigo " + id);
            person.setAge(new Random().nextInt(40+1));
            persons.put(id, person);
        }
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("/getPersonByID/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByID(@PathParam("id")int id) {
        return persons.get(id);
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        person.calcularSalario();
        persons.put(person.getId(), person);
        return person;
    }
    
    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalaryInXML() {
        double totalSalario = 0;
        for (Person person : persons.values()) {
            totalSalario += person.getSalario();
        }

        double promedio = totalSalario / persons.size();
        return String.format("%.2f", promedio);
    }

    @GET
    @Path("/getTotalSalaryInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTotalSalaryInJson() {
        int totalSalario = 0;
        for (Person person : persons.values()) {
            totalSalario += person.getSalario();
        }
        return totalSalario;
    }
}
