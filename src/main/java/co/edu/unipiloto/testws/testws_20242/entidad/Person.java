package co.edu.unipiloto.testws.testws_20242.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author juann
 */
@XmlRootElement(name="persona")
@XmlType(propOrder={"id", "fullname", "age", "salario"})
public class Person {
    private int id;
    private String fullname;
    private int age;
    private int salario;
    private static final int salario_min = 1300000;

    public Person(int id, String fullname, int age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        calcularSalario();
    }

    public Person() {
        
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        calcularSalario();
    }

    @XmlElement
    public int getSalario() {
        return salario;
    }

    public void calcularSalario() {
        this.salario = (this.age * salario_min) / 3;
    }
}
