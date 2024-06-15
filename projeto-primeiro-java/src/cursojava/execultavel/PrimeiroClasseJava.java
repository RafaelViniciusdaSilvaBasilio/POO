package cursojava.execultavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiroClasseJava {
	/* Main é metodo alto execultavel em java */
	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login ");
		String senha = JOptionPane.showInputDialog("Informe a senha ");
		
		if (login.equalsIgnoreCase("admin ") &&
				senha.equalsIgnoreCase("admin ")) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		/*é uma lista que dentor dela temos uma chave que identifica uma sequencia de valores também*/
		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();
		
		
		for ( int qtd = 1 ; qtd <=5; qtd++ ) {

		/* new aluno() é uma instancia (Criação de objeto)*/
		/*aluno1 é uma referência para o objeto aluno */
		
		String nome = JOptionPane.showInputDialog("Qual é o seu nome "+qtd+" ?");
		/*String idade = JOptionPane.showInputDialog("Qual é a sua idade");
		String dataNascimento = JOptionPane.showInputDialog("Qual é a Data de nascimento");
		String rg = JOptionPane.showInputDialog("Resgistro geral?");
		String cpf = JOptionPane.showInputDialog("Qual é o CPF?");
		String nomeMae = JOptionPane.showInputDialog("Qual é o nome da sua mãe");
		String nomePai = JOptionPane.showInputDialog("Qual é o nome do seu pai");
		String matricula = JOptionPane.showInputDialog("Data da matricula");
		String nomeEscola = JOptionPane.showInputDialog("Nome da Escola?");
		String serie = JOptionPane.showInputDialog("Qual a serie");*/
		
		
		Aluno aluno1 = new Aluno();
		
		aluno1.setNome(nome);
		/*aluno1.setIdade(Integer.valueOf(idade));
		aluno1.setDataNascimento(dataNascimento);
		aluno1.setRegistroGeral(rg);
		aluno1.setNumeroCpf(cpf);
		aluno1.setNomeMae(nomeMae);
		aluno1.setNomePai(nomePai);
		aluno1.setDataMatricula(matricula);
		aluno1.setNomeEscola(nomeEscola);
		aluno1.setSerieMatriculado(serie);*/
		
		for (int pos = 1; pos <=4; pos++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina "+pos+" ?");
			String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina "+pos+" ? ");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
		 int escolha =JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina ?");
		 
		 if (escolha == 0) {
			 
			 int continuarRemover = 0;
			 int posicao = 1;
			 while (continuarRemover == 0){
			 String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
			 aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
			 posicao ++;
			 continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover");
		 }
	}
		
		 alunos.add(aluno1);
	 }
		
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERAÇAO, new ArrayList<Aluno>());
		
	 for (Aluno aluno : alunos) {/*Separei em listas*/
		
		 if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
		   maps.get(StatusAluno.APROVADO).add(aluno);
	 }else 
		 if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERAÇAO)) {
			 maps.get(StatusAluno.REPROVADO).add(aluno);
		 } else {
			 maps.get(StatusAluno.RECUPERAÇAO).add(aluno);
		 }
	}
		
	 System.out.println("------------Lista dos Aprovados------------");
	 for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
		System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " co média de = " + aluno.getMediaNota());
		}
		
	 System.out.println("------------Lista dos Reprovados------------");
	 for (Aluno aluno :maps.get(StatusAluno.REPROVADO)) {
		System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " co média de = " + aluno.getMediaNota());
		}
	 
	 System.out.println("------------Lista dos Recuperação------------");
	 for (Aluno aluno : maps.get(StatusAluno.RECUPERAÇAO)) {
		System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
		}
	 
	}
	}
}

