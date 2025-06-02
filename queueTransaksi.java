public class QueueTransaksi {
    TransaksiLayanan[] data;
    int front = 0;
    int rear = -1;
    int size = 0;
    int max;

    public QueueTransaksi(int max){
        this.max = max;
        data = new TransaksiLayanan[max];
    }

    public void enqueue(TransaksiLayanan transaksi){
        if (size == max) {
            System.out.println("antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = transaksi;
        size++;
    }

    public void tampilkantransaksi(){
        System.out.println("Riwayat Transaksi");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % max;
            data[idx].tampilkantransaksi();
        }
    }
}
