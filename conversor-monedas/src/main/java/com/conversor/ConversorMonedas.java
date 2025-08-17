package com.conversor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorMonedas {
    private static final Map<String, Double> tasas = new HashMap<>();
    
    static {
        tasas.put("USD", 1.0);     // Dólar como base
        tasas.put("EUR", 0.92);    // Euro
        tasas.put("PEN", 3.78);    // Sol peruano
        tasas.put("MXN", 17.0);    // Peso mexicano
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("Monedas disponibles: " + tasas.keySet());

        System.out.print("Ingrese moneda origen (ej: USD): ");
        String origen = sc.next().toUpperCase();

        System.out.print("Ingrese moneda destino (ej: EUR): ");
        String destino = sc.next().toUpperCase();

        System.out.print("Ingrese cantidad a convertir: ");
        double cantidad = sc.nextDouble();

        if (!tasas.containsKey(origen) || !tasas.containsKey(destino)) {
            System.out.println("Moneda no soportada.");
            return;
        }

        double enUSD = cantidad / tasas.get(origen);
        double convertido = enUSD * tasas.get(destino);

        System.out.printf("%.2f %s = %.2f %s%n", cantidad, origen, convertido, destino);
    }
}
