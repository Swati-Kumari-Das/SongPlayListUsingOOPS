import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public class Main {    

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        
      

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("TNT", 4.5);
        album.addSong("HighWay to hell", 4.6);
        albums.add(album);
    

        album = new Album("Arijit Hits", "Arijit Singh");
        album.addSong("Tum Hi Ho", 4.30);
        album.addSong("Channa Mereya", 4.45);
        album.addSong("Kesariya", 4.25);
        album.addSong("Raabta", 4.10);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Stormbringer", playList_1);
        albums.get(0).addToPlayList("Love don't mean a thing", playList_1);
        albums.get(1).addToPlayList("Tum Hi Ho", playList_1);
        albums.get(1).addToPlayList("Channa Mereya", playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Song> playList){
       Scanner sc=new Scanner(System.in);
       boolean quit = false;
       boolean forward = true;
       ListIterator<Song> listIterator = playList.listIterator();
         if(playList.size() == 0){
              System.out.println("No songs in the playlist");
              
    }else{
        System.out.println("Now playing " + listIterator.next().toString());
        printMenu();
    }
       while(!quit){
           int action = sc.nextInt();
           sc.nextLine();
           switch(action){
               case 0:
                   System.out.println("Playlist complete");
                   quit = true;
                   break;
               case 1:
                   if(!forward){
                       if(listIterator.hasNext()){
                           listIterator.next();
                       }
                       forward = true;
                   }
                   if(listIterator.hasNext()){
                       System.out.println("Now playing " + listIterator.next().toString());
                   }else{
                       System.out.println("We have reached the end of the playlist");
                       forward = false;
                   }
                   break;
               case 2:
                   if(forward){
                       if(listIterator.hasPrevious()){
                           listIterator.previous();
                       }
                       forward = false;
                   }
                   if(listIterator.hasPrevious()){
                       System.out.println("Now playing " + listIterator.previous().toString());
                   }else{
                       System.out.println("We are at the start of the playlist");
                       forward = true;
                   }
                   break;
               case 3:
                   if(forward){
                       if(listIterator.hasPrevious()){
                           System.out.println("Now replaying " + listIterator.previous().toString());
                           forward = false;
                       }else{
                           System.out.println("We are at the start of the list");
                       }
                   }else{
                       if(listIterator.hasNext()){
                           System.out.println("Now replaying " + listIterator.next().toString());
                           forward = true;
                       }else{
                           System.out.println("We have reached the end of the list");
                       }
                   }
                   break;
               case 4:
                   printList(playList);
                   break;
               case 5:
                   printMenu();
                   break;
               case 6:
                   if(playList.size() >0){
                       listIterator.remove();
                       if(listIterator.hasNext()){
                           System.out.println("Now playing " + listIterator.next().toString());
                          
                       }else{
                            if(listIterator.hasPrevious()){
                                 System.out.println("Now playing " + listIterator.previous().toString());
                            }
                       }
                   }
                   break;
           }
       }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n"+
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList){
       
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
      
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("================================");

    }
}