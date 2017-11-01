package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager
{
    private File fileAccess;
    private Scanner in;
    @SuppressWarnings("unused")
	private String fileName;
 
    // Constructor creates a file
    public FileManager(String filename)
    {
    		fileName = filename;
	        fileAccess = new File(filename);
	            	  
    }
    
    //Error handling
    public boolean handleError(Exception i)
    {
        System.out.println("Error: " + i.getMessage());
        return false;
    }

    // Tests if the scanner has been set up.  If not, sets it, and return boolean: success/failure
    private boolean inSet()
    {
        if(in == null)
        {
            try
            {
                in = new Scanner(fileAccess);
                return true;
            }
            catch(IOException i)
            {
                return handleError(i);
            }
        }	
        return true; // Has already been set up
    }

    // Returns the next token
    public String next()
    {
        inSet();
        return in.next();
    }

    // Returns the next line.
    public String nextLine()
    {
        inSet();
        return in.nextLine();
    }

    // Returns the next int.
    public int nextInt()
    {
        inSet();
        return in.nextInt();
    }

    // Tests if the scanner has another token to read
    public boolean hasNext()
    {
        inSet();
        return in.hasNext();
    }

    // Tests if the scanner has another line to read
    public boolean hasNextLine()
    {
        inSet();
        return in.hasNextLine();
    }

    // Tests if the scanner has another int to read.
    public boolean hasNextInt()
    {
        inSet();
        return in.hasNextInt();
    }

    // Returns the number of lines left in the file
    public int numOfLines()
    {
        int lines = 0;
        while(in.hasNextLine())
        {
            inSet();
            in.nextLine();
            lines++;
        }
    in = null; // resets the scanner
    return lines;
    }

     
    public void closeFile()
    {
    	if(in != null)
        {
            in.close();
        }
    }

    // Called automatically when program ends, closes the file
    protected void finalize() throws Throwable
    {
        closeFile();
    }
        
    // Returns the Scanner
    public Scanner getScanner()
    {
        inSet();
        return in;
    }    
   
}
