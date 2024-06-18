import java.io.*;

public class Ler {
    // M�todo para ler uma String:
    public static String umaString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException e) {
            System.out.println("Erro ao ler fluxo de entrada.");
        }
        return s;
    }

    // M�todo para ler um int:
    public static int umInt() {
        while (true) {
            try {
                return Integer.parseInt(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um inteiro v�lido!!!");
            }
        }
    }

    // M�todo para ler um byte:
    public static byte umByte() {
        while (true) {
            try {
                return Byte.parseByte(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um byte v�lido!!!");
            }
        }
    }

    // M�todo para ler um short:
    public static short umShort() {
        while (true) {
            try {
                return Short.parseShort(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um short v�lido!!!");
            }
        }
    }

    // M�todo para ler um long:
    public static long umLong() {
        while (true) {
            try {
                return Long.parseLong(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um long v�lido!!!");
            }
        }
    }

    //// M�todo para ler um float;
    public static float umFloat() {
        while (true) {
            try {
                return Float.parseFloat(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um float v�lido!!!");
            }
        }
    }

    // M�todo para ler um double:
    public static double umDouble() {
        while (true) {
            try {
                return Double.valueOf(umaString().trim());
            } catch (NumberFormatException e) {
                System.out.println("N�o � um double v�lido!!!");
            }
        }
    }

    // M�todo para ler um char:
    public static char umChar() {
        while (true) {
            try {
                return umaString().charAt(0);
            } catch (Exception e) {
                System.out.println("N�o � um char v�lido!!!");
            }
        }
    }

    // M�todo para ler um boolean:
    public static boolean umBoolean() {
        while (true) {
            try {
                return Boolean.parseBoolean(umaString().trim());
            } catch (Exception e) {
                System.out.println("N�o � um boolean v�lido!!!");
            }
        }
    }
}