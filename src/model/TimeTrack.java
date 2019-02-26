package model;

import ui.Main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeTrack extends Main{


    static List<Double> laptimes = new ArrayList<Double> ();
    static double start;
    static double end;




    public static void track(double laps){

        System.out.println("click when you are ready to begin");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("GO GO GO!");
        System.out.println(laps+" Laps to go");

        do{


            start = System.nanoTime();

            // timer start
            // get first time

            scanner.nextLine();
            end = System.nanoTime();

            double tD = (end - start)/1000000000;


            laptimes.add(tD);

            laps = laps-1;

            if (laps > 1)
            {System.out.println(laps+" Laps to go");}
            else if (laps == 1)
            {System.out.println("Last Lap");}
            else {System.out.println("You did it!");}


        }

        while (laps >= 1);



    }



    public static void finishtime(){

        double q = 0;

        for (int i = 0; i < laptimes.size(); i++){

            q = q + laptimes.get(i);

        }

       System.out.println("You finished with time "+ q + " seconds");

    }





    public static void returntimes(){

        for (int i = 0; i < laptimes.size(); i++){

            System.out.println("Lap " + laptimes.get(i)+ " seconds");



        }




    }





}
