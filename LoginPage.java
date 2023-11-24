import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LoginPage implements ActionListener {
    private static JTextField userText;
    private static JPasswordField passText;
    private static JLabel user;
    private static JLabel pass;
    private static JLabel loginstatus;
    private static JButton login;

    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        frame.setSize(400,220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Facebook");
        panel.setLayout(null);
        ImageIcon img=new ImageIcon("facebook.png");
        frame.add(panel);
        panel.setBackground(new Color(0x3b5998));
        frame.setIconImage(img.getImage());
        pass=new JLabel("Password");
        user=new JLabel("Username");
        loginstatus=new JLabel("");
        userText=new JTextField(20);
        passText=new JPasswordField(20);
        user.setForeground(Color.white);
        pass.setForeground(Color.white);
        login =new JButton("Log In");
        login.addActionListener(new LoginPage());
        userText.setBounds(130,30,200,20);
        passText.setBounds(130,70,200,20);
        user.setBounds(50,30,60,20);
        pass.setBounds(50,70,60,20);
        login.setBounds(140,110,100,20);
        loginstatus.setBounds(60,140,300,20);
        panel.add(user);
        panel.add(pass);
        panel.add(userText);
        panel.add(passText);
        panel.add(login);
        panel.add(loginstatus);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=userText.getText();
        String password=passText.getText();
        if(username.isEmpty() || password.isEmpty()){
            loginstatus.setText("username or password is empty try again :'(");

        } else if (username.equals("omar") && password.equals("123456")) {
            loginstatus.setText("Login is successful complete the code please :)");
        }else{
            loginstatus.setText("Login is faild :( ");
        }

    }
}