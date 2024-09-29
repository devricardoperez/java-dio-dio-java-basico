import java.util.InputMismatchException;
import java.util.Scanner;

// Interface para controlar o televisor
interface ControladorTelevisor {
    void encender();
    void apagar();
    void aumentarVolume();
    void diminuirVolume();
    void mudarCanal(int canal);
    void mudarCanal();
    void mostrarEstado();
}

// Classe Televisor que implementa a interface
class Televisor implements ControladorTelevisor {
    private boolean encendido;
    private int volume;
    private int canal;

    public Televisor() {
        this.encendido = false; // Inicialmente desligado
        this.volume = 0; // Volume inicial
        this.canal = 1; // Canal inicial
    }

    @Override
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("O televisor está ligado.");
        } else {
            System.out.println("O televisor já está ligado.");
        }
    }

    @Override
    public void apagar() {
        if (encendido) {
            encendido = false;
            System.out.println("O televisor está desligado.");
        } else {
            System.out.println("O televisor já está desligado.");
        }
    }

    @Override
    public void aumentarVolume() {
        if (encendido) {
            if (volume < 30) {
                volume++;
                System.out.println("Volume aumentado para: " + volume);
            } else {
                System.out.println("Volume máximo alcançado.");
            }
        } else {
            System.out.println("O televisor está desligado. Ligue-o primeiro.");
        }
    }

    @Override
    public void diminuirVolume() {
        if (encendido) {
            if (volume > 0) {
                volume--;
                System.out.println("Volume diminuído para: " + volume);
            } else {
                System.out.println("Volume mínimo alcançado.");
            }
        } else {
            System.out.println("O televisor está desligado. Ligue-o primeiro.");
        }
    }

    @Override
    public void mudarCanal(int canal) {
        if (encendido) {
            if (canal >= 1 && canal <= 10000) {
                this.canal = canal;
                System.out.println("Canal mudado para: " + canal);
            } else {
                System.out.println("Canal inválido. Escolha um canal entre 1 e 10000.");
            }
        } else {
            System.out.println("O televisor está desligado. Ligue-o primeiro.");
        }
    }

    @Override
    public void mudarCanal() {
        if (encendido) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número do canal (1 a 10000): ");
            try {
                int canalEscolhido = scanner.nextInt();
                mudarCanal(canalEscolhido);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpar o buffer
            }
        } else {
            System.out.println("O televisor está desligado. Ligue-o primeiro.");
        }
    }

    @Override
    public void mostrarEstado() {
        if (encendido) {
            System.out.println("Televisor está ligado.");
            System.out.println("Canal atual: " + canal);
            System.out.println("Volume atual: " + volume);
        } else {
            System.out.println("Televisor está desligado.");
        }
    }
}

// Classe que gerencia a interação do usuário
class Usuario {
    private ControladorTelevisor televisor;

    public Usuario(ControladorTelevisor televisor) {
        this.televisor = televisor;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVocê deseja usar o controle da TV? (s/n): ");
            String usarControle = scanner.nextLine();
            if (usarControle.equalsIgnoreCase("n")) {
                System.out.println("Saindo do programa.");
                break;
            }

            System.out.println("\n1. Ligar TV");
            System.out.println("2. Desligar TV");
            System.out.println("3. Aumentar Volume");
            System.out.println("4. Diminuir Volume");
            System.out.println("5. Mudar Canal (digitar número)");
            System.out.println("6. Mudar Canal (um de cada vez)");
            System.out.println("7. Mostrar Estado");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        televisor.encender();
                        break;
                    case 2:
                        televisor.apagar();
                        break;
                    case 3:
                        televisor.aumentarVolume();
                        break;
                    case 4:
                        televisor.diminuirVolume();
                        break;
                    case 5:
                        System.out.print("Digite o número do canal (1 a 10000): ");
                        int canal = scanner.nextInt();
                        televisor.mudarCanal(canal);
                        break;
                    case 6:
                        televisor.mudarCanal();
                        break;
                    case 7:
                        televisor.mostrarEstado();
                        break;
                    case 8:
                        System.out.println("Saindo do programa.");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpar o buffer
            }
        }
    }
}

// Classe principal
public class _01_SmartTV {
    public static void main(String[] args) {
        ControladorTelevisor miTv = new Televisor();
        Usuario usuario = new Usuario(miTv);
        usuario.menu();
    }
}
