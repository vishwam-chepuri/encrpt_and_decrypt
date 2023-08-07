import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class hex_en{
	
	
	public int ascii_to_hex(char ch){
		return (int)ch;
	}
	public String hex_coding(int n){
		int a[]=new int[8];String s="";
		for(int i=7; n>0; i--)   	 
		{    
			a[i]=n%2;    
			n= n/2;  
		} 
		char c[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'};
		int l=a[0]*8+a[1]*4+a[2]*2+a[3]*1;
		int m=a[7]*1+a[6]*2+a[5]*4+a[4]*8;
		s+=c[l];
		s+=c[m];
		return s;
	}
	public String key_combination(String s,String key[]){
        String r="";
        
		r+=key[(int)(s.charAt(0))%65];
		r+=key[((int)s.charAt(1))%65];
		return r;
		
	}

public static void main(String args[]){
	
	int hex;
	String s;
	hex_en h=new hex_en();
	String key[]={"0101","1001","1101","0001","1111","0110","1010","0000","1000","1100","1110","0010","1011","0100","0111","0011"};
    //File file = new File("C:/Users/hp/Documents/file.txt");
    char my_character ;
    String[] values = {"File","Text Input","No option"};

    Object selected = JOptionPane.showInputDialog(null, "What do you want to encrypt?", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "2");
         if( selected == "File")
		{
			/*JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
			int r = j.showOpenDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) 
            { 
                // set the label to the path of the selected file 
				//l.setText(j.getSelectedFile().getAbsolutePath()); 
				File file = new File(j.getSelectedFile().getAbsolutePath());
			}*/
			JFileChooser fc=new JFileChooser();    
    		int i=fc.showOpenDialog(null)  ; 
    		if(i==JFileChooser.APPROVE_OPTION){    
        		File f=fc.getSelectedFile();    
				String filepath=f.getPath();
			}
			
			try{
				FileInputStream fis = new FileInputStream(filepath);
				FileWriter fw=new FileWriter("encrypt.txt");  
					 
				while (fis.available() > 0 ) {
					my_character = (char) fis.read();
					hex=h.ascii_to_hex(my_character);
					System.out.println(hex);
					s=h.hex_coding(hex);
					System.out.println(s);
					s=h.key_combination(s,key);
					System.out.println(s);
					fw.write(s); 
							
				}
				fw.close();
				fis.close();
				}
			catch(Exception e){
				System.out.println(e.getMessage());
				}

		}
        else{
                System.out.println("User cancelled");
            }  
            
    



}
}
