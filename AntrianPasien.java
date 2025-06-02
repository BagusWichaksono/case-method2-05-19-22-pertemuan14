public class AntrianPasien {
    NodePasien head, tail;
    int size = 0;

    public void tambahPasien(Pasien p) {
        NodePasien newNode = new NodePasien(p);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println(">> Pasien masuk ke dalam antrian.");
    }

    public void tampilkanAntrian() {
        NodePasien temp = head;
        while (temp != null) {
            temp.data.tampilkanInformasi();
            temp = temp.next;
        }
    }

    public int jumlahPasien() {
        return size;
    }

    public Pasien layaniPasien() {
        if (head == null) return null;
        Pasien p = head.data;
        head = head.next;
        size--;
        return p;
    }
}