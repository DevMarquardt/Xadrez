import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        static Scanner sc = new Scanner(System.in);
        static Jogador jogador1 = new Jogador("");
        static Jogador jogador2 = new Jogador("");
        static Jogador jogadorJogando = jogador1;
        static Tabuleiro tabuleiro = new Tabuleiro();
        static Peca peca = new Peca() {
            @Override
            public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
                return null;
            }
        };
        public static void main(String[] args) {

         jogador1.setCor("Branco", tabuleiro);
         jogador2.setCor("Preto", tabuleiro);

         definirNome(jogador1, jogador2, jogadorJogando);
        //escolha da peça
        //System.out.println(jogador1.getPecas());
        //int escolhaPeca = sc.nextInt();
        //Peca peca = jogador1.getPecas().get(escolhaPeca);
        //System.out.println(peca);

        //escolha da posição
        //ArrayList<Posicao> posicoes = peca.possiveisMovimentos((tabuleiro));
        //int escolhaPosicao = sc.nextInt();
        //Posicao posicao = posicoes.get(escolhaPosicao);
        //jogador1.moverPeca(peca,posicao,tabuleiro,jogador2);
    }

    private static void definirNome(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando){
        do {
            System.out.println("Jogador 1 nome: ");
            String nome1 = sc.next();
            jogador1.setNome(nome1);
            System.out.println("Jogador 2 nome: ");
            String nome2 = sc.next();
            jogador1.setNome(nome2);
        }while(jogador1.getNome()=="" && jogador2.getNome()=="");

        geraTabuleiro(jogador1, jogador2, jogadorJogando, tabuleiro);

    }

    public static void loopJogadorJogando(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando){
        if (jogadorJogando==jogador1){
            jogadorJogando=jogador2;
        }else if(jogadorJogando==jogador2){
            jogadorJogando=jogador1;
        }
    }

    private static void geraTabuleiro(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando, Tabuleiro tabuleiro){
        ArrayList<Posicao> posicaoNoTabuleiro = tabuleiro.getPosicoes();
        for (Posicao posicao : posicaoNoTabuleiro) {
            if (posicao.getPeca()!=null){
                System.out.println(posicao.getPeca().icone);
                if ((posicaoNoTabuleiro.indexOf(posicao)+1)%8 == 0){
                    System.out.println("\n");

                }
            }
        }
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
