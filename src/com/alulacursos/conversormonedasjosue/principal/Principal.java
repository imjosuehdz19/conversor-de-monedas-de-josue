package com.alulacursos.conversormonedasjosue.principal;

import com.alulacursos.conversormonedasjosue.modelos.ConsultarTasa;
import com.alulacursos.conversormonedasjosue.modelos.Conversor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultarTasa api = new ConsultarTasa();

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("""
                    ***************************************************
                    Sea bienvenido al Real Josue's exchange $$$$
                    
                    Actualmente contamos con las siguientes monedas:
                    
                    1. Dólar --> Peso Chileno
                    2. Dólar --> Peso Argentino
                    3. Peso Argentino --> Dólar
                    4. Real Brasileño --> Dólar
                    5. Dólar --> Euro
                    6. Euro --> Dólar
                    7. Salir.
                    
                    Por favor elija la conversión a desear:
                    """);

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                String monedaBase = "";
                String monedaDestino = "";

                switch (opcion) {
                    case 1 -> { monedaBase = "USD"; monedaDestino = "CLP"; }
                    case 2 -> { monedaBase = "USD"; monedaDestino = "ARS"; }
                    case 3 -> { monedaBase = "ARS"; monedaDestino = "USD"; }
                    case 4 -> { monedaBase = "BRL"; monedaDestino = "USD"; }
                    case 5 -> { monedaBase = "USD"; monedaDestino = "EUR"; }
                    case 6 -> { monedaBase = "EUR"; monedaDestino = "USD"; }
                }

                Conversor resultado = api.obtenerTasa(monedaBase, monedaDestino);
                if (resultado != null) {
                    // Calculamos el valor final
                    resultado.setResult(String.valueOf(monto * resultado.getConversion_rate()));
                    System.out.println(resultado.mostrarResultado(monto) + "\n");


                    String registro = resultado.mostrarResultado(monto);
                }

            } else if (opcion != 7) {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        System.out.println("Gracias por usar nuestros servicios");
    }
}