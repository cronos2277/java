import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IteratorPattern{
static int x = 1;
static IteratorAbstract <Register> iterator; 
static Person person = new Person();
static Locale local = new Locale();
static Register register = new Register();

    public static void main(String args[]){ 
        System.out.println("Quantos Clientes você quer cadastrar? ");
        int num = new Scanner(System.in).nextInt();
        System.out.println("Você irá registrar "+num+" clientes, não digite nada e de enter, para encerrar o cadastramento.\n");
        for(int i = 0;i < num;i++){              
            System.out.println("Informe o nome do cliente "+x);
            person.setName(new Scanner(System.in).nextLine());              
            System.out.println("Informe a cidade do cliente "+x);           
            local.setCity(new Scanner(System.in).nextLine());
            System.out.println("Informe o Estado do cliente \n"+x);
            local.setState(new Scanner(System.in).nextLine());
            person.setLocal(local);
            register.add(person.getName(),local.getCity(), local.getState());
            x++;
        }

        try{
            iterator = register.makeIt();       
            int y = -1;
            System.out.println("\n");
            while(iterator.hasNext()){                  
                    System.out.println("Nome("+(y+2)+"): "+register.thisPerson(y+1));
                    y++;    
                    iterator.next();
                }
                System.out.println("\n"+y+", usuario(s) registrado(s).");   
            }catch(Exception e){}

    }

}
//Essa classe é um Bean que tratará da cidade e do Estado.
class Locale{
    private String city;
    private String state;
    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }
}

//Esse bean contém um local e um nome.
class Person{   
    private String name;
    private Locale local;

    public void setName(String name){
        this.name = name;
    }

    public void setLocal(Locale locale){
        this.local = local;
    }

    public String getName(){
        return this.name;
    }

    public Locale getLocal(){
        return this.local;
    }

}
//Essa interface lida com a criação de um Iterator.
interface CreateIterator{
    public IteratorAbstract makeIt();   
}

//A classe registro implementa a interface de criação. O registro além de
//permitir a criação de um iterator a partir dele, Ele contém métodos próprios.
class Register implements CreateIterator{
    private int index;
    private Map<Integer,Person> register;
    public Register(){
        index = 0;
        register = new HashMap<Integer,Person>();
    }
 //Esse método é da classe Register mesmo e adiciona uma nova pessoa ao
 //HashMap do registro.    
    public void add(String nome, String cidade, String estado){
        Person person = new Person();
        Locale locale = new Locale();
        locale.setCity(cidade);
        locale.setState(estado);
        person.setName(nome);
        person.setLocal(locale);
        this.register.put(index,person);
        index++;
    }
    
//Esse método da classe Register, remove com base em um índice uma Pessoa do registro.       
    public void remove(int index){
        this.register.remove(index);
    }
    
//Retorna o tamanho do registro, esse método pertence a classe Registro.
    public int size(){
        return this.register.size();
    }
    
//Retorna o nome de uma pessoa no registro com base no índice informado.  
     public String thisPerson(int y){
     return this.register.get(y).getName();
    }  
    
//Esse sim é o método da interface, esse método permite criar um iterator
//com pessoa. Repare que ela retorna a própria interface, Você dá new 
//em uma classe que implementa a interface  usando  registo como parametro,
//no caso. Essa é a utilidade de se ter uma classe concreta que implementa
//o conteúdo do Iterator.
    @Override
    public IteratorAbstract makeIt(){
        return new IteratorCreator(this.register);
    }

    

}

//Essa interface diz respeito ao conteúdo do Iterator. Ela tipifica o
//método da classe de criação de Iterator e será implementada
interface IteratorAbstract <It>{
    public It isFirst();
    public It next();
    public boolean hasNext();
    public It thisItem();       
}

//Aqui é definido o funcionamento do Iterator. No caso o registro usa dela,
//repare que essa classe usa como parametro um objeto do tipo Person, com
//métodos exclusivos para ele.
class IteratorCreator implements IteratorAbstract<Person>{
    private int index;
    private Map<Integer,Person> register;
    public IteratorCreator(Map<Integer, Person> reg){
        this.register = reg;
        this.index = -1;
    }

    @Override
    public Person isFirst(){
        return this.register.get(0); //Verifica se é o conteudo do primeiro
    }

    @Override
    public Person next(){
//Isso faz o iterator correr, ou seja cada vez que o next é chamado, ele
//chama o próximo Person da lista.       
        ++this.index; 
        return register.get(index);

    }

    @Override
    public Person thisItem(){
//Faz a mesma coisa que o método Next(), mais sem avançar para o próximo.
        return this.register.get(index);
    }

    @Override
    public boolean hasNext(){
//retorna false quando se chegar do ultimo Person da lista.
        if(this.register.size() > index)
            return true;
        else
            return false;
    }   

}

/*
 * O Iterator não tem segredo, aqui é explicado como funciona o 
 * java.util.Iterator;
 * O seu objetivo é percorrer listas de objetos, como um Iterator qualquer.
 * */
