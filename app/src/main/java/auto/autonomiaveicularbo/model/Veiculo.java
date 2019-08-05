package auto.autonomiaveicularbo.model;

public class Veiculo {
    private String nome;
    private Double km;
    private Double combustivel;

    public Veiculo() {
    }

    public Veiculo(String nome, Double km, Double combustivel) {
        this.nome = nome;
        this.km = km;
        this.combustivel = combustivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public void setKm(String km) {
        try {
            this.km = Double.parseDouble(km);
        } catch (Exception e) {
            this.km = null;
        }
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }

    public void setCombustivel(String combustivel){
        try {
            this.combustivel = Double.parseDouble(combustivel);
        } catch (Exception e){
            this.combustivel = null;
        }
    }
}
