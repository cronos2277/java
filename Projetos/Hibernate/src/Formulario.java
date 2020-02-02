public abstract class Formulario extends javax.swing.JFrame{	
		private static final long serialVersionUID = 1L;
		private static final String titulo = "CRUD Alunos";
		protected String[] jlabels_names = {"Codigo","Nome","Cidade","Telefone"};
		protected String[] buttons_names = {"Novo","Alterar","Salvar","Excluir"};
	 	protected javax.swing.JButton jButton1;
	    protected javax.swing.JButton jButton2;
	    protected javax.swing.JButton jButton3;
	    protected javax.swing.JButton jButton4;
	    protected javax.swing.JLabel jLabel1;
	    protected javax.swing.JLabel jLabel2;
	    protected javax.swing.JLabel jLabel3;
	    protected javax.swing.JLabel jLabel4;    
	    protected javax.swing.JScrollPane jScrollPane2;    
	    protected javax.swing.JTable jTable2;
	    protected javax.swing.JTextField jTextField1;
	    protected javax.swing.JTextField jTextField2;
	    protected javax.swing.JTextField jTextField3;
	    protected javax.swing.JTextField jTextField4;
	    protected javax.swing.table.DefaultTableModel defaultTable;
	    protected Gerente gerente;	    
	    protected Acao acao;
	    
	protected void initComponents() {
		this.gerente = new Gerente();
        this.acao = new Acao(this.gerente);      
    	this.jLabel1 = new javax.swing.JLabel();
    	this.jLabel2 = new javax.swing.JLabel();
    	this.jLabel3 = new javax.swing.JLabel();
    	this.jLabel4 = new javax.swing.JLabel();      
    	this.jTextField1 = new javax.swing.JTextField();
    	this.jTextField2 = new javax.swing.JTextField();
    	this.jTextField3 = new javax.swing.JTextField();
    	this.jTextField4 = new javax.swing.JTextField();
    	this.jButton1 = new javax.swing.JButton();
    	this.jButton2 = new javax.swing.JButton();
    	this.jButton3 = new javax.swing.JButton();
    	this.jButton4 = new javax.swing.JButton();
    	this.jScrollPane2 = new javax.swing.JScrollPane();
    	this.setjTable();    	
        this.setPattern();
        
    	}  
	
		protected void setjTable() {
			this.jTable2 = new javax.swing.JTable();
			this.jTable2.addMouseListener(this.acao.getMouseListener());
		}
	
	
	 //Essa funcao criadora de label 
	  protected void setLabels(javax.swing.JLabel[] jlabels, String[] nomes) {
		  if(jlabels.length == nomes.length) {
			  for(int i=0;i<nomes.length;i++) {
				  jlabels[i].setText(nomes[i]);
			  }
		  }else {
			  System.out.println("Parametros incorretos para a funcao setLabels");
		  }
		  
	  }
	 
	//Essa funcao criadora de botoes
	  protected void setButtons(javax.swing.JButton[] jlabels, String[] nomes) {
		  if(jlabels.length == nomes.length) {
			  for(int i=0;i<nomes.length;i++) {
				  jlabels[i].setText(nomes[i]);
			  }
		  }else {
			  System.out.println("Parametros incorretos para a funcao setButtons");
		  }
		  
	  }  
	  
	  //Metodo para criacao de Modelos de tabela.
	  public javax.swing.table.DefaultTableModel getDefaultTable(){
		  return new javax.swing.table.DefaultTableModel( new Object [][] {	        	
	        },
	        new String [] {
	            "Codigo", "Nome", "Cidade", "Telefone"
	        }
	    ) {
	        
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
	            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
	        };
	        boolean[] canEdit = new boolean [] {
	            false, true, true, true
	        };

	        @SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
	            return types [columnIndex];
	        }

	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return canEdit [columnIndex];
	        }
	    };
	  }
	
	  //Aqui roda as configurações padrão.
	@SuppressWarnings("deprecation")
	protected void setPattern() {
		this.setTitle(Formulario.titulo); 
		  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        javax.swing.JLabel[] jlabels_fields = {jLabel1,jLabel2,jLabel3,jLabel4};
	        javax.swing.JButton[] jbuttons_fields = {jButton1,jButton2,jButton3,jButton4};
	        this.setLabels(jlabels_fields, jlabels_names); 
	        this.setButtons(jbuttons_fields, buttons_names);        
	        jTextField1.disable();    
			   this.defaultTable = this.getDefaultTable();     
			   acao.fillTable(defaultTable, gerente);
			    jTable2.setModel(defaultTable);
			        jScrollPane2.setViewportView(jTable2);
			
			        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			        getContentPane().setLayout(layout);
			        layout.setHorizontalGroup(
			            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGroup(layout.createSequentialGroup()
			                .addContainerGap()
			                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			                    .addComponent(jScrollPane2)
			                    .addGroup(layout.createSequentialGroup()
			                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
			                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
			                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			                            .addGroup(layout.createSequentialGroup()
			                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			                                    .addComponent(jTextField1)
			                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
			                                .addGap(94, 94, 94)
			                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
			                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
			                                .addGap(18, 18, 18)
			                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
			                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
			                                    .addComponent(jTextField3)))
			                            .addGroup(layout.createSequentialGroup()
			                                .addComponent(jButton1)
			                                .addGap(58, 58, 58)
			                                .addComponent(jButton2)
			                                .addGap(66, 66, 66)
			                                .addComponent(jButton3)
			                                .addGap(56, 56, 56)
			                                .addComponent(jButton4)))
			                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
			        );
			        layout.setVerticalGroup(
			            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGroup(layout.createSequentialGroup()
			                .addGap(22, 22, 22)
			                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
			                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
			                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
			                .addGap(16, 16, 16)
			                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
			                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
			                .addGap(18, 18, 18)
			                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
			        );
			        
			        pack();
	}

}
