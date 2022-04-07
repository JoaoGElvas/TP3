import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


import javax.swing.*;

public class Swing {
    private static  DB db;
    Swing(DB dbReference){
        db = dbReference;
    }

	// Telas
	private static final JFrame loginframe = new JFrame("Tela de Login");
    private static JFrame dashboardFrame;
	
    private static final JButton buttonRegister = new JButton("Registrar-se");
    private static JButton buttonLogin;
    private static JTextField userLoginText;
    private static final JTextField userRegisterText = new JTextField(20);
    private static JButton createCarButton;
    private static boolean isLogged = false;

    
    public static class LoginEvent implements ActionListener {
		public void actionPerformed(ActionEvent evt){

            isLogged = db.SearchDono(userLoginText.getText());
            if(isLogged){
            	loginframe.setVisible(false);
                Swing.Dashboard(userLoginText.getText());
            }
        }
    }

    public static class RegisterEvent implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            System.out.println("register clicado");
            db.InsertDono(userRegisterText.getText());
        }
    }
    
    public static class AddCarEvent implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            db.InsertDono(userRegisterText.getText());
        }
    }
    

    
    //Pagina de Login
    
    /** Método para gerar uma janela de login do swing
     * @return void*/
     public static void LoginPage(){
         userLoginText = new JTextField(20);
         userLoginText.setBounds(100,30, 160, 25);
         loginframe.add(userLoginText);
         buttonLogin = new JButton("Fazer Login");

         buttonLogin.setBounds(100,80,160, 40);
         loginframe.add(buttonLogin);
         loginframe.setSize(400,500);
         loginframe.setLocationRelativeTo(null);
         loginframe.setLayout(null);
         loginframe.setVisible(true);
         buttonLogin.addActionListener(new LoginEvent());

         userRegisterText.setBounds(100,300, 160, 25);
         loginframe.add(userRegisterText);

         buttonRegister.setBounds(100,350,160, 40 );
         loginframe.add(buttonRegister);
         loginframe.setSize(400,500);
         loginframe.setLayout(null);
         loginframe.setVisible(true);
         buttonRegister.addActionListener(new RegisterEvent());
     }
     
     //Dashboard Principal
     
     /** Método para gerar uma janela de dashboard do swing
     * @param name nome do usuario 
    * @return void*/
     public static void Dashboard(String name){
         ArrayList<String> cars = db.GetAllCarsByOwner(name);
         JList carsList = new JList(cars.toArray());

         dashboardFrame = new JFrame("Dashboard, Bem vindo: " + name);

        class EditCarEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                dashboardFrame.setVisible(false);
                 EditCarView(name , cars.get(carsList.getSelectedIndex()));
            }
        }

         class CreateCarEvent implements ActionListener {
             public void actionPerformed(ActionEvent evt){
                 dashboardFrame.setVisible(false);
                 CreateCarView(name);
             }
         }
        
          JButton EditCarButton = new JButton("Editar veiculo selecionado");
          EditCarButton.addActionListener(new EditCarEvent());
          EditCarButton.setBounds(600,500,200, 80);

     	dashboardFrame.setSize(400,500);
     	dashboardFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
     	
     	
     	JButton createCarButton = new JButton("Cadastrar veiculo");
     	createCarButton.setBounds(600,80,200, 80);

        createCarButton.addActionListener(new CreateCarEvent());
        
        carsList.setBounds(600, 200, 200, 100);
        dashboardFrame.setLocationRelativeTo(null);
        dashboardFrame.add(BorderLayout.CENTER , carsList);
     	dashboardFrame.add(createCarButton);
     	dashboardFrame.add(EditCarButton);
     	dashboardFrame.setLayout(null);
     	dashboardFrame.setVisible(true);
     }

     //Car view
     
     /** Método para gerar uma janela de criar um carro no swing
      * @param name nome do usuario 
     * @return void*/
    public static void CreateCarView(String name){
        JFrame createCarFrame = new JFrame("Adicione seu carro: ");
        createCarFrame.setLocationRelativeTo(null);
        createCarFrame.setSize(400,500);
        createCarFrame.setLayout(null);

        JLabel carModelLabel = new JLabel("Modelo: ");
        carModelLabel.setBounds(100,50, 160, 25);

        JTextField carModelInput = new JTextField(30);
        carModelInput.setBounds(100,70, 160, 25);

        JLabel carBrandLabel = new JLabel("Marca: ");
        carBrandLabel.setBounds(100,90, 160, 25);

        JTextField carBrandInput = new JTextField(30);
        carBrandInput.setBounds(100,110, 160, 25);

        class CreateCarEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                System.out.println(carModelInput.getText());
                System.out.println(carBrandInput.getText());
                db.InsertCar(name , carBrandInput.getText(), carModelInput.getText());
                createCarFrame.setVisible(false);
                Dashboard(name);
            }
        }

        JButton createCarButton = new JButton("Adicionar");
        createCarButton.setBounds(100,150, 160, 25);
        createCarButton.addActionListener(new CreateCarEvent());


        createCarFrame.add(carModelLabel);
        createCarFrame.add(carModelInput);
        createCarFrame.add(carBrandInput);
        createCarFrame.add(carBrandLabel);
        createCarFrame.add(createCarButton);
        createCarFrame.setVisible(true);
    }
    
        /** Método para gerar uma janela de edicao de um carro no swing
         * @param name nome do usuario
         * @param carName qual carro do usuario para editar
        * @return void*/
     public static void EditCarView(String name , String carName ){
         Veiculo car = db.SearchCar(name, carName);
         Abastecimentos[] abastecimentos = db.SearchAllAbastecimentos(name, carName);
         
         
         JFrame editCarViewFrame = new JFrame("Edite seu carro: " + carName );
         editCarViewFrame.setLocationRelativeTo(null);
         editCarViewFrame.setSize(1200,1000);
         editCarViewFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         
         // info do carro
         JLabel donoInfo = new JLabel("Dono: " + car.getName());
         donoInfo.setBounds(50,50 , 250, 25);


         JLabel modeloInfo = new JLabel("Modelo: " + car.getModel());
         modeloInfo.setBounds(50,70 , 250, 25);

         JLabel marcaInfo = new JLabel("Marca: " + car.getMarca());
         marcaInfo.setBounds(50,90 , 250, 25);
     

         JLabel abastecimentoInfo = new JLabel("Abastecimento: ");
         abastecimentoInfo.setBounds(50,130,  250, 25);
         editCarViewFrame.add(abastecimentoInfo);
         
         JList listAbastecimentos = new JList(car.getAllAbastecimentos().toArray());
         System.out.println(car.getAllAbastecimentos());
         
         listAbastecimentos.setBounds(50,150, 250, 250);
         editCarViewFrame.add(listAbastecimentos);
         
         JLabel despesasInfo = new JLabel("Despesas: ");
         despesasInfo.setBounds(500,130 , 250, 25);
         
         JList listDespesas = new JList(car.getAllDespesas().toArray());
         listDespesas.setBounds(500,150, 250, 250);
         editCarViewFrame.add(listDespesas);
         
         JLabel receitaInfo = new JLabel("Receitas: ");
         receitaInfo.setBounds(1000,130 , 250, 25);
         
         JList listReceitas = new JList(car.getAllReceitas().toArray());
         listReceitas.setBounds(1000, 150, 250, 250);
         editCarViewFrame.add(listReceitas);
        
         
         // Abastecimento
         JLabel precoLitroLabel = new JLabel();
         precoLitroLabel.setText("Preco por litro: ");
         precoLitroLabel.setBounds(50,500, 160, 25);

         JLabel LitroLabel = new JLabel();
         LitroLabel.setText("Quantidade de Litros: ");
         LitroLabel.setBounds(250, 500, 160, 25);
         

         JTextField userPrecoLitroText = new JTextField(20);
	     userPrecoLitroText.setBounds(40,500, 160, 25);
	     
         JTextField userLitroText = new JTextField(20);
         userLitroText.setBounds(240,500, 160, 25);
         
         JButton abastecimentoButton = new JButton ("Adicionar abastecimento");
         abastecimentoButton.setBounds(640,500, 250, 25);

         
         class PrecoLitroEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(userPrecoLitroText.getText());
                System.out.println(userLitroText.getText());
                
                userPrecoLitroText.getText().replaceAll( "," , "." );
                double precoLitro = Double.parseDouble(userPrecoLitroText.getText());
                
                userLitroText.getText().replaceAll( "," , "." );
                double litro = Double.parseDouble(userLitroText.getText());
                
                double valor = precoLitro * litro;
                System.out.println("Valor litro: " + valor);
                db.InsertAbastecimento(precoLitro,litro, valor , name, carName);
                editCarViewFrame.dispatchEvent(new WindowEvent(editCarViewFrame, WindowEvent.WINDOW_CLOSING));
                EditCarView(name , carName);
            }
         }
         
         

         abastecimentoButton.addActionListener(new PrecoLitroEvent());
         
         
         
          // Despesas
         
           JLabel tipoDespesa = new JLabel();
           tipoDespesa.setText("Tipo de despesa: ");
           tipoDespesa.setBounds(50,550, 160, 25);
 
           JLabel valorDespesa = new JLabel();
           valorDespesa.setText("Valor da despesa:  ");
           valorDespesa.setBounds(250, 550, 160, 25);
           
           JLabel observacaoDespesa = new JLabel();
           observacaoDespesa.setText("OBS:  ");
           observacaoDespesa.setBounds(450, 550, 160, 25);
             
           JTextField usertipoDespesaText = new JTextField(20);
           usertipoDespesaText.setBounds(40,550, 160, 25);
  
           JTextField uservalorDespesaText = new JTextField(20);
           uservalorDespesaText.setBounds(240,550, 160, 25);
           
           JTextField userobservacaoDespesaText = new JTextField(50);
           userobservacaoDespesaText.setBounds(440,550, 160, 25);
 
           JButton despesaButton = new JButton ("Adicionar despesa");
           despesaButton.setBounds(640,550, 250, 25);
           
           class DespesasEvent implements ActionListener {
               public void actionPerformed(ActionEvent evt) {
                   System.out.println("Tipo despesa: " + usertipoDespesaText.getText());
                   System.out.println("OBS despesa: " +observacaoDespesa.getText());                  

                   uservalorDespesaText.getText().replaceAll( "," , "." );
                   double valordespesaParsed = Double.parseDouble(uservalorDespesaText.getText());
                   System.out.println("Valor despesa: " + valordespesaParsed);
                   db.InsertDespesa(usertipoDespesaText.getText(), valordespesaParsed, userobservacaoDespesaText.getText(), name, carName);
                   editCarViewFrame.setVisible(false);
                   EditCarView(name , carName);
               }
           }


           despesaButton.addActionListener(new DespesasEvent());

         //Receita

           JLabel tipoReceita = new JLabel();
           tipoReceita.setText("Tipo de receita: ");
           tipoReceita.setBounds(50, 600, 160, 25);
 
           JLabel valorReceita = new JLabel();
           valorReceita.setText("Valor da receita:  ");
           valorReceita.setBounds(250,600, 160, 25);
           
           JLabel observacaoReceita = new JLabel();
           observacaoReceita.setText("OBS:  ");
           observacaoReceita.setBounds(450, 600, 160, 25);
             
           JTextField usertipoReceitaText = new JTextField(20);
           usertipoReceitaText.setBounds(40,600, 160, 25);
  
           JTextField uservalorReceitaText = new JTextField(20);
           uservalorReceitaText.setBounds(240,600, 160, 25);
           
           JTextField userobservacaoReceitaText = new JTextField(50);
           userobservacaoReceitaText.setBounds(440,600, 160, 25);
 
           JButton receitaButton = new JButton ("Adicionar receita");
           receitaButton.setBounds(640,600, 250, 25);
           
           class ReceitaEvent implements ActionListener {
               public void actionPerformed(ActionEvent evt) {
                   System.out.println("Tipo receita: " + usertipoReceitaText.getText());
                   System.out.println("OBS receita: " +userobservacaoReceitaText.getText());      

                   uservalorReceitaText.getText().replaceAll( "," , "." );
                   double valoreceitaParsed = Double.parseDouble(uservalorReceitaText.getText());
                   System.out.println("Valor receita: " + valoreceitaParsed);
                   
                   db.InsertReceita(tipoReceita.getText(), valoreceitaParsed, observacaoReceita.getText(), name, carName);
                   editCarViewFrame.setVisible(false);
                   EditCarView(name , carName);
               }
           }


           receitaButton.addActionListener(new ReceitaEvent());
           
           

         // Relatorio
         
         class GerarRelatorioEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                editCarViewFrame.setVisible(false);
                RelatorioView(car);
            }
        }

         JButton buttonRelatorio = new JButton("Gerar relatorio");
         buttonRelatorio.setBounds(640,650, 250, 25);
         buttonRelatorio.setContentAreaFilled(false);
         buttonRelatorio.setOpaque(true);
         buttonRelatorio.addActionListener(new GerarRelatorioEvent());
         buttonRelatorio.setBackground(Color.RED);
           
           
           
      // ADD Abastecimento
      editCarViewFrame.add(abastecimentoButton);
      editCarViewFrame.add(LitroLabel);
      editCarViewFrame.add(precoLitroLabel);
      editCarViewFrame.add(userPrecoLitroText);
      editCarViewFrame.add(userLitroText);
      
      // ADD Despesas

        editCarViewFrame.add(tipoDespesa);
        editCarViewFrame.add(observacaoDespesa);
        editCarViewFrame.add(valorDespesa);
        editCarViewFrame.add(usertipoDespesaText);
        editCarViewFrame.add(uservalorDespesaText);
        editCarViewFrame.add(userobservacaoDespesaText);
        editCarViewFrame.add(despesaButton);
        
     // ADD Receita        
        
        editCarViewFrame.add(tipoReceita);
        editCarViewFrame.add(valorReceita);
        editCarViewFrame.add(observacaoReceita);
        editCarViewFrame.add(usertipoReceitaText);
        editCarViewFrame.add(uservalorReceitaText);
        editCarViewFrame.add(userobservacaoReceitaText);
        editCarViewFrame.add(receitaButton);
        
        
     // ADD Relatorio  
        
        editCarViewFrame.add(buttonRelatorio); 

        
    // ADD INFO
        
        editCarViewFrame.add(donoInfo); 
        editCarViewFrame.add(modeloInfo); 
        editCarViewFrame.add(marcaInfo);
        editCarViewFrame.add(despesasInfo); 
        editCarViewFrame.add(receitaInfo); 
        

        editCarViewFrame.setLayout(null);
        editCarViewFrame.setVisible(true);

     }
     /** Método para gerar uma janela de relatorio do swing
      * @param Veiculo carro para gerar um relatorio 
     * @return void*/
     static void RelatorioView(Veiculo car){
         Relatorio relatorio = new Relatorio(car);
         
         JFrame relatorioFrame = new JFrame("Veja seu relatorio"); 
         
         
         JLabel relatoriosaldoLabel = new JLabel("Saldo: " + relatorio.getSaldo());
         relatoriosaldoLabel.setBounds(50,50, 250, 25);
         relatorioFrame.add(relatoriosaldoLabel);
         
         JLabel relatoriocustoLabel = new JLabel("Custo: " + relatorio.getCustoTotal());
         relatoriocustoLabel.setBounds(50,100, 250, 25);
         relatorioFrame.add(relatoriocustoLabel);
         
         JLabel relatorioreceitaLabel = new JLabel("Receita: " + relatorio.getReceita());
         relatorioreceitaLabel.setBounds(50,150, 250, 25);
         relatorioFrame.add(relatorioreceitaLabel);
         
         JLabel mediaAbastecimentoLabel = new JLabel ("Media dos abastecimentos: " + relatorio.getMediaAbastecimento());
         mediaAbastecimentoLabel.setBounds(50,200, 250, 25);
         relatorioFrame.add(mediaAbastecimentoLabel);
         
         JLabel mediaDespesaLabel = new JLabel ("Media das despesas: " + relatorio.getMediaDespesa());
         mediaDespesaLabel.setBounds(50,250, 250, 25);
         relatorioFrame.add(mediaDespesaLabel);
         
         JLabel mediaReceitaLabel = new JLabel ("Media das receitas: " + relatorio.getMediaReceita());
         mediaReceitaLabel.setBounds(50,300, 250, 25);
         relatorioFrame.add(mediaReceitaLabel);
        
         
         relatorioFrame.setLocationRelativeTo(null);
         relatorioFrame.setSize(1200,1000);
         relatorioFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         relatorioFrame.setVisible(true);
     }

}


