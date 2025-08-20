import java.util.Scanner;

public class ConversorMoeda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite o valor a ser convertido:");
            double valor = scanner.nextDouble();

            scanner.nextLine(); // Consome a quebra de linha

            System.out.println("Digite a moeda de origem (ex: BRL, USD, EUR, JPY):");
            String moedaOrigem = scanner.nextLine().toUpperCase();

            System.out.println("Digite a moeda de destino (ex: BRL, USD, EUR, JPY):");
            String moedaDestino = scanner.nextLine().toUpperCase();

            double resultado = converterMoeda(valor, moedaOrigem, moedaDestino);

            if (resultado == -1) {
                System.out.println("Moeda não suportada. Por favor, use BRL, USD, EUR ou JPY.");
            } else {
                System.out.printf("O valor convertido é: %.2f %s%n", resultado, moedaDestino);
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Por favor, digite um valor numérico válido.");
        } finally {
            scanner.close();
        }
    }

    public static double converterMoeda(double valor, String moedaOrigem, String moedaDestino) {

        double taxaOrigem;
        switch (moedaOrigem) {
            case "USD":
                taxaOrigem = 5.20;
                break;
            case "EUR":
                taxaOrigem = 5.60;
                break;
            case "BRL":
                taxaOrigem = 1.00;
                break;
            case "JPY":
                taxaOrigem = 0.035;
                break;
            default:
                return -1;
        }

        double taxaDestino;
        switch (moedaDestino) {
            case "USD":
                taxaDestino = 5.20;
                break;
            case "EUR":
                taxaDestino = 5.60;
                break;
            case "BRL":
                taxaDestino = 1.00;
                break;
            case "JPY":
                taxaDestino = 0.035;
                break;
            default:
                return -1;
        }


        double valorEmBRL = valor * taxaOrigem;
        double valorConvertido = valorEmBRL / taxaDestino;

        return valorConvertido;
    }
}