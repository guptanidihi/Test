package com.CCQA.com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties
{
	
	InputStream inputStream;
	
	public String getPropValues() throws IOException
	{
		String URL=null;
		try
		{
			Properties prop = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			 
			if (inputStream != null)
			{
				prop.load(inputStream);
			} 
			else
			{
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			URL = prop.getProperty("URL");
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		finally
		{
			inputStream.close();
		}
		return URL;
	}
}
