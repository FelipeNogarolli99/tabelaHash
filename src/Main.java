public class Main {
    public static void main(String[] args) {
        System.out.println("Programa gerador de Hash!");

        int tam_vetor = 10; // Tamanho da Hash
        int max = 5; // Número máximo de elementos

        System.out.println("Tamanho da Hash: " + tam_vetor);
        System.out.println("Número máximo de elementos: " + max);
        System.out.println("Fator de carga: " + (float) max / (float) tam_vetor);

        Hash alunohash = new Hash(tam_vetor, max);
        // Inserir alunos automaticamente
        Pessoa pessoa1 = new Pessoa(123, "Alice");
        Pessoa pessoa2 = new Pessoa(456, "Bob");
        Pessoa pessoa3 = new Pessoa(789, "Carol");
        Pessoa pessoa4 = new Pessoa(101, "David");
        Pessoa pessoa5 = new Pessoa(103, "Dav");

        Pessoa pessoa6 = new Pessoa(102, "Daid");

        alunohash.inserir(pessoa1);
        alunohash.inserir(pessoa2);
        alunohash.inserir(pessoa3);
        alunohash.inserir(pessoa4);
        alunohash.inserir(pessoa5);

        alunohash.inserir(pessoa6);

        // Exemplo: Remover um aluno por ID
//        alunohash.deletar(123, "");
//
//        // Exemplo: Remover um aluno por nome
//        alunohash.deletar(-1, "Bob");

        // Exemplo: Buscar um aluno por ID

        int buscaId = 101;
        boolean[] buscaResultado = new boolean[1];
        alunohash.buscar(buscaId, "", buscaResultado);
        if (buscaResultado[0]) {
            System.out.println("Pessoa encontrado por ID!  : " + buscaId);
        } else {
            System.out.println("Pessoa não encontrado por ID.");
        }

        // Exemplo: Buscar um aluno por nome
        String buscaNome = "pedro";
        alunohash.buscar(-1, buscaNome, buscaResultado);
        if (buscaResultado[0]) {
            System.out.println("Pessoa encontrado por nome! : " + buscaNome);
        } else {
            System.out.println("Pessoa não encontrado por nome.");
        }

        // Imprimir a Hash
        alunohash.imprimir();
    }
}
