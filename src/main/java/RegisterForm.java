import ConnectDB.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    Connect connect = new Connect();

    public RegisterForm() {
        setTitle("Register");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        registerButton = new JButton("Register");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        add(panel);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Connection connection = connect.getConnection();

                String pass_maHoa = Base64.getEncoder().encodeToString(password.getBytes());

                //lay du lieu tu db
                String query = "INSERT INTO `account`(`user`, `pass`) VALUES (?,?)";
                try {
                    PreparedStatement st = connection.prepareStatement(query);

                    st.setString(1, username);
                    st.setString(2, pass_maHoa);

                    System.out.println(st);

                    int rs = st.executeUpdate();

                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "sign up success");
                        LoginForm loginForm = new LoginForm();
                        loginForm.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "sign in fail");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
