package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class GUI extends JPanel{


    public static void createGUI() {


        JFrame pane = new JFrame();


        JButton button;
        JLabel label;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        label = new JLabel("   Distance in KM");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(label, c);


        JTextField txtfld1 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(txtfld1, c);


        label = new JLabel("   Time in MINS");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(label, c);


        JTextField txtfld2 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 2;
        pane.add(txtfld2, c);


        label = new JLabel("   Lap in KM");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 2;
        pane.add(label, c);


        JTextField txtfld3 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 2;
        pane.add(txtfld3, c);




        label = new JLabel("ENTER ALL OF INFORMATION FIRST, THEN CLICK START");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 5;
        pane.add(label, c);




        button = new JButton("Start");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        //c.insets = new Insets(10,0,0,10);  //top padding
        c.gridx = 3;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 4;       //third row


        button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
        //Execute when button is pressed


        ImageIcon greenbutton = new ImageIcon("src/Images/green-button-badge.jpg");
        double Distance;
        double Time;
        double Lap;




        Distance = Double.parseDouble(txtfld1.getText());

        Time = Double.parseDouble(txtfld2.getText());

        Lap = Double.parseDouble(txtfld3.getText());

        double pace = Time / (Distance / Lap);

        double laps = Distance/Lap;

        Tracker.laps = laps;




        JFrame clicker = new JFrame();

        clicker.setSize(500, 600);

        clicker.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        List<Double> timeslist = new ArrayList<>();

        List<Double> referencetimes = new ArrayList<>();






            JButton b = new JButton(greenbutton);

            //Add action listener to button
            b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            //Execute when button is pressed





                    if (Tracker.isFirst){

                        double z;
                        z = System.nanoTime();
                        referencetimes.add(z);
                        JLabel progress = new JLabel(Tracker.laps+" Laps to go!!");
                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.gridx = 0;
                        c.gridy = Tracker.a;
                        c.weighty = 0.2;
                        clicker.add(progress, c);
                        clicker.revalidate();
                        clicker.repaint();

                        Tracker.laps--;

                        Tracker.isFirst = false;

                        return;



                    }




                    if (Tracker.laps == 0) {

                        double b = System.nanoTime();

                        double d = b - referencetimes.get(referencetimes.size() - 1);

                        timeslist.add(d);

                        referencetimes.add(b);

                        JFrame frame = new JFrame();
                        JPanel record = new JPanel();
                        record.setLayout(new BoxLayout(record, BoxLayout.Y_AXIS));


                        for (int i = 0; i < timeslist.size(); i++){

                            JLabel time = new JLabel(timeslist.get(i)+" seconds");

                            record.add(time);


                        }
                        frame.add(record);
                        frame.pack();
                        record.setVisible(true);
                        frame.setVisible(true);
                    }


                    if (Tracker.laps == 1) {

                        double b = System.nanoTime();

                        double d = b - referencetimes.get(referencetimes.size() - 1);

                        timeslist.add(d);

                        referencetimes.add(b);

                        JLabel last = new JLabel("Last Lap!!");

                        Tracker.a++;

                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.gridx = 0;
                        c.gridy = Tracker.a;
                        c.weighty = 0.2;
                        clicker.add(last, c);
                        clicker.revalidate();
                        clicker.repaint();
                        ///make location exact same spot as laps label

                        clicker.add(last, c);

                        Tracker.laps = 0;

                    }




                    if (Tracker.laps  > 1){

                        double b = System.nanoTime();

                        double d = b - referencetimes.get(referencetimes.size() - 1);

                        timeslist.add(d);

                        referencetimes.add(b);


                        JLabel update = new JLabel((Tracker.laps)+" Laps to go!!");

                        Tracker.a++;
                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.gridx = 0;
                        c.gridy = Tracker.a;
                        c.weighty = 0.2;
                        clicker.add(update, c);
                        clicker.revalidate();
                        clicker.repaint();
                        ///make location exact same spot as laps label

                        Tracker.laps--;
                        clicker.add(update, c);


                    }
            }
            }
            );


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        clicker.add(b, c);




        JLabel pacelabel = new JLabel("You must keep a pace of "+ pace+ " minutes per lap for "+ laps+" laps, click when ready to begin");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 0.2;
        clicker.add(pacelabel, c);


        clicker.setVisible(true);

        }});
        pane.add(button, c);





        pane.setVisible(true);
        pane.setSize(1100, 400);
    }
}
