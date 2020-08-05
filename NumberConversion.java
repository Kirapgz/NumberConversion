
import java.util.*;
public class NumberConversion {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String answer = "";
		do {
			boolean invalid = true;
			do {
				intro();
				int choice = 0;
						
				while(invalid) {
					try {
						choice = in.nextInt();
						invalid = false;
					}
					catch(InputMismatchException e) {
						in.nextLine();
						System.out.println("\nInvalid input. Please try again.");
						intro();	
					}
				}
				
				invalid = true;
				switch(choice){
				case 1:
					int ans = 0;
					boolean b = true;
					while(b) {
	 					try {
	 						System.out.println("[Decimal to Binary]");
							System.out.println("Enter the value: ");
							ans = in.nextInt();
							
							if(ans > 0) {
								invalid = false;
								b = false;
							}
							else {
								in.nextLine();
								System.out.println("\nInvalid input. Please try again.");
							}
						}
						catch(InputMismatchException e){
							in.nextLine();
							System.out.println("\nInvalid input. Please try again.");
						}
					}
					System.out.println(ans + " = " + dec2bin(ans));
					System.out.println();
					break;
					
				case 2:
					boolean c = true;
					while(c) {
						try {
							System.out.println("[Decimal to Hexadecimal]");
							System.out.println("Enter the value: ");
							String ans2 = in.next();
							
							if(Integer.parseInt(ans2) > 0) {
								System.out.println(ans2 + " = " + dec2hex(ans2));
								System.out.println();
								invalid = false;
								c = false;
							}
							else {
								in.nextLine();
								System.out.println("\nInvalid input. Please try again.");
							}
						}
						catch(NumberFormatException e) {
							in.nextLine();
							System.out.println("\nInvalid input. Please try again.");
						}
					}
					break;
					
				case 3:
					boolean d = true;
					while(d) {
						System.out.println("[Binary to Decimal]");
						System.out.println("Enter the value: ");
						String ans3 = in.next();
						if (ans3.matches("[01]+")) {
							System.out.println(ans3 + " = " + bin2dec(ans3));
							System.out.println();
							invalid = false;
						    d = false;
						}
						else {
						    in.nextLine();
						    System.out.println("\nInvalid input. Please try again.");
						}
					}
					invalid = false;
					break;
					
				case 4:
					boolean e = true;
					while(e) {
						System.out.println("[Hexadecimal to Decimal]");
						System.out.println("Enter the value: ");
						String ans4 = in.next();
						String str = ans4.toUpperCase();
						int count = 0;
						int x = 0;
						int power = str.length(); 
						for(int i = 0; i < str.length(); i++) {
							if(!Character.isLetterOrDigit(str.charAt(i)) || str.substring(i).matches("[G-Z]+")) {
								count++;
							}
						}
						
						if(count < 1) {
							System.out.println(str + " = " + hex2dec(str, power, x));
							System.out.println();
							invalid = false;
							e = false;
						}
						else {
							in.nextLine();
						    System.out.println("\nInvalid input. Please try again.");
						}
					}
					break;
					
				default:
					in.nextLine();
					System.out.println("\nInvalid input. Please try again.");
					intro();
					
				}
			}while(invalid);
			
			
			
			invalid = true;
			while(invalid) {
				System.out.println("Try again?(y/n)");
				answer = in.next();
				if(!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
					in.nextLine();
					System.out.println("Invalid input.");
				}
				else {
					invalid = false;
				}
			}
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("\nThank you");
			} 
		
		}while(answer.equalsIgnoreCase("y"));
		
		
		in.close();
	}
	
	
	public static long dec2bin (int x) {
		if(x == 0) {
			return 0;
		}
		else {
			return ((x % 2) + 10 * dec2bin(x/2) );
		}
			
	}
	
	
	public static String dec2hex (String n) {
		String result = "";
		int x = Integer.parseInt(n);
		if(x == 0) {
			return "";
		}
		else {
			int remainder = x % 16;
			switch (remainder) {
            case 10:
                result = "A";
                break;
            case 11:
                result = "B";
                break;
            case 12:
                result = "C";
                break;
            case 13:
                result = "D";
                break;
            case 14:
                result = "E";
                break;
            case 15:
                result = "F";
                break;
            default:
                result = remainder + result;
                break;
        }
        return dec2hex(Integer.toString(x / 16)) + result;
		}		
	}
	
	
	public static int bin2dec(String bin) {
		int x = 0;
		int length = bin.length();
		if (length > 0) {
			String substring = bin.substring(1);
			int digit = Character.getNumericValue(bin.charAt(0));
			x = digit * (int) Math.pow(2, length - 1) + bin2dec(substring);
		}
		return x;
	}
	
	
	public static int hex2dec(String hex, int power, int t){
		int x=0;
		char ch = hex.charAt((hex.length()-1)- t);
		
		if (ch >= '0' && ch <='9') {
			x = ch - '0';
		} else if (ch == 'A') {
			x = 10;
		} else if (ch == 'B') {
			x = 11;
		} else if (ch == 'C') {
			x = 12;
		} else if (ch == 'D') {
			x = 13;
		} else if (ch == 'E') {
			x = 14;
		} else if (ch == 'F') {
			x = 15;
		}
		
		int n = x * (int) Math.pow(16, t);
		t++;
		
		if(hex.length() != t) {
			return hex2dec(hex, power, t) + n;
		}
		else {
			return n;
		}
	}
	
	public static void intro() {
		System.out.println("Number conversion Systems\n");
		System.out.println("1. Decimal to Binary\n");
		System.out.println("2. Decimal to Hexadecimal\n");
		System.out.println("3. Binary to Decimal\n");
		System.out.println("4. Hexadecimal to Decimal\n");
		System.out.println("Choose option 1, 2, 3 or 4: ");
		return;
	}
	
}
