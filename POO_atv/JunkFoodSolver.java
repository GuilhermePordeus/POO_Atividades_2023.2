import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

class Slot {
    private String name;
    private float price;
    private int quantity;

    public Slot(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return String.format("%8s", this.name) + " : " +
                this.quantity + " U : " +
                JunkFoodSolver.decForm.format(this.price) + " RS";
    }
}

class VendingMachine {
    private ArrayList<Slot> slots;
    private float profit;
    private float cash;
    private int capacity;

    public VendingMachine(int capacity) {
        this.capacity = capacity;
        slots = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            slots.add(new Slot("empty", 0.00f, 0));
        }
    }

    private boolean indiceInvalido(int ind) {
        if (ind < 0 || ind >= this.slots.size()) {
            return true;
        }
        return false;
    }

    public Slot getSlot(int ind) {
        if (this.indiceInvalido(ind)) {
            return null;
        }

        return this.slots.get(ind);
    }

    public void setSlot(int ind, Slot slot) {
    }

    public void clearSlot(int ind) {
    }

    public float withdrawCash() {
        JunkFoodSolver.println("voce recebeu " + JunkFoodSolver.decForm.format(this.cash) + " RS");
        return this.cash;
    }

    public float getProfit() {
        return this.profit;
    }

    public void buyItem(int ind) {
    }

    public String toString() {
        String s = "saldo: " + JunkFoodSolver.decForm.format(this.cash) + "\n";
        for (int i = 0; i < this.slots.size(); i++) {
            Slot slot = this.getSlot(i);
            s += i + " [" + slot + "]\n";
        }
        return s;
    }
}

class JunkFoodSolver {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(0);

        while (true) {
            String linha = input();
            String[] palavras = linha.split(" ");
            println("$" + linha);

            if (palavras[0].equals("end")) {
                break;
            } else if (palavras[0].equals("init")) {
                machine = new VendingMachine(Integer.parseInt(palavras[1]));
            } else if (palavras[0].equals("show")) {
                print(machine);
            } else if (palavras[0].equals("set")) {
                machine.setSlot(Integer.parseInt(palavras[1]),
                        new Slot(palavras[2], Float.parseFloat(palavras[4]), Integer.parseInt(palavras[3])));
            } else if (palavras[0].equals("limpar")) {
                machine.clearSlot(Integer.parseInt(palavras[1]));
            } else if (palavras[0].equals("apurado")) {
                println("apurado total: " + decForm.format(machine.getProfit()));
            } else {
                println("comando inválido!");
            }
        }
    }

    public static Scanner scan = new Scanner(System.in);

    public static String input() {
        return scan.nextLine();
    }

    public static void println(Object str) {
        System.out.println(str);
    }

    public static void print(Object str) {
        System.out.print(str);
    }

    public static DecimalFormat decForm = new DecimalFormat("0.00");
}