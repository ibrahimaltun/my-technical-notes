package javads_algo_leetcode.classes_pointers;


public class Main {
    public static void main(String[] args) {
        Cookie cookieOne = new Cookie("red");
        Cookie cookieTwo = new Cookie("blue");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());

        cookieOne.setColor("black");
        System.out.println(cookieOne.getColor());
    }
}
