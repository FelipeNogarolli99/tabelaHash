class Pessoa {
    private int id;
    private String nome;

    public Pessoa() {
        id = -1;
        nome = " ";
    }

    public Pessoa(int r, String n) {
        id = r;
        nome = n;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
