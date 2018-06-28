/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import com.mysql.jdbc.Statement;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kush
 */
public class UserDetails extends javax.swing.JFrame {

    /**
     * Creates new form UserDetails
     */
    public UserDetails() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setResizable(false);
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int) tk.getScreenSize().getWidth();
        int ysize=(int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        jLabel2.setVisible(false);
        showuser();
    }
public UserDetails(String a) {
     try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setResizable(false);
        initComponents();
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xsize=(int) tk.getScreenSize().getWidth();
        int ysize=(int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
        jLabel2.setText(a);
        jLabel2.setVisible(false);
        showuser();
    }
public ArrayList<Leaves> userList(){
    ArrayList<Leaves> usersList = new ArrayList<>();
    try{
     Class.forName("com.mysql.jdbc.Driver");  
     com.mysql.jdbc.Connection con;
     con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","kdsh2397");
     int count=0;
     String query="select * from leaves where user_id='"+jLabel2.getText()+"';";
     Statement st=(Statement) con.createStatement();
        ResultSet rs1=st.executeQuery(query);
        while(rs1.next())
        {
            count++;
        }
        int no=(count/2);
        int n= no+(count%2);
        String a=Integer.toString(n);
        jLabel7.setText(a);
        String c=jLabel9.getText();
    String b=jLabel7.getText();
    First.setEnabled(c.equals("1")==false);
    Previous.setEnabled(c.equals("1")==false);
    Next.setEnabled(c.equals(b)==false);
    Last.setEnabled(c.equals(b)==false);
        int pg=Integer.parseInt(c);
        String query1="select*from leaves where user_id='"+jLabel2.getText()+"' order by name limit "+2+" offset "+((pg-1)*2)+"";
        ResultSet rs=st.executeQuery(query1);
        Leaves user;
        while(rs.next()){
            user=new Leaves(rs.getString("name"),rs.getString("user_id"),rs.getString("manager_id"),rs.getString("start"),rs.getString("end"),rs.getInt("days"),rs.getInt("yearol"),rs.getString("status"));
            usersList.add(user);
        }
    }
    catch(Exception e){
        showMessageDialog(null,e);
    }
    return usersList;
}
public void showuser(){
    ArrayList<Leaves>list=userList();
    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    Object [] row = new Object[8];
    for(int i=0;i<list.size();i++){
        row[0]=list.get(i).getname();
        row[1]=list.get(i).getuserid();
        row[2]=list.get(i).getmanagerid();
        row[3]=list.get(i).getstart();
        row[4]=list.get(i).getend();
        row[5]=list.get(i).getdays();
        row[6]=list.get(i).getyearol();
        row[7]=list.get(i).getstatus();
        model.addRow(row);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        First = new javax.swing.JButton();
        Previous = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Last = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Your Details");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Your Leaves");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "UserID", "ManagerID", "Start Date", "End Date", "Days", "Year of Leave", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        First.setText("First");
        First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstActionPerformed(evt);
            }
        });

        Previous.setText("Previous");
        Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousActionPerformed(evt);
            }
        });

        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Last.setText("Last");
        Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastActionPerformed(evt);
            }
        });

        jLabel3.setText("/");

        jLabel9.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(First)
                .addGap(100, 100, 100)
                .addComponent(Previous)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(Next)
                .addGap(100, 100, 100)
                .addComponent(Last)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(First)
                            .addComponent(Previous))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Last)
                            .addComponent(Next)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
new userpage_a(jLabel2.getText()).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstActionPerformed
jLabel9.setText("1");
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    showuser();
    }//GEN-LAST:event_FirstActionPerformed

    private void LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastActionPerformed
jLabel9.setText(jLabel7.getText());
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    showuser();
    }//GEN-LAST:event_LastActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
String a=jLabel9.getText();
        int n=Integer.parseInt(a);
        n+=1;
        String b=Integer.toString(n);
        jLabel9.setText(b);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    showuser();
    }//GEN-LAST:event_NextActionPerformed

    private void PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousActionPerformed
String a=jLabel9.getText();
        int n=Integer.parseInt(a);
        n-=1;
        String b=Integer.toString(n);
        jLabel9.setText(b);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
    model.setRowCount(0);
    showuser();
    }//GEN-LAST:event_PreviousActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton First;
    private javax.swing.JButton Last;
    private javax.swing.JButton Next;
    private javax.swing.JButton Previous;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
