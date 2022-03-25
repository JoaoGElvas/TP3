import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Swing {

	// Telas
	private static JFrame f = new JFrame("Tela de Login");
	private static JFrame dashboardFrame = new JFrame("Dashboard");
	
    private static JButton buttonRegister = new JButton("Registrar-se");
    private static JButton buttonLogin;
    private static JTextField userLoginText;
    private static JTextField userRegisterText = new JTextField(20);

    
    public static class LoginEvent implements ActionListener {
		DB db;
		LoginEvent(DB dbReference){
			db = dbReference;
		}
		public void actionPerformed(ActionEvent evt){
            System.out.println("login: " + userLoginText.getText());
            db.SearchDono(userLoginText.getText());
        }
    }

    public static class RegisterEvent implements ActionListener {
		DB db;
        RegisterEvent(DB dbReference){
            db = dbReference;
        }
        public void actionPerformed(ActionEvent evt){
            System.out.println("register clicado");
            db.InsertDono(userRegisterText.getText());
        }
    }
    

    public static void main(String[] a){
		
     }

    
    //Pagina de Login
     public static void LoginPage(DB db){
         userLoginText = new JTextField(20);
         userLoginText.setBounds(100,30, 160, 25);
         f.add(userLoginText);
         buttonLogin = new JButton("Fazer Login");

         buttonLogin.setBounds(100,80,160, 40);
         f.add(buttonLogin);
         f.setSize(400,500);
         f.setLayout(null);
         f.setVisible(true);
         buttonLogin.addActionListener(new LoginEvent(db));

         userRegisterText.setBounds(1000,30, 160, 25);
         f.add(userRegisterText);

         buttonRegister.setBounds(1000,80,160, 40 );
         f.add(buttonRegister);
         f.setSize(400,500);
         f.setLayout(null);
         f.setVisible(true);
         buttonRegister.addActionListener(new RegisterEvent(db));
     }
     
     //Dashboard Principal
     public static void Dashboard(){
     	
     }

}


