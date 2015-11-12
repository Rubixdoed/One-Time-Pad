import java.util.Scanner;

/**
 * @author Zachary Stroud
 * @version 1.0
 */
public class Core{
    
    private static Scanner scan;
    
    public static void main(String[] args){
        
        scan = new Scanner(System.in);
        
        boolean running = true;
        while(running){
            
            System.out.print( "Encrypt, Decrypt, or Exit\n(E / D / X) > " );
            String type = scan.nextLine();
            
            char c = type.charAt(0);
            if( c == 'E' || c == 'e' ){
                System.out.println( "Encrypted: " + encrypt() );
            } else if( c == 'D' || c == 'd' ){
                System.out.println( "Decrypted: " + decrypt() );
            } else if( c == 'X' || c == 'x' ){
                running = false;
            } else {
                System.out.print( "You need to select " );
            }
            
        }
        
    }
    
    private static String locations = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static String encrypt(){
        
        System.out.print( "Enter the key\n> " );
        String key = scan.nextLine().toUpperCase();
        System.out.print( "Enter the text\n> " );
        String text = scan.nextLine().toUpperCase();
        
        int key_index = 0;
        String ret = "";
        for(int i = 0; i < text.length(); i++){
            int text_location = locations.indexOf( text.charAt(i) );
            
            if(text_location >= 0){
                int key_location = locations.indexOf( key.charAt(key_index++) );
                ret += locations.charAt( (text_location + key_location) % 26 );
            } else {
                ret += text.charAt(i);
            }
        }
        
        return ret;
        
    }
    
    public static String decrypt(){
        
        System.out.print( "Enter the key\n> " );
        String key = scan.nextLine().toUpperCase();
        System.out.print( "Enter the text\n> " );
        String text = scan.nextLine().toUpperCase();
        
        int key_index = 0;
        String ret = "";
        for(int i = 0; i < text.length(); i++){
            int text_location = locations.indexOf( text.charAt(i) );
            
            if( text_location >= 0){
                int key_location = locations.indexOf( key.charAt(key_index++) );
                int new_char = (text_location + key_location) % 26;
                if(new_char < 0){
                    new_char += 26;
                }
                ret += locations.charAt( new_char );
            } else {
                ret += text.charAt(i);
            }
        }
        
        return ret;
    }
    
}
