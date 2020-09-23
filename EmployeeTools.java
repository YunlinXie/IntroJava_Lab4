import java.util.Arrays;

public class EmployeeTools
{
	public static double getTwoDigitDecimal(double x)
	{
		return Math.round(x * 100.0) / 100.0;
	}

	public static String getNCharStr(int n, char c)
	{
		char[] chars = new char[n];
		Arrays.fill(chars, c);
		return new String(chars);
	}

	public static String getWidthNStringStartWith(String s, int width)
    {
        return s + getNCharStr(width - s.length(), ' ');
    }
}