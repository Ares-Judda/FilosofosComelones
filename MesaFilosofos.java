public class MesaFilosofos {
    public static void main(String[] args) {
        Tenedor[] tenedores = new Tenedor[5];
        Filosofo[] filosofos = new Filosofo[5];

        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Tenedor();
        }

        for (int i = 0; i < 5; i++) {
            Tenedor tenedorIzquierdo = tenedores[i];
            Tenedor tenedorDerecho = tenedores[(i + 1) % 5];

            // Para evitar deadlocks, el último filósofo toma primero el tenedor derecho
            if (i == 4) {
                filosofos[i] = new Filosofo(i + 1, tenedorDerecho, tenedorIzquierdo);
            } else {
                filosofos[i] = new Filosofo(i + 1, tenedorIzquierdo, tenedorDerecho);
            }

            new Thread(filosofos[i], "Filosofo " + (i + 1)).start();
        }
    }
}

