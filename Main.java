import java.util.Scanner;

class Main {
  static int count;

  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.print("Enter the first term: ");
    int num = console.nextInt();

    count = 1; //The first term inclusive. + Prints
    System.out.println("\nLength:" + hailstoneLength(num));
    System.out.println("Is long sequence? " + isLongSeq(num));
    System.out.println("Proportion of long sequences: " + propLong(num));
    console.close();
  }

  //Builds the stack, terminates when n = 1, and returns the count.
  public static int hailstoneLength(int n){
    if (n == 1){
      return count;
    }
    else{
      count++;
      if (n % 2 == 0){ //If Even
        return (hailstoneLength(n/2)); //n/2
      }
      else{ //If Odd
        return (hailstoneLength((3*n)+1)); //3n + 1
      }
    }
  }
  
  public static boolean isLongSeq(int n){
    count = 1; //Resets count, so no errors occur.
    return (hailstoneLength(n) > n);
  }

  public static double propLong(int n){
    double x = 0.0; //Set to double to divide correctly.

    //Simple for loop.
    for (int i = 1; i <= n; i++){
      if (isLongSeq(i)){
        x++;
      }
    }
    return x/n; //returns val.
  }
}