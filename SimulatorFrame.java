package hm2;

import hm2.Scheduler.SelectionPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dragos
 */
public class SimulatorFrame extends javax.swing.JFrame {
    
    SimulationManager sm;
    boolean muteGUIEvents = false;
    Timer timerGUI;
    SimLogger logger;
    
    /**
     * Creates new form SimulatorFrame
     */
    public SimulatorFrame(SimulationManager sm) {
        
        //auto init of GUI
        initComponents();
        
        //init SimLogger
        logger = new SimLogger(logTextArea);
        
        //associate frame with data source
        this.sm = sm;       
        
        //associate logger with sm
        this.sm.setLogger(logger);

        //our init of GUI
        timeLimitTextField.setText(Integer.toString(sm.timeLimit));
        minArrIntervalTextField.setText(Integer.toString(sm.minArrInterval));
        maxArrIntervalTextField.setText(Integer.toString(sm.maxArrInterval));

        maxProcessingTimeTextField.setText(Integer.toString(sm.maxProcessingTime));
        minProcessingTimeTextField.setText(Integer.toString(sm.minProcessingTime));        
        
        numberOfServersTextField.setText(Integer.toString(sm.initialServersNum));
        maxTasksPerServerTextField.setText(Integer.toString(sm.maxTasksPerServer));                   

        muteGUIEvents = true;
        selectionPolicyComboBox.setSelectedIndex(sm.selectionPolicy.ordinal());
        muteGUIEvents = false;

        //timerGUI will update live results on GUI every 1 second
        timerGUI = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                avgWaitLabel.setText(sm.getAvgWaitingPeriod()+ " ");
                avgServLabel.setText(sm.getAvgServiceTime()+" ");
                emptyQueueTimeLabel.setText(sm.getEmptyQueueTimePerc()+" ");
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLimitTextField = new javax.swing.JTextField();
        maxProcessingTimeTextField = new javax.swing.JTextField();
        minProcessingTimeTextField = new javax.swing.JTextField();
        numberOfServersTextField = new javax.swing.JTextField();
        maxTasksPerServerTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        selectionPolicyComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        minArrIntervalTextField = new javax.swing.JTextField();
        maxArrIntervalTextField = new javax.swing.JTextField();
        addQueueBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        avgWaitLabel = new javax.swing.JLabel();
        avgServLabel = new javax.swing.JLabel();
        emptyQueueTimeLabel = new javax.swing.JLabel();
        statusBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        timeLimitTextField.setText("jTextField1");
        timeLimitTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeLimitTextFieldActionPerformed(evt);
            }
        });

        maxProcessingTimeTextField.setText("jTextField2");
        maxProcessingTimeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxProcessingTimeTextFieldActionPerformed(evt);
            }
        });

        minProcessingTimeTextField.setText("jTextField3");
        minProcessingTimeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minProcessingTimeTextFieldActionPerformed(evt);
            }
        });

        numberOfServersTextField.setText("jTextField4");
        numberOfServersTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfServersTextFieldActionPerformed(evt);
            }
        });

        maxTasksPerServerTextField.setText("jTextField5");
        maxTasksPerServerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxTasksPerServerTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Simulation interval (s):");

        jLabel2.setText("Max Service Time:");

        jLabel3.setText("Min Service Time:");

        jLabel4.setText("Number of queues:");

        jLabel5.setText("Max clients per queue:");

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Selection Policy:");

        selectionPolicyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shortest Queue", "Shortest Time" }));
        selectionPolicyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionPolicyComboBoxActionPerformed(evt);
            }
        });

        logTextArea.setColumns(20);
        logTextArea.setRows(5);
        jScrollPane1.setViewportView(logTextArea);

        jLabel7.setText("Log of Events");

        jLabel8.setText("Min arriving interval (s):");

        jLabel9.setText("Max arriving interval (s):");

        minArrIntervalTextField.setText("jTextField1");
        minArrIntervalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minArrIntervalTextFieldActionPerformed(evt);
            }
        });

        maxArrIntervalTextField.setText("jTextField2");
        maxArrIntervalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxArrIntervalTextFieldActionPerformed(evt);
            }
        });

        addQueueBtn.setText("Add queue");
        addQueueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addQueueBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Average waiting time:");

        jLabel11.setText("Average service time:");

        jLabel12.setText("Emty queue time:");

        avgWaitLabel.setText("avgWaitLabel");

        avgServLabel.setText("avgServLabel");

        emptyQueueTimeLabel.setText("emptyQueueTimeLabel");

        statusBtn.setText("Status");
        statusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBtnActionPerformed(evt);
            }
        });

        jLabel13.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(minProcessingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxArrIntervalTextField)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(maxTasksPerServerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(49, 49, 49)
                            .addComponent(selectionPolicyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(19, 19, 19)
                                .addComponent(timeLimitTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minArrIntervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numberOfServersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(maxProcessingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(startButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addQueueBtn)
                                    .addComponent(statusBtn)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avgWaitLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emptyQueueTimeLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avgServLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLimitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(minArrIntervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(maxArrIntervalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(minProcessingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(maxProcessingTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfServersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(maxTasksPerServerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectionPolicyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startButton)
                            .addComponent(statusBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(addQueueBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(avgWaitLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(avgServLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(emptyQueueTimeLabel)
                            .addComponent(jLabel13))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeLimitTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeLimitTextFieldActionPerformed
        
        String text = timeLimitTextField.getText();
        sm.timeLimit = Integer.parseInt(text);
        //JOptionPane.showMessageDialog(null, "time limit = " + sm.timeLimit);
    }//GEN-LAST:event_timeLimitTextFieldActionPerformed

    private void maxProcessingTimeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxProcessingTimeTextFieldActionPerformed
        // TODO add your handling code here:
        String text = maxProcessingTimeTextField.getText();
        sm.maxProcessingTime = Integer.parseInt(text);
        //JOptionPane.showMessageDialog(null, "max processing time = " + sm.maxProcessingTime);
    }//GEN-LAST:event_maxProcessingTimeTextFieldActionPerformed

    private void minProcessingTimeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minProcessingTimeTextFieldActionPerformed
        // TODO add your handling code here:
        String text = minProcessingTimeTextField.getText();
        sm.minProcessingTime = Integer.parseInt(text);
        //JOptionPane.showMessageDialog(null, "min processing time = " + sm.minProcessingTime);
        
    }//GEN-LAST:event_minProcessingTimeTextFieldActionPerformed

    private void numberOfServersTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfServersTextFieldActionPerformed
        String text = this.numberOfServersTextField.getText();
        sm.initialServersNum = Integer.parseInt(text);
    }//GEN-LAST:event_numberOfServersTextFieldActionPerformed

    private void maxTasksPerServerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxTasksPerServerTextFieldActionPerformed
        // TODO add your handling code here:
        String text = maxTasksPerServerTextField.getText();
        sm.maxTasksPerServer = Integer.parseInt(text);
        //JOptionPane.showMessageDialog(null, "number of clients = " + sm.numberOfClients);
    }//GEN-LAST:event_maxTasksPerServerTextFieldActionPerformed

    private void selectionPolicyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionPolicyComboBoxActionPerformed
        //String s = (String )selectionPolicyComboBox.getSelectedItem();
        //JOptionPane.showMessageDialog(this, "Ati selectat " + s);                
        if(!this.muteGUIEvents)
        {
            int i = selectionPolicyComboBox.getSelectedIndex();
            sm.selectionPolicy = SelectionPolicy.values()[i];
        }
    }//GEN-LAST:event_selectionPolicyComboBoxActionPerformed

    private void minArrIntervalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minArrIntervalTextFieldActionPerformed
         String text = minArrIntervalTextField.getText();
         sm.minArrInterval = Integer.parseInt(text);
    }//GEN-LAST:event_minArrIntervalTextFieldActionPerformed

    private void maxArrIntervalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxArrIntervalTextFieldActionPerformed
         String text = maxArrIntervalTextField.getText();
         sm.maxArrInterval = Integer.parseInt(text);
    }//GEN-LAST:event_maxArrIntervalTextFieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
         //start simulation manager
         Thread t = new Thread(sm);
         t.start();
         
         //start updating interface
         timerGUI.start();                  
    }//GEN-LAST:event_startButtonActionPerformed

    private void statusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBtnActionPerformed
        for(Server s : sm.getServers())
        {
            String text = "Server "+s.id+" tasks:";
            
            BlockingQueue<Task> tasks = s.getTasks();
            for(Task t : tasks)
            {
                text  = text.concat(" "+t.id);
            }
            
            logger.log(text);
        }
    }//GEN-LAST:event_statusBtnActionPerformed

    private void addQueueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addQueueBtnActionPerformed
        sm.addServerAndRedistributeTasks();
        //print a status
        statusBtnActionPerformed(evt);
    }//GEN-LAST:event_addQueueBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimulationManager sm = new SimulationManager();
                SimulatorFrame sf = new SimulatorFrame(sm);
                
                sf.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addQueueBtn;
    private javax.swing.JLabel avgServLabel;
    private javax.swing.JLabel avgWaitLabel;
    private javax.swing.JLabel emptyQueueTimeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JTextField maxArrIntervalTextField;
    private javax.swing.JTextField maxProcessingTimeTextField;
    private javax.swing.JTextField maxTasksPerServerTextField;
    private javax.swing.JTextField minArrIntervalTextField;
    private javax.swing.JTextField minProcessingTimeTextField;
    private javax.swing.JTextField numberOfServersTextField;
    private javax.swing.JComboBox<String> selectionPolicyComboBox;
    private javax.swing.JButton startButton;
    private javax.swing.JButton statusBtn;
    private javax.swing.JTextField timeLimitTextField;
    // End of variables declaration//GEN-END:variables
}
