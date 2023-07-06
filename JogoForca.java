import java.util.Scanner;
public class JogoForca
{
    public static void main(String[] args)
    {
        Scanner ler = new Scanner(System.in);
        int menor = 0, maior=29,aux=0,tentativa = 0;
        boolean verificaLetra = false;
        String palavras[] = {"abundante","aconchegante","adepto","agilidade","ambicioso","benevolente","colaboracao","conquistar","deslumbrante","efervescente","empreendedor","enigmatico","equilibrio","exuberante","fascinante","harmonia","incansavel","inovador","jubilo","melancolia","modestia","notavel","otimismo","pacifico","perspicaz","protagonista","resiliente","sincero","talento","versatil"};
        int num_random = randomNumero();
        String palavraCerta = palavras[num_random];
		int tamanho =  palavraCerta.length();
        char letrasPalavraCerta[] = new char[tamanho], letrasInseridas[] = new char[tamanho],letrasErradas[] = new char[tamanho],letra;
        for(int i = 0; i < tamanho; i++)
        {
            letrasPalavraCerta[i] = palavraCerta.charAt(aux);
            aux++;
        }
        aux = 0;
        for(int j = 0;j < tamanho;j++)
		{
			letrasInseridas[j] = '_';
		}
        while(verificaVitoria(letrasInseridas, letrasPalavraCerta, tamanho)==false && tentativa <6)
        {
            verificaLetra = false;
			exibeForca(tentativa);
            System.out.print("A palavra é: ");
            for(int j = 0;j<tamanho;j++)
			{
				System.out.print(letrasInseridas[j]);
			}
			System.out.print("\nLetras erradas: ");
			for(int j = 0;j<7;j++)
			{
			System.out.print(letrasErradas[j]);
			}
			System.out.print("\nInsira uma letra: ");
			letra = ler.next().charAt(0);
			boolean validaLetra = false;
			for(int j = 0;j<tamanho;j++)
			{
			while(letra == letrasInseridas[j] && validaLetra == false && j<tamanho || letra == letrasErradas[j] && validaLetra == false&& j<tamanho )
			   {
			System.out.println("A letra ja foi inserida \nInsira uma nova letra: ");
			letra = ler.next().charAt(0);
			if(letra != letrasInseridas[j] || letra != letrasErradas[j])
			{
			validaLetra = true;
			}
			   }
			}
			for(int j = 0;j<tamanho;j++)
			{
			if(letra == letrasPalavraCerta[j])
			   {
			   letrasInseridas[j] = letra;
			   verificaLetra = true;
			   }
			}
			if(verificaLetra == false)
			{
			   letrasErradas[aux] = letra;
			   tentativa++;
			   aux++;
			}
		}
		if(verificaVitoria(letrasInseridas,letrasPalavraCerta,tamanho)==false)
		{
			exibeForca(tentativa);
			System.out.println("Perdeu o jogo \n A palavra secreta é " + palavraCerta);
		}
		if(verificaVitoria(letrasInseridas,letrasPalavraCerta,tamanho)==true && tentativa < 6)
		{
			System.out.println("Ganhaste o jogo \n A palavra secreta é " + palavraCerta);
		}
    }
    public static void exibeForca(int tentativa) {
        switch (tentativa) {
            case 1:
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________   ");
            break;
            case 2:
                System.out.println("    _____________");
                System.out.println("    |            |");
                System.out.println("    |            |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________   ");
            break;
            case 3:
                System.out.println("    _____________");
                System.out.println("    |            |");
                System.out.println("    |            |");
                System.out.println("    |          _____");
                System.out.println("    |         |     |");
                System.out.println("    |         |     | ");
                System.out.println("    |          -----");
                System.out.println("    |             ");
                System.out.println("    |             ");
                System.out.println("    |             ");
                System.out.println("    |             ");
                System.out.println("    |             ");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________");
            break;
            case 4:
                System.out.println("    ______________");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |           _____");
                System.out.println("    |          |     |");
                System.out.println("    |          |     | ");
                System.out.println("    |           -----");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________   ");
            break;
            case 5:
                System.out.println("    ______________");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |           _____");
                System.out.println("    |          |     |");
                System.out.println("    |          |     | ");
                System.out.println("    |           -----");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |            / \\");
                System.out.println("    |           /   \\");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________   ");
            break;
			case 6:
                System.out.println("    ______________");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |           _____");
                System.out.println("    |          |     |");
                System.out.println("    |          |     | ");
                System.out.println("    |           -----");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |         ----|----");
                System.out.println("    |             |");
                System.out.println("    |             |");
                System.out.println("    |            / \\");
                System.out.println("    |           /   \\");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("____________   ");
            break;
        }
    }
         
    public static boolean verificaVitoria(char[] letrasInseridas, char[] letrasPalavraCerta, int tamanho) 
	{
		for (int i = 0; i < tamanho; i++)
		{
			if (letrasInseridas[i] != letrasPalavraCerta[i])
			{
				return false;
			}
		}
		return true;
	}
	public static int randomNumero()
	{
		int menor = 0;
		int maior = 29;
		int num_random = (int)(Math.random() * (maior - menor + 1) + menor);
		return num_random;
	}
}