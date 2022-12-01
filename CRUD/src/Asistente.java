import java.io.Serializable;

public class Asistente implements Serializable{
    protected String name;
    protected String lastname;
    protected String CI;
    protected int edad;
    
    
    public Asistente(){
        name="";
        lastname="";
        CI="";
        edad=0;
    }
    public Asistente(String name,String lastname,String CI,int edad){
        this.name = name;
        this.lastname = lastname;
        this.CI = CI;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "{" + "nombre: " + name + " }";
    }

    
    
}
