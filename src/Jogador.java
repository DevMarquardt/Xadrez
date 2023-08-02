import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String cor;
    private double pontos;

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        for (Posicao posicao: tabuleiro.getPosicoes()) {
            if(posicao.getPeca()!= null && posicao.getPeca().getCor().equals(this.cor)){
                this.pecas.add(posicao.getPeca());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public String getCor() {
        return cor;
    }

    private ArrayList<Peca> pecas;

    public Jogador(String nome){
        this.nome = nome;
        this.pecas = new ArrayList<>();
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public boolean moverPeca(Peca peca, Posicao posicao, Tabuleiro tabuleiro, Jogador adversario){

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro, posicao);
        if (pecaAdversaria != null && valida){
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }



    public boolean proporEmpate(
            Jogador jogador){
        return true;
    }

    public void desistir(){

    }
}
