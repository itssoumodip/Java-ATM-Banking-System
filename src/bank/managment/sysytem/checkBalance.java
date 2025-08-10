package bank.managment.sysytem;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet; 
import javax.swing.JPasswordField;

public class checkBalance extends JFrame implements ActionListener {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JTextField card;
    JPasswordField pin;
    JButton submit;
    public Connection c;
    public Statement st;
    checkBalance(){
        
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        JLabel text=new JLabel("Card NO : ");
        text.setFont(new Font("System",Font.BOLD, 18));
        text.setBounds(168,310,200,20);
        text.setForeground(Color.white);
        image.add(text);
       
        card=new JTextField();
        card.setFont(new Font("Raleway",Font.PLAIN, 18));
        card.setBounds(280,310,205,25);
        card.setForeground(Color.white);
        card.setForeground(Color.black);
        image.add(card);
        
        
        JLabel pinNumber=new JLabel("PIN : ");
        pinNumber.setFont(new Font("System",Font.BOLD, 18));
        pinNumber.setBounds(168,370,200,20);
        pinNumber.setForeground(Color.white);
        image.add(pinNumber);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.PLAIN, 18));
        pin.setBounds(280,370,205,25);
        pin.setForeground(Color.white);
        pin.setForeground(Color.black);
        image.add(pin);
        
        
        submit = new JButton("Submit");
        submit.setFont(new Font("System",Font.PLAIN, 20));
        submit.setBounds(185,450,300,30);
        submit.setForeground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        image.add(submit);
        
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "yoursoumodip14");
            st = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String cardNumber = card.getText();
        String pinNumber = pin.getText();
        
        try{
            
           String query = "SELECT *FROM Account WHERE cardNumber = '" + cardNumber + "' and pinNumber = '" + pinNumber + "'";
           ResultSet rs = st.executeQuery(query);
           
           if (rs.next()) {
            String balance = rs.getString("Balance"); // Assuming 'balance' is an INT column
            
            showBalance obj=new showBalance(balance);
            this.hide();
            obj.show();
            
           } else {
            JOptionPane.showMessageDialog(null, "Invalid card number or PIN.");
           }
           
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null,"Error"+error);
        }
    }
    
    public static void main(String args[]) {
        
        new checkBalance();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
