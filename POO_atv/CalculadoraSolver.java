import java.util.*;

// Esse rascunho não possui o método de divisão, nem a invocação na main.

class Calculator {
    public int batteryMax;
    public int battery = 0;
    public float display = 0;

    public void setBatteryMax(int batteryMax) {
        this.batteryMax = batteryMax;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void setDisplay(float display) {
        this.display = display;
    }

    public int getBattery() {
        return this.battery;
    }

    public float getDisplay() {
        return this.display;
    }

    public int getBatteryMax() {
        return batteryMax;
    }

    public Calculator(int batteryMax) {
    }

    public void chargeBattery(int value) {
        setBattery(this.battery + value);
    }

    public boolean useBattery() {
        if (getBattery() > 0) {
            return true;
        }
        return false;
    }

    public void sum(int a, int b) {
        if (useBattery()) {
            setDisplay(a + b);
            setBattery(this.battery - 1);
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void div(int a, int b) {
        if (b == 0) {
            System.out.println("fail: divisao por zero");
        } else if (useBattery()) {
            setDisplay(a / b);
            setBattery(this.battery - 1);
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    public String toString() {
        return String.format("display = %.2f, battery = %d", this.display, this.battery);

        // se seu java estiver utilizando `,` como separador decimal, use:
        // DecimalFormat df = new DecimalFormat("0.00");
        // return String.format("display = %s, battery = %d", df.format(this.display),
        // this.battery);
    }
}

public class CalculadoraSolver {
    static Calculator calc = new Calculator(0);

    public static void main(String[] _args) {
        while (true) {
            String line = input();
            String[] args = line.split(" ");
            write('$' + line);

            if ("show".equals(args[0])) {
                write(calc.toString());
            } else if ("init".equals(args[0])) {
                calc = new Calculator((int) number(args[1]));
            } else if ("charge".equals(args[0])) {
                calc.chargeBattery((int) number(args[1]));
            } else if ("sum".equals(args[0])) {
                calc.sum((int) number(args[1]), (int) number(args[2]));
            } else if ("div".equals(args[0])) {
                calc.div((int) number(args[1]), (int) number(args[2]));
            } else if ("end".equals(args[0])) {
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