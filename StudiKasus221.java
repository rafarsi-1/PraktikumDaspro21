import java.util.Scanner;

public class StudiKasus221 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nama, jenisKegiatan;
        int jumlahDokumen, peringkat, statusPendanaan;

        System.out.print("Nama mahasiswa  : ");
        nama = input.nextLine();

        System.out.print("Jenis kegiatan (BELMAWA/BAKORMA/MANDIRI/PKM/LAINNYA) : ");
        jenisKegiatan = input.nextLine();

        System.out.print("Jumlah dokumen  : ");
        jumlahDokumen = input.nextInt();

        jenisKegiatan = jenisKegiatan.toUpperCase();

        boolean berhakDana = false;
        String alasan = "";

        if (jenisKegiatan.equals("BELMAWA")
                || jenisKegiatan.equals("BAKORMA")
                || jenisKegiatan.equals("MANDIRI")) {
            System.out.print("Peringkat juara (1/2/3, isi 0 jika bukan juara) : ");
            peringkat = input.nextInt();

            if (peringkat >= 1 && peringkat <= 3) {
                if (jumlahDokumen == 4) {
                    berhakDana = true;
                } else {
                    alasan = "Dokumen tidak lengkap (kurang "
                            + (4 - jumlahDokumen) + " dokumen). "
                            + "Dana penghargaan tidak diberikan.";
                }
            } else {
                alasan = "Tidak memperoleh dana penghargaan "
                        + "(hanya untuk Juara 1/2/3).";
            }

        } else if (jenisKegiatan.equals("PKM")) {

            System.out.print("Status pendanaan PKM (1 = lolos, 0 = tidak lolos) : ");
            statusPendanaan = input.nextInt();

            if (statusPendanaan == 1) {
                if (jumlahDokumen == 4) {
                    berhakDana = true;
                } else {
                    alasan = "Dokumen tidak lengkap (kurang "
                            + (4 - jumlahDokumen) + " dokumen). "
                            + "Dana penghargaan tidak diberikan.";
                }
            } else {
                alasan = "Tidak memperoleh dana penghargaan "
                        + "(tim tidak lolos pendanaan PKM).";
            }

        } else {
            alasan = "Tidak memperoleh dana penghargaan "
                    + "(jenis kegiatan tidak termasuk ketentuan).";
        }

        System.out.println();
        if (berhakDana) {
            System.out.println("Status : Berhak memperoleh dana penghargaan.");
        } else {
            System.out.println("Status : " + alasan);
        }
    }
}