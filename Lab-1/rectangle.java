import java.util.Scanner;
class rectangle{
public static void main(String args[]){
int l,b,area;
System.out.print("Enter value for sides: ");
Scanner r=new Scanner(System.in);
l=r.nextInt();
b=r.nextInt();
area=l*b;
System.out.print("Area of Rectangle: "+area);
}}