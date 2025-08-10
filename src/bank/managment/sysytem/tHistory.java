package bank.managment.sysytem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class tHistory extends JFrame implements ActionListener{
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
    String cardNumber,userName,email,balance,lasttransaction,type;
    JButton back;
    
    tHistory(String userName,String email,String cardNumber,String balance, String lasttransaction,String type){
        
       this.cardNumber=cardNumber;
       this.userName=userName;
       this.email=email;
       this.balance=balance;
       this.lasttransaction=lasttransaction;
       this.type=type;
       setTitle("NOVA BANK ONLINE SERVICE");
       setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        JLabel text=new JLabel("TRANSACTION HISTORY");
        text.setFont(new Font("System",Font.BOLD, 20));
        text.setBounds(220,290,280,28);
        text.setForeground(Color.red);
        image.add(text);
        
        JLabel bname=new JLabel("NOVA BANK OF INDIA         Branch Code: 45521");
        bname.setFont(new Font("System",Font.PLAIN, 15));
        bname.setBounds(169,320,350,28);
        bname.setForeground(Color.pink);
        image.add(bname);
        
        JLabel name=new JLabel("AC/Holder : ");
        name.setFont(new Font("System",Font.BOLD, 16));
        name.setBounds(169,350,280,20);
        name.setForeground(Color.white);
        image.add(name);
        
        JLabel nameText=new JLabel(""+userName);
        nameText.setFont(new Font("System",Font.BOLD, 16));
        nameText.setBounds(262,350,280,20);
        nameText.setForeground(Color.yellow);
        image.add(nameText);
        
        JLabel Email=new JLabel("Email : ");
        Email.setFont(new Font("System",Font.BOLD, 16));
        Email.setBounds(169,380,280,28);
        Email.setForeground(Color.white);
        image.add(Email);
        
        JLabel EmailText=new JLabel(""+email);
        EmailText.setFont(new Font("System",Font.BOLD, 16));
        EmailText.setBounds(228,380,280,20);
        EmailText.setForeground(Color.yellow);
        image.add(EmailText);
        
        JLabel accNumber=new JLabel("AC/No : ");
        accNumber.setFont(new Font("System",Font.BOLD, 16));
        accNumber.setBounds(169,410,280,20);
        accNumber.setForeground(Color.white);
        image.add(accNumber);
        
        JLabel accNumberText=new JLabel(""+cardNumber);
        accNumberText.setFont(new Font("System",Font.BOLD, 16));
        accNumberText.setBounds(240,410,280,20);
        accNumberText.setForeground(Color.yellow);
        image.add(accNumberText);
        
        JLabel Balance=new JLabel("Current Balance : ");
        Balance.setFont(new Font("System",Font.BOLD, 16));
        Balance.setBounds(169,440,280,20);
        Balance.setForeground(Color.white);
        image.add(Balance);
        
        JLabel BalanceText=new JLabel(""+balance);
        BalanceText.setFont(new Font("System",Font.BOLD, 16));
        BalanceText.setBounds(315,440,280,20);
        BalanceText.setForeground(Color.yellow);
        image.add(BalanceText);
        
        JLabel lastTransaction=new JLabel("Last Transaction : ");
        lastTransaction.setFont(new Font("System",Font.BOLD, 16));
        lastTransaction.setBounds(169,470,280,20);
        lastTransaction.setForeground(Color.white);
        image.add(lastTransaction);
        
        JLabel lastTransactionText=new JLabel(""+lasttransaction);
        lastTransactionText.setFont(new Font("System",Font.BOLD, 16));
        lastTransactionText.setBounds(169,495,380,20);
        lastTransactionText.setForeground(Color.yellow);
        image.add(lastTransactionText);
        
        
        JLabel Type=new JLabel("Transaction Type : ");
        Type.setFont(new Font("System",Font.BOLD, 16));
        Type.setBounds(169,520,280,20);
        Type.setForeground(Color.white);
        image.add(Type);
        
        JLabel TypeText=new JLabel(""+type);
        TypeText.setFont(new Font("System",Font.BOLD, 16));
        TypeText.setBounds(320,520,280,20);
        TypeText.setForeground(Color.yellow);
        image.add(TypeText);
        
        back=new JButton("Back");
        back.setFont(new Font("System",Font.BOLD, 22));
        back.setBounds(222,578,205,40);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
       
       
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        new Transaction("").setVisible(true);
    }
    
    public static void main(String args[]) {
        new tHistory("","","","","","");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
