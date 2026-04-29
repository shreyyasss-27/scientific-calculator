package mainCalculator;
import java.io.*;
import java.util.*;

public class Calculator {
    public static double finalResult = 0.0;
    public static int choice;
    public static Scanner sc = new Scanner(System.in);
    static double x;
    static double y;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("_____________________________________________");
            System.out.println("________________OPERATIONS___________________");
            System.out.println();
            System.out.println("1. ADD         2. SUB      3. MULTIPLY");
            System.out.println("4. DIVIDE      5. POWER    6. SQUARE ROOT");
            System.out.println("7. SIN         8. COS      9. TAN");
            System.out.println("10. STORE      11. RECALL  12. CLEAR");
            System.out.println("___           13. HISTORY        ___");
            System.out.println("0. EXIT");
            System.out.println();
            System.out.println("_____________________________________________");

            System.out.println();
            System.out.println("Enter your operations:");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Exiting and clearing history/log files...");
                    clearHistoryAndLogs();
                    running = false;
                    break;
                case 1:
                    System.out.println("ADDITION");
                    finalResult = additions.setaddition();
                    resultStorage();
                    break;
                case 2:
                    System.out.println("SUBTRACTION");
                    finalResult = subtractions.setsubtraction();
                    resultStorage();
                    break;
                case 3:
                    System.out.println("MULTIPLICATION");
                    finalResult = multiplication.setmultiplications();
                    resultStorage();
                    break;
                case 4:
                    System.out.println("DIVIDE");
                    finalResult = division.setdivisions();
                    resultStorage();
                    break;
                case 5:
                    System.out.println("POWER");
                    finalResult = powerof.setpowerof();
                    resultStorage();
                    break;
                case 6:
                    System.out.println("SQUARE ROOT");
                    finalResult = squareroot.setsquareroot();
                    resultStorage();
                    break;
                case 7:
                    System.out.println("SIN");
                    finalResult = sineof.setsineof();
                    resultStorage();
                    break;
                case 8:
                    System.out.println("COS");
                    finalResult = cosof.setcosof();
                    resultStorage();
                    break;
                case 9:
                    System.out.println("TAN");
                    finalResult = tanof.settanof(); // Fixed typo
                    resultStorage();
                    break;
                case 10:
                    System.out.println("STORE");
                    specialResultStorage();
                    finalResult = 0.0;
                    break;
                case 11:
                    System.out.println("RECALL");
                    specialWatchHistory();
                    break;
                case 12:
                    System.out.println("CLEAR");
                    finalResult = 0.0;
                    break;
                case 13:
                    System.out.println("HISTORY");
                    System.out.println("HISTORY FROM: (OLD TO NEW)");
                    watchHistory();
                    finalResult = 0.0;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void resultStorage() {
        File file1 = new File("mainCalculator/History/resultHistory.txt");
        // Create the History directory if it doesn't exist
        File historyDir = file1.getParentFile();
        if (!historyDir.exists()) {
            historyDir.mkdirs();
        }
        String storeResult = String.valueOf(finalResult);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1, true));
            bw.write(storeResult);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void watchHistory() {
        String HistoryContent;
        File file1 = new File("mainCalculator/History/resultHistory.txt");
        // Create the History directory if it doesn't exist
        File historyDir = file1.getParentFile();
        if (!historyDir.exists()) {
            historyDir.mkdirs();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            System.out.println();
            while ((HistoryContent = br.readLine()) != null) {
                System.out.println("     " + HistoryContent);
            }
            System.out.println();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void specialWatchHistory() {
        String HistoryContent;
        File file1 = new File("mainCalculator/History/specialResultHistory.txt");
        // Create the History directory if it doesn't exist
        File historyDir = file1.getParentFile();
        if (!historyDir.exists()) {
            historyDir.mkdirs();
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            System.out.println();
            while ((HistoryContent = br.readLine()) != null) {
                System.out.println("     " + HistoryContent);
                double HistoryOld = Double.parseDouble(HistoryContent);
                finalResult = HistoryOld;
            }
            System.out.println();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void specialResultStorage() {
        File file1 = new File("mainCalculator/History/specialResultHistory.txt");
        // Create the History directory if it doesn't exist
        File historyDir = file1.getParentFile();
        if (!historyDir.exists()) {
            historyDir.mkdirs();
        }
        String storeResult = String.valueOf(finalResult);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
            bw.write(storeResult);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logOperation(String operation, double result) {
        File file1 = new File("mainCalculator/History/operationLog.txt");
        // Create the History directory if it doesn't exist
        File historyDir = file1.getParentFile();
        if (!historyDir.exists()) {
            historyDir.mkdirs();
        }
        String logEntry = operation + " = " + result;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file1, true));
            bw.write(logEntry);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearHistoryAndLogs() {
        String[] files = {"mainCalculator/History/resultHistory.txt", "mainCalculator/History/operationLog.txt", "mainCalculator/History/specialResultHistory.txt"};
        for (String filePath : files) {
            try {
                FileWriter fw = new FileWriter(filePath, false); // overwrite mode
                fw.write("");
                fw.close();
            } catch (IOException e) {
                System.out.println("Failed to clear: " + filePath);
            }
        }
    }

    // Getters and Setters
    public static double getFinalResult() {
        return finalResult;
    }

    public static void setFinalResult(double finalResult) {
        Calculator.finalResult = finalResult;
    }
}

class additions extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setaddition() {
        double sum;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            System.out.print("Enter the number: ");
            y = sc.nextDouble();
            sum = x + y;
        } else {
            sum = Calculator.getFinalResult();
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            sum = sum + x;
        }
        Calculator.logOperation("Addition", sum);
        return sum;
    }
}

class subtractions extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setsubtraction() {
        double diff;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            System.out.print("Enter the number: ");
            y = sc.nextDouble();
            diff = x - y;
        } else {
            diff = Calculator.getFinalResult();
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            diff = diff - x;
        }
        Calculator.logOperation("Subtraction", diff);
        return diff;
    }
}

class multiplication extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setmultiplications() {
        double prod;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            System.out.print("Enter the number: ");
            y = sc.nextDouble();
            prod = x * y;
        } else {
            prod = Calculator.getFinalResult();
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            prod = prod * x;
        }
        Calculator.logOperation("Multiplication", prod);
        return prod;
    }
}

class division extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setdivisions() {
        double finalResult = 0.0;
        try {
            if (Calculator.getFinalResult() == 0) {
                System.out.print("Enter the number: ");
                x = sc.nextDouble();
                System.out.print("Enter the number: ");
                y = sc.nextDouble();
                if (y == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                finalResult = x / y;
            } else {
                finalResult = Calculator.getFinalResult();
                System.out.print("Enter the number: ");
                x = sc.nextDouble();
                if (x == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                finalResult = finalResult / x;
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        Calculator.logOperation("Division", finalResult);
        return finalResult;
    }
}

class powerof extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setpowerof() {
        double finalResult;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number x : ");
            x = sc.nextDouble();
            System.out.print("Enter the number y : ");
            y = sc.nextDouble();
            finalResult = Math.pow(x, y);
            Calculator.setFinalResult(finalResult);
        } else {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            finalResult = Math.pow(Calculator.getFinalResult(), x);
            Calculator.setFinalResult(finalResult);
        }
        Calculator.logOperation("Power", finalResult);
        return finalResult;
    }
}

class squareroot extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setsquareroot() {
        double finalResult;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            finalResult = Math.sqrt(x);
            Calculator.setFinalResult(finalResult);
        } else {
            finalResult = Math.sqrt(Calculator.getFinalResult());
            Calculator.setFinalResult(finalResult);
        }
        Calculator.logOperation("Square Root", finalResult);
        return finalResult;
    }
}

class sineof extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setsineof() {
        double finalResult;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            y = Math.toRadians(x);
            finalResult = Math.sin(y);
            Calculator.setFinalResult(finalResult);
        } else {
            y = Math.toRadians(Calculator.getFinalResult());
            finalResult = Math.sin(y);
            Calculator.setFinalResult(finalResult);
        }
        Calculator.logOperation("Sine", finalResult);
        return finalResult;
    }
}

class cosof extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double setcosof() {
        double finalResult;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number(in degrees): ");
            x = sc.nextDouble();
            y = Math.toRadians(x);
            finalResult = Math.cos(y);
            Calculator.setFinalResult(finalResult);
        } else {
            y = Math.toRadians(Calculator.getFinalResult());
            finalResult = Math.cos(y);
            Calculator.setFinalResult(finalResult);
        }
        Calculator.logOperation("Cosine", finalResult);
        return finalResult;
    }
}

class tanof extends Calculator {
    static Scanner sc = new Scanner(System.in);

    public static double settanof() { // Fixed method name
        double finalResult;
        if (Calculator.getFinalResult() == 0) {
            System.out.print("Enter the number: ");
            x = sc.nextDouble();
            y = Math.toRadians(x);
            finalResult = Math.tan(y);
            Calculator.setFinalResult(finalResult);
        } else {
            y = Math.toRadians(Calculator.getFinalResult());
            finalResult = Math.tan(y);
            Calculator.setFinalResult(finalResult);
        }
        Calculator.logOperation("Tangent", finalResult);
        return finalResult;
    }
}