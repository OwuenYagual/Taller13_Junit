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

    /**
     * Tests of Solve method, of class Operations.
     */
    
    
}
