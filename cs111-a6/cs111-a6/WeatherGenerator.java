
// Haider Ali Ha484@scarletmail.rutgers.edu Ha484



public class WeatherGenerator {

    static final int WET = 1;
    static final int DRY = 2;
    
    static final int[] numberOfDaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void populateArrays(double[][] drywet, double[][] wetwet) {

        StdIn.setFile("drywet.txt");

	for(int i=0; i < drywet.length; i++){
            for(int j=0; j<14; j++){
                drywet[i][j] = StdIn.readDouble();
            }
        }

	StdIn.setFile("wetwet.txt");

	for(int i=0; i < drywet.length; i++){
            for(int j=0; j<14; j++){
                wetwet[i][j] = StdIn.readDouble();
            }
        }
    }

    public static void populateLocationProbabilities( double[] drywetProbability, double[] wetwetProbability, 
                                     double longitude, double latitude, 
                                     double[][] drywet, double[][] wetwet){
        int h=-1;

        for(int c=0; c<wetwet.length;c++)
            if(wetwet[c][0]==longitude && wetwet[c][1]==latitude)
            h=c;

        for (int c=2;c<wetwet[h].length;c++)
        {
            wetwetProbability[c-2]=wetwet[h][c];
            drywetProbability[c-2]=drywet[h][c];
        }

    }
    public static int[] forecastGenerator( double drywetProbability, double wetwetProbability, int numberOfDays) {
            int [] prob = new int [numberOfDays];
            prob[0] = (int)(StdRandom.uniform()*2)+1; 
                
            for(int p=1; p<prob.length;p++)
            {
                if(prob[p-1]==2)
                {
                    if(StdRandom.uniform()<drywetProbability)
                        prob[p]=1; 
                      else
                        prob[p]=2;
                
            }
            else if (prob[p-1]==1){
                if (StdRandom.uniform()<wetwetProbability){
                    prob[p]=1;
                }
                else
                    prob[p]=2;
            }
        }
        return prob;
    }
    public static int[] oneMonthForecast(int numberOfLocations, int month, double longitude, double latitude )
    {
        double [][] drywet =  new double[numberOfLocations][14];
        double [][] wetwet = new double[numberOfLocations][14];
        populateArrays(drywet, wetwet);

        double[] drywetProbability = new double[12];
        double [] wetwetProbability = new double [12];

        populateLocationProbabilities(drywetProbability, wetwetProbability, longitude, latitude, drywet, wetwet);

        return forecastGenerator( drywetProbability[month], wetwetProbability[month], numberOfDaysInMonth[month]);
    }
    public static int numberOfWetDryDays (int[] forecast, int mode) {
        int total = 0;

        for (int count = 0; count < forecast.length; count++)
        {

            if (forecast[count] == mode)
            {

                total = total + 1;
            }
        }
        return total; 
    }

        public static int lengthOfLongestSpell(int[] forecast, int mode)
         {
            int x=0;
            int y=0;

            for (int num :forecast)
            {
            if( num == mode ) 
            {
                x++;
            }
             else 
             {
                   if (x>y){
                    y=x;
             }
            }
                x=0;
                     
                
        }
        return y;
    } 
    public static int bestWeekToTravel(int[] forecast){
        
        int days = Integer.MAX_VALUE;

        int position = 0; 

        for(int w=0; w+7 <= forecast.length ;w++){
            int [] daysInWeek = new int [7];
            for(int i =0; i < daysInWeek.length;i++)
            {
                daysInWeek[i]=forecast[w+i];
            }
            int value=numberOfWetDryDays(daysInWeek,1);
            if (value<days){
                days = value;
                position = w;
            }
        }
        return position;
    }
    public static void main (String[] args) {

        int numberOfRows    = 4100;
        int numberOfColumns = 14;
        double longitude = Double.parseDouble(args[0]);
        double latitude  = Double.parseDouble(args[1]);
        int    month     = Integer.parseInt(args[2]);
        
        int[] forecast = oneMonthForecast( numberOfRows,  month,  longitude,  latitude );
        

        int drySpell = lengthOfLongestSpell(forecast, DRY);
        int wetSpell = lengthOfLongestSpell(forecast, WET);
        int bestWeek = bestWeekToTravel(forecast);

        StdOut.println("There are " + forecast.length + " days in the forecast for month " + month);
        StdOut.println(drySpell + " days of dry spell.");
        StdOut.println("The bestWeekToTravel starts on:" + bestWeek );

        for ( int i = 0; i < forecast.length; i++ ) {
            String weather = (forecast[i] == WET) ? "Wet" : "Dry";  
            StdOut.println("Day " + (i) + " is forecasted to be " + weather);
        }
    }
}
