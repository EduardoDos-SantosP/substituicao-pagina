package src.algoritmo;

import src.Pagina;

import java.util.List;

public class AlgoritmoNru extends AlgoritmoSubstituicaoPagina {
    public AlgoritmoNru(List<Pagina> disco, List<Pagina> ram) {
        super(disco, ram);
    }

    @Override
    public void substituir(int instrucao) {
        int menorClasse = 4;
        int classeNru;
        Pagina paginaAntiga = null;
        for (byte i = 0; i < ram.size(); i++) {
            classeNru = 2 * ram.get(i).getR() + ram.get(i).getM();
            if (classeNru < menorClasse) {
                menorClasse = classeNru;
                paginaAntiga = ram.get(i);
            }
        }
        assert paginaAntiga != null;

        if (paginaAntiga.getM() == 1) persistirPagina(paginaAntiga);
        ram.remove(paginaAntiga);
        Pagina paginaNova = disco.stream()
                .filter(p -> p.getInstrucao() == instrucao)
                .toList()
                .get(0);
        ram.add(paginaNova);
    }
}
