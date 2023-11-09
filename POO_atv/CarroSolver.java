import java.util.*;

// Nesse rascunho esta faltando a parte de dirigir o carro

class Car {
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem

    public Car() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }

    void setPass(int pass) {
        this.pass = pass;
    }

    void setGas(int gas) {
        this.gas = gas;
    }

    void setKM(int km) {
        this.km = km;
    }

    int getPass() {
        return this.pass;
    }

    int getGas() {
        return this.gas;
    }

    int getKM() {
        return this.km;
    }

    public void enter() {
        if (this.pass < this.passMax) {
            setPass(pass + 1);
        } else {
            System.out.println("fail: limite de pessoas atingido");
        }
    }

    public void leave() {
        if (this.pass > 0) {
            setPass(pass - 1);
        } else {
            System.out.println("fail: nao ha ninguem no carro");
        }
    }

    public void fuel(int gas) {
        setGas(gas);
    }

    void drive(int n) {
        if (getPass() == 0) {
            System.out.println("fail: nao ha ninguem no carro");
        } else if (getGas() == 0) {
            System.out.println("fail: tanque vazio");

        } else if (getGas() >= n) {
            setGas(getGas() - n);
        } else {
            System.out.println("fail: tanque vazio apos andar " + getGas() + "km");
            setGas(0);
        }
    }

    public String toString() {
        return "pass: " + getPass() + ", gas: " + getGas() + ", km: " + getKM();
    }
};

public class CarroSolver {
    public static void main(String[] a) {
        Car car = new Car();

        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if (args[0].equals("show")) {
                System.out.println(car);
            } else if (args[0].equals("enter")) {
                car.enter();
            } else if (args[0].equals("leave")) {
                car.leave();
            } else if (args[0].equals("drive")) {
                car.drive((int) number(args[1]));
            }
            // --
            else if (args[0].equals("fuel")) {
                car.fuel((int) number(args[1]));
            } else if (args[0].equals("end")) {
                break;
            } else {
                write("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    private static String input() {
        return scanner.nextLine();
    }

    private static double number(String value) {
        return Double.parseDouble(value);
    }

    private static void write(String value) {
        System.out.println(value);
    }
}
