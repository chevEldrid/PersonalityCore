import java.io.*;
import java.util.*;

public class SaveState implements Serializable
{

	private Core cody;
	private Parser parsey;

	public SaveState()
	{

	}
	public SaveState(Parser darsey, Core spock)
	{
		cody=spock;
		parsey=darsey;
	}
	public Core getCore()
	{
		return cody;
	}
	public Parser getParser()
	{
		return parsey;
	}
}