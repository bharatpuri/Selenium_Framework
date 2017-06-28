package com.autoiq.pages;

import java.io.IOException;

public class Testcmdprompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Runtime rt = Runtime.getRuntime();
	    try {
	        rt.exec(new String[]{"cmd.exe","/c","start"});

	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    String command = "mvn test AutoiQTestSuite.xml";*/
	    try
	    {
	        Process process = Runtime.getRuntime().exec("cmd /c start  mvn test -DsuiteXmlFile=AutoiQTestSuite.xml");
	    } catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}

}
