import java.io.*;
class hex_de{
  public String key_combination(char ch[],String key[]){
		String m="",n="",s="";
		for(int h=0;h<=3;h++){
		 	m+=ch[h];
		 	n+=ch[h+4];
         }
         
        int k=0,l=0;
		for(int i=0;i<=15;i++){
			if(key[i].equals(m)){
                k=i;
			}
			if(key[i].equals(n)){
				l=i;
			}
        }
        
		s+=(char)(65+k);
		s+=(char)(65+l);
		return s;
	}
	public String hex_decoding(String s){
		String l[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
		String r="";
	
		r+=l[s.charAt(0)-65];
		r+=l[s.charAt(1)-65];
		return r;
	}
	long binary_to_dec(String s){
		long res=(s.charAt(0)-48)*128+(s.charAt(1)-48)*64+(s.charAt(2)-48)*32+(s.charAt(3)-48)*16+(s.charAt(4)-48)*8+(s.charAt(5)-48)*4+(s.charAt(6)-48)*2+(s.charAt(7)-48)*1;
		return res;
	}
	char dec_to_ascii(long dec){
		return (char)dec;
	}
	

public static void main(String args[]){
	
	long dec;char c;
	String s;
	hex_de h=new hex_de();
	String key[]={"0101","1001","1101","0001","1111","0110","1010","0000","1000","1100","1110","0010","1011","0100","0111","0011"};
    File file = new File("encrypt.txt");
    int count=0;
    char a[]=new char[8];
    try{
        FileInputStream fis = new FileInputStream(file);
        FileWriter fw=new FileWriter("decrypt.txt"); 
    while (fis.available()>0) {
        count=0;
        while(count<8){
            a[count]=(char)fis.read();
            count++;
        }
        
		s=h.key_combination(a,key);
		
		s=h.hex_decoding(s);
		//System.out.println(s);
		dec=h.binary_to_dec(s);
		//System.out.println(dec);
		c=h.dec_to_ascii(dec);
		fw.write(c);
}
fis.close();fw.close();
}
catch(Exception e){
        System.out.println(e.getMessage());
    }

}
}