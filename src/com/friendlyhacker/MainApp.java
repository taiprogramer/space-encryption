/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.friendlyhacker;

import java.io.File;
import javax.swing.JFileChooser;
import java.awt.event.ItemEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import static com.friendlyhacker.Worker.*;

/**
 *
 * @author HuynhVanTai
 */
public class MainApp extends javax.swing.JFrame {

    private static File selectedFile = null;
    private static String please_select_file_label = "Please select file!";
    private static String encrypt_success_label = "Encrypt successfully.";
    private static String decrypt_success_label = "Decrypt successfully.";
    private static String encrypt_fail_label = "Encrypt failed.";
    private static String decrypt_fail_label = "Decrypt failed.";
    private static String encrypting_label = "Start encrypting...";
    private static String decrypting_label = "Start decrypting...";
    private static String already_encrypted_label = "This file already encrypted!";
    private static String not_encrypted_file_label = "This file is not encrypted.";
    private static String wrong_password_label = "Password you've typed is not correct.";
    private static String about_label
            = "A simple text-file encryption tool written in Java.\n"
            + "Team: Friendly Hacker\n"
            + "Idea: Nguyen Duy Kha.";

    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        buttonGroupLanguages = new javax.swing.ButtonGroup();
        jButtonChooseFile = new javax.swing.JButton();
        jTextFieldPathFile = new javax.swing.JTextField();
        jButtonEncrypt = new javax.swing.JButton();
        jButtonDecrypt = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelStatusLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemChooseFile = new javax.swing.JMenuItem();
        jMenuLanguage = new javax.swing.JMenu();
        jRadioButtonMenuItemVietnamese = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemEnglish = new javax.swing.JRadioButtonMenuItem();
        jMenuAbout = new javax.swing.JMenu();

        jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Space Encryption");

        jButtonChooseFile.setText("Choose File");
        jButtonChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseFileActionPerformed(evt);
            }
        });

        jTextFieldPathFile.setEditable(false);

        jButtonEncrypt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonEncrypt.setText("Encrypt");
        jButtonEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncryptActionPerformed(evt);
            }
        });

        jButtonDecrypt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonDecrypt.setText("Decrypt");
        jButtonDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecryptActionPerformed(evt);
            }
        });

        jLabelStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabelPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPassword.setText("Password:");

        jPasswordField.setText("RepublicofVietNam");

        jLabelStatusLabel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabelStatusLabel.setText("Status:");

        jMenuFile.setText("File");

        jMenuItemChooseFile.setText("Choose file");
        jMenuItemChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChooseFileActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemChooseFile);

        jMenuBar.add(jMenuFile);

        jMenuLanguage.setText("Language");

        buttonGroupLanguages.add(jRadioButtonMenuItemEnglish);
        buttonGroupLanguages.add(jRadioButtonMenuItemVietnamese);
        
        jRadioButtonMenuItemVietnamese.setText("Vietnamese");
        jRadioButtonMenuItemVietnamese.setName("language"); // NOI18N
        jRadioButtonMenuItemVietnamese.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonMenuItemVietnameseItemStateChanged(evt);
            }
        });
        jMenuLanguage.add(jRadioButtonMenuItemVietnamese);

        jRadioButtonMenuItemEnglish.setSelected(true);
        jRadioButtonMenuItemEnglish.setText("English");
        jRadioButtonMenuItemEnglish.setName("language"); // NOI18N
        jRadioButtonMenuItemEnglish.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonMenuItemEnglishItemStateChanged(evt);
            }
        });
        jMenuLanguage.add(jRadioButtonMenuItemEnglish);

        jMenuBar.add(jMenuLanguage);

        jMenuAbout.setText("About");
        jMenuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAboutMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuAbout);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldPathFile, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonChooseFile))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelStatusLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(jButtonEncrypt)
                                        .addGap(51, 51, 51)
                                        .addComponent(jButtonDecrypt))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabelPassword)
                        .addGap(38, 38, 38)
                        .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPathFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonChooseFile))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEncrypt)
                    .addComponent(jButtonDecrypt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseFileActionPerformed
        // TODO add your handling code here:
        // test open file
        int result = jFileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = jFileChooser.getSelectedFile();
            jTextFieldPathFile.setText(selectedFile.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonChooseFileActionPerformed

    private void jButtonEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncryptActionPerformed
        if (selectedFile == null) {
            jLabelStatus.setText(please_select_file_label);
        } else {
            if (is_encrypted_file(selectedFile)) {
                jLabelStatus.setText(already_encrypted_label);
            } else {
                jLabelStatus.setText(encrypting_label);
                boolean result = start_encrypt(selectedFile, new String(jPasswordField.getPassword()));
                if (result) {
                    jLabelStatus.setText(encrypt_success_label);
                } else {
                    jLabelStatus.setText(encrypt_fail_label);
                }
            }
        }
    }//GEN-LAST:event_jButtonEncryptActionPerformed

    private void jButtonDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecryptActionPerformed
        if (selectedFile == null) {
            jLabelStatus.setText(please_select_file_label);
        } else {
            if (!is_encrypted_file(selectedFile)) {
                jLabelStatus.setText(not_encrypted_file_label);
            } else {
                if (!is_password_correct(
                        selectedFile, new String(jPasswordField.getPassword()))) {
                    jLabelStatus.setText(wrong_password_label);
                } else {
                    jLabelStatus.setText(decrypting_label);
                    boolean result = start_decrypt(selectedFile, new String(jPasswordField.getPassword()));
                    if (result) {
                        jLabelStatus.setText(decrypt_success_label);
                    } else {
                        jLabelStatus.setText(decrypt_fail_label);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonDecryptActionPerformed

    private void jMenuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAboutMouseClicked
        JOptionPane.showMessageDialog(null,
                about_label
        );
    }//GEN-LAST:event_jMenuAboutMouseClicked

    private void jMenuItemChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChooseFileActionPerformed
        jButtonChooseFileActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemChooseFileActionPerformed

    private void jRadioButtonMenuItemVietnameseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemVietnameseItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            set_languages(new Locale("vn", "VN"));
        }
    }//GEN-LAST:event_jRadioButtonMenuItemVietnameseItemStateChanged

    private void jRadioButtonMenuItemEnglishItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemEnglishItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            set_languages(new Locale("", ""));
        }
    }//GEN-LAST:event_jRadioButtonMenuItemEnglishItemStateChanged

    /* taiprogramer's util functions */
    private void set_languages(Locale locale) {
        ResourceBundle messages;
        messages = ResourceBundle.getBundle(
                "com.friendlyhacker.MessagesBundle",
                locale
        );
        jMenuFile.setText(messages.getString("jMenuFile"));
        jMenuItemChooseFile.setText(messages.getString("jMenuItemChooseFile"));
        jMenuLanguage.setText(messages.getString("jMenuLanguage"));
        jRadioButtonMenuItemVietnamese.setText(messages.getString("jRadioButtonMenuItemVietnamese"));
        jRadioButtonMenuItemEnglish.setText(messages.getString("jRadioButtonMenuItemEnglish"));
        jMenuAbout.setText(messages.getString("jMenuAbout"));
        jLabelPassword.setText(messages.getString("jLabelPassword"));
        jLabelStatusLabel.setText(messages.getString("jLabelStatusLabel"));
        jButtonChooseFile.setText(messages.getString("jButtonChooseFile"));
        jButtonEncrypt.setText(messages.getString("jButtonEncrypt"));
        jButtonDecrypt.setText(messages.getString("jButtonDecrypt"));
        // Notify Label
        please_select_file_label = messages.getString("please_select_file_label");
        encrypt_success_label = messages.getString("encrypt_success_label");
        decrypt_success_label = messages.getString("decrypt_success_label");
        encrypt_fail_label = messages.getString("encrypt_fail_label");
        decrypt_fail_label = messages.getString("decrypt_fail_label");
        encrypting_label = messages.getString("encrypting_label");
        decrypting_label = messages.getString("decrypting_label");
        already_encrypted_label = messages.getString("already_encrypted_label");
        not_encrypted_file_label = messages.getString("not_encrypted_file_label");
        wrong_password_label = messages.getString("wrong_password_label");
        about_label = messages.getString("about_label");
    }

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLanguages;
    private javax.swing.JButton jButtonChooseFile;
    private javax.swing.JButton jButtonDecrypt;
    private javax.swing.JButton jButtonEncrypt;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelStatusLabel;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemChooseFile;
    private javax.swing.JMenu jMenuLanguage;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemEnglish;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemVietnamese;
    private javax.swing.JTextField jTextFieldPathFile;
    // End of variables declaration//GEN-END:variables
}
