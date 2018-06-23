package models;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Data implements Serializable
{

	private static final long serialVersionUID = 5870986225688309123L;
	private String message;
	private InetAddress destiny;

	public Data(String message, String name) throws UnknownHostException
	{
		this.message = message;
		this.destiny = InetAddress.getByName(name);
	}

	@ Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime*result+((destiny==null) ? 0 : destiny.hashCode());
		result = prime*result+((message==null) ? 0 : message.hashCode());
		return result;
	}

	@ Override
	public boolean equals(Object obj)
	{
		if (this==obj)
			return true;
		if (obj==null)
			return false;
		if (getClass()!=obj.getClass())
			return false;
		Data other = (Data) obj;
		if (destiny==null)
		{
			if (other.destiny!=null)
				return false;
		}
		else if (!destiny.equals(other.destiny))
			return false;
		if (message==null)
		{
			if (other.message!=null)
				return false;
		}
		else if (!message.equals(other.message))
			return false;
		return true;
	}

}
