import java.util.Scanner;

public class solucao {

	static int[] memoria; // matriz que representa a memória na solucao
	static int N; // tamanho dessa memoria para ser alocada
	
	// método que realiza a acao de somar os valores de V de pos em diante
	public static void frente(int pos, int V) {
		
		int j = pos-1;
		int i = V;
		
		while (j < N && i > 0) {
			memoria[j] += i;
			j++;
			i--;
		}
		
		return;
	}
	
	// método que realiza acao de somar os valores de V de pos para trás
	public static void tras(int pos, int V) {
		
		int j = pos-1;
		int i = V;
		
		while (j >= 0 && i > 0) {
			memoria[j] += i;
			j--;
			i--;
		}
		
		return;
	}
	
	// valor que imprime o valor em dada posicao de memoria
	public static void imprime(int i) {
		System.out.println(memoria[i-1]);
		return;
	}
	
    public static void main(String[] args) {
    	
    	Scanner in = new Scanner(System.in);
        N = in.nextInt();     // le da entrada o tamanho da matriz
        int M = in.nextInt(); // le a quantidade de instrucoes
        int V;
        int instrucao;
        int pos;
        
        if (N > 0 && N <= 200000) { // verifica o limite do tamanho da matriz
        	if (M > 0 && M <= 200000) { 
	        	memoria = new int[N];
	        	
	        	for (int i = 0; i < M; i++) {
        			instrucao = in.nextInt();
        			pos = in.nextInt();
        			
	        		if (instrucao != 3) { // é a única instrucao que nao possui 2 argumentos
	        			V = in.nextInt();
		        		if (V > 0 && V <= 200000) {
		        			if (pos >= 0 && pos <= N) {
		        				if (instrucao == 1) {
		        					frente(pos, V);
		        				} else if (instrucao == 2) {
		        					tras(pos, V);
		        				}
		        			}
		        		}
	        		} else if (instrucao == 3) { // caso seja ela, le apenas um argumento
    					imprime(pos);
    				}
	        	}
        	}
        }
    }
}