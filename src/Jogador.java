import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String cor;
    private double pontos;

    public void pecasDisponiveis(Tabuleiro tabuleiro){
        for (Peca peca: this.pecas) {
            System.out.print(tabuleiro.getPosicaoPecaTabuleiro(peca)+" - "+peca.icone+ " | ");
        }
    }

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

    public void moverPeca(Tabuleiro tabuleiro, Peca peca, int movimento){
        tabuleiro.getPosicoes().get(tabuleiro.getPosicaoPecaTabuleiro(peca)).setPeca(null);
        tabuleiro.getPosicoes().get(movimento).setPeca(peca);
    }



    public boolean proporEmpate(
            Jogador jogador){
        return true;
    }

    public void desistir(){

    }
}
