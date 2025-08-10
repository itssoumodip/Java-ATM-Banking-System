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


public class MiniStatement extends JFrame implements ActionListener{
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

    JTextField card,name,email;
    JButton getData;
    public Connection c;
    public Statement st;
    String balance,lasttransaction,type;
    MiniStatement(){
        
       setTitle("NOVA BANK ONLINE SERVICE");
       setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        JLabel Name=new JLabel("Name : ");
        Name.setFont(new Font("System",Font.BOLD, 16));
        Name.setBounds(168,310,200,20);
        Name.setForeground(Color.white);
        image.add(Name);
       
        name=new JTextField();
        name.setFont(new Font("Raleway",Font.BOLD, 16));
        name.setBounds(260,310,225,25);
        name.setForeground(Color.white);
        name.setForeground(Color.black);
        image.add(name);
        
        JLabel Email=new JLabel("Email : ");
        Email.setFont(new Font("System",Font.BOLD, 16));
        Email.setBounds(168,340,200,20);
        Email.setForeground(Color.white);
        image.add(Email);
       
        email=new JTextField();
        email.setFont(new Font("Raleway",Font.BOLD, 16));
        email.setBounds(260,340,225,25);
        email.setForeground(Color.white);
        email.setForeground(Color.black);
        image.add(email);
        
        JLabel cardNumber=new JLabel("Card NO : ");
        cardNumber.setFont(new Font("System",Font.BOLD, 16));
        cardNumber.setBounds(168,370,200,20);
        cardNumber.setForeground(Color.white);
        image.add(cardNumber);
       
        card=new JTextField();
        card.setFont(new Font("Raleway",Font.BOLD, 16));
        card.setBounds(260,370,225,25);
        card.setForeground(Color.white);
        card.setForeground(Color.black);
        image.add(card);
        
        
        getData = new JButton("Get Data");
        getData.setFont(new Font("System",Font.PLAIN, 18));
        getData.setBounds(185,450,300,30);
        getData.setForeground(Color.white);
        getData.setForeground(Color.black);
        getData.addActionListener(this);
        image.add(getData);
        
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
        String userName = name.getText();
        String Email = email.getText();
        
        try{
           if(cardNumber.equals("")){
               JOptionPane.showMessageDialog(null,"Please Enter Card Number");
           }else{
                String query = "SELECT * FROM Account WHERE cardNumber = '" + cardNumber + "'";
                ResultSet rs = st.executeQuery(query);
                
                if(rs.next()){
                    this.balance= rs.getString("Balance");
                    this.lasttransaction= rs.getString("Date");
                    this.type= rs.getString("type");
                    System.out.print(lasttransaction);
                    tHistory ob=new tHistory(userName,Email,cardNumber,balance,lasttransaction,type);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Card Number");
                }
           }
            
        }catch(HeadlessException | SQLException error){
        JOptionPane.showMessageDialog(null,"Error: "+error);
        
      }
        
    }
    
    public static void main(String args[]) {
       new MiniStatement();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
