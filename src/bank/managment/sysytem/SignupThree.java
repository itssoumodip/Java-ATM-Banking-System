package bank.managment.sysytem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupThree extends JFrame implements ActionListener {
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

    JRadioButton r1,r2,r3,r4;
    ButtonGroup accountgroup;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    public Connection c;
    public Statement st;
    String formno,name;
            
    SignupThree(String formno,String name){
        
        this.name=name;
        this.formno=formno;
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        getContentPane().setBackground(Color.white);
      
        JLabel l1=new JLabel("Page 4: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        l1.setBounds(260,40,400,40);
        l1.setForeground(Color.black);
        add(l1);
        
        
        JLabel type=new JLabel("Account Type : ");
        type.setFont(new Font("Raleway",Font.BOLD,25));
        type.setBounds(100,140,200,30);
        type.setForeground(Color.black);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setForeground(Color.black);
        r1.setBackground(Color.white);
        r1.setBounds(120,190,150,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setForeground(Color.black);
        r2.setBackground(Color.white);
        r2.setBounds(370,190,230,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setForeground(Color.black);
        r3.setBackground(Color.white);
        r3.setBounds(120,230,150,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setForeground(Color.black);
        r4.setBackground(Color.white);
        r4.setBounds(370,230,180,20);
        add(r4);
        
        accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        
        
        JLabel cardno=new JLabel("Card Number : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,25));
        cardno.setBounds(100,300,200,30);
        cardno.setForeground(Color.black);
        add(cardno);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,25));
        number.setBounds(330,300,400,30);
        number.setForeground(Color.black);
        add(number);
        
        
        JLabel carddetails=new JLabel("Your 16 Digits Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,330,400,20);
        carddetails.setForeground(Color.red);
        add(carddetails);
        
        JLabel pinno=new JLabel("PIN Number: ");
        pinno.setFont(new Font("Raleway",Font.BOLD,25));
        pinno.setBounds(100,370,200,30);
        pinno.setForeground(Color.black);
        add(pinno);
        
        
        JLabel pindetails=new JLabel("Your 4 Digits PIN");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,400,20);
        pindetails.setForeground(Color.red);
        add(pindetails);
        
        
        JLabel pNumber=new JLabel("XXXX");
        pNumber.setFont(new Font("Raleway",Font.BOLD,25));
        pNumber.setBounds(330,370,400,30);
        pNumber.setForeground(Color.black);
        add(pNumber);
        
        
        
        JLabel service=new JLabel("Service Required : ");
        service.setFont(new Font("Raleway",Font.BOLD,25));
        service.setBounds(100,450,350,30);
        service.setForeground(Color.black);
        add(service);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(120,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(370,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobail Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(120,550,200,30);
        add(c3);
        
        c4=new JCheckBox("Email & SMS ALERT");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(370,550,350,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(120,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(370,600,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,680,590,30);
        add(c7);
        
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD,16));
        submit.setBounds(180,735,100,30);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD,16));
        cancel.setBounds(420,735,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        setSize(740,820);
        setLocation(350,0);
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
         if(e.getSource()== submit){
             
             String accountType = null;
             if(r1.isSelected()){
                 accountType = "Saving Account";
             }else if(r2.isSelected()){
                 accountType = "Fixed Deposite Account";
             }else if(r3.isSelected()){
                 accountType = "Current Account";
             }else if(r4.isSelected()){
                 accountType = "Recurring Account";
             }
             
            //generated card and pin 
            Random ran=new Random();
            String  cardNumber ="" + Math.abs((ran.nextLong()%90000000L)+ 5040936000000000L);
            String pinNumber = "" + (1000 + ran.nextInt(9000));
            String tempMoney ="2000";
            Date date=new Date();
            String type = "Create";
            
            String facility="";
            if(c1.isSelected()){
                facility+=" ATM Card, ";
            }if(c2.isSelected()){
                facility+=" Internet Banking, ";
            }if(c3.isSelected()){
                facility+=" Mobail Banking, ";
            }if(c4.isSelected()){
                facility+=" Email & SMS ALERT, ";
            }if(c5.isSelected()){
                facility+=" Cheque Book, ";
            }if(c6.isSelected()){
                facility+=" E-Statement, ";
            }
            
            try {
               
                // save data 
               String query = "INSERT INTO signup3 VALUES('" + formno+ "','" + accountType+ "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
               String query2 = "INSERT INTO Account VALUES('" + formno+ "','" + cardNumber + "','" + pinNumber + "','" + type + "','" + tempMoney + "','" + date + "')";
                
                st.executeUpdate(query);
                st.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Account Created Successfull!!");
               
                JOptionPane.showMessageDialog(null, "RS 2000 Credited in your Account\nLater it would be Cut from your account\nand you should maintain 500 RS in your account!!");
                
                JOptionPane.showMessageDialog(null, "Welcome "+name+"!!!\nYour Card Number: "+cardNumber+"\nPIN : "+pinNumber);
                this.hide();
                Login obj=new Login();
                obj.show();
               
            }catch (HeadlessException ex) {
               JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } catch (SQLException ex) {
                 Logger.getLogger(SignupThree.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }else if(e.getSource() == cancel){
            System.exit(0);
         }
     }
    
   
    public static void main(String args[]) {
      
        SignupThree signupThree = new SignupThree(""," ");
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
