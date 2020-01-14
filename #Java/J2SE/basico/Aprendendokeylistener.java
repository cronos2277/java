package br.com.treinaweb.parte2;
    /* 
      Este exemplo mostra como escrever uma classe 
      que implementa a interface KeyListener. 
    */  
      
    import javax.swing.*;  
    import java.awt.*;  
    import java.awt.event.*;  
      
    public class Aprendendokeylistener extends JFrame{  
      public Aprendendokeylistener() {  
        super("Eventos do Mouse e Teclado");  
        Container c = getContentPane();  
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);  
        c.setLayout(layout);  
          
        Teclado teclado = new Teclado();  
        this.addKeyListener(teclado);      
      
        setSize(350, 250);  
        setVisible(true);  
      }  
        
      public static void main(String args[]){  
    	  Aprendendokeylistener app = new Aprendendokeylistener();  
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      }  
    }  
      
    /* 
    Classe auxiliar usada para obter eventos do 
    teclado. Como esta classe implementa a interface 
    KeyListener, ela deverá fornecer implementações para 
    os métodos keyPressed, keyReleased e keyTyped 
    */  
    class Teclado implements KeyListener{  
      public void keyPressed(KeyEvent e){  
        JOptionPane.showMessageDialog(null,   
          "Uma tecla foi pressionada!");  
      }   
      
      public void keyReleased(KeyEvent e){  
        // código aqui  
      }  
      
      public void keyTyped(KeyEvent e){  
        // código aqui  
      }  
    }  