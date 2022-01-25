package heberleandro.desafiodiopoo;


import heberleandro.desafiodiopoo.dominio.Bootcamp;
import heberleandro.desafiodiopoo.dominio.Curso;
import heberleandro.desafiodiopoo.dominio.Dev;
import heberleandro.desafiodiopoo.dominio.Mentoria;

import java.time.LocalDate;

public class DesafioDioPooApplication {

	public static void main(String[] args) {
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso Java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);

		Curso curso2 = new Curso();
		curso2.setTitulo("Curso Js");
		curso2.setDescricao("descrição curso js");
		curso2.setCargaHoraria(5);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria de java");
		mentoria.setDescricao("descrição mentoria java");
		mentoria.setData(LocalDate.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);

		Dev devHeber = new Dev();
		devHeber.setNome("Heber");
		devHeber.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos Heber:" + devHeber.getConteudosInscritos());
		devHeber.progredir();
		devHeber.progredir();
		System.out.println("-");
		System.out.println("Conteúdos Inscritos Heber:" + devHeber.getConteudosInscritos());
		System.out.println("Conteúdos Concluídos Heber:" + devHeber.getConteudosConcluidos());
		System.out.println("XP:" + devHeber.calcularTotalXp());

		System.out.println("-------");

		Dev devJoao = new Dev();
		devJoao.setNome("Joao");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
		devJoao.progredir();
		devJoao.progredir();
		devJoao.progredir();
		System.out.println("-");
		System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
		System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
		System.out.println("XP:" + devJoao.calcularTotalXp());

		bootcamp.rankXpDevs();
	}
}
