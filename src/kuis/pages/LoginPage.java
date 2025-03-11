package kuis.pages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
    
    private JLabel userlbl, passlbl, lbl; 
    public JTextField username; 
    private JPasswordField password; 
    private JButton btnLogin; 
    private JPanel panel, panelBtn, panellbl;
    public LoginPage(){
        super("Halaman Login"); 
        setLayout(new BorderLayout()); 
        
        lbl = new JLabel("Selamat Datang di Aplikasi 123230079"); 
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        panellbl = new JPanel(); 
        panellbl.add(lbl);
        add(panellbl, BorderLayout.NORTH);
        
        panel = new JPanel(new GridLayout(3,2,5,5)); 
        userlbl = new JLabel("Username : "); 
        passlbl = new JLabel("Password : "); 
        username = new JTextField(); 
        password = new JPasswordField(); 
        panel.add(userlbl); 
        panel.add(username); 
        panel.add(passlbl); 
        panel.add(password); 
        
        add(panel, BorderLayout.CENTER); 
        
        panelBtn = new JPanel(); 
        btnLogin = new JButton("Login");
        btnLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        btnLogin.addActionListener(this);
        panelBtn.add(btnLogin); 
        add(panelBtn, BorderLayout.SOUTH); 
        pack(); 
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin)
        {
            //String user = username.getText().toLowerCase(); 
            String pass = new String(password.getPassword()); 
            if((!username.getText().isEmpty() && pass.equals("if-d"))){
                new MainPage(username.getText()); 
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal Login, Pastikan USername Terisi & Password Sesuai","Error",JOptionPane.ERROR_MESSAGE);
                username.setText("");
                password.setText("");
            }
        }
        
    }
    
}
