package bank.managment.sysytem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, register;
    JTextField cardText;
    JPasswordField pinText;
    public Connection c;
    public Statement st;

    public Login() {
        
        //set frame Title 
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null); // set Frame Layout null , because bu default layout center
        
        // set image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // load from system
        Image i2 = i1.getImage().getScaledInstance(135,135,Image.SCALE_DEFAULT); // SET height,width of img
        //convert image to imageIcon because we can't place direct image in Frame 
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label=new JLabel(i3);
        label.setBounds(50,10,135,135); // x-axis,y-axis,img width, img height
        
        add(label); // place image on Frame
        
        //change frame color
        getContentPane().setBackground(Color.white);
        
        //create a Label 
        JLabel text=new JLabel("Welcome to Nova Bank ATM");
        text.setBounds(200,60,530,40); // set position
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setForeground(Color.orange);
        add(text);
        
        //create a Label2 
        JLabel card=new JLabel("Enter Card No : ");
        card.setBounds(145,150,280,50); // set position
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        card.setForeground(Color.black);
        add(card);
        
        // add text field 
        cardText=new JTextField();
        cardText.setBounds(365,157,290,30);
        cardText.setFont(new Font("Monospaced", Font.PLAIN, 23));
        add(cardText);
        
        //create a Label3 
        JLabel pin=new JLabel("Enter PIN : ");
        pin.setBounds(145,220,290,50); // set position
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setForeground(Color.black);
        add(pin);
        
          // add text field 
        pinText=new JPasswordField();
        pinText.setBounds(365,223,290,30);
        pinText.setFont(new Font("Monospaced", Font.PLAIN, 23));
        add(pinText);
       
        // button sign in
        login=new JButton("SIGN IN");
        login.setBounds(368,300,120,36);
        login.setForeground(Color.white);
        login.setBackground(Color.black);
        login.setFont(new Font("Raleway", Font.BOLD, 20));
        login.addActionListener(this);
        add(login);
        
        // button clear
        clear=new JButton("CLEAR");
        clear.setBounds(530,300,120,36);
        clear.setForeground(Color.white);
        clear.setBackground(Color.black);
        clear.setFont(new Font("Raleway", Font.BOLD, 20));
        clear.addActionListener(this);
        add(clear);
        
        // button sign up
        register=new JButton("SIGN UP");
        register.setBounds(368,365,282,36);
        register.setForeground(Color.white);
        register.setBackground(Color.black);
        register.setFont(new Font("Raleway", Font.BOLD, 20));
        register.addActionListener(this);
        add(register);
        
       
        //create Frame 
       
        setResizable(false);
        setSize(800,490);
        setVisible(true);  //set visibility of Frame 
        setLocation(350,200); // set Frame location in window
        
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "yoursoumodip14");
            st = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
      
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }// </editor-fold>                        
    @Override
    public void actionPerformed(ActionEvent e){
        
      if(e.getSource()== clear){
          cardText.setText(" ");
          pinText.setText("");
          
      } else if (e.getSource()== login){
          
          String cardNumber = cardText.getText();
          String pinNumber = pinText.getText();
          try {

               String query = "SELECT * FROM Account WHERE cardNumber = '"+cardNumber+"' AND pinNumber =  '"+pinNumber+"' ";
               ResultSet rs = (ResultSet) st.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Transaction(pinNumber).setVisible(true);
               }else
                JOptionPane.showMessageDialog(null, "Invalid Credintials!!");
               
            }catch (HeadlessException ex) {
               JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } catch (SQLException ex) {
              Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }else if(e.getSource()== register){
          this.hide();
          SignupOne ob2=new SignupOne();
          ob2.show();
      }
       
        
    }
    public static void main(String args[]) {
        
         Login ob=new Login();
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
