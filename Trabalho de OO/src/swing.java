import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class swing { 
	private static JFrame f = new JFrame("Tela de Login");
    private static JButton buttonRegister=new JButton("Registrar-se");
    private static JButton buttonLogin;
    private static JTextField userLoginText;
    private static JTextField userRegisterText = new JTextField(20);
    
    public void main(String[] a){
		buttonLogin.addActionListener(new UserEvent());
    }
    
    userLoginText = new JTextField(20);
    userLoginText.setBounds(100,30, 160, 25);
    f.add(userLoginText);
    buttonLogin = new JButton("Fazer Login");

    buttonLogin.setBounds(100,80,160, 40);
    f.add(buttonLogin);
    f.setSize(400,500);
    f.setLayout(null);
    f.setVisible(true);
    
    userRegisterText.setBounds(1000,30, 160, 25);
    f.add(userRegisterText);

    buttonRegister.setBounds(1000,80,160, 40 );
    f.add(buttonRegister);
    f.setSize(400,500);
    f.setLayout(null);
    f.setVisible(true);

    public class UserEvent implements ActionListener {
		public void actionPerformed(ActionEvent evt){
            System.out.println("butao clicado");
        }
    }   
}


