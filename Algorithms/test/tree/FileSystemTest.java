package tree;

import org.junit.Before;
import org.junit.Test;

import trees.FileSystem;

public class FileSystemTest {
	
	FileSystem fileSystem = new FileSystem("61b");
	
@Before
	public  void setup() {
		
		fileSystem.createDirectory(fileSystem.getRootDirectory(),"hw");
		fileSystem.addFile(fileSystem.getRootDirectory(), "index.html");
		fileSystem.createDirectory(fileSystem.getRootDirectory(),"lab");
		fileSystem.createDirectory(fileSystem.getRootDirectory(),"lec");
		
		//Adding files to hw
		fileSystem.addFile("hw", "hw1.doc");
		fileSystem.addFile("hw", "hw2.doc");

        //Add lab1 and lab2 sub directory to labs
		fileSystem.createDirectory("lab","lab1");
		fileSystem.createDirectory("lab","lab2");
		
		//Add files to lab1
		fileSystem.addFile("lab1", "lab1.ppt");

		fileSystem.addFile("lec", "lec1.ppt");
		fileSystem.addFile("lec", "lec2.ppt");
		fileSystem.addFile("lec", "lec3.ppt");
	
//fileSystem.printAll();
		
	}

    @Test
    public void testPrintAll(){
    	fileSystem.printAll();
    }

}
