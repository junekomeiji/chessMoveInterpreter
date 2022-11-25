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
        
        String moveresult = "";
        int pointer = 0;
        boolean capture = false;
        boolean alphabetSeen = false;
        boolean seenPiece = false;
        
        String c1 = "";
        String c2 = "";  
        
        while(pointer < this.move.length()){
            
            char cc = this.move.charAt(pointer);
            
            if(seenPiece == false){
                if(Character.isUpperCase(cc)){
                switch(cc){
                    case 'K' -> moveresult += "King ";
                    case 'Q' -> moveresult += "Queen ";
                    case 'R' -> moveresult += "Rook ";
                    case 'B' -> moveresult += "Bishop ";
                    case 'N' -> moveresult += "Knight ";
                    default -> moveresult = "Invalid piece!";
                }
                    seenPiece = true;
                }
                
                else if(Character.isLowerCase(cc)){
                moveresult += "Pawn ";
                seenPiece = true;
                } else {
                return "Invalid move!";
                }
                
            }
           
                
            if((Character.isLowerCase(cc) || Character.isDigit(cc)) && cc != 'x'){
                c1 += cc;
                alphabetSeen = true;
            } else if(cc == 'x'){
                capture = true;
            }    
            pointer++;
        }
        
        if(c2.isEmpty()){
                if(capture == true) moveresult += ("captures piece at " + c1);
                else moveresult += ("moves to " + c1);
        } else {
                if(capture == true) moveresult += ("at " + c1 + "captures piece at " + c2);
                else moveresult += ("at " + c1 + "moves to " + c2);
        }
        
        return moveresult;
    }
}