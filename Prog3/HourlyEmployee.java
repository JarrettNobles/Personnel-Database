import java.io.*;
import java.util.*;

public class HourlyEmployee extends Employee implements Serializable
{

	public HourlyEmployee (String name, double wage)
	{
		super(name, wage);	
	}

	public String computePay (Double hours)
	{
		double pay;
		//String s = String.valueOf(pay);
		//Double.toString(pay);
		Double overTime;
		double overTimeRate;
		if( hours > 40 )
		{
			overTime = hours - 40.0;
			overTimeRate = wage * 1.5;
			pay = (wage * 40 ) + overTime * overTimeRate;
		}

		else
		{
			pay = hours * wage;
		}

		return Utilities.toDollars(pay);
		
	}

	public String toString()
	{
		String result = "";
		int length;
		String tempWage = Utilities.toDollars(wage);
		result += name;
		length = 33 - name.length() - tempWage.length();
		for(int i = 0; i < length; i++)
		{
			result += " ";
		}
		result += ("$" + tempWage + "/hour");
		return result;
	}

}
