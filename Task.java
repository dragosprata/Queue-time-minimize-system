package hm2;

import java.util.Random;

public class Task {
    private long arrivalTime;   //sec
    private long processingTime;  //sec
    private long finishTime;   //sec

    public int id;
    
    public Task(long arrTime, int minProcessingTime, int maxProcessingTime, int id){
            arrTime=arrivalTime;
            Random rand = new Random();
            //generate random processingTime in interval (minProcessingTime..maxProcessingTime) seconds
            processingTime = rand.nextInt(maxProcessingTime-minProcessingTime)+minProcessingTime;
            this.id = id;
            }

    public long getArrivalTime() {
            return arrivalTime;
    }

    public void setArrivalTime(int arrTime) {
            this.arrivalTime = arrTime;
    }

    public long getProcessingTime() {
            return processingTime;
    }

    public void setProcessingTime(int processingTime) {
            this.processingTime = processingTime;
    }

}
