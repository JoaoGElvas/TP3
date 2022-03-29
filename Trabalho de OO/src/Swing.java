import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Swing {
    private static  DB db;
    Swing(DB dbReference){
        db = dbReference;
    }

	// Telas
	private static final JFrame f = new JFrame("Tela de Login");
    private static JFrame dashboardFrame;
	
    private static final JButton buttonRegister = new JButton("Registrar-se");
    private static JButton buttonLogin;
    private static JTextField userLoginText;
    private static final JTextField userRegisterText = new JTextField(20);

    private static boolean isLogged = false;

    
    public static class LoginEvent implements ActionListener {
		public void actionPerformed(ActionEvent evt){

            isLogged = db.SearchDono(userLoginText.getText());
            if(isLogged){
                f.setVisible(false);
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
    

    public static void main(String[] a){
		
     }

    
    //Pagina de Login
     public static void LoginPage(){
         userLoginText = new JTextField(20);
         userLoginText.setBounds(100,30, 160, 25);
         f.add(userLoginText);
         buttonLogin = new JButton("Fazer Login");

         buttonLogin.setBounds(100,80,160, 40);
         f.add(buttonLogin);
         f.setSize(400,500);
         f.setLayout(null);
         f.setVisible(true);
         buttonLogin.addActionListener(new LoginEvent());

         userRegisterText.setBounds(1000,30, 160, 25);
         f.add(userRegisterText);

         buttonRegister.setBounds(1000,80,160, 40 );
         f.add(buttonRegister);
         f.setSize(400,500);
         f.setLayout(null);
         f.setVisible(true);
         buttonRegister.addActionListener(new RegisterEvent());
     }
     
     //Dashboard Principal
     public static void Dashboard(String name){
        dashboardFrame = new JFrame("Dashboard, Bem vindo: " + name);
     	JButton createCarButton = new JButton("Cadastrar veiculo");
     	dashboardFrame.setSize(400,500);
     	dashboardFrame.setLayout(null);

     	dashboardFrame.add(createCarButton);
     	dashboardFrame.setVisible(true);
     }

}


