package pkg;

import com.opensymphony.xwork2.ActionSupport;

public class Form extends ActionSupport {
private static final long serialVersionUID = 1L;
//	-------------------------------------------------------------------------------------------
/* 				Corresponde a tag <s:select />
 * Abaixo o menu select, o famoso menu drop down. A lista do tipo String privada corresponde a lista
 * contendo os valores a ser escolhido pelo cliente, no formulário. a String privada recebe o valor
 * correspondente da lista. Por exemplo se o usuário escolher a opção 2, a String recebe o valor Opção2.
 * Obs: As regras são as mesmas do javaBeans, apenas atributos privados, o Struts lê pelo get, escreve pelo set.*/
private String [] select = {"Opção 1", "Opção 2", "Opção 3"}; //	--> Opções para o usuário escolher.
private String sel; //	--> Essa String recebe o valor informado da lista select acima.
private String [] select2 = {"Opção 1", "Opção 2", "Opção 3"};
private String sel2;
//	-------------------------------------------------------------------------------------------
/*				Corresponde a tag <s:radio />
 * RadioButton nesse caso apenas uma opção é válida. Funciona de maneira semelhante ao select acima.
 * */
private String [] radiobutton = {"Radio Opção 1", "Radio Opção 2", "Radio Opção 3"}; // --> Opções para o usuário escolher.
private String radio; // --> recebe a opção escolhida pelo usuário.
//	-------------------------------------------------------------------------------------------
/*				Corresponde a tag <s:checkboxlist />
 * CheckBoxList é o contrário dos dois campos acima. Nele você pode marcar mais de uma opção.
 * Supondo que você marque a "CheckBox Opção 1" e "CheckBox Opção 3", a String será escrita da seguinte forma: "CheckBox Opção 1, CheckBox Opção 3"
 * */
private String [] CheckBoxList = {"CheckBox Opção 1", "CheckBox Opção 2", "CheckBox Opção 3"}; //	--> Opções a ser escolhidas pelo usuário.
private String SelectedCheckBoxList; //	--> Essa String recebe os valores, como o exemplificado acima.
//	-------------------------------------------------------------------------------------------
/*	Corresponde ao <s:file/>  Essa String recebe o caminho do arquivo selecionado.
 * 	Supondo que o arquivo seja "file" e esteja em "c:", o valor dessa String será "C:\file"
 *  */
private String file1;   
//	-------------------------------------------------------------------------------------------
private String pass; // Corresponde ao <s:password/>. Igual ao textField, mas oculto ao usuário.
//	-------------------------------------------------------------------------------------------
private String check; //Corresponde ao <s:checkbox />. Recebe true ou o valor de fieldValue, caso seja marcado. False caso não esteja marcada.
//	-------------------------------------------------------------------------------------------
	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
	public String [] getRadiobutton() {
		return radiobutton;
	}
	public void setRadiobutton(String [] radiobutton) {
		this.radiobutton = radiobutton;
	}
	public String [] getCheckBoxList() {
		return CheckBoxList;
	}
	public void setCheckBoxList(String [] checkBoxList) {
		CheckBoxList = checkBoxList;
	}
	
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getSelectedCheckBoxList() {
		return SelectedCheckBoxList;
	}
	public void setSelectedCheckBoxList(String selectedCheckBoxList) {
		SelectedCheckBoxList = selectedCheckBoxList;
	}	
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String [] getSelect() {
		return select;
	}
	public void setSelect(String [] select) {
		this.select = select;
	}
	public String getSel() {
		return sel;
	}
	public void setSel(String sel) {
		this.sel = sel;
	}
	public String [] getSelect2() {
		return select2;
	}
	public void setSelect2(String [] select2) {
		this.select2 = select2;
	}
	public String getSel2() {
		return sel2;
	}
	public void setSel2(String sel2) {
		this.sel2 = sel2;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
}
