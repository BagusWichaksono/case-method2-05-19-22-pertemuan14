public class queueTransaksi {
    TransaksiLayanan [] data;
    int front;
    int rear;
    int size;
    int max;

    public queueTransaksi(int max){
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
        size ++;
    }

    public void  tampilkantransaksi(){
        System.out.println("Riwayat Transaksi");
        for (int i = 0; i < size; i++) {
            int idx = (front + 1) % max;
            data[idx].tampilkantransaksi();
        }
    }
}
