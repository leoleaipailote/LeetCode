class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> geneBank = new HashSet<String>();
        for (String s : bank)
            geneBank.add(s);
        HashSet<String> visited = new HashSet<String>();
        Queue<Pair> bfs = new LinkedList<Pair>();
        Pair start = new Pair(startGene, 0);
        visited.add(startGene);
        bfs.add(start);
        while (!(bfs.isEmpty())) {
            Pair p = bfs.poll();
            String s = (String) p.getKey();
            int numMut = (int) p.getValue();
            if (s.equals(endGene))
                return numMut;
            List<String> validMutations = checkMutation(s, geneBank);
            for (String str : validMutations) {
                if (!(visited.contains(str))) {
                    visited.add(str);
                    Pair newPair = new Pair(str, numMut + 1);
                    bfs.add(newPair);
                }
            }
        }
        return -1;
    }

    public List<String> checkMutation(String someGene, HashSet<String> bank) {
        /*
         * Find all gene strings that are 1 mutation away
         * this is going to be 8*3 = 24 operations as we replace each character in the
         * string
         * with a character not equal to itself in the list of possible genes
         * Check bank for each of these, and return a list of valid genes 1 mutation
         * away
         */

        char[] genes = { 'A', 'C', 'G', 'T' };
        List<String> validMut = new ArrayList<String>();
        int length = someGene.length();
        for (int i = 0; i < 8; i++) {
            for (char c : genes) {
                if (c != someGene.charAt(i)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(someGene.substring(0, i));
                    sb.append(c);
                    sb.append(someGene.substring(i + 1, length));
                    String mutation = sb.toString();
                    if (bank.contains(mutation))
                        validMut.add(mutation);
                }
            }
        }
        return validMut;
    }
}