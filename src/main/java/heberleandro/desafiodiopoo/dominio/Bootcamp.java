package heberleandro.desafiodiopoo.dominio;

import lombok.Data;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public void rankXpDevs(){

        List<Dev> devList = devsInscritos.stream().sorted((o1, o2) -> o2.calcularTotalXp().compareTo(o1.calcularTotalXp())).collect(Collectors.toList());

        int index = 1;
        System.out.println("=== Rank ===");
        for (Dev dev: devList) {
            System.out.println(String.format("%dº - %s :: %d", index++, dev.getNome(), dev.calcularTotalXp().intValue()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
