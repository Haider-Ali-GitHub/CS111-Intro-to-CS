/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author: Haider Ali ha484@scarletmail.rutgers.edu ha484
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {

        double b[] = new double[array.length];
  
        for (int i=0; i<array.length; i++)
        b[i] = array[i];
          
        return b;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

        for(int i = 0 ;i<x.length ; i++)
        {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
          
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {

        for(int i = 0 ;i<x.length ; i++)
        {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

        double d = theta*Math.PI/180;
        double sine = Math.sin(d);
        double cosine = Math.cos(d);
        for(int i = 0 ;i<x.length ; i++)
        {
            double xa =0,ya=0;
            xa = x[i]*cosine - y[i]*sine;
            ya = y[i]*cosine + x[i]*sine;
            x[i] = xa;
            y[i] = ya;
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {
        
        StdDraw.setScale(-5.0, +5.0); 
        double[] x = { 0, 1, 1, 0 }; 
        double[] y = { 0, 0, 2, 1 }; 
        double alpha = 2.0; 
        StdDraw.setPenColor(StdDraw.RED); 
        StdDraw.polygon(x, y); 
        scale(x, y, alpha); 
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
          
    }
}
