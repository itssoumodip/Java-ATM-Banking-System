package bank.managment.sysytem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;


public class SignupTwo extends JFrame implements ActionListener {

    JButton clear,next;
    JTextField panText,aadharText;
    JRadioButton Sno,Syes,Ayes,Ano;
    ButtonGroup seniorgroup,existaccountgroup;
    public Connection c;
    public Statement st;
    JComboBox catagoryText,religionText,incomeText,educationText,occupationText;
    String formno,name;
    
    SignupTwo(String formno,String name){
        this.formno=formno;
        this.name=name;
        
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 23));
        additionalDetails.setBounds(290, 40, 400, 30);
        additionalDetails.setForeground(Color.black);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 110, 200, 30);
        religion.setForeground(Color.black);
        add(religion);
        
        String valReligions[] = {" Hindu"," Muslim"," Sikh"," Christan"," Others"};
        religionText = new JComboBox(valReligions);
        religionText.setFont(new Font("Monospaced", Font.BOLD, 20));
        religionText.setBounds(320, 110, 400, 35);
        religionText.setBackground(Color.white);
        add(religionText);

        JLabel catagory = new JLabel("Catagory : ");
        catagory.setFont(new Font("Raleway", Font.BOLD, 20));
        catagory.setBounds(100, 160, 200, 30);
        catagory.setForeground(Color.black);
        add(catagory);
        
        String valCatagory[] = {"General","OBC","ST","SC","Others"};
        catagoryText = new JComboBox(valCatagory);
        catagoryText.setFont(new Font("Monospaced", Font.BOLD, 20));
        catagoryText.setBounds(320, 160, 400, 35);
        catagoryText.setBackground(Color.white);
        add(catagoryText);

        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 210, 200, 30);
        income.setForeground(Color.black);
        add(income);

        String valIncome[] = {" Null"," < 1,50,000"," < 2,50,000"," < 5,00,000"," Upto 10,00,000"};
        incomeText = new JComboBox(valIncome);
        incomeText.setFont(new Font("Monospaced", Font.BOLD, 20));
        incomeText.setBounds(320, 210, 400, 35);
        incomeText.setBackground(Color.white);
        add(incomeText);
        

        JLabel gender = new JLabel("Educational  ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 280, 200, 30);
        gender.setForeground(Color.black);
        add(gender);


        JLabel education = new JLabel("Qualification : ");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 305, 200, 30);
        education.setForeground(Color.black);
        add(education);
        
        String valEducation[] = {" Matrix"," HS"," Graduate"," Post Graduate"," Doctrate"," Others"};
        educationText = new JComboBox(valEducation);
        educationText.setFont(new Font("Monospaced", Font.BOLD, 20));
        educationText.setBounds(320, 305, 400, 35);
        educationText.setBackground(Color.white);
        add(educationText);
       

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 360, 200, 30);
        occupation.setForeground(Color.black);
        add(occupation);
        
        String valOccupation[] = {" Businessman"," Coporate Employee"," Doctor"," Engineer"," Government Employee", " Lawyer"," Labour"," Salaried"," Self-Employed"," Student"," Others"};
        occupationText = new JComboBox(valOccupation);
        occupationText.setFont(new Font("Monospaced", Font.BOLD, 20));
        occupationText.setBounds(320, 358, 400, 35);
        occupationText.setBackground(Color.white);
        add(occupationText);

    

        JLabel pan = new JLabel("PAN NO : ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 410, 200, 30);
        pan.setForeground(Color.black);
        add(pan);

        panText = new JTextField();
        panText.setFont(new Font("Monospaced", Font.BOLD, 20));
        panText.setBounds(320, 410, 400, 35);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar No : ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 460, 200, 30);
        aadhar.setForeground(Color.black);
        add(aadhar);

        aadharText = new JTextField();
        aadharText.setFont(new Font("Monospaced", Font.BOLD, 20));
        aadharText.setBounds(320, 460, 400, 35);
        add(aadharText);

        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 510, 200, 30);
        seniorCitizen.setForeground(Color.black);
        add(seniorCitizen);
        
        Syes = new JRadioButton("Yes");
        Syes.setBounds(330, 510, 130, 47);
        Syes.setBackground(Color.white);
        Syes.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(Syes);
        
        Sno = new JRadioButton("No");
        Sno.setBounds(470, 510, 130, 47);
        Sno.setBackground(Color.white);
        Sno.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(Sno);
        
        seniorgroup = new ButtonGroup();
        seniorgroup.add(Syes);
        seniorgroup.add(Sno);

        JLabel existAccount = new JLabel("Existing Account : ");
        existAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existAccount.setBounds(100, 560, 200, 30);
        existAccount.setForeground(Color.black);
        add(existAccount);
        
        Ayes = new JRadioButton("Yes");
        Ayes.setBounds(330, 560, 130, 47);
        Ayes.setBackground(Color.white);
        Ayes.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(Ayes);
        
        Ano = new JRadioButton("No");
        Ano.setBounds(470, 560, 130, 47);
        Ano.setBackground(Color.white);
        Ano.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(Ano);
        
        existaccountgroup = new ButtonGroup();
        existaccountgroup.add(Ayes);
        existaccountgroup.add(Ano);


        next = new JButton("NEXT");
        next.setBounds(332, 650, 159, 36);
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
              String religion = (String) religionText.getSelectedItem();
              String catagory = (String) catagoryText.getSelectedItem();
              String  income =  (String) incomeText.getSelectedItem();
              String education = (String) educationText.getSelectedItem();
              String occupation = (String) occupationText.getSelectedItem();
              String seniorcitizen = null;
              if(Syes.isSelected()){
                  seniorcitizen="Yes";
              }else if(Sno.isSelected()){
                  seniorcitizen="No";
              }
              
              String isAccount = null;
              if(Ayes.isSelected()){
                  isAccount="Yes";
              }else if(Ano.isSelected()){
                  isAccount="No";
              }
              
             String pan = panText.getText();
             String aadhar = aadharText.getText();

            try {
               
                String query = "INSERT INTO signup2 VALUES('" + formno + "','" + religion + "','" + catagory + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + seniorcitizen + "','" + isAccount + "')";
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form  2 Submitted Successfully!");
                this.hide();
                SignupThree obj=new SignupThree(formno,name);
                obj.show();
                
            } catch (HeadlessException | SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }

        if (e.getSource() == clear) {
            panText.setText("");
            aadharText.setText("");
            seniorgroup.clearSelection();
            existaccountgroup.clearSelection();
            religionText.setSelectedIndex(-1);
            catagoryText.setSelectedIndex(-1);
            incomeText.setSelectedIndex(-1);
            educationText.setSelectedIndex(-1);
            occupationText.setSelectedIndex(-1);
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
        SignupTwo signupTwo = new SignupTwo(" "," ");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
