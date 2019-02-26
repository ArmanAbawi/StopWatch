package ui;


import model.Pace;
import model.TimeTrack;



public class Main {



    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI.createGUI();
            }
        });

        TimeTrack.track(Pace.getLAPS());
        TimeTrack.returntimes();
        TimeTrack.finishtime();


    }



}

