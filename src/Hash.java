class Hash {
    private int max_itens;
    private int max_posicoes;
    private int quant_itens;
    private Pessoa[] estrutura;

    public Hash(int tam_vetor, int max) {
        quant_itens = 0;
        max_itens = max;
        max_posicoes = tam_vetor;
        estrutura = new Pessoa[tam_vetor];
        for (int i = 0; i < tam_vetor; i++) {
            estrutura[i] = new Pessoa(-1, " ");
        }
    }

    public int FuncaoHash(Pessoa pessoa) {
        return (pessoa.getId() % max_posicoes);
    }

    public void inserir(Pessoa pessoa) {
        if (estacheio()) {
            System.out.println("A tabela hash está cheia.");
            return;
        }

        int local = FuncaoHash(pessoa);
        while (estrutura[local].getId() != -1) {
            local = (local + 1) % max_posicoes;
        }
        estrutura[local] = pessoa;
        quant_itens++;
    }

    public void deletar(int id, String nome) {
        boolean encontrado = false;

        for (int i = 0; i < max_posicoes; i++) {
            if ((id != -1 && estrutura[i].getId() == id) ||
                    (nome.length() > 0 && estrutura[i].getNome().equalsIgnoreCase(nome))) {
                estrutura[i] = new Pessoa(-2, " ");
                quant_itens--;
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println("Aluno(s) excluído(s) com sucesso!");
        } else {
            System.out.println("Aluno não encontrado para exclusão.");
        }
    }

//    public void buscar(Pessoa pessoa, boolean[] busca) {
//        int local = FuncaoHash(pessoa);
//        while (estrutura[local].getId() != -1) {
//            if (estrutura[local].getId() == pessoa.getId()) {
//                busca[0] = true;
//                return;
//            }
//            local = (local + 1) % max_posicoes;
//        }
//        busca[0] = false;
//    }

    public void buscar(int id, String nome, boolean[] busca) {
        for (int i = 0; i < max_posicoes; i++) {
            if ((id != -1 && estrutura[i].getId() == id) ||
                    (nome.length() > 0 && estrutura[i].getNome().equalsIgnoreCase(nome))) {
                busca[0] = true;
                return;
            }
        }
        busca[0] = false;
    }

    public void imprimir() {
        System.out.println("Pos  Key");
        for (int i = 0; i < max_posicoes; i++) {
            System.out.print("[" + i + "]  ");
            System.out.print(estrutura[i].getNome());
            System.out.println();
        }
    }

    public boolean estacheio() {
        return (quant_itens == max_itens);
    }

    public int obterTamanhoAtual() {
        return quant_itens;
    }
}