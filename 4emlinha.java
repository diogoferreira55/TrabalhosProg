import java.util.Scanner;
public class quatroEmLinha
{
    //Programa principal
    public static void main(String[] args)
    {
        Scanner ler = new Scanner(System.in);
        char tabuleiro[][] = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        int jogada = 1, i = 5;
        int escolha = 0;
        while (jogada <= 42 && verificaVencedor(tabuleiro) == false)
        {
            escolha = menu(tabuleiro, jogada);
            while (escolha > 7 || escolha < 1)
            {
                if (jogada % 2 == 0)
                {
                    System.out.println("Insira a coluna que quer colocar o O(entre 1 e 7):");
                    escolha = ler.nextInt();
                } else
                {
                    System.out.println("Insira a coluna que quer colocar o X(entre 1 e 7):");
                    escolha = ler.nextInt();
                }
            }
            jogada++;
            switch (escolha)
            {
                case 1, 2, 3, 4, 5, 6, 7:
                    int cont = 0;
                    i = 5;
                    while(tabuleiro[i][escolha - 1] == 'X' || tabuleiro[i][escolha - 1] == 'O') {
                        cont++;
                        i--;
                    }
                    if(cont == 6)
                    {
                        System.out.println("A coluna esta cheia \n Escolha outra");
                        escolha = ler.nextInt();
                    }
                    if (i >= 0)
                    {
                        if (jogada % 2 == 0) {
                            tabuleiro[i][escolha - 1] = 'X';
                        } else {
                            tabuleiro[i][escolha - 1] = 'O';
                        }
                    }
                break;
            }
            if(verificaVencedor(tabuleiro) == true)
            {
                if (i >= 0)
                {
                    if (jogada % 2 == 0) {
                        System.out.println("O jogador X ganhou o jogo ");
                    } else {
                        System.out.println("O jogador O ganhou o jogo");
                    }
                }
            }
            if(verificaVencedor(tabuleiro)==true)
            {
                System.out.println("  1    2    3    4    5    6    7");
                System.out.println(tabuleiro[0][0] + "   |" + tabuleiro[0][1] + "   |" + tabuleiro[0][2] + "   |" + tabuleiro[0][3] + "   |" + tabuleiro[0][4] + "   |" + tabuleiro[0][5] + "   |" + tabuleiro[0][6]);
                System.out.println("----------------------------------");
                System.out.println(tabuleiro[1][0] + "   |" + tabuleiro[1][1] + "   |" + tabuleiro[1][2] + "   |" + tabuleiro[1][3] + "   |" + tabuleiro[1][4] + "   |" + tabuleiro[1][5] + "   |" + tabuleiro[1][6]);
                System.out.println("----------------------------------");
                System.out.println(tabuleiro[2][0] + "   |" + tabuleiro[2][1] + "   |" + tabuleiro[2][2] + "   |" + tabuleiro[2][3] + "   |" + tabuleiro[2][4] + "   |" + tabuleiro[2][5] + "   |" + tabuleiro[2][6]);
                System.out.println("----------------------------------");
                System.out.println(tabuleiro[3][0] + "   |" + tabuleiro[3][1] + "   |" + tabuleiro[3][2] + "   |" + tabuleiro[3][3] + "   |" + tabuleiro[3][4] + "   |" + tabuleiro[3][5] + "   |" + tabuleiro[3][6]);
                System.out.println("----------------------------------");
                System.out.println(tabuleiro[4][0] + "   |" + tabuleiro[4][1] + "   |" + tabuleiro[4][2] + "   |" + tabuleiro[4][3] + "   |" + tabuleiro[4][4] + "   |" + tabuleiro[4][5] + "   |" + tabuleiro[4][6]);
                System.out.println("----------------------------------");
                System.out.println(tabuleiro[5][0] + "   |" + tabuleiro[5][1] + "   |" + tabuleiro[5][2] + "   |" + tabuleiro[5][3] + "   |" + tabuleiro[5][4] + "   |" + tabuleiro[5][5] + "   |" + tabuleiro[5][6]);
            }
        }
    }

    //Funçao para exibir o menu e para ler a escolha do utilizadpr
    public static int menu(char tabuleiro[][], int jogada)
    {
        Scanner ler = new Scanner(System.in);
        int escolha;
        System.out.println("  1    2    3    4    5    6    7");
        System.out.println(tabuleiro[0][0] + "   |" + tabuleiro[0][1] + "   |" + tabuleiro[0][2] + "   |" + tabuleiro[0][3] + "   |" + tabuleiro[0][4] + "   |" + tabuleiro[0][5] + "   |" + tabuleiro[0][6]);
        System.out.println("----------------------------------");
        System.out.println(tabuleiro[1][0] + "   |" + tabuleiro[1][1] + "   |" + tabuleiro[1][2] + "   |" + tabuleiro[1][3] + "   |" + tabuleiro[1][4] + "   |" + tabuleiro[1][5] + "   |" + tabuleiro[1][6]);
        System.out.println("----------------------------------");
        System.out.println(tabuleiro[2][0] + "   |" + tabuleiro[2][1] + "   |" + tabuleiro[2][2] + "   |" + tabuleiro[2][3] + "   |" + tabuleiro[2][4] + "   |" + tabuleiro[2][5] + "   |" + tabuleiro[2][6]);
        System.out.println("----------------------------------");
        System.out.println(tabuleiro[3][0] + "   |" + tabuleiro[3][1] + "   |" + tabuleiro[3][2] + "   |" + tabuleiro[3][3] + "   |" + tabuleiro[3][4] + "   |" + tabuleiro[3][5] + "   |" + tabuleiro[3][6]);
        System.out.println("----------------------------------");
        System.out.println(tabuleiro[4][0] + "   |" + tabuleiro[4][1] + "   |" + tabuleiro[4][2] + "   |" + tabuleiro[4][3] + "   |" + tabuleiro[4][4] + "   |" + tabuleiro[4][5] + "   |" + tabuleiro[4][6]);
        System.out.println("----------------------------------");
        System.out.println(tabuleiro[5][0] + "   |" + tabuleiro[5][1] + "   |" + tabuleiro[5][2] + "   |" + tabuleiro[5][3] + "   |" + tabuleiro[5][4] + "   |" + tabuleiro[5][5] + "   |" + tabuleiro[5][6]);
        if (jogada % 2 == 0)
        {
            System.out.println("Insira a coluna que quer colocar o O:");
            escolha = ler.nextInt();
        } else
        {
            System.out.println("Insira a coluna que quer colocar o X:");
            escolha = ler.nextInt();
        }
        return escolha;
    }
    //funçao para verificar vencedor
    public static boolean verificaVencedor(char tabuleiro[][])
    {
        int contXh = 0, contOh = 0, contOv = 0, contXv = 0,contOd = 0, contXd = 0;
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if(tabuleiro[i][j] == 'X' && tabuleiro[i][j+1] == 'X' && tabuleiro[i][j+2] == 'X' && tabuleiro[i][j+3] == 'X')
                {
                    contXh=4;
                }
                if(tabuleiro[i][j] == 'O' && tabuleiro[i][j+1] == 'O' && tabuleiro[i][j+2] == 'O' && tabuleiro[i][j+3] == 'O')
                {
                    contOh=4;
                }
            }
        }
        for(int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (tabuleiro[j][i] == 'X' && tabuleiro[j+1][i] == 'X' && tabuleiro[j+2][i] == 'X' && tabuleiro[j+3][i] == 'X')
                {
                    contXv=4;
                }
                if (tabuleiro[j][i] == 'O' && tabuleiro[j+1][i] == 'O' && tabuleiro[j+2][i] == 'O' && tabuleiro[j+3][i] == 'O')
                {
                    contOv=4;
                }
            }
        }
        for(int i = 5; i >3; i--)
        {
            for (int j = 0; j < 4; j++)
            {
                if(tabuleiro[i][j] == 'X' && tabuleiro[i-1][j+1] == 'X' && tabuleiro[i-2][j+2] == 'X' && tabuleiro[i-3][j+3] == 'X')
                {
                    contXd=4;
                }
                if (tabuleiro[i][j] == 'O' && tabuleiro[i-1][j+1] == 'O' && tabuleiro[i-2][j+2] == 'O' && tabuleiro[i-3][j+3] == 'O')
                {
                    contOd=4;
                }
            }
        }
        for(int j = 6; j  > 4; j--)
        {
            for (int i = 5; i > 3; i--)
            {
                if(tabuleiro[i][j] == 'X' && tabuleiro[i-1][j-1] == 'X' && tabuleiro[i-2][j-2] == 'X' && tabuleiro[i-3][j-3] == 'X')
                {
                    contXd=4;
                }
                if (tabuleiro[i][j] == 'O' && tabuleiro[i-1][j-1] == 'O' && tabuleiro[i-2][j-2] == 'O' && tabuleiro[i-3][j-3] == 'O')
                {
                    contOd=4;
                }
            }
        }
        if (contXh == 4 || contOh == 4 || contXv == 4 || contOv ==4 ||contOd== 4|| contXd==4)
        {
            return true;
        } else
        {
            return false;
        }
    }
}