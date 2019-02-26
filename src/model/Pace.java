package model;


import Exceptions.TheException;


import java.util.Scanner;


public class Pace {

    public double LAP;
    public double pace;
    static double LAPS;
    static int y = 1;

    public Pace(double distance, double time, double lap) throws TheException {
        setPace(distance, time, lap);
}






//REQUIRES three numbers > 0
//MODIFIES this
//EFFECTS changes the initially declared pace to a new one

    public void setPace(double distance, double time,  double lap) throws TheException {
        if ((distance > 0) && (time > 0) && (lap > 0)) {

            this.LAP = lap;
            pace = time / (distance / LAP);
        }

        else {

            throw new TheException("Not Valid, please enter a new pace");

        }

    }




    //EFFECTS returns the pace of the Pace object
    public double getPace() {
        return pace;
    }










    public static void startingRun(){

        do
        {
            try
            {

                {


                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please enter how far in KILOMETERS you want to run");
                    double Distance = scanner.nextDouble();

                    scanner.nextLine();

                    System.out.println("Please enter how long you want to run in MINUTES");
                    double Time = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Please enter how long each lap is");
                    double Lap = scanner.nextDouble();
                    scanner.nextLine();

                    //try{
                    LAPS = (Distance/Lap);

                    //catch

                    Pace x = new Pace(Distance, Time, Lap);
                    System.out.println("you need to keep up a " + x.getPace() + " minutes/LAP pace for "
                            +LAPS+ " laps");
                    y = 2;
                }
            }
            catch (TheException e)
            {
                System.out.println(e.getMessage());
            }
        }
        while (y == 1);




    }


public static double setLAPS(double a, double b){

        if (!((a/b) == 0))

        {


        }



return a;

}



    public static double getLAPS(){


        return LAPS;


    }







}



