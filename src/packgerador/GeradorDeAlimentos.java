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

/**
 * gera um titulo de ficcao para filme ou livro.
 * 
 * duas partes: um nome feminino e um adjetivo no estilo western.
 * 
 * @author orlando
 */
public class GeradorDeAlimentos {
    
    private static String[] alimentos = {
        "Chocolate ",
        "Macarrao ",
        "Bife ",
        "Alface ",
        "Biscoito ",
        "Bolacha ",
        "Hamburguer ",
        "Pizza ",
        "Miojo ",
        "Omelete ",
        "Ovo ",
        "Salsicha ",
        "Carne ",
        "Picanha ",
        "Cereal ",
        "Água ",
        "Lasanha ",
        "Canelone ",
        "Frango ",
        "Galinha "
    };
    
    private static String[] complementos = {
        "ao leite",
        "ao molho branco",
        "a milanesa",
        "meio amargo",
        "ao sugo",
        "com bacon",
        "com queijo",
        "com presunto",
        "com presunto e queijo",
        "com catupiry",
        "light",
        "diet",
        "sem gás",
        "com gás",
        "com gotas de chocolate",
        "a frufru",
        "ao molho madeira",
        "no bafo"
    };
    
    /**
     * @return um nome feminino seguido de adjetivo no estilo western.
     */
    public static String prox() {
        
        ExpressaoGeradora exp = new ExpressaoGeradora(1);
        exp.colar(new ParteSorteada(alimentos));
        exp.colar(new ParteSorteada(complementos));
        
        ExpressaoGeradora[] ops = {exp};
        Gerador g = new Gerador(ops);
        
        return g.prox();
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(prox());
        }
    }
    
}
