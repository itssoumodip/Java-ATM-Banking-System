package bank.managment.sysytem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class showBalance extends JFrame implements ActionListener {
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
    String balanace;
    JButton back,exit;
    showBalance(String balanace){
        this.balanace=balanace;
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        JLabel text=new JLabel("Your Current Balance is  : ");
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(200,330,290,20);
        text.setForeground(Color.white);
        image.add(text);
        
        JLabel bal=new JLabel(""+balanace);
        bal.setFont(new Font("System",Font.BOLD, 16));
        bal.setBounds(408,330,290,20);
        bal.setForeground(Color.yellow);
        image.add(bal);
        
        back=new JButton("Back to Menu");
        back.setFont(new Font("System",Font.PLAIN, 17));
        back.setBounds(185,400,140,30);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
        
        exit=new JButton("Exit");
        exit.setFont(new Font("System",Font.PLAIN, 17));
        exit.setBounds(355,400,140,30);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
           Transaction obj=new Transaction("");
           this.hide();
           obj.show();
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
    }
   
    public static void main(String args[]) {
        new showBalance("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
