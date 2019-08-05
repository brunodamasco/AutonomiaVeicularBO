package auto.autonomiaveicularbo.model;

public class FrotaBO {
    private VeiculoBO vBO;
    private double total = 0;
    private int contador = 0;

    public FrotaBO(VeiculoBO vBO) {
        this.vBO = vBO;
    }

    public FrotaBO() {
    }

    public VeiculoBO getvBO() {
        return vBO;
    }

    public void setvBO(VeiculoBO vBO) {
        this.vBO = vBO;
    }

    public void addUnidadeCarro() {
        contador++;
    }

    public void addAutonomia() {
        total += vBO.getAutonomia();
    }

    public double getAutonomiaFrota() {
        return total / contador;
    }

    @Override
    public String toString() {
        vBO = new VeiculoBO();
        return (contador + 1) + " - ";
    }
}
