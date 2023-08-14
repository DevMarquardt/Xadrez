import java.util.ArrayList;

public class Peao extends  Peca{

    public boolean primMov = true;

    public Peao(String cor, Posicao posicao){
        super(cor, posicao);
        this.icone = gerarIcone();
    }

    public char gerarIcone() {
        if (this.getCor().equals("Branco")) {
            return '♙';
        }
        return '♟';
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicoes();

        int posicaoNoTabuleiro = tabuleiro.getPosicaoPecaTabuleiro(this);


        if(this.getCor().equals("Preto")) {
            if (posicaoNoTabuleiro + 8 < 64) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                }
            }
            if (posicaoNoTabuleiro + 16 < 64) {
                if (posicaoNoTabuleiro <= 15 && posicaoNoTabuleiro >= 8) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                    }
                }
            }
            if (posicaoNoTabuleiro + 9 <64) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
                    }
                }
            }


        if (posicaoNoTabuleiro + 7 <64) {
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                }
            }


        }}else {
            if (posicaoNoTabuleiro - 8 >= 0) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                }
            }
            if (posicaoNoTabuleiro - 16 >= 0) {
                if (posicaoNoTabuleiro<=55 && posicaoNoTabuleiro >= 48) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    }
                }
            }
            if (posicaoNoTabuleiro - 9 >= 0) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                    }
                }
            }
            if (posicaoNoTabuleiro - 7 >= 0) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));
                    }
                }
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Peao{" +
                "primMov=" + primMov +
                "} " + super.toString();
    }
}
