package multiThreading;

// =========================================   SYNCHRONIZED  ==========================================================
// multi-threading çalışma koşullarında birden fazla thread'in aynı kaynağa (değişken metot, class, bellek vb)
// erişimi (okuma veya yazma) sırasında verinin güncellenmesi ve tutarlılığı ile ilgili sorunlar çıkabilir.
// Bu tutarsızlığı engellemek için synchronized keywordu kullanılabilir.
// Kısaca, Syncronization bir kaynağın tread'ler tarafından eş zamanlı kullanımına kapatılması (Lock) işlemidir.

// Synchronized keywordunun farklı kullanımları bulunmaktadır.
//  1- Eğer bir metot "synronized" yapılırsa (Method-Level Syncronization) bu metota aynı andan birden fazla thread'in
//     erişimine izin verilmez.
//
//  2- Eğer bir metot yerine o metodun ait olduğu class'ı aynı anda birden fazla thread'in kullanımına kapatmak
//     (class-level Syncronization) istersek o zaman "synchronized static" kullanmalıyız.

//  3- Eğer bir metot içerisinde belirli bir kismin eş zamanlı thread kullanımına kapatılmasını ister isek o zaman
//     "synchronized block" (block-level Syncronization) kullanmalıyız.

public class MT02MethodLevelSyncronization {
    // Her iki thread tarafından ortak kullanılacak degişken
    public static int sayac = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Sayici.say("th1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Sayici.say("th2");
            }
        });
        thread1.start();
//        thread1.join();  // Join metodu ise yarayabilir ancak bu ornke için multi-threading tamamıyle devre dışı
        // bırakmak gibi düşünüşebilir.
        thread2.start();
    }
}

// Metotu synchronized yaparak her iki thread'in aynı anda (eş-zamanlı, concurently) metoda erişimini engellemiş olduk.
// Eger böyle yapmasaydık eş zamanlı olarak Thread1 ve thread2 say metoduna erişip sayac'ın degerini arttırabilirdi.
// Bu sıkıntı join metodu ile de giderilebilirdi. Ancak ikisi arasında ince nunaslar bulunmaktadır.
// join() metodu bir thread'in tamamıyla bitmesinin beklenmesini sağlarken, synchronization aynı anda bir kaynağa
// erişimi engellemektedir.
// Hangisinin daha elverişli olacağı uygulamanın gereksinimlerine ve koşullara göre değişebilir.

class Sayici {
    // Method-Level Synchonization
    synchronized public static void say(String thread) {
        for (int i = 1; i <= 20; i++) {
            MT02MethodLevelSyncronization.sayac++;
            System.out.println("Sayac-" + thread + ":" +MT02MethodLevelSyncronization.sayac);
        }
    }
}

