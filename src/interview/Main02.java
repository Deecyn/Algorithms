package interview;

import java.util.*;

/**
 * @author Deecyn
 * @version 0.1
 * Description: 通知传递
 */
public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> mList = new ArrayList<>();
        int idx0 = -1; // 编号为 0 的人所在团队的索引
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                int tmp = sc.nextInt();
                if (tmp == 0) {
                    idx0 = i;
                }
                list.add(tmp);
            }
            mList.add(list);
        }

        Set<Integer> passSet = new HashSet<>(n);
        passSet.addAll(mList.get(idx0));

        for (List<Integer> list : mList) {
            for (Integer i : list) {
                if (passSet.contains(i)) {
                    passSet.addAll(list);
                    break;
                }
            }
        }

        for (List<Integer> list : mList) {
            for (Integer i : list) {
                if (passSet.contains(i)) {
                    passSet.addAll(list);
                    break;
                }
            }
        }

        System.out.println(passSet.size());
    }

}
