import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		Terminal terminal=new Terminal();
		while(true) {
			System.out.print(terminal.Path+": ");
			String Input=scan.nextLine();
			String Inputs[]=Input.split("\\|");
			for(int j=0;j<Inputs.length;j++) {

			Parser parser=new Parser();
			boolean IsVaild=parser.parse(Inputs[j]);
			String Result="";
			if(IsVaild) {
				
				
				if(parser.command.equals("clear")){             	
					terminal.clear();
				}
				
				else if(parser.command.equals("cd")) {				
					Result=terminal.cd(parser.args[0]);
				}
				
				else if(parser.command.equals("ls")) {				
					Result=terminal.ls();
				}
				
				else if(parser.command.equals("cp")) {				
					Result=terminal.cp(parser.args[0], parser.args[1]);
				}
				
				else if(parser.command.equals("mv")) {				
					Result=terminal.mv(parser.args[0], parser.args[1]);
				}
				else if(parser.command.equals("rm")) {
					Result=terminal.rm(parser.args[0]);			
				}
				else if(parser.command.equals("mkdir")) {		
					Result=terminal.mkdir(parser.args[0]);
				}
				else if(parser.command.equals("rmdir")) {		
					Result=terminal.rmdir(parser.args[0]);
				}
				else if(parser.command.equals("cat")) {			
					Result=terminal.cat(parser.args[0],parser.args[1]);
				}
				else if(parser.command.equals("more")) {		
					Result=terminal.more(parser.args[0]);
				}
				else if(parser.command.equals("pwd")) {	      
					Result=terminal.pwd();
				}
				else if(parser.command.equals("args")) {	
					Result=terminal.args();
				}
				else if(parser.command.equals("date")) {
					Result=terminal.date();
				}
				else if(parser.command.equals("help")) {
					Result=terminal.help();
				}
				else if(parser.command.equals("exit")){
					terminal.exit();
				}
				
				if(parser.redirectingFile.equals("")) { 
					System.out.println(Result);
				}
				else if(parser.redirectingFile.equals(">>")) {
					String file = "test.txt";
					BufferedWriter out = new BufferedWriter(new FileWriter(file));
					out.write("Hello World:\n");
		            out.close();
				}	
				else{
					File file=new File(parser.redirectingFile);
					PrintWriter out=new PrintWriter(file);
					for(int i=0;i<Result.length();i++) {
						if(Result.charAt(i)=='\n') {
							out.println();
						}
						else {
							out.print(Result.charAt(i));
						}
					}
					
					out.close();
					
				}
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		
			
	}
		
	}

}