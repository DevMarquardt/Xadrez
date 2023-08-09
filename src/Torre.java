import java.util.ArrayList;

public class Torre extends Peca {
    private boolean primMove;

    public Torre(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♖';
        }
        return '♜';
    }
    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        int posicaoNoTabuleiro = tabuleiro.getPosicaoPecaTabuleiro(this);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (Posicao posicao : tabuleiro.getPosicoes()){

        }

        for (int i = posicaoNoTabuleiro + 8; i < tabuleiro.getPosicoes().size(); i+= 8) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for (int i = posicaoNoTabuleiro - 8; i >= 0; i-= 8) {
            if (verificaPeca(tabuleiro.getPosicoes().get(i), possiveisMovimentos)){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? 64 : posicaoNoTabuleiro + 1); i<posicaoNoTabuleiro;i++) {
            if (verificaPeca(posicoesTabuleiro.get(i),possiveisMovimentos) || validaExtremidade(i + 1)){
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1: posicaoNoTabuleiro - 1); i >= 0; i--) {
            if (verificaPeca(posicoesTabuleiro.get(i),possiveisMovimentos) || validaExtremidade(i)){
                break;
            }
        }
        return possiveisMovimentos;
    }
}