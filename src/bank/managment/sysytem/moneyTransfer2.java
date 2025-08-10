package bank.managment.sysytem;
import java.awt.Color;
import java.awt.Font;
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

public class moneyTransfer2 extends JFrame  implements ActionListener {
    
    
    JTextField card2,pin,amount;
    JButton transfer,back;
    String rcardNumber;
    public Connection c;
    public Statement st;
    public moneyTransfer2(String rcardNumber,String rName) {
        
        this.rcardNumber=rcardNumber;
        
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        
        JLabel text=new JLabel("Enter  Your Card No  ");
        text.setFont(new Font("System",Font.BOLD, 18));
        text.setBounds(185,305,300,20);
        text.setForeground(Color.white);
        image.add(text);
       
        card2=new JTextField();
        card2.setFont(new Font("Raleway",Font.PLAIN, 18));
        card2.setBounds(185,330,300,25);
        card2.setForeground(Color.white);
        card2.setForeground(Color.black);
        image.add(card2);
        
        
        JLabel text2=new JLabel("Enter Your PIN  ");
        text2.setFont(new Font("System",Font.BOLD, 18));
        text2.setBounds(185,375,300,20);
        text2.setForeground(Color.white);
        image.add(text2);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.PLAIN, 18));
        pin.setBounds(185,400,300,25);
        pin.setForeground(Color.white);
        pin.setForeground(Color.black);
        image.add(pin);
        
        JLabel text3=new JLabel("Enter Amount  ");
        text3.setFont(new Font("System",Font.BOLD, 18));
        text3.setBounds(185,445,300,20);
        text3.setForeground(Color.white);
        image.add(text3);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.PLAIN, 18));
        amount.setBounds(185,470,300,25);
        amount.setForeground(Color.white);
        amount.setForeground(Color.black);
        image.add(amount);
        
        
        transfer=new JButton("Transfer");
        transfer.setFont(new Font("System",Font.PLAIN, 20));
        transfer.setBounds(185,520,120,30);
        transfer.setForeground(Color.white);
        transfer.setForeground(Color.black);
        transfer.addActionListener(this);
        image.add(transfer);
        
        
        back=new JButton("Back");
        back.setFont(new Font("System",Font.PLAIN, 20));
        back.setBounds(361,520,120,30);
        back.setForeground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
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
    @Override
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==back){
            Transaction obj=new Transaction("");
            this.hide();
            obj.show();
        }else if(e.getSource()==transfer){
            String userCardNo = card2.getText();
            String userPin = pin.getText();
            String Amount = amount.getText();
            String type="Transfer Rs ";
            String type2="Credited Rs ";
            Date date=new Date();
            try{
                
               if(userCardNo.equals("") || userPin.equals("") || Amount.equals("")){
                   
                   JOptionPane.showMessageDialog(null,"Please Fill up All Fields");
               }
               else{
                   String query = "SELECT *FROM Account WHERE cardNumber = '" + userCardNo + "' and pinNumber = '" + userPin + "'";
                   ResultSet rs = st.executeQuery(query);
                   
                   if(rs.next()){
                        String balance = rs.getString("Balance");
            
                         int balanceInt = Integer.parseInt(balance);
                         int addAmount = Integer.parseInt(Amount);
                         int newAmount = balanceInt - addAmount;
            
                         if(newAmount<500){
                              JOptionPane.showMessageDialog(null,"Insufficient Balance");
                               System.exit(0);
                         }
                         
                         String query2 = "SELECT *FROM Account WHERE cardNumber = '" + rcardNumber + "'";
                         ResultSet rs2 = st.executeQuery(query2);
                         
                         if(rs2.next()){
                             
                            String balance2 = rs2.getString("Balance");
                            int balanceInt2 = Integer.parseInt(balance2);
                            int newAmount2 = balanceInt2 + addAmount;
                            
                            String query3 = "UPDATE Account SET Balance = '" + newAmount + "', type = '" + (type+" "+addAmount) + "',Date = '" + date + "' WHERE cardNumber = '" + userCardNo + "'";
                            String query4 = "UPDATE Account SET Balance = '" + newAmount2 + "', type = '" + (type2+" "+addAmount) + "',Date = '" + date + "' WHERE cardNumber = '" + rcardNumber + "'";
                             
                           int rowsUpdated = st.executeUpdate(query3);
                           int rowsUpdated2 = st.executeUpdate(query4);

                           if (rowsUpdated > 0 && rowsUpdated2 > 0) {
                              JOptionPane.showMessageDialog(null, "Rs "+Amount+" successfully Transfered in "+rcardNumber);
                              Transaction obj=new Transaction("");
                              this.hide();
                               obj.show();
                           } else {
                              JOptionPane.showMessageDialog(null, "Failed to Withdrawl amount.");
                           }
                             
                         }else{
                             JOptionPane.showMessageDialog(null,"Invalid Reciver Crad No or PIN");
                             this.hide();
                             new moneyTransfer().setVisible(true);
                         }
                       
                   }else{
                       JOptionPane.showMessageDialog(null,"Invalid Crad No or PIN");
                   }
                   
               }
                
            }catch(SQLException error){
            JOptionPane.showMessageDialog(null,"Error"+error);
        }
        }
    }
    
    public static void main(String args[]) {
        new moneyTransfer2("","");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
