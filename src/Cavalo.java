import java.util.ArrayList;

public class Cavalo extends Peca {

    public Cavalo(String cor, Posicao posicao){
        super(cor,posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♘';
        }
        return '♞';
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        for (Posicao posicao : tabuleiro.getPosicoes()) {
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
            if (indice == posicaoNoTabuleiro - 17 ||
                    indice == posicaoNoTabuleiro - 15 ||
                    indice == posicaoNoTabuleiro - 10 ||
                    indice == posicaoNoTabuleiro - 6 ||
                    indice == posicaoNoTabuleiro + 6 ||
                    indice == posicaoNoTabuleiro + 10 ||
                    indice == posicaoNoTabuleiro + 15 ||
                    indice == posicaoNoTabuleiro + 17) {
                //Coluna H
                if (validaExtremidade(posicaoNoTabuleiro + 1) &&
                        !(indice == posicaoNoTabuleiro - 15 ||
                                indice == posicaoNoTabuleiro - 6 ||
                                indice == posicaoNoTabuleiro + 10 ||
                                indice == posicaoNoTabuleiro + 17)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //Coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) &&
                        !(indice == posicaoNoTabuleiro - 17 ||
                                indice == posicaoNoTabuleiro - 10 ||
                                indice == posicaoNoTabuleiro + 6 ||
                                indice == posicaoNoTabuleiro + 15)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //Coluna B
                else if (validaExtremidade(posicaoNoTabuleiro - 1) &&
                        !(indice == posicaoNoTabuleiro - 10 ||
                                indice == posicaoNoTabuleiro + 6)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //Coluna G
                else if (validaExtremidade(posicaoNoTabuleiro + 2) &&
                        !(indice == posicaoNoTabuleiro + 17 ||
                                indice == posicaoNoTabuleiro - 15)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //Não é um canto
                else {
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Cavalo" + super.toString();
    }
}
