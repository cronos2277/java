package javapackage;
public class ArrayCopyForEachExerc�cio {

	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = new int [6];
		
		
		System.arraycopy(a, 0, b, 0, a.length);
		//System.arraycopy(Array a ser copiado, Informa o primeiro array a ser copiado, O Array de destino, O primeiro array a receber os dados, crit�rio de parada);
		//a.length � o tamanho do array a.
		
		for(int e: b){ //for(tipo, a vari�vel a ser usada no la�o: O Array a ser varrido)
		System.out.println(e);
		}
	}

}
