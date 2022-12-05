import src.Pagina;
import src.Util;
import src.algoritmo.AlgoritmoNru;
import src.algoritmo.AlgoritmoSubstituicaoPagina;

import java.util.ArrayList;
import java.util.List;

public class Kernel extends Util {
    private static final List<Pagina> disco = new ArrayList<>();
    private static final List<Pagina> ram = new ArrayList<>();
    private static final AlgoritmoSubstituicaoPagina algoritmo = new AlgoritmoNru(disco, ram);

    public static void main(String[] args) {
        preencherDisco();
        preencherRam();
        run();
    }

    private static void preencherDisco() {
        for (byte i = 0; i < 100; i++)
            disco.add(new Pagina(i));
    }

    private static void preencherRam() {
        Pagina pagina;
        for (int i = 0; i < 10; i++)
            while (true) {
                if (ram.contains(pagina = disco.get(random(100))))
                    continue;
                ram.add(pagina);
                break;
            }
    }

    private static void run() {
        print("Antes:");
        print("RAM");
        ram.forEach(Util::print);
        print("Disco");
        disco.forEach(Util::print);

        for (short execucao = 0; execucao < 500; execucao++) {
            int instrucaoRequisitada = random(100) + 1;
            Pagina pagina = buscarPaginaCarregada(instrucaoRequisitada);

            if (pagina != null) {
                pagina.setR(1);
                if (random(100) < 30) {
                    pagina.setDado(pagina.getDado() + 1);
                    pagina.setM(1);
                }
                continue;
            }

            algoritmo.substituir(instrucaoRequisitada);

            ram.forEach(Pagina::clock);
        }

        print("Depois:");
        print("RAM");
        ram.forEach(Util::print);
        print("Disco");
        disco.forEach(Util::print);
    }

    private static Pagina buscarPaginaCarregada(int instrucao) {
        for (Pagina pagina : ram)
            if (pagina.getInstrucao() == instrucao)
                return pagina;
        return null;
    }
}
