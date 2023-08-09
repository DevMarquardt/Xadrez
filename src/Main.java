import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        static Scanner sc = new Scanner(System.in);
        static Jogador jogador1 = new Jogador("aa");
        static Jogador jogador2 = new Jogador("bb");
        static Jogador jogadorJogando = jogador1;
        static Jogador jogadorNaoJogando = jogador2;
        static Tabuleiro tabuleiro = new Tabuleiro();
        public static void main(String[] args) {

         jogador1.setCor("Branco", tabuleiro);
         jogador2.setCor("Preto", tabuleiro);

         definirNome(jogador1, jogador2, jogadorJogando);
    }

    private static void definirNome(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando){
        do {
            System.out.println("Jogador 1 nome: ");
            String nome1 = sc.next();
            jogador1.setNome(nome1);
            System.out.println("Jogador 2 nome: ");
            String nome2 = sc.next();
            jogador2.setNome(nome2);
        }while(jogador1.getNome()=="" && jogador2.getNome()=="");

        geraTabuleiro(tabuleiro);

    }


    private static void geraTabuleiro(Tabuleiro tabuleiro) {
        int joga=0;
        do {
            tabuleiro.geraTabuleiro(jogador1, jogador2);
            if (joga%2==0){
                jogadorJogando=jogador2;
                jogadorNaoJogando = jogador1;
            }else {
                jogadorJogando=jogador1;
                jogadorNaoJogando = jogador2;
            }

            jogadorJogando.pecasDisponiveis(tabuleiro);
            Peca peca = null;
            System.out.println("Turno do " + jogadorJogando.getNome());
            System.out.println("Qual peça você deseja movimentar? ");
            int escolhaPeca = sc.nextInt();
            if (escolhaPeca<64 && jogadorJogando.getPecas().contains(tabuleiro.getPosicoes().get(escolhaPeca).getPeca())) {
                peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
                System.out.println("Peça: " + peca.icone + " | posição " + tabuleiro.getPosicaoPecaTabuleiro(peca));
                System.out.println(peca.possiveisMovimentos(tabuleiro));
                tabuleiro.possiveisMovimentos(peca);
                System.out.println("Para qual posição você deseja mover? ");
                int escolhaPosicao = sc.nextInt();

                if (escolhaPosicao<64 && peca.possiveisMovimentos(tabuleiro).contains(tabuleiro.getPosicoes().get(escolhaPosicao))) {
                    jogadorJogando.moverPeca(tabuleiro, peca, escolhaPosicao);
                    joga++;
                } else {
                    System.out.println("Não da pra mover pra ca");
                    System.out.println("tenta dnv");
                }
            } else {
                System.out.println("Não da pra mover pra ca");
            }
        } while (!validarVitoria(jogadorNaoJogando));
    }



    private static boolean validarVitoria(Jogador adversario){
        for (Peca peca: adversario.getPecas()) {
            if (peca instanceof Rei){
                return false;
            }
        }
        return true;
    }

}
