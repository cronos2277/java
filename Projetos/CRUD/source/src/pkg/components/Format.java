package pkg.components;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import pkg.main.Do;

public class Format {
	public PlainDocument getRules(int var){
		switch(var){
			case 1: return new TextRules(); //1 Setado para nomes.
			case 2: return new NumbersRules(); //2 setado para apenas números.
			case 3: return new DoubleRules(); //3 Setado para campos do tipo double.
			default:return null;
		}		
	}	
	
	private class TextRules extends PlainDocument{		
		private static final long serialVersionUID = 1L;
		//Caracteres permitidos para texto, no caso quando getRules for 1.
		private String rules = "[^a-z | ^A-Z | ^ | ^ç | ^Ç | ^ã | ^Ã | ^â | ^Â | ^ü | ^Ü | ^á | ^à | ^À | ^Á | ^é | ^É | ^í | ^Í | ^Ó | ^ó | ^õ | ^Õ | ^ú | ^Ú | ^ñ | |Ñ |^']";
		@Override
		public void insertString(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
		
		@SuppressWarnings("unused")
		public void replace(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
	}
	
	//Caracteres permitidos para numeros, no caso quando getRules for 2.
	private class NumbersRules extends PlainDocument{
		private static final long serialVersionUID = 1L;
		private String rules = "[^0-9]";
		@Override
		public void insertString(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
		
		@SuppressWarnings("unused")
		public void replace(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
	}
	
	//Caracteres permitidos para double, no caso quando getRules for 3.
	private class DoubleRules extends PlainDocument{
		private static final long serialVersionUID = 1L;
		private String rules = "[^0-9 | ^.]";		
		@Override
		public void insertString(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
		
		@SuppressWarnings("unused")
		public void replace(int offset, String str,AttributeSet attr) throws BadLocationException{
			super.insertString(offset, str.replaceAll(rules, ""), attr);
		}
	}	
	
	//Configuração das caixas JComboBox.
	public JComboBox<String> getBox(String ... strings ){
		JComboBox<String> combo = new JComboBox<String>();
		for(String str: strings)
			combo.addItem(str);
		return combo;
	}
	
	//Configuração de mascaras.
	public MaskFormatter getMask(char c){
		MaskFormatter mask;
		try {
			if(c == 'd'){ //Padrão data.			
				mask = new MaskFormatter("##/##/####");
				return mask;
			}else if(c == 'b'){ //Padrão para Banco
				return mask = new MaskFormatter("#######-#");
			}else if (c == 'i'){ // Padrão número do netbook, 4 algorismos.
				return mask = new MaskFormatter("####");
			}else if (c == 'z'){ //Padrão telefone
				return mask = new MaskFormatter("#####-###");			
			}else if (c == 'c'){//CPF
				return mask = new MaskFormatter("###.###.###-##");
			}
		}catch (ParseException error) {
			Do.notifyTechnicalError(error);return null;
		}
		return null;
		
	}
	
}
