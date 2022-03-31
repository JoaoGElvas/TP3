import java.awt.BorderLayout;
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
    

    public static void main(String[] a){
		
     }

    
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
         
        class EditCarEvent implements ActionListener {
            public void actionPerformed(ActionEvent evt){
                 EditCarView(name);
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
     
        JList carsList = new JList(cars.toArray());

        carsList.setBounds(600, 200, 200, 100);
        dashboardFrame.add(BorderLayout.CENTER , carsList);
     	dashboardFrame.add(createCarButton);
     	dashboardFrame.add(EditCarButton);
     	dashboardFrame.setLayout(null);
     	dashboardFrame.setVisible(true);
     }

     //Car view

     public static void EditCarView(String name ){
         JFrame editCarViewFrame = new JFrame("Edite seu carro: " );
         editCarViewFrame.setSize(400,500);

         // Abastecimento
         JLabel precoLitroLabel = new JLabel();
         precoLitroLabel.setText("Preço por litro: ");
         precoLitroLabel.setBounds(150, 30, 160, 25);

         JLabel LitroLabel = new JLabel();
         LitroLabel.setText("Quantidade de Litros: ");
         LitroLabel.setBounds(350, 30, 160, 25);
         
         JTextField userPrecoLitroText = new JTextField(20);
	     userPrecoLitroText.setBounds(140,30, 160, 25);
	     
         JTextField userLitroText = new JTextField(20);
         userLitroText.setBounds(340,30, 160, 25);
         
         JButton abastecimento = new JButton ("Adicionar abastecimento");
         abastecimento.setBounds(740,30, 250, 25);
         
          // Despesas
           JLabel tipoDespesa = new JLabel();
           tipoDespesa.setText("Tipo de despesa: ");
           tipoDespesa.setBounds(150, 80, 160, 25);
 
           JLabel valorDespesa = new JLabel();
           valorDespesa.setText("Valor Despesa:  ");
           valorDespesa.setBounds(350, 80, 160, 25);
           
           JLabel observacaoDespesa = new JLabel();
           observacaoDespesa.setText("OBS:  ");
           observacaoDespesa.setBounds(550, 80, 160, 25);
             
           JTextField usertipoDespesaText = new JTextField(20);
           usertipoDespesaText.setBounds(140,80, 160, 25);
  
           JTextField uservalorDespesaText = new JTextField(20);
           uservalorDespesaText.setBounds(340,80, 160, 25);
           
           JTextArea userobservacaoDespesaText = new JTextArea();
           userobservacaoDespesaText.setBounds(540,80, 160, 25);
 
           JButton buttonAdicionarDespesa = new JButton ("Adicionar despesa");
           buttonAdicionarDespesa.setBounds(740,80, 250, 25);

         //
           
           


           
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
      
      

	  editCarViewFrame.setLayout(null);
	  editCarViewFrame.setVisible(true);

     }

}


