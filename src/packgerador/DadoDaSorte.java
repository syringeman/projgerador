/* Copyright 2013 Universidade Estadual Paulista
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package packgerador;

import java.util.ArrayList;
import java.util.Random;

/**
 * gerador de valores aleatorios com chances iguais.
 * 
 * possui um numero fixo de lados, definido na construcao.
 * 
 * permite sortear um valor apenas, ou um conjunto, com repeticoes ou nao.
 * 
 * a faixa de valores vai de zero ao antecessor do numero de lados.
 * 
 * @author orlando
 */
public class DadoDaSorte {
    private Random g = new Random();
    private int lados;
    
    public DadoDaSorte(int lados){
        this.lados = lados;
    }
    
    private static int[] extrairArray(ArrayList<Integer> al) {
        Object[] ar = al.toArray();
        int[] res = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            res[i] = ((Integer) ar[i]).intValue();
        }
        return res;
    }
    
    /**
     * sorteia um valor unico.
     * @return inteiro entre 0 e antecessor(lados)
     */
    public int lancar() {
        return g.nextInt(lados);
    }
    
    /**
     * produz um conjunto de valores sorteados.
     * @param vezes deve ser estritamente positivo.
     * @return valores, possivelmente com repeticoes.
     */
    public int[] lancarVariasVezes(int vezes) {
        int lance = lancar();
        ArrayList<Integer> lances = new ArrayList<Integer> ();
        lances.add(lance);
        for (int i = 0; i < vezes - 1; i++) {
            lance = lancar();
            lances.add(lance);
        }
        return extrairArray(lances);
    }
    
    /**
     * produz um conjunto de valores sem repeticoes.
     * @param vezes deve ser estritamente positivo e nunca maior que o numero de lados
     * @return valores sem repeticoes
     */
    public int[] lancarVariasVezesSemRepetir(int vezes) {
        int lance = lancar();
        ArrayList<Integer> lances = new ArrayList<Integer> ();
        lances.add(lance);
        for (int i = 0; i < vezes - 1; i++) {
            while(lances.contains(new Integer(lance)))
                lance = lancar();
            lances.add(lance);
        }
        return extrairArray(lances);
    }
}
