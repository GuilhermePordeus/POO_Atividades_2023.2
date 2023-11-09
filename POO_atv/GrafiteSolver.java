import java.text.DecimalFormat;
import java.util.Scanner;

class Lead {
    private float thickness; // calibre
    private String hardness; // dureza
    private int size; // tamanho em mm

    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public float getThickness() {
        return this.thickness;
    }

    public String getHardness() {
        return this.hardness;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // public void setThickness(float thickness) {
    // this.thickness = thickness;
    // }

    public int usagePerSheet() {
        if (hardness.equals("HB"))
            return 1;
        else if (hardness.equals("2B"))
            return 2;
        else if (hardness.equals("4B"))
            return 4;
        else
            return 6;
    }

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
}

class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasGrafite() {
        if (this.tip != null) {
            return true;
        }
        return false;
    }

    public boolean insert(Lead grafite) {
        if (!hasGrafite()) {
            if (this.thickness != grafite.getThickness()) {
                System.out.println("fail: calibre incompatibel");
                return false;
            } else {
                this.tip = grafite;
                return true;
            }
        }
        System.out.println("fail: ja existe grafite");
        return false;
    }

    public Lead remove() {
        if (hasGrafite()) {
            Lead lead = this.tip;
            this.tip = null;
            return lead;

        } else {
            return null;
        }
    }

    public void writePage() {
        if (!hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return;
        }
        if (hasGrafite() && tip.getSize() >= 10) {
            if (tip.usagePerSheet() == 1) {
                if (tip.getSize() > 10) {
                    tip.setSize(tip.getSize() - 1);
                } else {
                    System.out.println("fail: tamanho insuficiente");
                }
            }
            if (tip.usagePerSheet() == 2) {
                if (tip.getSize() >= 12) {
                    tip.setSize(tip.getSize() - 2);
                } else if (tip.getSize() == 11) {
                    tip.setSize(10);
                    System.out.println("fail: folha incompleta");
                } else {
                    System.out.println("fail: tamanho insuficiente");
                }
            }
            if (tip.usagePerSheet() == 4) {
                if (tip.getSize() >= 14) {
                    tip.setSize(tip.getSize() - 4);
                } else if (tip.getSize() > 10 && tip.getSize() < 14) {
                    tip.setSize(10);
                    System.out.println("fail: folha incompleta");
                } else {
                    System.out.println("fail: tamanho insuficiente");
                }
            }
            if (tip.usagePerSheet() == 6) {
                if (tip.getSize() >= 16) {
                    tip.setSize(tip.getSize() - 6);
                } else if (tip.getSize() > 10 && tip.getSize() < 16) {
                    tip.setSize(10);
                    System.out.println("fail: folha incompleta");
                } else {
                    System.out.println("fail: tamanho insuficiente");
                }
            }
        }
    }

    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}

public class GrafiteSolver {
    public static void main(String[] args) {
        Pencil pencil = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);

            if ("end".equals(argsL[0])) {
                break;
            } else if ("init".equals(argsL[0])) {
                pencil = new Pencil(number(argsL[1]));
            } else if ("insert".equals(argsL[0])) {
                pencil.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3])));
            } else if ("remove".equals(argsL[0])) {
                pencil.remove();
            } else if ("write".equals(argsL[0])) {
                pencil.writePage();
            } else if ("show".equals(argsL[0])) {
                write(pencil.toString());
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static float number(String str) {
        return Float.parseFloat(str);
    }
}