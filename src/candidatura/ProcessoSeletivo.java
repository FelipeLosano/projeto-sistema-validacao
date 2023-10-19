package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
  public static void main(String[] args) {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
    for (String candidato : candidatos) {
      entrandoEmContato(candidato);
    }
  }

  static void entrandoEmContato(String candidato) {
    int tentativas = 0;
    boolean continuarTentando = true;
    boolean atendeu = false;
    do {
      atendeu = atender();
      continuarTentando = !atendeu;
      if(continuarTentando)
        tentativas++;
      else
        System.out.println("Contato realizado com sucesso");
    } while (continuarTentando && tentativas < 3);

    if(atendeu)
      System.out.println("Conseguimos contato com " + candidato + " na " + tentativas + " tentativa");
    else
      System.out.println("Não conseguimos contato com " + candidato + " após " + tentativas + " tentativas");
  }

}

  static boolean atender() {
    return new Random().nextBoolean();
  }

  static void imprimirSelecionados() {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
    for (String candidato : candidatos) {
      System.out.println("O candidato selecionado foi: " + candidato);
    }
  }

  static void selecaoCandidatos() {
    String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

    int candidatosSelecionados = 0;
    int candidatosAtual = 0;
    double salarioBase = 2000.0;

    while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
      String candidato = candidatos[candidatosAtual];
      double salarioPretendido = valorPretendido();

      if (salarioBase >= salarioPretendido) {
        System.out.println("O candidato " + candidato + " foi selecionado");
        candidatosSelecionados++;
      }
      candidatosAtual++;
    }
  }

  static double valorPretendido() {
    return ThreadLocalRandom.current().nextDouble(1800, 2200);
  }

  static void analisarCandidato(double salarioPretendido) {
    double salarioBase = 2000.0;
    if (salarioBase > salarioPretendido) {
      System.out.println("Ligar para o candidato");
    } else if (salarioBase == salarioPretendido) {
      System.out.println("Ligar para o candidato com contra proposta");
    } else {
      System.out.println("Aguardando o resultado dos demais candidatos");
    }
  }
}
