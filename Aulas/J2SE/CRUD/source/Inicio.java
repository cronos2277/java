package javapackage;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.*;
public class Inicio {
static JFrame janela = new JFrame("Cadastro De Clientes - CRUD 2.0");
	public static void main(String[] args) {
	Componentes comp = new Componentes();
	
	JotaTable.TableConf(JotaTable.modelo);
	janela.setVisible(true);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	janela.setLocationRelativeTo(null);
	janela.setSize(800, 600);
	JotaTable.tabela.addMouseListener(comp.escuta);
	//Painel de cima.
	Componentes.painel.setLayout(new GridLayout(3,2));
	Componentes.painel.setBackground(Color.LIGHT_GRAY);
	Componentes.painel.add(comp.nome_l);
	Componentes.painel.add(Componentes.nome_t);
	Componentes.painel.add(comp.email_l);
	Componentes.painel.add(Componentes.email_t);
	Componentes.painel.add(comp.tel_l);
	Componentes.painel.add(Componentes.tel_t);
	Componentes.painel.setSize(200,300);
	
	//Painel de Baixo.
	Componentes.Paineb.setLayout(new FlowLayout());
	Componentes.Paineb.setBackground(Color.LIGHT_GRAY);
	Componentes.Paineb.add(comp.cadastrar);
	Componentes.Paineb.add(comp.editar);
	Componentes.Paineb.add(comp.limpar);
	Componentes.Paineb.add(comp.deletar);
	Componentes.Painelt.setLayout(new FlowLayout());
	Componentes.Painelt.setBackground(Color.LIGHT_GRAY);
	Componentes.Painelt.add(JotaTable.tabela);
	janela.getContentPane().setLayout(new BorderLayout());
	janela.getContentPane().add(Componentes.painel, BorderLayout.NORTH);
	janela.getContentPane().add(Componentes.Paineb, BorderLayout.SOUTH);
	janela.getContentPane().add(JotaTable.tabela, BorderLayout.CENTER);
	
	//ActionListener
	comp.limpar.addActionListener(comp.escuta);
	Componentes.nome_t.addActionListener(comp.escuta);
	Componentes.email_t.addActionListener(comp.escuta);
	Componentes.tel_t.addActionListener(comp.escuta);
	comp.editar.addActionListener(comp.escuta);
	comp.cadastrar.addActionListener(comp.escuta);
	comp.deletar.addActionListener(comp.escuta);
	}

}
