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

public class PinChange extends JFrame implements ActionListener{
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
    JPasswordField oldPin,newPin;
    JButton SetPin;
    public Connection c;
    public Statement st;
    
    PinChange(){
        
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
        text.setBounds(168,300,200,20);
        text.setForeground(Color.white);
        image.add(text);
       
        card=new JTextField();
        card.setFont(new Font("Raleway",Font.PLAIN, 18));
        card.setBounds(300,300,205,25);
        card.setForeground(Color.white);
        card.setForeground(Color.black);
        image.add(card);
        
        
        JLabel pinNumber=new JLabel("Old PIN : ");
        pinNumber.setFont(new Font("System",Font.BOLD, 18));
        pinNumber.setBounds(168,360,200,20);
        pinNumber.setForeground(Color.white);
        image.add(pinNumber);
        
        oldPin=new JPasswordField();
        oldPin.setFont(new Font("Raleway",Font.PLAIN, 18));
        oldPin.setBounds(300,360,205,25);
        oldPin.setForeground(Color.white);
        oldPin.setForeground(Color.black);
        image.add(oldPin);
        
         JLabel setPin=new JLabel("Set New PIN : ");
        setPin.setFont(new Font("System",Font.BOLD, 18));
        setPin.setBounds(168,420,200,20);
        setPin.setForeground(Color.white);
        image.add(setPin);
        
        newPin=new JPasswordField();
        newPin.setFont(new Font("Raleway",Font.PLAIN, 18));
        newPin.setBounds(300,420,205,25);
        newPin.setForeground(Color.white);
        newPin.setForeground(Color.black);
        image.add(newPin);
        
        
        SetPin=new JButton("Change PIN");
        SetPin.setFont(new Font("System",Font.PLAIN, 18));
        SetPin.setBounds(255,490,180,30);
        SetPin.setForeground(Color.white);
        SetPin.setForeground(Color.black);
        SetPin.addActionListener(this);
        image.add(SetPin);
          
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
       String oldPIN = oldPin.getText();
       String newPIN = newPin.getText();
       try{
           
           if(cardNumber.equals("") || oldPIN.equals("") || newPIN.equals("")){
                JOptionPane.showMessageDialog(null,"Please Fill up All Fields");
           }else{
               
               String query = "SELECT *FROM Account WHERE cardNumber = '" + cardNumber + "' and pinNumber = '" + oldPIN + "'";
               ResultSet rs = st.executeQuery(query);
               
               if(rs.next()){
                   
                   String query2 = "UPDATE Account SET pinNumber= '" + newPIN + "' WHERE pinNumber = '"+ oldPIN+"' ";
                   
                   String query3 = "UPDATE signup3 SET pinNumber= '" + newPIN + "' WHERE pinNumber = '"+ oldPIN+"' ";
                   
                   int rowUpdate = st.executeUpdate(query2);
                   int rowUpdate2 = st.executeUpdate(query3);
                   
                   if(rowUpdate > 0 || rowUpdate2 > 0){
                      JOptionPane.showMessageDialog(null,"PIN Changed Successfull !!!");
                      Transaction obj=new Transaction("");
                      this.hide();
                      obj.show();
                       
                   }else{
                       JOptionPane.showMessageDialog(null,"PIN not Changed!!!");
                       Transaction obj=new Transaction("");
                      this.hide();
                      obj.show();
                   }
                
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid Card or Old PIN");
                   Transaction obj=new Transaction("");
                    this.hide();
                    obj.show();
               }
               
               
           }
           
       }catch(SQLException error){
            JOptionPane.showMessageDialog(null,"Error"+error);
       }
    }
    
    public static void main(String args[]) {
       new PinChange();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
