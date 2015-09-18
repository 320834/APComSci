package p10_12;

public class RootApproximator
{
    private double a;
    private double x0;
    private double x1;
    
    public RootApproximator(double aNumber)
    {
        a = aNumber;
        x1 = aNumber;
    }
    
    public double nextGuess()
    {
        x1 = x0;
        x0 = (x1 + a / x1) / 2;
        return x1;
    }
    
    public double getRoot()
    {
        while(!Numeric.approxEqual(x0, x1))
            nextGuess();
        return x1;
    }

}
