import java.util.ArrayList;

public class Tabuleiro {

    private ArrayList<Posicao> posicoes = new ArrayList<>();

    @Override
    public String toString() {
        return "Tabuleiro{" +
                "posicoes=" + posicoes +
                '}';
    }

    public int getPosicaoPecaTabuleiro(Peca peca){
        for (int i = 0; i < posicoes.size(); i++) {
            if (posicoes.get(i).getPeca() == peca){
                return i;
            }
        }
        return 0;
    }

    public void geraTabuleiro(Jogador j1, Jogador j2){
        ArrayList <Peca> pecasBrancas = new ArrayList<>();
        ArrayList <Peca> pecasPretas = new ArrayList<>();
        for (Posicao posicao:
                posicoes) {
            if(posicoes.get(posicoes.indexOf(posicao)).getPeca() != null){
                if(posicoes.get(posicoes.indexOf(posicao)).getPeca().getCor().equals("Branco")){
                    pecasBrancas.add(posicoes.get(posicoes.indexOf(posicao)).getPeca());
                }else {
                    pecasPretas.add(posicoes.get(posicoes.indexOf(posicao)).getPeca());
                }
            }

        }
        j1.setPecas(pecasBrancas);
        j2.setPecas(pecasPretas);

        for (Posicao posicao : posicoes) {
            System.out.print(posicoes.get(posicoes.indexOf(posicao)).getPeca() != null ? String.valueOf(posicao.getPeca().getIcone()): "[- -]");
            if ((posicoes.indexOf(posicao)+1)%8 == 0){
                System.out.print("\n");
            }

        }
    }

    public void possiveisMovimentos(Peca peca){
        ArrayList<Posicao> possiveis = peca.possiveisMovimentos(this);
        for (Posicao posicao:
                posicoes) {
            if(possiveis.contains(posicao)){
                if(posicoes.indexOf(posicao)<10){
                    System.out.print("[- 0" + posicoes.indexOf(posicao) + "-]");
                }else {
                    System.out.print("[-" + posicoes.indexOf(posicao) + "-]");
                }
            }
            else if(posicoes.get(posicoes.indexOf(posicao)).getPeca() != null){
                if(posicoes.indexOf(posicao)<10){
                    System.out.print("[-"+posicoes.get(posicoes.indexOf(posicao)).getPeca().icone+"-]");
                }else {
                    System.out.print("[-"+posicoes.get(posicoes.indexOf(posicao)).getPeca().icone+"-]");
                }
            }
            else if(posicao.getPeca() != peca){
                System.out.print("[- -]");
            }
            if ((posicoes.indexOf(posicao)+1)%8 == 0){
                System.out.print("\n");
            }
        }
    }


    public Tabuleiro(){
        for (int i = 0; i < 64 ; i++) {
            posicoes.add(new Posicao());
            if(i >= 8 && i <= 15){
                posicoes.get(i).setPeca(new Peao("Preto", posicoes.get(i)));
            }
            if(i >= 48 && i <= 55){
                posicoes.get(i).setPeca(new Peao("Branco" , posicoes.get(i)));
            }
            if(i == 0 || i == 7){
                posicoes.get(i).setPeca((new Torre("Preto", posicoes.get(i))));
            }
            if(i == 56 || i == 63 ){
                posicoes.get(i).setPeca((new Torre("Branco", posicoes.get(i))));
            }
            if(i == 1 || i == 6){
                posicoes.get(i).setPeca((new Cavalo("Preto", posicoes.get(i))));
            }
            if(i == 57 || i == 62){
                posicoes.get(i).setPeca((new Cavalo("Branco", posicoes.get(i))));
            }
            if(i == 2 || i == 5){
                posicoes.get(i).setPeca((new Bispo("Preto", posicoes.get(i))));
            }
            if(i == 58 || i == 61){
                posicoes.get(i).setPeca((new Bispo("Branco", posicoes.get(i))));
            }
            if(i == 3){
                posicoes.get(i).setPeca((new Rainha("Preto", posicoes.get(i))));
            }
            if(i == 59){
                posicoes.get(i).setPeca((new Rainha("Branco", posicoes.get(i))));
            }
            if(i == 4){
                posicoes.get(i).setPeca((new Rei("Preto", posicoes.get(i))));
            }
            if(i == 60){
                posicoes.get(i).setPeca((new Rei("Branco", posicoes.get(i))));
            }
        }
    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public int getPosicaoNoTabuleiro(Posicao posicao) {
        for (int i=0; i<posicoes.size(); i++){
            if (posicoes.get(i) == posicao){
                return i;
            }
        }
    return 0;
    }
}