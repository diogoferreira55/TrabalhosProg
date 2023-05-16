import java.util.Scanner;
public class jogoGalo {
    //Programa principal
    public static void main(String[] argd) {
        Scanner ler = new Scanner(System.in);
        char tabuleiro[] = { '1','2','3','4','5','6','7','8','9'};
        int jogada = 0;
        int escolha,aux = 0;
        while(verificaVencedor(tabuleiro) == false && jogada <= 8)
        {
            escolha = menu(tabuleiro,jogada);
            jogada++;
            for(int i=0;i<9;i++)
            {
                aux = i + 1;
                if(aux == escolha)
                {
                    if(jogada % 2 == 0)
                    {
                        tabuleiro[i] = 'O';
                    }else
                    {
                        tabuleiro[i] = 'X';
                    }
                }
            }
            if(verificaVencedor(tabuleiro) == true){
                if(jogada % 2 == 0){
                    System.out.println("O jogador O ganhou o jogo");
                    System.out.println(tabuleiro[0] + "   |   " + tabuleiro[1] + "   |   " + tabuleiro[2]);
                    System.out.println("--------------------");
                    System.out.println(tabuleiro[3] + "   |   " + tabuleiro[4] + "   |   " + tabuleiro[5]);
                    System.out.println("--------------------");
                    System.out.println(tabuleiro[6] + "   |   " + tabuleiro[7] + "   |   " + tabuleiro[8]);
                }else{
                    System.out.println("O jogador X ganhou o jogo");
                    System.out.println(tabuleiro[0] + "   |   " + tabuleiro[1] + "   |   " + tabuleiro[2]);
                    System.out.println("--------------------");
                    System.out.println(tabuleiro[3] + "   |   " + tabuleiro[4] + "   |   " + tabuleiro[5]);
                    System.out.println("--------------------");
                    System.out.println(tabuleiro[6] + "   |   " + tabuleiro[7] + "   |   " + tabuleiro[8]);
                }
            }
            if(verificaVencedor(tabuleiro) == false && jogada ==9){
                System.out.println("O jogo terminou empatado");
                System.out.println(tabuleiro[0] + "   |   " + tabuleiro[1] + "   |   " + tabuleiro[2]);
                System.out.println("--------------------");
                System.out.println(tabuleiro[3] + "   |   " + tabuleiro[4] + "   |   " + tabuleiro[5]);
                System.out.println("--------------------");
                System.out.println(tabuleiro[6] + "   |   " + tabuleiro[7] + "   |   " + tabuleiro[8]);
            }
        }
    }
    //Funçao que verifica se existe algum vencedor
    public static boolean verificaVencedor(char tabuleiro[])
    {
        if(tabuleiro[0] == tabuleiro[1] && tabuleiro[1] == tabuleiro[2])
        {
            return true;
        }else if(tabuleiro[3] == tabuleiro[4] && tabuleiro[4] == tabuleiro[5])
        {
            return true;
        }else if(tabuleiro[6] == tabuleiro[7] && tabuleiro[7] == tabuleiro[8])
        {
            return true;
        }else if(tabuleiro[0] == tabuleiro[3] && tabuleiro[3] == tabuleiro[6])
        {
            return true;
        }else if(tabuleiro[1] == tabuleiro[4] && tabuleiro[4] == tabuleiro[7])
        {
            return true;
        }else if(tabuleiro[2] == tabuleiro[5] && tabuleiro[5] == tabuleiro[8])
        {
            return true;
        }else if(tabuleiro[0] == tabuleiro[4] && tabuleiro[4] == tabuleiro[8])
        {
            return true;



        }else if(tabuleiro[2] == tabuleiro[4] && tabuleiro[4] == tabuleiro[6])
        {
            return true;
        }else
        {
            return false;
        }
    }
    //Funçao para exibir o menu e ler a escolha do utilizador
    public static int menu(char tabuleiro[],int jogada)
    {
        Scanner ler = new Scanner(System.in);
        int escolha = 0;
        System.out.println(tabuleiro[0] + "   |   " + tabuleiro[1] + "   |   " + tabuleiro[2]);
        System.out.println("--------------------");
        System.out.println(tabuleiro[3] + "   |   " + tabuleiro[4] + "   |   " + tabuleiro[5]);
        System.out.println("--------------------");
        System.out.println(tabuleiro[6] + "   |   " + tabuleiro[7] + "   |   " + tabuleiro[8]);
        if(jogada % 2 == 0) {
            System.out.println("Jogador X escolha a posiçao: ");
            escolha = ler.nextInt();
        }else
        {
            System.out.println("Jogador O escolha a posiçao: ");
            escolha = ler.nextInt();
        }
        while(tabuleiro[escolha-1] == 'X' || tabuleiro[escolha-1] == 'O')
        {
            System.out.println("Insira outra posiçao: ");
            escolha = ler.nextInt();
        }
        return escolha;
    }
}