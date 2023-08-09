import java.util.ArrayList;

public class Bispo extends Peca {

    public Bispo(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♗';
        }
        return '♝';
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();
        int posicaoNoTabuleiro = posicoesTabuleiro.indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? 64 : posicaoNoTabuleiro + 7); i < posicoesTabuleiro.size(); i+=7) {
            if (i<64){
                Posicao posicao = tabuleiro.getPosicoes().get(i);
                this.verificaPeca(posicao,possiveisMovimentos);
                if (verificaPeca(posicoesTabuleiro.get(i),possiveisMovimentos) || validaExtremidade(i)){
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? 0 : posicaoNoTabuleiro - 7); i  >= 0; i-=7) {
            if (i<64) {
                Posicao posicao = tabuleiro.getPosicoes().get(i);
                this.verificaPeca(posicao, possiveisMovimentos);
                if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro + 1) ? 64: posicaoNoTabuleiro + 9); i < posicoesTabuleiro.size(); i+=9) {
            if (i<64) {
                Posicao posicao = tabuleiro.getPosicoes().get(i);
                this.verificaPeca(posicao, possiveisMovimentos);
                if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i + 1)) {
                    break;
                }
            }
        }
        for (int i = (validaExtremidade(posicaoNoTabuleiro) ? 0: posicaoNoTabuleiro -9); i >= 0; i-=9) {
            if (i<64) {
                Posicao posicao = tabuleiro.getPosicoes().get(i);
                this.verificaPeca(posicao, possiveisMovimentos);
                if (verificaPeca(posicoesTabuleiro.get(i), possiveisMovimentos) || validaExtremidade(i)) {
                    break;
                }
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Bispo" + super.toString();
    }
}
