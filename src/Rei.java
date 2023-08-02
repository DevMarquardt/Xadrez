import java.util.ArrayList;

public class Rei extends Peca {
    private boolean primMove;

    public Rei(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♔';
        }
        return '♚';
    }

    @Override
    public String toString() {
        return "Rei{" +
                "primMove=" + primMove +
                "} " + super.toString();
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicoes().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (Posicao posicao : tabuleiro.getPosicoes()){
            int indice = tabuleiro.getPosicoes().indexOf(posicao);
            if (indice == posicaoNoTabuleiro - 9 ||
                    indice == posicaoNoTabuleiro - 8||
                    indice == posicaoNoTabuleiro - 7||
                    indice == posicaoNoTabuleiro - 1||
                    indice == posicaoNoTabuleiro + 1||
                    indice == posicaoNoTabuleiro + 7||
                    indice == posicaoNoTabuleiro + 8||
                    indice == posicaoNoTabuleiro + 9){
                if (validaExtremidade(posicaoNoTabuleiro + 1) &&
                        !(indice == posicaoNoTabuleiro + 9 ||
                                indice == posicaoNoTabuleiro - 7 ||
                                indice == posicaoNoTabuleiro + 1)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                //Coluna A
                else if (validaExtremidade(posicaoNoTabuleiro) &&
                        !(indice == posicaoNoTabuleiro - 9 ||
                                indice == posicaoNoTabuleiro + 7 ||
                                indice == posicaoNoTabuleiro - 1)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }
        }


        return possiveisMovimentos;
    }
}
