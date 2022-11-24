package chessMoveInterpreter;

import java.util.Scanner;

/**
 *
 * @author Rose
 */
public class Test {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
        
        System.out.println("Hello World!");
        System.out.println("What's the chess move?");
        
        String test = sc.nextLine();
        Move move = new Move(test);
        
        System.out.println(move.moveresult() );
    }
}

class Move{
    String move;
    
    public Move(String moved){
        move = moved;
        if(moved.length() < 2){
            move = "INVALID MOVE";
        }
    }
    
    public String moveresult(){
        
        String moveresult = "Move ";
        
        char fC = this.move.charAt(0);
        
        
        if(Character.isUpperCase(fC)){
            switch(fC){
                case 'K' -> moveresult += "King ";
                case 'Q' -> moveresult += "Queen ";
                case 'R' -> moveresult += "Rook ";
                case 'B' -> moveresult += "Bishop ";
                case 'N' -> moveresult += "Knight ";
                default -> moveresult = "Invalid move!";
            }
            
            moveresult += this.move.substring(1, 3);
        
            
        }
        else if(Character.isLowerCase(fC)){
            moveresult += "Pawn to ";
            
             moveresult += this.move.substring(0, 2);
            
        } else {
            return "Invalid move!";
        }
        
        
        
        return moveresult;
    }
}