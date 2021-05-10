package testpkg;

import Wrappers.JsonFileHandler;
import org.testng.annotations.Test;

public class FileTest {
    
    
    @Test
    public void jsonTest()
    {
        JsonFileHandler.readFile();
         //String s =JsonFileHandler.print();
      //   System.out.println(s);
    }
    
    
}
