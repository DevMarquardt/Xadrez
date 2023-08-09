import java.util.ArrayList;

public class Rainha extends Peca {

    public Rainha(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♕';
        }
        return '♛';
    }
    @Override
    public String toString() {
        return "Rainha{} " + super.toString();
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        int posicaoNoTabuleiro = tabuleiro.getPosicaoPecaTabuleiro(this);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? 64 : posicaoNoTabuleiro + 8); i < posicoesTabuleiro.size(); i += 8) {
            if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? -1 : posicaoNoTabuleiro - 7); i >= 0; i -= 7) {
            if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? 64 : posicaoNoTabuleiro + 9); i < posicoesTabuleiro.size(); i += 9) {
            if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? -1 : posicaoNoTabuleiro - 9); i >= 0; i -= 9) {
            if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }
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
