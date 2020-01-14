import java.util.TreeMap;
public class treemapa{
public static void main(String [] args){
TreeMap<Integer,Character> mapa = new TreeMap<Integer,Character>();
for(int i=0;i<5;i++){
int j = 90-i;
mapa.put(i,(char)j);
System.out.println("Indice "+i+" vale: "+mapa.get(i));	
}
}
}
//TreeMap ele se assemelha ao HashMap, mais ele permite a recuperação, de valor
//de um array pela função .get(). O TreeMap é uma coleção alternativa ao HashMap. 