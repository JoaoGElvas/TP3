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

        dashboardFrame = new JFrame("Dashboard, Bem vindo: " + name);
     	dashboardFrame.setSize(400,500);
     	dashboardFrame.setLayout(null);
     	
     	JButton createCarButton = new JButton("Cadastrar veiculo");
     	createCarButton.setBounds(600,80,200, 80);
     	loginframe.setSize(400,500);
     	loginframe.setLayout(null);
     	loginframe.setVisible(true);
        createCarButton.addActionListener(new LoginEvent());


        JLabel carroLabel = new JLabel("Carro: ");
        carroLabel.setBounds(400, 200, 100, 80);
        loginframe.add(carroLabel);
        JList carsList = new JList(cars.toArray());


        System.out.println(cars);
        carsList.setBounds(600, 200, 200, 100);
        dashboardFrame.add(BorderLayout.CENTER , carsList);
     	dashboardFrame.add(createCarButton);
     	dashboardFrame.setVisible(true);
     }

     public static void CreateCarView(){
         
     }

}


