/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.gui;

import calculator.logics.Operator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kakshoo
 */
public class Calculator {
    
    //private file saveFile;
    public Scanner scanner;
    public Operator operator;
    
    public Calculator() {
        //this.saveFile = ...;
        this.scanner = new Scanner(System.in);
        this.operator = new Operator();
        
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    
    
    
    public void startCalculator() {
        
        //Käynnistys
        
        System.out.println("Welcome to Calculator.app!");
        String output = "";
        double firstInput = 0;
        double secondInput = 0;
        while (true) {
            System.out.println("What would you like to calculate?");
            System.out.println("1: Basic operations");
            System.out.println("2: Trigonometric operations");
            System.out.println("3: Powers");
            System.out.println("4: Print out your calculation history");
            System.out.println("e: Exit");
            System.out.println("");
            String command = scanner.nextLine();
            
            
            //Peruslaskutoimitusket
            
            
            if (command.equals("1")) {
                
                System.out.println("Enter operation (+, -, /, *)");
                
                while (true) {
                    String operation = scanner.nextLine();
                    if (!(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("/")) && !(operation.equals("*"))) {
                        System.out.println("Unsupported operation, try again.");
                    } else {
                        this.operator.setLastOperation(operation);
                        break;
                    }
                }
                System.out.println("Enter first number or enter 'ans' to use last result.");
                String input = scanner.nextLine();
                if (input.equals("ans")) {
                    operator.setLastInput(operator.getLastResult());
                    firstInput = operator.getLastResult();
                } else {
                    try {
                        firstInput = Double.parseDouble(input);
                        operator.setLastInput(firstInput);
                      
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, closing calculator");
                        break;
                    }
                }
                System.out.println("Enter second number or enter 'ans' to use last result.");
                
                input = scanner.nextLine();
                if (input.equals("ans")) {
                    operator.setLastInput(operator.getLastResult());
                    secondInput = operator.getLastResult();
                } else {
                    try {
                        secondInput = Double.parseDouble(input);
                        operator.setLastInput(secondInput);
                  
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, closing calculator");
                        break;
                    }
                }
                if (operator.getLastOperation().equals("+")) {
                    operator.sum(firstInput, secondInput);
                    output = firstInput + "+" + secondInput + " = " + operator.getLastResult();
                }
                if (operator.getLastOperation().equals("-")) {
                    operator.substraction(firstInput, secondInput);
                    output = firstInput + "-" + secondInput + " = " + operator.getLastResult();
                }
                if (operator.getLastOperation().equals("/")) {
                    operator.division(firstInput, secondInput);
                    output = firstInput + "/" + secondInput + " = " + operator.getLastResult();
                }
                if (operator.getLastOperation().equals("*")) {
                    operator.multiplication(firstInput, secondInput);
                    output = firstInput + "*" + secondInput + " = " + operator.getLastResult();
                }
                System.out.println(output);
                System.out.println("");
                try (FileWriter fw = new FileWriter("operations.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
                    out.println(output);
                } catch (IOException e) {
                    System.out.println("The application encountered an error");
                }
            }
            
            
            
            
            //Trigonometriset funktiot
            
            
            if (command.equals("2")) {
                System.out.println("Enter operation (sin, cos, tan)");
                
                while (true) {
                    String operation = scanner.nextLine();
                    if (!(operation.equals("sin")) && !(operation.equals("cos")) && !(operation.equals("tan"))) {
                        System.out.println("Unsupported operation, try again.");
                    } else {
                        this.operator.setLastOperation(operation);
                        break;
                    }
                }
                System.out.println("Enter a number or enter 'ans' to use last result.");
                String input = scanner.nextLine();
                if (input.equals("ans")) {
                    operator.setLastInput(operator.getLastResult());
                    firstInput = operator.getLastResult();
                } else {
                    try {
                        firstInput = Double.parseDouble(input);
                        operator.setLastInput(firstInput);
                          
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, closing calculator");
                        break;
                    }
                }
                if (operator.getLastOperation().equals("sin")) {
                    operator.sin(firstInput);
                    output = "sin(" + firstInput + ") = " +  operator.getLastResult();
                }
                if (operator.getLastOperation().equals("cos")) {
                    operator.cos(firstInput);
                    output = "cos(" + firstInput + ") = " +  operator.getLastResult();
                }
                if (operator.getLastOperation().equals("tan")) {
                    operator.tan(firstInput);
                    output = "tan(" + firstInput + ") = " +  operator.getLastResult();
                }
                System.out.println(output);
                System.out.println("");
                try (FileWriter fw = new FileWriter("operations.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
                    out.println(output);
                } catch (IOException e) {
                    System.out.println("The application encountered an error");
                }
            }
            
            //Juuret
            
            if (command.equals("3")) {

                System.out.println("Enter a number you'd like to raise to a power, or enter 'ans' to use last result.");
                String input = scanner.nextLine();
                if (input.equals("ans")) {
                    operator.setLastInput(operator.getLastResult());
                    firstInput = operator.getLastResult();
                } else {
                    try {
                        firstInput = Double.parseDouble(input);
                        operator.setLastInput(firstInput);
                      
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, closing calculator");
                        break;
                    }
                }
                System.out.println("Enter the power you would like your last input to be raised to, or enter 'ans' to use last result as the power.");
                
                input = scanner.nextLine();
                if (input.equals("ans")) {
                    operator.setLastInput(operator.getLastResult());
                    secondInput = operator.getLastResult();
                } else {
                    try {
                        secondInput = Double.parseDouble(input);
                        operator.setLastInput(secondInput);
                  
                        
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, closing calculator");
                        break;
                    }
                }
                operator.power(firstInput, secondInput);
                output = firstInput + " to the power of " + secondInput + " = " + operator.getLastResult();
                System.out.println(output);
                System.out.println("");
                try (FileWriter fw = new FileWriter("operations.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
                    out.println(output);
                } catch (IOException e) {
                    System.out.println("The application encountered an error");
                }
            }
            
            if (command.equals("4")) {
                
                try (FileWriter fw = new FileWriter("operations.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
                
                } catch (IOException e) {
                    System.out.println("The application encountered an error");
                }
                
                ArrayList<String> lines = new ArrayList<>();

                try {
                    Files.lines(Paths.get("operations.txt")).forEach(line -> lines.add(line));
                } catch (Exception e) {
                    System.out.println("The application encountered an error");
                }
                
                lines.stream().forEach(t -> System.out.println(t));
                System.out.println("");
            }
            
            if (command.equals("e")) {
                System.out.println("Thank you for using the calculator.");
                break;
            }
        }
    }
}



                        
                        
                        
                        
                        
                        //try {
//                String exitOrNumber = scanner.nextLine();
//                if (exitOrNumber.equals("e")) {
//                    System.out.println("Thank you for using the calculator.");
//                    break;
//                }
//                double x = Double.parseDouble(exitOrNumber);
//                operator.setLastInput(Double.parseDouble(exitOrNumber));
//                operator.setLastResult(Double.parseDouble(exitOrNumber));
//            } catch (NumberFormatException ex) {
//                System.out.println("Invalid input, closing calculator");
//                break;
//            }

                

                
           
//            double firstInput = operator.getLastInput();
//            
//            System.out.println("Enter operation (+, -, /, *)");
//            OUTER:
//            while (true) {
//                String operation = scanner.nextLine();
//                if (operation.equals("sqrt")) {
//                    double sqrt = operator.sqrt(operator.getLastResult());
//                    System.out.println(sqrt);
//                    break;
//                    
//                }
//                if (!(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("/")) && !(operation.equals("*")) && !(operation.equals("=")) && !(operation.equals("^"))) {
//                    System.out.println("Unsupported operation, try again.");
//                } else {
//                    System.out.println("Enter the second number.");
//                    operator.setLastInput(Double.parseDouble(scanner.nextLine()));
//                    double secondInput = operator.getLastInput();
//                
//                    switch (operation) {
//                        case "+":
//                            double sum = operator.sum(operator.getLastResult(), secondInput);
//                            System.out.println(sum);
//                            break OUTER;
//                        case "-":
//                            double subs = operator.substraction(operator.getLastResult(), secondInput);
//                            System.out.println(subs);
//                            break OUTER;
//                        case "/":
//                            double divi = operator.division(operator.getLastResult(), secondInput);
//                            System.out.println(divi);
//                            break OUTER;
//                        case "*":
//                            double multi = operator.multiplication(operator.getLastResult(), secondInput);
//                            System.out.println(multi);
//                            break OUTER;
//                        case "=":
//                            double equ = operator.equals();
//                            System.out.println(equ);
//                            break OUTER;
//                        case "^":
//                            double power = operator.power(operator.getLastResult(), secondInput);
//                            System.out.println(power);
//                            break OUTER;
//                        default:
//                            break;
//                    }
//                }
//            }
//        }
//    }   

//try {
//                String exitOrNumber = scanner.nextLine();
//                if (exitOrNumber.equals("e")) {
//                    System.out.println("Thank you for using the calculator.");
//                    break;
//                }
//                double x = Double.parseDouble(exitOrNumber);
//                operator.setLastInput(Double.parseDouble(exitOrNumber));
//                operator.setLastResult(Double.parseDouble(exitOrNumber));
//            } catch (NumberFormatException ex) {
//                System.out.println("Invalid input, closing calculator");
//                break;
//            }