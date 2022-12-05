package src.algoritmo;

import src.Pagina;

import java.util.List;

public abstract class AlgoritmoSubstituicaoPagina {
    protected final List<Pagina> disco;
    protected final List<Pagina> ram;

    public AlgoritmoSubstituicaoPagina(List<Pagina> disco, List<Pagina> ram) {
        this.disco = disco;
        this.ram = ram;
    }

    public abstract void substituir(int instrucao);

    protected void persistirPagina(Pagina pagina) {
        disco.set(disco.indexOf(pagina), pagina);
    }

}
