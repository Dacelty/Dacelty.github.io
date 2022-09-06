import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();

        List<Integer> r0 = new LinkedList<>();
        r0.add(1);
        List<Integer> r1 = new LinkedList<>();
        r0.add(2);
        List<Integer> r2 = new LinkedList<>();
        r0.add(3);
        List<Integer> r3 = new LinkedList<>();

        rooms.add(r0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRoom = new boolean[rooms.size()];

        Queue<List<Integer>> queue = new LinkedList();

        //đánh dấu room 0 và ghi là đã visit
        queue.add(rooms.get(0));
        visitedRoom[0] = true;

        //bắt đầu visitedCount = 1 bởi vì room 0 đã visit
        int visitedCount = 1;

        while(!queue.isEmpty()){
            List<Integer> roomKeys = queue.remove();
            for(int key : roomKeys){
                if(!visitedRoom[key]){
                    queue.add(rooms.get(key));
                    visitedRoom[key] = true;

                    visitedCount++;
                }
            }
        }

        return visitedCount == visitedRoom.length;
    }


}
