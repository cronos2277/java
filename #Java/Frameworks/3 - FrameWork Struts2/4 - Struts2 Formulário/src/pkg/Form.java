package pkg;

import com.opensymphony.xwork2.ActionSupport;

public class Form extends ActionSupport {
private static final long serialVersionUID = 1L;
//	-------------------------------------------------------------------------------------------
/* 				Corresponde a tag <s:select />
 * Abaixo o menu select, o famoso menu drop down. A lista do tipo String privada corresponde a lista
 * contendo os valores a ser escolhido pelo cliente, no formul�rio. a String privada recebe o valor
 * correspondente da lista. Por exemplo se o usu�rio escolher a op��o 2, a String recebe o valor Op��o2.
 * Obs: As regras s�o as mesmas do javaBeans, apenas atributos privados, o Struts l� pelo get, escreve pelo set.*/
private String [] select = {"Op��o 1", "Op��o 2", "Op��o 3"}; //	--> Op��es para o usu�rio escolher.
private String sel; //	--> Essa String recebe o valor informado da lista select acima.
private String [] select2 = {"Op��o 1", "Op��o 2", "Op��o 3"};
private String sel2;
//	-------------------------------------------------------------------------------------------
/*				Corresponde a tag <s:radio />
 * RadioButton nesse caso apenas uma op��o � v�lida. Funciona de maneira semelhante ao select acima.
 * */
private String [] radiobutton = {"Radio Op��o 1", "Radio Op��o 2", "Radio Op��o 3"}; // --> Op��es para o usu�rio escolher.
private String radio; // --> recebe a op��o escolhida pelo usu�rio.
//	-------------------------------------------------------------------------------------------
/*				Corresponde a tag <s:checkboxlist />
 * CheckBoxList � o contr�rio dos dois campos acima. Nele voc� pode marcar mais de uma op��o.
 * Supondo que voc� marque a "CheckBox Op��o 1" e "CheckBox Op��o 3", a String ser� escrita da seguinte forma: "CheckBox Op��o 1, CheckBox Op��o 3"
 * */
private String [] CheckBoxList = {"CheckBox Op��o 1", "CheckBox Op��o 2", "CheckBox Op��o 3"}; //	--> Op��es a ser escolhidas pelo usu�rio.
private String SelectedCheckBoxList; //	--> Essa String recebe os valores, como o exemplificado acima.
//	-------------------------------------------------------------------------------------------
/*	Corresponde ao <s:file/>  Essa String recebe o caminho do arquivo selecionado.
 * 	Supondo que o arquivo seja "file" e esteja em "c:", o valor dessa String ser� "C:\file"
 *  */
private String file1;   
//	-------------------------------------------------------------------------------------------
private String pass; // Corresponde ao <s:password/>. Igual ao textField, mas oculto ao usu�rio.
//	-------------------------------------------------------------------------------------------
private String check; //Corresponde ao <s:checkbox />. Recebe true ou o valor de fieldValue, caso seja marcado. False caso n�o esteja marcada.
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
