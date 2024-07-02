package listadopersonasapp;


/**
 *
 * @author hugot
 */
public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private static int numeroPersonas = 0;

    // Constructor vacio.
    public Persona() {
        this.id = ++Persona.numeroPersonas;
    }

    // Constructor con argumentos.
    public Persona(String nombre, String apellido, String telefono, String email) {
        this();// Se llama al constructor vacio.
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

    }

    // Metodos get y set.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Override // Metodo de sobreescritura.
    public String toString() {
        return "Persona{" + 
                "id = " + id + 
                ", nombre = " + nombre + 
                ", apellido = " + apellido + 
                ", telefono = " + telefono + 
                ", email = " + email + '}';
    }

    
    public static void main(String[] args) {
        
        Persona persona1 = new Persona ("Juan", "Perez", "5678928990", "juan@gmail.com");
        System.out.println(persona1);
    }
}

