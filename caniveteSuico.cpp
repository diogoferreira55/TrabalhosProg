#include <iostream>
#include <stdlib.h>

using namespace std;
// funçao para calcular o expoente que recebe como parametros a base e o expoente 
long long int expoente(int b, int e)
{
	long long int resultado = 1;
	if(e != 0)
	{
		for(int i = 1; i <= e;i++)
		{
			resultado = resultado * b;
		}
	}
	return resultado;
}
// funçao para verificar se o numero binario inserido é binario ou nao e recebe como parametro o numero binario inserido
bool verificaBinario(long long int num) 
{
	int digito;
    bool binario; 
	binario = true;
    while(num > 0) 
	{
        digito = num % 10;
        if(digito != 0 && digito != 1) 
		{
            binario = false;
        }
        num = num / 10;
    }
    return binario;
}
// funçao para converter um numero binario para decimal e recebe como parametro o numero binario inserido
int converteBinarioParaDecimal(long long int num)
{
	int decimal=0,i = 0,digito;
	while(!verificaBinario(num)) 
	{
        cout << "Numero invalido. Insira um numero binario (0 e 1): ";
		cin >> num;
    }
	while(num != 0)
	{
		digito = num % 10;
		num = num / 10;
		decimal = decimal + digito * expoente(2,i);
		i++;
	}
	return decimal;
}
// funçao para converter uma velocidade em km/s para m/s e recebe como parametro a velocidade inserida
double kmParaMs(int num)
{
	float resultado;
	resultado = num / 3.6;
	return resultado;
}
// funcao para converter um numero decimal para binario e recebe como parametro o numero inserido
long long int decimalParaBinario(int num)
{
    long long int aux, binario = 0, pos = 1;
    while(num > 0)
    {
        aux = num % 2;
        binario = binario + aux * pos;
        num = num /2;
        pos = pos * 10;
    }
    return binario;
}
//funcao para exibir o menu
int menuOpcao()
{
	char x;
	cout << " \n--- MENU OPCOES \n | X - SAIR DO PROGRAMA \n | 1 - Converte de binario para decimal \n | 2 - Converte decimal para binario \n | 3 - Converter velocidade Km/h para M/s \n | 4 - TABUADA \n --- \n Escolha opcao : ";
	cin >> x;
	return x;
}
// funçao para exibir o menu da tabuada 
char menuTabuada()
{
	char aux;
	cout << " \n--- MENU TABUADA \n | X - SAIR DO MENU TABUADA \n | 1 - ADICAO \n | 2 - SUBTRACAO \n | 3 - DIVISAO  \n | 4 - MULTIPLICACAO \n --- \n Escolha opcao : ";
	cin >> aux;
	return aux;
}
//funcao para somar os numeros inseridos pelo utilizador 
float soma(float num,float num2)
{
	double resultado;
	resultado = 0;
	resultado = num + num2;
	return resultado;
}
//funcao para subtrair os numeros inseridos pelo utilizador 
float subtracao(float num,float num2)
{
	float resultado;
	resultado = 0;
	resultado = num - num2;
	return resultado;
}
//funcao para dividir os numeros inseridos pelo utilizador o  1º parametro e o dividendo e o 2º é o divisor
float divisao(float num,float num2)
{
	float resultado;
	resultado = 1;
	resultado = num / num2;
	return resultado;
}
//funcao para multiplicar os numeros inseridos pelo utilizador 
float mult(float num,float num2)
{
	float resultado;
	resultado = 1;
	resultado = num * num2;
	return resultado;
}
// programa
int main()
{
	char op,opcao;
	float num,num2;
	do
	{
		op = menuOpcao();
		switch(op)
		{
			case '1' :
				system("cls");
				cout << "Insira um numero binario para converter para decimal: ";
				cin >> num;
				cout << "O numero convertido para decimal e: " <<  converteBinarioParaDecimal(num);
			break;
			case '2' :
				system("cls");
				cout <<"Insira um numero decimal para converter para binario: ";
				cin >> num;
				cout << " O numero decimal convertido para binario e: " << decimalParaBinario(num);
			break;
			case '3' :
				system("cls");
				cout << "Insira uma velocidade em km/h para converter para m/s: ";
				cin >> num;
				cout << "A velocidade inserida em m/s e: " << kmParaMs(num);
			break;
			case '4' :
				do
				{
					opcao = menuTabuada();
					switch(opcao)
					{
						case '1':
							system("cls");
							cout << "Insira 1 numero para somar ";
							cin >> num;
							cout << "Insira outro numero para somar ";
							cin >> num2;
							cout << "O resultado da soma é " << soma(num,num2);
						break;
						case '2':
							system("cls");
							cout << "Insira 1 numero para subtrair ";
							cin >> num;
							cout << "Insira outro numero para subtrair ";
							cin >> num2;
							cout << "O resultado da soma é " << subtracao(num,num2);
						break;
						case '3':
							system("cls");
							cout << "Insira 1 numero para dividir ";
							cin >> num;
							cout << "Insira outro numero para dividir ";
							cin >> num2;
							while(num2 == 0)
							{
								cout << "A operacao nao e possivel ser realizada";
								cout << "\nInsira 1 numero diferente de 0 ";
								cin >> num2;
							}
							cout << "O resultado da soma é " << divisao(num,num2);
						break;
						case '4':
							system("cls");
							cout << "Insira 1 numero para multiplicar ";
							cin >> num;
							cout << "Insira outro numero para multiplicar ";
							cin >> num2;
							cout << "O resultado da soma é " << mult(num,num2);
						break;
						case 'x':
						case 'X':
							cout << "Ira retornar ao menu principal";
						break;
						default:
							cout << "Escolha invalida";
						break;
					}
				}while(opcao != 'x' && opcao != 'X');
			break;
			case 'x' :
				cout << "O programa vai terminar ";
			break;
			case 'X' :
				cout << "O programa vai terminar ";
			break;
			default :
				cout << "Opcao invalida ";
			break;
		}
	}while(op != 'x' && op != 'X');
	return 0;
}