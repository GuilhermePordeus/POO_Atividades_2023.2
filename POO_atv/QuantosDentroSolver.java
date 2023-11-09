import java.util.*;

class Ponto {
    float x;
    float y;
}

class Circulo {
    Ponto centro;
    float radio;

}

class CirculoUtils {
    public static boolean pontoInterno(Ponto ponto, Circulo circulo) {
        float distancia = (float) Math
                .sqrt(Math.pow(ponto.x - circulo.centro.x, 2) + Math.pow(ponto.y - circulo.centro.y, 2));
        return distancia <= circulo.radio;
    }

    public static int pontosDentro(ArrayList<Ponto> pontos, Circulo circulo) {
        int cont = 0;
        for (int i = 0; i < pontos.size(); i++) {
            if (pontoInterno(pontos.get(i), circulo)) {
                cont++;
            }
        }
        return cont;
    }
}

class QuantosDentroSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Ponto> pontos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Ponto ponto = new Ponto();
            ponto.x = scanner.nextFloat();
            ponto.y = scanner.nextFloat();
            pontos.add(ponto);
        }

        Circulo circulo = new Circulo();
        circulo.centro = new Ponto();
        circulo.centro.x = scanner.nextFloat();
        circulo.centro.y = scanner.nextFloat();
        circulo.radio = scanner.nextFloat();

        int num = CirculoUtils.pontosDentro(pontos, circulo);
        System.out.println(num);

    }
}