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

/**
 * define o formato de uma string a ser gerada aleatoriamente por um gerador.
 * 
 * a expressao geradora tem um peso, que define a sua chance proporcional
 * de ser sorteada pelo gerador para gerar a string. o sorteio e' realizado
 * com um conjunto de expressoes geradoras.
 * 
 * as partes da expressao sao coladas uma a uma. ha' partes que geram uma
 * substring fixa, ha' partes que sorteiam uma string dentro de um array.
 * 
 * por exemplo para gerar uma das seguintes strings:
 * - Produtos de beleza.
 * - Produtos de armarinho.
 * - Produtos de limpeza.
 * deve-se construir uma expressao geradora composta de uma parte fixa
 * ("Produtos de ")  e um parte sorteada (["beleza", "armarinho", "limpeza"]).
 * 
 * o método toArray é usado para extrair as partes.
 * 
 * @author orlando
 */
public class ExpressaoGeradora {

    private int peso;
    private ArrayList<ParteDeExpressao> partes = new ArrayList<ParteDeExpressao>();
    
    /**
     * @param peso define as chances proporcionais desta expressao ser sorteada
     */
    public ExpressaoGeradora(int peso){
        this.peso = peso;
    }
    
    /**
     * anexa uma parte a expressao na sequencia
     * @param parte deve ser uma parte fixa ou uma parte sorteada
     */
    public void colar(ParteDeExpressao parte) {
        partes.add(parte);       
    }
    
    /**
     * 
     * @return conjunto de partes da string
     */
    public ParteDeExpressao[] toArray() {
        Object[] ar = partes.toArray();
        ParteDeExpressao[] res = new ParteDeExpressao[ar.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (ParteDeExpressao) ar[i];
        }
        return res;
    }

    /**
     * @return o peso
     */
    public int getPeso() {
        return peso;
    }
}
