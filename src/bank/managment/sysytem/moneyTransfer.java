package bank.managment.sysytem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class moneyTransfer extends JFrame implements ActionListener {
    
    JTextField card,userName;
    JButton next,back;
    
    public moneyTransfer() {
        
        setTitle("NOVA BANK ONLINE SERVICE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900); // ❗Set bounds manually
        add(image);
        
        
        JLabel text=new JLabel("Enter Reciver Card No  ");
        text.setFont(new Font("System",Font.BOLD, 18));
        text.setBounds(185,305,300,20);
        text.setForeground(Color.white);
        image.add(text);
       
        card=new JTextField();
        card.setFont(new Font("Raleway",Font.PLAIN, 18));
        card.setBounds(185,330,300,25);
        card.setForeground(Color.white);
        card.setForeground(Color.black);
        image.add(card);
        
        
        JLabel text2=new JLabel("Enter Reciver Name  ");
        text2.setFont(new Font("System",Font.BOLD, 18));
        text2.setBounds(185,375,300,20);
        text2.setForeground(Color.white);
        image.add(text2);
        
        userName=new JTextField();
        userName.setFont(new Font("Raleway",Font.PLAIN, 18));
        userName.setBounds(185,400,300,25);
        userName.setForeground(Color.white);
        userName.setForeground(Color.black);
        image.add(userName);
        
        
        next=new JButton("Next");
        next.setFont(new Font("System",Font.PLAIN, 20));
        next.setBounds(185,455,120,30);
        next.setForeground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        image.add(next);
        
        
        back=new JButton("Back");
        back.setFont(new Font("System",Font.PLAIN, 20));
        back.setBounds(361,455,120,30);
        back.setForeground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
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
        }else if(e.getSource()==next){
            String rCardNo = card.getText();
            String rName = userName.getText();
            moneyTransfer2 obj=new moneyTransfer2(rCardNo,rName);
            this.hide();
            obj.show();
        }
        
    }
    
   
    public static void main(String args[]) {
       new moneyTransfer();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
