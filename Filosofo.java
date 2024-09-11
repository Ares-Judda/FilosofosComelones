public class Filosofo implements Runnable {
    private final Tenedor tenedorIzquierdo;
    private final Tenedor tenedorDerecho;
    private final int id;

    public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                System.out.println("Filosofo " + id + " se prepara para comer...");
                if (tomarTenedores()) {
                    comer();
                    soltarTenedores();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " está pensando...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private boolean tomarTenedores() throws InterruptedException {
        if (tenedorIzquierdo.tomar()) {
            System.out.println("Filosofo " + id + " toma su tenedor izquierdo...");
            if (tenedorDerecho.tomar()) {
                System.out.println("Filosofo " + id + " toma su tenedor derecho...");
                return true;
            } else {
                tenedorIzquierdo.soltar();
                System.out.println("Filosofo " + id + " soltó su tenedor izquierdo.");
            }
        }
        return false;
    }

    private void comer() throws InterruptedException {
        System.out.println("Filosofo " + id + " está comiendo...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void soltarTenedores() {
        tenedorDerecho.soltar();
        System.out.println("Filosofo " + id + " soltó su tenedor derecho.");
        tenedorIzquierdo.soltar();
        System.out.println("Filosofo " + id + " soltó su tenedor izquierdo.");
    }
}
