public class ContadorDeAPIs {

    private int contadorCEP;
    private int contadorCNPJ;
    private int contadorJog;

    public ContadorDeAPIs() {
        this.contadorCEP = 0;
        this.contadorCNPJ = 0;
        this.contadorJog = 0;
    }

    public void contarCEP() {
        contadorCEP++;
    }

    public void contarCNPJ() {
        contadorCNPJ++;
    }

    public void contarJog() {
        contadorJog++;
    }

    public int getContadorCEP() {
        return contadorCEP;
    }

    public int getContadorCNPJ() {
        return contadorCNPJ;
    }

    public int getContadorJog() {
        return contadorJog;
    }
}
