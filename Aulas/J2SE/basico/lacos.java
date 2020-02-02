public class lacos{
public static void main(String [] args){
 int num = 0;
 primeiro :
 for(num=0;num<=20;num++){
	
 	switch (num){
	case 0: System.out.println(num);continue;
	case 1: System.out.println(num);continue;
	case 2: System.out.println(num);continue;
	case 3: System.out.println(num);continue;
	case 4: System.out.println(num);continue;
	case 5: System.out.println(num);continue;
	case 6: System.out.println(num);continue;
	case 7: System.out.println(num);continue;
	case 8: System.out.println(num);continue;
	case 9: System.out.println(num);continue;
	}
	System.out.println("\n");
	do{
	
	System.out.println(num);
	num++;
	if(num==19)break primeiro;
	}while(num<=20);
	
	
	
	//Fim de código
}	
}	
}
//O laço case vai até encontrar um break, ou um continue. Se o for acima, for 0
//ele vai do case 0 ate o 9, antes do for aumentar um, no laço for. Se for um,
//ele pula o zero, e vai até o nove antes de aumentar o laço. default no switch 
//case, com o case default dentro de laço da problema. Como o case está continue, 
// ao terminar os cases ele pula para o laço for.
//do while, sempre vai entrar depois dos cases, assim que o for não entrar mais 
//nos cases ele entra no do while, exceto que o case estivesse dentro do do while
//o do ele é executado pelo menos uma vez.
//O if quando o for eh 19, da um break ate o label primeiro acima do laço for, 
//ou seja o comando break ele leva o codigo para acima do laço.
//O for vai ateh o numero 19, sendo interrompido pelo desvio if quando igual a 19.