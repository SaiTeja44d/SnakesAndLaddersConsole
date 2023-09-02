import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SnakesAndLadders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Integer> snakes = new HashMap<>();
        HashMap<Integer,Integer> ladders = new HashMap<>();
        Random random = new Random();
        int xpos = 1;
        int ypos = 1;
        int i = 0;
        snakes.put(23,3);
        snakes.put(36,6);
        snakes.put(52,8);
        snakes.put(66,47);
        snakes.put(79,43);
        snakes.put(85,45);
        snakes.put(89,51);
        snakes.put(92,13);
        snakes.put(95,73);
        snakes.put(98,64);

        ladders.put(9,50);
        ladders.put(14,35);
        ladders.put(20,58);
        ladders.put(27,68);
        ladders.put(37,65);
        ladders.put(60,81);
        ladders.put(63,97);
        ladders.put(67,88);

        System.out.println("**************"+ " SNAKES AND LADDERS "+"***************" );
        System.out.println("Enter 1 to Start:");
        int start = in.nextInt();
        in.nextLine();
        if(start==1){
            System.out.println("Enter player 1 name");
            String p1 = in.nextLine();
            System.out.println("Enter player 2 name");
            String p2 = in.nextLine();
            System.out.println(p1 +" and "+ p2 +" are at position 1");
            while(xpos!=100 && ypos!=100){
                if(i%2==0){
                    System.out.println(p1+"'s turn, press enter to roll the dice:");
                    in.nextLine();
                    int dice = random.nextInt(6)+1;
                    xpos += dice;
                    if(xpos==100){
                        System.out.println(p1+" WON, PARTY LEDAA "+p1);
                        break;
                    }
                    else if(xpos>100){
                        xpos-=dice;
                        System.out.println("You've rolled a "+dice);
                        System.out.println("Can't move beyond 100");
                    }
                    else if(snakes.containsKey(xpos)){
                        System.out.println("You've rolled a "+dice+" and moved to "+xpos);
                        xpos = snakes.get(xpos);
                        System.out.println("A snake bit you, you came down to :"+ xpos);
                    }
                    else if(ladders.containsKey(xpos)){
                        System.out.println("you've rolled a "+dice+" and moved to "+xpos);
                        xpos = ladders.get(xpos);
                        System.out.println("you've got a ladder, you went up to :"+ xpos);
                    }
                    else{
                        System.out.println("you've rolled a "+dice+" and moved to "+xpos);
                    }
                    
                }
                else{
                    System.out.println(p2+"'s turn, press enter to roll the dice:");
                    in.nextLine();
                    int dice = random.nextInt(6)+1;
                    ypos += dice;
                    if(ypos==100){
                        System.out.println(p2+" WON, PARTY LEDAA "+p2);
                        break;
                    }
                    else if(ypos>100){
                        ypos-=dice;
                        System.out.println("you've rolled a "+dice);
                        System.out.println("Can't move beyond 100");
                    }
                    if(snakes.containsKey(ypos)){
                        System.out.println("you've rolled a "+dice+" and moved to "+ypos);
                        ypos = snakes.get(ypos);
                        System.out.println("A snake bit you, you came down to :"+ ypos);
                    }
                    else if(ladders.containsKey(ypos)){
                        System.out.println("you've rolled a "+dice+" and moved to "+ypos);
                        ypos = ladders.get(ypos);
                        System.out.println("you've got a ladder, you went up to :"+ ypos);
                    }
                    else{
                        System.out.println("you've rolled a "+dice+" and moved to "+ypos);
                    }
                    
                }
                i++;
            }

        }
        in.close();
    }
}
