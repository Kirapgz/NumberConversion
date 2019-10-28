# NumberConversion
A Java program for converting decimal to binary, decimal to hexadecimal, binary to decimal and hexadecimal to decimal. Any improvements are welcome (as I'am such an amateur programmer)

This program is actually for my assessment work. So it look so messy and incomprehensible. One of the requirements is that the program should be error proof, so I've tried to think all possible errors that could happened when user input numbers. 

The list of possible errors that I could think of are:-
  1) User input double value when they should input int value.
  2) User input value other than '1' and '0' when trying to convert binary to decimal.
  3) Large decimal values when converted to binary become too long i.e. value cannot be stored in int variable.
  4) User input double values or letters other than ABCDEF when converting hexadecimal value to decimal.
  5) User input special characters (eg: @, $, #)
  6) User input lowercase letters (eg: a instead of A) i.e. lowercase letters is not equal to uppercase letters.
  
Also another requirement is that each conversion must be carried out by recursion method.
