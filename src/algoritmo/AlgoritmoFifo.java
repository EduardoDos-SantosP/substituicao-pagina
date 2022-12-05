package src.algoritmo;

import src.Pagina;

import java.util.List;

public class AlgoritmoFifo extends AlgoritmoSubstituicaoPagina {
    public AlgoritmoFifo(List<Pagina> disco, List<Pagina> ram) {
        super(disco, ram);
    }

    @Override
    public void substituir(int instrucao) {
        Pagina paginaAntiga = ram.get(0);
        persistirPagina(paginaAntiga);
        ram.remove(paginaAntiga);

        Pagina paginaNova = disco.stream()
                .filter(p -> p.getInstrucao() == instrucao)
                .toList()
                .get(0);
        ram.add(paginaNova);
    }
}