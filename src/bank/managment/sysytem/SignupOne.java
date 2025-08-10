package bank.managment.sysytem;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupOne extends JFrame implements ActionListener {
    
    JButton clear,next;
    JTextField nameText,gurdianNameText,emailText,pinText,stateText,cityText,addressText;
    JRadioButton male,female,others,married,unmarried;
    JDateChooser dobText;
    ButtonGroup gendergroup,maritalgroup;
    long randomNo;
    public Connection c;
    public Statement st;
    
    
    SignupOne(){
        
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);

        Random ran = new Random();
        randomNo = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO.  " + randomNo);
        formno.setFont(new Font("Raleway", Font.BOLD, 37));
        formno.setBounds(140, 10, 600, 40);
        formno.setForeground(Color.red);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 23));
        personalDetails.setBounds(290, 60, 400, 30);
        personalDetails.setForeground(Color.black);
        add(personalDetails);

        JLabel name = new JLabel("Enter Full Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 110, 200, 30);
        name.setForeground(Color.black);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Monospaced", Font.BOLD, 20));
        nameText.setBounds(320, 110, 400, 35);
        add(nameText);

        JLabel fathername = new JLabel("Gurdian Name : ");
        fathername.setFont(new Font("Raleway", Font.BOLD, 20));
        fathername.setBounds(100, 160, 200, 30);
        fathername.setForeground(Color.black);
        add(fathername);

        gurdianNameText = new JTextField();
        gurdianNameText.setFont(new Font("Monospaced", Font.BOLD, 20));
        gurdianNameText.setBounds(320, 160, 400, 35);
        add(gurdianNameText);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 210, 200, 30);
        dob.setForeground(Color.black);
        add(dob);

        dobText = new JDateChooser();
        dobText.setBounds(320, 210, 200, 35);
        dobText.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(dobText);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        gender.setForeground(Color.black);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(330, 260, 130, 47);
        male.setBackground(Color.white);
        male.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(470, 260, 130, 47);
        female.setBackground(Color.white);
        female.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(600, 260, 130, 47);
        others.setBackground(Color.white);
        others.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(others);

        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        JLabel email = new JLabel("Enter Email Id : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 310, 200, 30);
        email.setForeground(Color.black);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Monospaced", Font.BOLD, 20));
        emailText.setBounds(320, 310, 400, 35);
        add(emailText);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 360, 200, 30);
        marital.setForeground(Color.black);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(330, 358, 130, 47);
        married.setBackground(Color.white);
        married.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(470, 358, 180, 47);
        unmarried.setBackground(Color.white);
        unmarried.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(unmarried);

        maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 410, 200, 30);
        address.setForeground(Color.black);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Monospaced", Font.BOLD, 20));
        addressText.setBounds(320, 410, 400, 35);
        add(addressText);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 460, 200, 30);
        city.setForeground(Color.black);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Monospaced", Font.BOLD, 20));
        cityText.setBounds(320, 460, 400, 35);
        add(cityText);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 510, 200, 30);
        state.setForeground(Color.black);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Monospaced", Font.BOLD, 20));
        stateText.setBounds(320, 510, 400, 35);
        add(stateText);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 560, 200, 30);
        pincode.setForeground(Color.black);
        add(pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("Monospaced", Font.BOLD, 20));
        pinText.setBounds(320, 560, 400, 35);
        add(pinText);

        next = new JButton("NEXT");
        next.setBounds(320, 650, 159, 36);
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.addActionListener(this);
        add(next);

        clear = new JButton("CLEAR");
        clear.setBounds(560, 650, 159, 36);
        clear.setForeground(Color.white);
        clear.setBackground(Color.black);
        clear.setFont(new Font("Raleway", Font.BOLD, 20));
        clear.addActionListener(this);
        add(clear);

        getContentPane().setBackground(Color.white);

        setSize(850, 760);
        setLocation(350, 10);
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String formno = "" + randomNo;
            String name = nameText.getText();
            String fathername = gurdianNameText.getText();
            String dob = ((JTextField) dobText.getDateEditor().getUiComponent()).getText();
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : others.isSelected() ? "Others" : "";
            String email = emailText.getText();
            String marital = married.isSelected() ? "Married" : unmarried.isSelected() ? "Unmarried" : "";
            String address = addressText.getText();
            String city = cityText.getText();
            String state = stateText.getText();
            String pin = pinText.getText();

            try {
                if (name.equals("") || fathername.equals("") || dob.equals("") || gender.equals("") || email.equals("") || marital.equals("") || address.equals("") || city.equals("") || state.equals("") || pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!");
                } else {
                    String query = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fathername + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" + pin + "')";
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Form 1 Submitted Successfully!");
                    this.hide();
                    SignupTwo obj=new SignupTwo(formno,name);
                    obj.show();
                }
            } catch (HeadlessException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }

        if (e.getSource() == clear) {
            nameText.setText("");
            gurdianNameText.setText("");
            emailText.setText("");
            addressText.setText("");
            pinText.setText("");
            stateText.setText("");
            cityText.setText("");
            gendergroup.clearSelection();
            maritalgroup.clearSelection();
            dobText.setDate(null);
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

    public static void main(String args[]) {
         new SignupOne();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
