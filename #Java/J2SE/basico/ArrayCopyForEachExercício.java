package javapackage;
public class ArrayCopyForEachExercício {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = new int [6];
		
		
		System.arraycopy(a, 0, b, 0, a.length);
		//System.arraycopy(Array a ser copiado, Informa o primeiro array a ser copiado, O Array de destino, O primeiro array a receber os dados, critério de parada);
		//a.length é o tamanho do array a.
		
		for(int e: b){ //for(tipo, a variável a ser usada no laço: O Array a ser varrido)
		System.out.println(e);
		}
	}

}
