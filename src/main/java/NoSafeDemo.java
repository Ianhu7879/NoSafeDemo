import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//arrayList是线程不安全的
public class NoSafeDemo {
	public static void main(String[] args) {
		List list =new CopyOnWriteArrayList<>();
		//List<String> list = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 6));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
}
