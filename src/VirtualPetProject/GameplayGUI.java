/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VirtualPetProject;


import javax.swing.*;

/**
 *
 * @author zenox
 */
public class GameplayGUI extends javax.swing.JFrame {

    /**
     * Creates new form GameplayGUI
     * 
     */
            private final Animal pet;
            
            

    
    public GameplayGUI(Animal pet) {
        this.pet = pet;
        initComponents();
        updateProgressBars();
        
        
        // Set up the pet image label
       
    }
    
    private void updateProgressBars() {
        HungerBar.setValue(pet.getHunger());
        EnergyBar.setValue(pet.getEnergy());
        FunBar.setValue(pet.getFun());
        HygieneBar.setValue(pet.getHygiene());
        BladderBar.setValue(pet.getBladder());
        SocialBar.setValue(pet.getSocial());
        jPanel1.revalidate(); // Revalidate panel to update GUI
    jPanel1.repaint();
    }
    
    // Add this method to your GameplayGUI class



   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HungerBar = new javax.swing.JProgressBar();
        SocialBar = new javax.swing.JProgressBar();
        HygieneBar = new javax.swing.JProgressBar();
        EnergyBar = new javax.swing.JProgressBar();
        BladderBar = new javax.swing.JProgressBar();
        FunBar = new javax.swing.JProgressBar();
        feed = new javax.swing.JButton();
        cuddle = new javax.swing.JButton();
        walk = new javax.swing.JButton();
        toilet = new javax.swing.JButton();
        shower = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sleep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        feed.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        feed.setText("Feed");
        feed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedActionPerformed(evt);
            }
        });

        cuddle.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        cuddle.setText("Cuddle");
        cuddle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuddleActionPerformed(evt);
            }
        });

        walk.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        walk.setText("Walk");
        walk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                walkActionPerformed(evt);
            }
        });

        toilet.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        toilet.setText("Toilet");
        toilet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toiletActionPerformed(evt);
            }
        });

        shower.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        shower.setText("Shower");
        shower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showerActionPerformed(evt);
            }
        });

        jLabel1.setText("Hunger:");

        jLabel2.setText("Social:");

        jLabel3.setText("Fun:");

        jLabel4.setText("Energy:");

        jLabel5.setText("Bladder:");

        jLabel6.setText("Hygiene:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sleep.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        sleep.setText("Sleep");
        sleep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sleepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HungerBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SocialBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FunBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EnergyBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BladderBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(HygieneBar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, 99)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feed)
                        .addGap(43, 43, 43)
                        .addComponent(cuddle)
                        .addGap(58, 58, 58)
                        .addComponent(walk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(sleep)
                        .addGap(47, 47, 47)
                        .addComponent(toilet)
                        .addGap(44, 44, 44)
                        .addComponent(shower)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(HungerBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(SocialBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(FunBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(EnergyBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(BladderBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HygieneBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feed)
                    .addComponent(cuddle)
                    .addComponent(walk)
                    .addComponent(toilet)
                    .addComponent(shower)
                    .addComponent(sleep))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Pet Message", JOptionPane.INFORMATION_MESSAGE);
    }
        
    private void feedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedActionPerformed
        // TODO add your handling code here:
        if (pet.getHunger() > 60) {
            showMessage("Don't feed " + pet.getPetName() +
                    " Otherwise " + pet.getPetName() + "'s will explode >_<.");
        } else {
            pet.fulfillHunger();
            showMessage(pet.getPetName() + "'s tummy is happy!");
            updateProgressBars();
        }
    
    }//GEN-LAST:event_feedActionPerformed

   
    
    private void walkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_walkActionPerformed
        // TODO add your handling code here:
        if (pet.getEnergy() < 30) {
            showMessage(pet.getPetName() + " is exhuasted at the moment,"
                    + pet.getPetName() + " needs sleep!");
        } else if (pet.getHunger() < 30) {
            showMessage("Oh no! " + pet.getPetName() + " is starving now. Please "
                    + "feed " + pet.getPetName() + " first.");
        } else if (pet.getBladder() < 25) {
            showMessage(pet.getPetName() + " needs to go to toilet");
        } else {
            pet.fulfillFun();
            showMessage(pet.getPetName() + " is really happy right now!");
            updateProgressBars();
        }
    }//GEN-LAST:event_walkActionPerformed

    private void cuddleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuddleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuddleActionPerformed

    private void sleepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sleepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sleepActionPerformed

    private void toiletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toiletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toiletActionPerformed

    private void showerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showerActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BladderBar;
    private javax.swing.JProgressBar EnergyBar;
    private javax.swing.JProgressBar FunBar;
    private javax.swing.JProgressBar HungerBar;
    private javax.swing.JProgressBar HygieneBar;
    private javax.swing.JProgressBar SocialBar;
    private javax.swing.JButton cuddle;
    private javax.swing.JButton feed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton shower;
    private javax.swing.JButton sleep;
    private javax.swing.JButton toilet;
    private javax.swing.JButton walk;
    // End of variables declaration//GEN-END:variables
}
