package auto.autonomiaveicularbo.model;

public class VeiculoBO {
    private Veiculo veiculo;
    private FrotaBO frotaBO;

    public VeiculoBO() {
    }

    public VeiculoBO(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public static boolean validaNome(Veiculo v) {
        return v.getNome() != null;
    }

    public static boolean validaKm(Veiculo v) {
        return v.getKm() != null;
    }

    public static boolean validaCom(Veiculo v) {
        return v.getCombustivel() != null;
    }

    public double getAutonomia() {
        return this.veiculo.getKm() / this.veiculo.getCombustivel();
    }

    @Override
    public String toString() {
        return "Carro: " + veiculo.getNome() + " - autonomia: " + getAutonomia() + " Km/L";
    }
}
