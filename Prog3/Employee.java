import java.io.*;
public abstract class Employee implements Serializable
{
    //variables for name and wage
    protected String name;
    protected double wage;

    protected Employee(String name, double wage)
    {
        this.name = name;
        this.wage = wage;
    }

    //reset the name
    public void setName(String name)
    {
        this.name = name;
    }

    //reset wage
    public void setWage(double wage)
    {
        this.wage = wage;
    }

    //increase wage function
    public void increaseWage(double increase)
    {
	
	wage *= (increase/ 100 + 1);
       //wage *= ((increase + 100) + 1);
    }

    //return methods
    //return name
    public String getName()
    {
        return name;
    }

    //return wage
    public double getWage()
    {
        return wage;
    }

    protected abstract String computePay(Double number);

}
