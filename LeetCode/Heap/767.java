class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        class Pair {
            int first;
            char second;

            Pair(int f, char s) {
                first = f;
                second = s;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.first != b.first) {
                        return b.first - a.first;
                    }
                    return 0;
                });

        for (char c : mp.keySet()) {
            pq.offer(new Pair(mp.get(c), c));
        }

        StringBuilder res = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (res.length() == 0 || res.charAt(res.length() - 1) != p.second) {
                res.append(p.second);
                p.first--;

                if (p.first > 0) {
                    pq.offer(p);
                }

            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                Pair p1 = pq.poll();

                res.append(p1.second);
                p1.first--;

                if(p1.first>0){
                    pq.offer(p1);
                }

                pq.offer(p);
            }
        }

        return res.toString();
    }
}
