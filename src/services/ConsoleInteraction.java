package services;

import entities.Currency;

import java.lang.classfile.instruction.SwitchCase;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInteraction {

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("7")) {
            System.out.println("----------------------------------------");
            System.out.println("Seja bem-vindo/a ao Conversor de Moedas!\n");
            System.out.println("1) Dólar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dólar");
            System.out.println("3) Dólar -> Real brasileiro");
            System.out.println("4) Real brasileiro -> Dólar");
            System.out.println("5) Dólar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");
            input = scanner.nextLine();
            System.out.println("----------------------------------------");
            selectCurrencies(input,scanner);
        }
        scanner.close();
    }

    public static void selectCurrencies(String input, Scanner scanner) {
            Currency curr1 = new Currency("USD");
            Currency curr2 = null;

            curr1.populateConversionRate();
            switch (input) {
                case "1":
                    curr2 = new Currency("ARS");
                    scanMoney(scanner);
                    System.out.format("Em pesos argentinos: %.2f \n",CurrencyExchangeCalculator.convertFromBase(curr1, curr2));
                    break;
                case "2":
                    curr2 = new Currency("ARS");
                    scanMoney(scanner);
                    System.out.format("Em dólares americanos: %.2f \n",CurrencyExchangeCalculator.convertToBase(curr1, curr2));
                    break;
                case "3":
                    curr2 = new Currency("BRL");
                    scanMoney(scanner);
                    System.out.format("Em reais brasileiros: %.2f",CurrencyExchangeCalculator.convertFromBase(curr1, curr2));
                    break;
                case "4":
                    curr2 = new Currency("BRL");
                    scanMoney(scanner);
                    System.out.format("Em dólares americanos: %.2f \n",CurrencyExchangeCalculator.convertToBase(curr1, curr2));
                    break;
                case "5":
                    curr2 = new Currency("COP");
                    scanMoney(scanner);
                    System.out.format("Em pesos colombianos: %.2f \n",CurrencyExchangeCalculator.convertFromBase(curr1, curr2));
                    break;
                case "6":
                    curr2 = new Currency("COP");
                    scanMoney(scanner);
                    System.out.format("Em dólares americanos: %.2f \n",CurrencyExchangeCalculator.convertToBase(curr1, curr2));
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
            if(!input.equals("7")){
                System.out.println("\nAperte qualquer tecla para continuar...");
                new java.util.Scanner(System.in).nextLine();
            }

    }

    private static void scanMoney(Scanner scanner){
        System.out.print("Quantidade da conversão: ");
        String moneyString = scanner.nextLine();
        try{
            Double money = Double.parseDouble(moneyString.replace(",","."));
            CurrencyExchangeCalculator.setMoney(money);
        } catch (NumberFormatException e){
            System.out.println("Entrada inválida! Digite um número corretamente");
            scanMoney(scanner);
        }
    }
}
