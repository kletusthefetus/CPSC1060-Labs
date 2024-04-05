/*
  James Maner
  CPSC1061: Lab 1
  Lab Section 003
  1/19/2023
*/


public class Hello {
    public static void main(String[] args) {
      int x = 5;
      int y = x / (-1);

      int twenty = 'a';
      char numOne = twenty;
      x = 4;
      System.out.println("Hello World!");
       String str = "java";
       for (int i = (str.length() - 1); i >= 0; i--)
       {
        System.out.println(str.charAt(i) + 3);
       }
       System.out.println(twenty);
       System.out.println(numOne);
    }


}