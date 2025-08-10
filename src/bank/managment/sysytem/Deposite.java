package bank.managment.sysytem;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.sql.ResultSet; 
import java.util.Date;

public class Deposite extends JFrame implements ActionListener{
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
    JButton deposite;
    JTextField card,amount;
    public Connection c;
    public Statement st;
    Deposite(){
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
        card.setFont(new Font("Raleway",Font.BOLD, 18));
        card.setBounds(280,310,205,25);
        card.setForeground(Color.white);
        card.setForeground(Color.black);
        image.add(card);
        
        
        JLabel Amount=new JLabel("Amount : ");
        Amount.setFont(new Font("System",Font.BOLD, 18));
        Amount.setBounds(168,370,200,20);
        Amount.setForeground(Color.white);
        image.add(Amount);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD, 18));
        amount.setBounds(280,370,205,25);
        amount.setForeground(Color.white);
        amount.setForeground(Color.black);
        image.add(amount);
        
        
        deposite = new JButton("Deposite");
        deposite.setFont(new Font("System",Font.PLAIN, 20));
        deposite.setBounds(185,450,300,30);
        deposite.setForeground(Color.white);
        deposite.setForeground(Color.black);
        deposite.addActionListener(this);
        image.add(deposite);
        
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
       String Amount = amount.getText();
       String type = "Deposite";
       Date date=new Date();

       if (cardNumber.isEmpty() || Amount.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter both card number and amount.");
        return;
       }

       try{
          String query = "SELECT * FROM Account WHERE cardNumber = '" + cardNumber + "'";
          ResultSet rs = st.executeQuery(query);

          if (rs.next()) {
            String balance = rs.getString("Balance");
            
            int balanceInt = Integer.parseInt(balance);
            int addAmount = Integer.parseInt(Amount);
            int newAmount = balanceInt + addAmount;

            System.out.println("Current Balance: " + balanceInt + ", Adding: " + addAmount + ", New Balance: " + newAmount);

            String query2 = "UPDATE Account SET Balance = '" + newAmount + "', type = '" + type + "', Date = '" + date + "' WHERE cardNumber = '" + cardNumber + "'";

            System.out.println("Update query: " + query2);

            int rowsUpdated = st.executeUpdate(query2);

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Balance updated successfully.");
                 Transaction obj=new Transaction("");
                 this.hide();
                 obj.show();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update balance.");
            }

         } else {
            JOptionPane.showMessageDialog(null, "Invalid card number or PIN.");
         }

       
      } catch(HeadlessException | SQLException error){
        JOptionPane.showMessageDialog(null,"Error: "+error);
        
      }
   }
   
    public static void main(String args[]) {
        Deposite deposite1 = new Deposite();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
