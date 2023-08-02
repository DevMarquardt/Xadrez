import java.util.ArrayList;

public abstract class Peca {
    private String cor;
    private Posicao posicao;
    public char icone;

    public Peca(String cor, Posicao posicao){
        this.cor = cor;
        this.posicao = posicao;
    }

    public Peca() {

    }

    public void setPossiveisMovimentos(ArrayList<Posicao> possiveisMovimentos) {
        this.possiveisMovimentos = possiveisMovimentos;
    }

    private ArrayList<Posicao> possiveisMovimentos;

    public Posicao getPosicao() {
        return posicao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean mover(
            Tabuleiro tabuleiro,
            Posicao posicao){
        ArrayList<Posicao> possiveisPosicoes = possiveisMovimentos(tabuleiro);
        for (Posicao posicaoPossivel:possiveisPosicoes){
            if (posicaoPossivel == posicao){
                //atribuindo a peça para a nova posição no tabuleiro
                posicao.setPeca(this);
                //removendo a peça da posição anterior no tabuleiro
                this.posicao.setPeca(null);
                //trocando a posição atual da peça no tabuleiro
                this.posicao = posicao;
                return true;
            }
        }
        return false;
    }

    public boolean validaExtremidade(int posicaoNoTabuleiro){
        return posicaoNoTabuleiro %8 == 0;
    }

    public abstract ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro);

    @Override
    public String toString() {
        return "Peca{" +
                "cor='" + cor + '\'' +
                ", posicao=" + posicao +
                '}';
    }

    public boolean verificaPeca(Posicao posicao, ArrayList<Posicao> possiveisMovimentos) {
        if(posicao.getPeca()==null){
            possiveisMovimentos.add(posicao);
            return false;
        }
        if (!posicao.getPeca().getCor().equals(this.getCor())) {
            possiveisMovimentos.add(posicao);
        }
        return true;
    }
}
