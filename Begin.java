import java.io.*;
import java.util.*;

public class Begin implements Serializable
{
	public static void main(String[] args)
	{
		Parser sparcer=new Parser();
		Core harvey=new Core(sparcer);
		System.out.println("GREETINGS USER!");
		while(true)
		{
			harvey.prompt();
		}
	}
}