import java.io.*;

public class SalaryEmployee extends Employee implements Serializable
{
    private double salary;

    public SalaryEmployee (String name, double salary)
    {
        super(name, (salary / 52));
        this.salary = salary;
    }

    //compute pay method
    public String computePay(Double hours)
    {
        double pay = wage;
        return Utilities.toDollars(pay);
    }

    //set salary method
    public void setSalary(double salary)
    {
        wage = salary / 52.00;
    }

    //getsalary method
    public double getSalary()
    {
        return wage * 52.00;
    }

    //to String method
    public String toString()
    {
        String result = "";
        int length;
        String tempWage = Utilities.toDollars(wage * 52.00);
        result += name;
        length = 33 - name.length() - tempWage.length();
        for(int i = 0; i < length; i++)
        {
            result += " ";
        }
        result += ("$" + tempWage + "/year");
        return result;
    }
}
