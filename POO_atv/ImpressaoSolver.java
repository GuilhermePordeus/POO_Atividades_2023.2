import java.util.*;

class Pessoa {
    private String name;
    private int matricula;
    private String disciplina;
    private float nota;

    public Pessoa(String name, int matricula, String disciplina, float nota) {
        this.name = name;
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public void ler() {
        Scanner scanner = new Scanner(System.in);

        name = scanner.nextLine();
        matricula = Integer.parseInt(scanner.nextLine());
        disciplina = scanner.nextLine();
        nota = Float.parseFloat(scanner.nextLine());

    }

    // public void print() {
    // System.out.println("Nome: " + name);
    // System.out.println("Matricula: " + matricula);
    // System.out.println("Disciplina: " + disciplina);
    // System.out.println("Nota: " + nota);

    // }

    public String toString() {
        return "Nome: " + name + "\nMatricula : " + matricula + "\nDisciplina : " + disciplina + "\nNota : " + nota;
    }

}

class Impressora {
    public static void main(String[] args) {
        Pessoa aluno = new Pessoa(null, 0, null, 0);

        aluno.ler();
        System.out.println(aluno.toString());

    }
}