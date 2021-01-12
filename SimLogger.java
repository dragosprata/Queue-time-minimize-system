/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hm2;

import javax.swing.JTextArea;

/**
 *
 * @author Dragos
 */
public class SimLogger {
    
    private JTextArea textArea;
    private long initialTime;//sec
    
    public SimLogger(JTextArea textArea)
    {
        this.textArea = textArea;
    }
    public void setInitialTime(long time)
    {
        this.initialTime = time;
    }
    public void log(String text)
    {        
        long crtTime = System.currentTimeMillis()/1000;
        long simTime = crtTime-this.initialTime;
        
        String simTimeString = String.format("%03d", simTime);
       
        this.textArea.append("Time" + simTimeString + ">" + text + "\n");
    }
    
}
