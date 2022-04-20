package com.pmart5a;

import com.pmart5a.myclasses.BinOps;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void sumBin(Scanner scanner, BinOps bins) {
        ArrayList<String> expression = getArguments(scanner);
        expression.add(bins.sum(expression.get(0), expression.get(1)));
        expression.add("+");
        printExpression(expression);
    }

    static void multBin(Scanner scanner, BinOps bins) {
        ArrayList<String> expression = getArguments(scanner);
        expression.add(bins.mult(expression.get(0), expression.get(1)));
        expression.add("*");
        printExpression(expression);
    }

    static ArrayList<String> getArguments(Scanner scanner) {
        ArrayList<String> args = new ArrayList<>();
        System.out.println("Ввеите первое двоичное число");
        args.add(scanner.nextLine());
        System.out.println("Ввеите второе двоичное число");
        args.add(scanner.nextLine());
        return args;
    }

    static void printExpression(ArrayList<String> expression) {
        System.out.printf("%s %s %s = %s\n", expression.get(0), expression.get(3), expression.get(1), expression.get(2));
    }

    public static void main(String[] args) {
        BinOps bins = new BinOps();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String menu = """
                        Меню:
                        1. Сложить два двоичных числа.
                        2. Перемножить два двоичных числа.
                        0. Выход.""";
                System.out.println(menu);
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        sumBin(scanner, bins);
                        break;
                    case 2:
                        multBin(scanner, bins);
                        break;
                    case 0:
                        return;
                }
            }
        } catch (RuntimeException exception) {
            System.out.println("Введённые данные некорректны. Работа программы завершена.");
        }
    }
}