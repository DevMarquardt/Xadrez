import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        static Scanner sc = new Scanner(System.in);


        public static void main(String[] args) {
            Jogador jogador1 = new Jogador("");
            Jogador jogador2 = new Jogador("");
            Tabuleiro tabuleiro = new Tabuleiro();
            jogador1.setCor("Branco", tabuleiro);
            jogador2.setCor("Preto", tabuleiro);

         definirNome(jogador1, jogador2, tabuleiro);
    }

    private static void definirNome(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        do {
            System.out.println("Jogador 1 nome: ");
            String nome1 = sc.next();
            jogador1.setNome(nome1);
            System.out.println("Jogador 2 nome: ");
            String nome2 = sc.next();
            jogador2.setNome(nome2);
        }while(jogador1.getNome()=="" && jogador2.getNome()=="");

        geraTabuleiro(tabuleiro, jogador1, jogador2);

    }

    private static void trocarPeca(Tabuleiro tabuleiro, Peca peca, Jogador jogadorJogando) {
        System.out.println("Parece que você chegou ao final do tabuleiro com seu peão");
        System.out.println("Com isso você tem o direito de escolher entre uma Rainha, Bispo, Torre ou Cavalo");
        System.out.println("Selecione qual você deseja: ");
        System.out.println("""
                1 - Rainha
                2 - Bispo
                3 - Torre
                4 - Cavalo""");
        int opcaoTroca = sc.nextInt();
        switch (opcaoTroca) {
            case 1:
                Peca rainhaP = new Rainha("Preto", peca.getPosicao());
                Peca rainhaB = new Rainha("Branco", peca.getPosicao());
                if (peca.getCor().equals("Preto")) {
                    jogadorJogando.getPecas().add(rainhaP);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(rainhaP);

                } else if (peca.getCor().equals("Branco")) {
                    jogadorJogando.getPecas().add(rainhaB);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(rainhaB);
                }
            case 2:
                Peca bispoP = new Bispo("Preto", peca.getPosicao());
                Peca bispoB = new Bispo("Branco", peca.getPosicao());
                if (peca.getCor().equals("Preto")) {
                    jogadorJogando.getPecas().add(bispoP);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(bispoP);

                } else if (peca.getCor().equals("Branco")) {
                    jogadorJogando.getPecas().add(bispoB);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(bispoB);
                }
            case 3:
                Peca torreP = new Torre("Preto", peca.getPosicao());
                Peca torreB = new Torre("Branco", peca.getPosicao());
                if (peca.getCor().equals("Preto")) {
                    jogadorJogando.getPecas().add(torreP);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(torreP);

                } else if (peca.getCor().equals("Branco")) {
                    jogadorJogando.getPecas().add(torreB);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(torreB);
                }
            case 4:
                Peca cavaloP = new Cavalo("Preto", peca.getPosicao());
                Peca cavaloB = new Cavalo("Preto", peca.getPosicao());
                if (peca.getCor().equals("Preto")) {
                    jogadorJogando.getPecas().add(cavaloP);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(cavaloP);

                } else if (peca.getCor().equals("Branco")) {
                    jogadorJogando.getPecas().add(cavaloB);
                    tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(cavaloB);
                }
        }
    }

    private static void verificaXeque(Tabuleiro tabuleiro, Jogador jogadorJogando, Jogador jogadorAdversario) {
        ArrayList<Posicao> possiveisMovimentosRei = null;
        Peca rei = null;
        for (Peca peca :
                jogadorJogando.getPecas()) {
            if (peca instanceof Rei) {
                rei = peca;
                possiveisMovimentosRei = peca.possiveisMovimentos(tabuleiro);
            }
        }
        ArrayList<Integer> fugaRei = new ArrayList<>();

        boolean podeSerDefendido = false;
        boolean reiPodeMover = false;

        for (Peca pecaAliada :
                jogadorJogando.getPecas()) {

            for (Peca pecaAtacando :
                    jogadorAdversario.getPecas()) {
                if (pecaAtacando.possiveisMovimentos(tabuleiro).contains(rei.getPosicao())) {
                    System.out.println("rei em xeque");
                    int atual;
                    if (!(pecaAliada instanceof Rei)) {
                        for (Posicao posicaoDefendendo :
                                pecaAliada.possiveisMovimentos(tabuleiro)) {
                                Peca peca = tabuleiro.getPosicoes().get(tabuleiro.getPosicaoNoTabuleiro(posicaoDefendendo)).getPeca();
                            atual = tabuleiro.getPosicaoPecaTabuleiro(pecaAliada);

                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(pecaAliada)).setPeca(null);
                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoNoTabuleiro(posicaoDefendendo)).setPeca(pecaAliada);

                            if (!pecaAtacando.possiveisMovimentos(tabuleiro).contains(rei.getPosicao())) {
                                System.out.println("A peça da posicao " + tabuleiro.getPosicaoNoTabuleiro(tabuleiro.getPosicoes().get(atual)) + ": " + pecaAliada.getIcone() + " pode defender o rei na posicao: " + tabuleiro.getPosicaoPecaTabuleiro(pecaAliada));
                                podeSerDefendido = true;
                            }

                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(pecaAliada)).setPeca(peca);
                            tabuleiro.getPosicoes().get(atual).setPeca(pecaAliada);
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        for (Posicao posicaorei :
                                rei.possiveisMovimentos(tabuleiro)) {

                            atual = tabuleiro.getPosicaoPecaTabuleiro(rei);
                            Peca peca = tabuleiro.getPosicoes().get(tabuleiro.getPosicaoNoTabuleiro(posicaorei)).getPeca();

                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(rei)).setPeca(null);
                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoNoTabuleiro(posicaorei)).setPeca(rei);

                            if (!pecaAtacando.possiveisMovimentos(tabuleiro).contains(rei.getPosicao())) {
                                possiveisMovimentosRei.remove(posicaorei);
                            }

                            tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(rei)).setPeca(peca);
                            tabuleiro.getPosicoes().get(atual).setPeca(rei);
                        }
                    }


                    for (int i = 0; i < fugaRei.size(); i++) {
                        int vezesIguais = 0;
                        for (int j = 0; j < fugaRei.size(); j++) {
                            if (fugaRei.get(i).equals(fugaRei.get(j)) && vezesIguais > 0) {
                                fugaRei.remove(fugaRei.get(j));
                                vezesIguais++;
                            }
                        }
                    }

                    if (possiveisMovimentosRei.size() > 0) {
                        for (Posicao possiveis :
                                possiveisMovimentosRei) {
                            System.out.println("O rei pode fugir para a posicao: " + tabuleiro.getPosicaoNoTabuleiro(possiveis));
                            reiPodeMover = true;
                        }
                    }

                    if (fugaRei.size() > 0) {
                        for (int posicaoEscapatoria :
                                fugaRei) {
                            System.out.println(posicaoEscapatoria);
                        }
                    }
                }
            }
        }
        for (Peca penaInimiga:
                jogadorAdversario.getPecas()) {
            if(penaInimiga.possiveisMovimentos(tabuleiro).contains(rei.getPosicao())){
                if(!podeSerDefendido && !reiPodeMover){
                    System.out.println("\nXeque Mate");
                    System.exit(0);
                }
            }
        }
    }

    private static void geraTabuleiro(Tabuleiro tabuleiro, Jogador jogador1, Jogador jogador2) {
        int joga=0;
        Jogador jogadorJogando;
        Jogador jogadorNaoJogando;
        do {
            if (joga%2==0){
                jogadorJogando=jogador2;
                jogadorNaoJogando = jogador1;
            }else {
                jogadorJogando=jogador1;
                jogadorNaoJogando = jogador2;
            }
            verificaXeque(tabuleiro, jogadorJogando, jogadorNaoJogando);
            tabuleiro.geraTabuleiro(jogador1, jogador2);
            jogadorJogando.pecasDisponiveis(tabuleiro);
            Peca peca = null;
            System.out.println("Turno do " + jogadorJogando.getNome());
            System.out.println("Qual peça você deseja movimentar? ");
            int escolhaPeca = sc.nextInt();
            if (escolhaPeca<64 && jogadorJogando.getPecas().contains(tabuleiro.getPosicoes().get(escolhaPeca).getPeca())) {
                peca = tabuleiro.getPosicoes().get(escolhaPeca).getPeca();
                System.out.println("Peça: " + peca.icone + " | posição " + tabuleiro.getPosicaoPecaTabuleiro(peca));
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
            if (peca instanceof Peao) {
                if ((tabuleiro.getPosicaoPecaTabuleiro(peca) >= 0 && tabuleiro.getPosicaoPecaTabuleiro(peca) <= 7) || (tabuleiro.getPosicaoPecaTabuleiro(peca) >= 56 && tabuleiro.getPosicaoPecaTabuleiro(peca) <= 63)) {
                    trocarPeca(tabuleiro, peca, jogadorJogando);
                }
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