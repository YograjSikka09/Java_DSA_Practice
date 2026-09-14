public class Videoaudio {
    public static void main(String[] args) {
        DownloadThread t1=new DownloadThread("Movie.mp4");
        DownloadThread t2=new DownloadThread("audio.mp3");
        DownloadThread t3=new DownloadThread("notes.pdf");
        t1.start();
        t2.start();
        t3.start();
    }
}
class DownloadThread extends Thread{
    DownloadThread(String name){
        super(name);
    }
    public void run(){
        try{

        
        for(int i=20;i<=100;i+=20){
            System.out.println(
                Thread.currentThread().getName()
                +" ->  "+i+" % "
            );
            // Thread.sleep(10000);
            Thread.sleep(10000);
        }
        System.out.println(
            Thread.currentThread().getName()
            +"-> Download Complete!"
        );
    }catch(InterruptedException e){
        System.out.println("Download Interrupted :");
    }
}
}