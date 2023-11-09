import java.util.*;

class Pessoa {
    private String name;
    private double nota;
    private double nota2;
    private double nota3;

    public Pessoa(String name, double nota, double nota2, double nota3) {
        this.name = name;
        this.nota = nota;
        this.nota2 = nota2;
        this.nota3 = nota3;

    }

    public void ler() {
        Scanner in = new Scanner(System.in);

        name = in.nextLine();
        nota = Double.parseDouble(in.nextLine());
        nota2 = Double.parseDouble(in.nextLine());
        nota3 = Double.parseDouble(in.nextLine());

    }

    public double media() {
        double soma = nota + nota2 + nota3;
        double media = soma / 3;
        return media;
    }

    public String toString() {
        return String.format("%.1f", media());

    }

}

public class NovaMediaSolver {
    public static void main(String[] args) {
        Pessoa aluno = new Pessoa(null, 0, 0, 0);

        aluno.ler();
        System.out.println(aluno.toString());

    }
}
