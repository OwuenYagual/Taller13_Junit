/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calculatorsmp;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author oweny
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Tests of MakeFormula method, of class Operations.
     */
    @Test
    @DisplayName("Verificar que MakeFormula selecciona todos los operadores (+, -, *, /) al menos una vez")
    public void testMakeFormula01() {
        Set<String> operators = new HashSet<>();
        String[] expectedOperators = {"+", "-", "*", "/"};

        // Ejecuta el método MakeFormula múltiples veces para asegurar que todos los operadores son seleccionados
        for (int i = 0; i < 1000; i++) {
            String formula = Operations.MakeFormula();
            for (String op : expectedOperators) {
                if (formula.contains(op)) {
                    operators.add(op);
                }
            }
            // Si ya hemos encontrado todos los operadores, podemos detenernos
            if (operators.size() == 4) {
                break;
            }
        }

        // Verifica que todos los operadores (+, -, *, /) fueron seleccionados
        assertArrayEquals(expectedOperators, operators.toArray(), "El metodo MakeFormula no incluye la operacion de division");
    }
    
    @Test
    @DisplayName("Test: Verificar que la fórmula no sea nula, vacía y contenga operadores válidos")
    void testMakeFormula02() {
        // Invocamos el método MakeFormula
        String formula = Operations.MakeFormula();

        // Verificamos si la fórmula generada no es nula y no está vacía
        assertNotNull(formula, "La fórmula generada es nula.");
        assertFalse(formula.isEmpty(), "La fórmula generada está vacía.");

        // Verificamos si la fórmula generada contiene al menos un operador de los esperados
        boolean containsOperator = formula.contains("+") || formula.contains("-")
                || formula.contains("*") || formula.contains("/");
        assertTrue(containsOperator, "La fórmula generada no contiene ningún operador.");

        // Verificamos si la fórmula generada solo contiene caracteres válidos (números y operadores)
        boolean isValid = formula.matches("[0-9+\\-*/]+");
        assertTrue(isValid, "La fórmula generada contiene caracteres inválidos.");
    }
    
    @Test
    @DisplayName("Verificar que MakeFormula genera diferentes fórmulas consecutivamente")
    public void testMakeFormula03() {
        String previousFormula = Operations.MakeFormula();
        boolean differentFound = false;

        for (int i = 0; i < 100; i++) {
            String currentFormula = Operations.MakeFormula();
            if (!currentFormula.equals(previousFormula)) {
                differentFound = true;
                break;
            }
            previousFormula = currentFormula;
        }

        assertTrue(differentFound, "MakeFormula generó la misma fórmula en todas las ejecuciones consecutivas");
    }

    /**
     * Tests of Solve method, of class Operations.
     */
    @Test
    @DisplayName("Evaluar la expresión 4*20+33+15 con el método Solve")
    public void testSolve01() {
        // Expresión a evaluar
        String formula = "4*20+33+15";

        // Resultado esperado
        String expected = "4*20+33+15=128";

        // Ejecutar el método Solve
        String result = Operations.Solve(formula);

        // Comparar el resultado con el valor esperado
        assertEquals(expected, result, "La evaluación de la expresión 4*20+33+15 es incorrecta");
    }
    
    @Test
    @DisplayName("Evaluar la expresión 100/10*2 con el método Solve")
    public void testSolve02() {
        String formula = "100/10*2";
        String expected = "100/10*2=20";
        String result = Operations.Solve(formula);
        assertEquals(expected, result, "La evaluación de la expresión 100/10*2 es incorrecta");
    }
    
    @Test
    @DisplayName("Test: Resolver una expresión que termina en número negativo")
    public void testSolve03() {
        String formula = "2-10";
        String expected = "2-10=-8";
        String result = Operations.Solve(formula);
        assertEquals(expected, result, "La resolución de la expresión con resultado negativo falló.");
    }
}
