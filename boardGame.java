import java.util.Scanner;
import java.util.Random;
public class boardGame {
    static int throwCubeOrExitGame(){
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        System.out.println("==========================================================================");
        System.out.println("1- Iniciar");
        System.out.println("0- Sair");
        option = scanner.nextInt();
        System.out.println("==========================================================================");
        return option;
    }
    static int justThrowCube(){
        Scanner scanner = new Scanner(System.in);
        int throwOption = -1;
        System.out.println("1- Lançar dado");
        throwOption = scanner.nextInt();
        return throwOption;
    }
    static int getRamdomNumber(){
        Random random = new Random();
        int ramdomNumber = random.nextInt(6) + 1;
        return ramdomNumber;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentlyPlayer = 1;
        int player1Position = 0;
        int player2Position= 0;
        int[] badLuckyHouses = {3, 7, 12, 14, 16, 18, 21, 24, 30, 32};
        int[] luckyHouses = {2, 5, 8, 11, 15, 20, 23, 25, 28, 31};
        System.out.println("==========================================================================");
        System.out.println("SEJA BEM VINDO!");
        System.out.println("VAMOS COMEÇAR A JOGAR?");
        int option1 = throwCubeOrExitGame();
        if(option1 == 1){
            System.out.println("Vez do Jogador 1");
            while(player1Position < 33 || player2Position < 33){
                if(currentlyPlayer % 2 != 0){
                    int justThrowCubeResult = justThrowCube();
                    if(justThrowCubeResult == 1){
                        int ramdomNumber = getRamdomNumber();
                        System.out.println("Tirou " + ramdomNumber);
                        player1Position += ramdomNumber;
                        for (int house : luckyHouses) {
                            if(house == player1Position){
                                System.out.println("Sorte +2 Casas");
                                player1Position += 2;
                                break;
                            }else{
                                
                            }
                        }
                        for (int house : badLuckyHouses) {
                            if(house == player1Position){
                                System.out.println("Azar -2 Casas");
                                player1Position -= 2;
                                break;
                            }else{
                                
                            }
                        }
                        System.out.println("Posição Jogador 1: " + player1Position);
                        currentlyPlayer++;
                        System.out.println("==========================================================================");
                        System.out.println("Vez do Jogador 2");
                    }
                }else if(currentlyPlayer % 2 == 0){
                    int justThrowCubeResult = justThrowCube();
                    if (justThrowCubeResult == 1) {
                        int ramdomNumber = getRamdomNumber();
                        System.out.println("Tirou " + ramdomNumber);
                        player2Position += ramdomNumber;
                        for (int house : luckyHouses) {
                            if(house == player2Position){
                                System.out.println("Sorte +2 Casas");
                                player2Position += 2;
                                break;
                            }else{
                                
                                
                            }
                        }
                        for (int house : badLuckyHouses) {
                            if(house == player2Position){
                                System.out.println("Azar -2 Casas");
                                player2Position -= 2;
                                break;
                            }else{
                                
                            }
                        }
                        System.out.println("Posição Jogador 2: " + player2Position);
                        currentlyPlayer++; 
                        System.out.println("=========================================================================="); 
                        System.out.println("Vez do Jogador 1"); 
                    }
                }
                if (player1Position >= 33) {
                    System.out.println("O jogador 1 venceu o jogo!");
                    break;
                }
                if (player2Position >= 33) {
                    System.out.println("O jogador 2 venceu o jogo!");
                    break;
                }
            }
        }
    }
}
