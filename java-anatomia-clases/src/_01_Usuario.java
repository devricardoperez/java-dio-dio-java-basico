public class _01_Usuario {

    public static void main(String[] args) {

        _01_Televisao televisao = new _01_Televisao();

        System.out.println("TV Ligada ? " + televisao.ligada);
        System.out.println("Canal Atual: " + televisao.canal);
        System.out.println("Volume Atual: " + televisao.volume);

        televisao.ligar();
        System.out.println("Novo Status -> TV Ligada ? " + televisao.ligada);

        televisao.desligar();
        System.out.println("Novo Status -> TV Ligada ? " + televisao.ligada);

        televisao.diminuirVolume();
        televisao.diminuirVolume();
        televisao.aumentarVolume();
        System.out.println("Volumen Atual: " + televisao.volume);

        televisao.mudarCanal(13);
        System.out.println("Canal Atual: " + televisao.canal);

    }
}
