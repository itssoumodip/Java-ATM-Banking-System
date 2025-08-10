package bank.managment.sysytem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
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
    JButton deposite,withdrawl,pinChange,ministatement,checkBalance,exit,moneytransfer;
    String pinNumber;
    Transaction(String pinNumber){
        
        this.pinNumber=pinNumber;
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Syatem", Font.BOLD,16));
        image.add(text); 
        
        deposite=new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        moneytransfer=new JButton("Money Transfer");
        moneytransfer.setBounds(170,450,150,30);
        moneytransfer.addActionListener(this);
        image.add(moneytransfer);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        
        checkBalance=new JButton("Balance Enquery");
        checkBalance.setBounds(355,485,150,30);
        checkBalance.addActionListener(this);
        image.add(checkBalance);
        
        
        exit=new JButton("Exit");
        exit.setBounds(262,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setUndecorated(true);
        setResizable(false);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
       
        setResizable(false);

        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==checkBalance){
            this.hide();
            checkBalance obj=new checkBalance();
            obj.show();
        }else if(e.getSource()==deposite){
            Deposite obj=new Deposite();
            this.hide();
            obj.show();
        }else if(e.getSource()==withdrawl){
            Withdrawl obj=new Withdrawl();
            this.hide();
            obj.show();
        }else if(e.getSource()==ministatement){
            MiniStatement obj=new MiniStatement();
            this.hide();
            obj.show();
        }else if(e.getSource()==moneytransfer){
            moneyTransfer obj=new moneyTransfer();
            this.hide();
            obj.show();
        }else if(e.getSource()==pinChange){
            this.hide();
            new PinChange().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        Transaction transaction = new Transaction("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
