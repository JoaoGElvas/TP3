import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    

   // public static void main(String[] a){
		
  //   }

    
    //Pagina de Login
     public static void LoginPage(){
         userLoginText = new JTextField(20);
         userLoginText.setBounds(100,30, 160, 25);
         loginframe.add(userLoginText);
         buttonLogin = new JButton("Fazer Login");

         buttonLogin.setBounds(100,80,160, 40);
         loginframe.add(buttonLogin);
         loginframe.setSize(400,500);
         loginframe.setLayout(null);
         loginframe.setVisible(true);
         buttonLogin.addActionListener(new LoginEvent());

         userRegisterText.setBounds(1000,30, 160, 25);
         loginframe.add(userRegisterText);

         buttonRegister.setBounds(1000,80,160, 40 );
         loginframe.add(buttonRegister);
         loginframe.setSize(400,500);
         loginframe.setLayout(null);
         loginframe.setVisible(true);
         buttonRegister.addActionListener(new RegisterEvent());
     }
     
     //Dashboard Principal
     public static void Dashboard(String name){
         ArrayList<String> cars = db.GetAllCarsByOwner(name);
         JList carsList = new JList(cars.toArray());
        class EditCarEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                 EditCarView(name , cars.get(carsList.getSelectedIndex()));
            }
        }
        
          JButton EditCarButton = new JButton("Editar veiculo selecionado");
          EditCarButton.addActionListener(new EditCarEvent());
          EditCarButton.setBounds(600,500,200, 80);    

        dashboardFrame = new JFrame("Dashboard, Bem vindo: " + name);
     	dashboardFrame.setSize(400,500);
     	
     	
     	JButton createCarButton = new JButton("Cadastrar veiculo");
     	createCarButton.setBounds(600,80,200, 80);

        createCarButton.addActionListener(new LoginEvent());
        
        carsList.setBounds(600, 200, 200, 100);
        dashboardFrame.add(BorderLayout.CENTER , carsList);
     	dashboardFrame.add(createCarButton);
     	dashboardFrame.add(EditCarButton);
     	dashboardFrame.setLayout(null);
     	dashboardFrame.setVisible(true);
     }

     //Car view

     public static void EditCarView(String name , String carName ){
         Veiculo car = db.SearchCar(name, carName);
         
         
         JFrame editCarViewFrame = new JFrame("Edite seu carro: " + carName );
         editCarViewFrame.setSize(400,500);
         
         // info do carro
         JLabel donoInfo = new JLabel("Dono: " + car.getName());
         donoInfo.setBounds(820,150 , 250, 25);
         
         
         JLabel modeloInfo = new JLabel("Modelo: " + car.getModel());
         modeloInfo.setBounds(820,160 , 250, 25);
         
         JLabel marcaInfo = new JLabel("Marca: " + car.getMarca());
         marcaInfo.setBounds(820,170 , 250, 25);
         
         JLabel abastecimentosInfo = new JLabel("Abastecimento ex");
         abastecimentosInfo.setBounds(820,180 , 250, 25);
         
         JLabel despesasInfo = new JLabel("Info das despesas");
         despesasInfo.setBounds(820,190 , 250, 25);
         
         JLabel receitaInfo = new JLabel("info das receitas");
         receitaInfo.setBounds(820, 200 , 250, 25);
         
         // Abastecimento
         JLabel precoLitroLabel = new JLabel();
         precoLitroLabel.setText("Preço por litro: ");
         precoLitroLabel.setBounds(150, 350, 160, 25);

         JLabel LitroLabel = new JLabel();
         LitroLabel.setText("Quantidade de Litros: ");
         LitroLabel.setBounds(350, 350, 160, 25);
         
         JTextField userPrecoLitroText = new JTextField(20);
	     userPrecoLitroText.setBounds(140,350, 160, 25);
	     
         JTextField userLitroText = new JTextField(20);
         userLitroText.setBounds(340,350, 160, 25);
         
         JButton abastecimento = new JButton ("Adicionar abastecimento");
         abastecimento.setBounds(740,350, 250, 25);
         
         class PrecoLitroEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(userPrecoLitroText.getText());
                System.out.println(userLitroText.getText());
                
                userPrecoLitroText.getText().replaceAll( "," , "." );
                double precoLitro = Double.parseDouble(userPrecoLitroText.getText());
                
                userLitroText.getText().replaceAll( "," , "." );
                double litro = Double.parseDouble(userLitroText.getText());
                
                double valor = precoLitro * litro;
                System.out.println(valor);	
                db.InsertAbastecimento(precoLitro, litro, valor, name, carName);
                
            }
         }
         
         

         abastecimento.addActionListener(new PrecoLitroEvent());
         
         
         
          // Despesas
         
           JLabel tipoDespesa = new JLabel();
           tipoDespesa.setText("Tipo de despesa: ");
           tipoDespesa.setBounds(150, 400, 160, 25);
 
           JLabel valorDespesa = new JLabel();
           valorDespesa.setText("Valor da despesa:  ");
           valorDespesa.setBounds(350, 400, 160, 25);
           
           JLabel observacaoDespesa = new JLabel();
           observacaoDespesa.setText("OBS:  ");
           observacaoDespesa.setBounds(550, 400, 160, 25);
             
           JTextField usertipoDespesaText = new JTextField(20);
           usertipoDespesaText.setBounds(140,400, 160, 25);
  
           JTextField uservalorDespesaText = new JTextField(20);
           uservalorDespesaText.setBounds(340,400, 160, 25);
           
           JTextField userobservacaoDespesaText = new JTextField(50);
           userobservacaoDespesaText.setBounds(540,400, 160, 25);
 
           JButton buttonAdicionarDespesa = new JButton ("Adicionar despesa");
           buttonAdicionarDespesa.setBounds(740,400, 250, 25);

         //Receita

           JLabel tipoReceita = new JLabel();
           tipoReceita.setText("Tipo de receita: ");
           tipoReceita.setBounds(150, 450, 160, 25);
 
           JLabel valorReceita = new JLabel();
           valorReceita.setText("Valor da receita:  ");
           valorReceita.setBounds(350,450, 160, 25);
           
           JLabel observacaoReceita = new JLabel();
           observacaoReceita.setText("OBS:  ");
           observacaoReceita.setBounds(550, 450, 160, 25);
             
           JTextField usertipoReceitaText = new JTextField(20);
           usertipoReceitaText.setBounds(140,450, 160, 25);
  
           JTextField uservalorReceitaText = new JTextField(20);
           uservalorReceitaText.setBounds(340,450, 160, 25);
           
           JTextField userobservacaoReceitaText = new JTextField(50);
           userobservacaoReceitaText.setBounds(540,450, 160, 25);
 
           JButton buttonAdicionarReceita = new JButton ("Adicionar receita");
           buttonAdicionarReceita.setBounds(740,450, 250, 25);

         // Relatorio

         JButton buttonRelatorio = new JButton("Gerar relatorio");
         buttonRelatorio.setBounds(740,500, 250, 25);
         buttonRelatorio.setContentAreaFilled(false);
         buttonRelatorio.setOpaque(true);
         buttonRelatorio.setBackground(Color.RED);
           
           
           
      // ADD Abastecimento
      editCarViewFrame.add(abastecimento);
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
        editCarViewFrame.add(buttonAdicionarDespesa);
        
     // ADD Receita        
        
        editCarViewFrame.add(tipoReceita);
        editCarViewFrame.add(valorReceita);
        editCarViewFrame.add(observacaoReceita);
        editCarViewFrame.add(usertipoReceitaText);
        editCarViewFrame.add(uservalorReceitaText);
        editCarViewFrame.add(userobservacaoReceitaText);
        editCarViewFrame.add(buttonAdicionarReceita);
        
        
     // ADD Relatorio  
        
        editCarViewFrame.add(buttonRelatorio);   

        
    // ADD INFO
        
        editCarViewFrame.add(donoInfo); 
        editCarViewFrame.add(modeloInfo); 
        editCarViewFrame.add(marcaInfo); 
        editCarViewFrame.add(abastecimentosInfo); 
        editCarViewFrame.add(despesasInfo); 
        editCarViewFrame.add(receitaInfo); 
        

        editCarViewFrame.setLayout(null);
        editCarViewFrame.setVisible(true);

     }

}


