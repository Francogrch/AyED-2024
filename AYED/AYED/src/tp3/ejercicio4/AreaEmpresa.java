package tp3.ejercicio4;

public class AreaEmpresa {
    private int tardanza;
    private String id;

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTardanza() {
        return tardanza;
    }

    public String getId() {
        return id;
    }

    public AreaEmpresa(int tardanza, String id) {
        this.tardanza = tardanza;
        this.id = id;
    }

    public AreaEmpresa(int tardanza) {
        this.tardanza = tardanza;
    }
}
