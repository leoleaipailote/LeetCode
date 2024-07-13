class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1)
            return 1;
        if (points.length == 2)
            return 2;
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Map<List<Double>, Integer> mc = new HashMap<List<Double>, Integer>();
            for (int j = i + 1; j < points.length; j++) {
                int[] coord1 = points[i];
                int[] coord2 = points[j];
                List<Double> line = calcMX(coord1, coord2);
                int count = mc.getOrDefault(line, 1);
                mc.put(line, count + 1);
                max = Math.max(max, count + 1);
            }
        }
        return max;
    }

    public List<Double> calcMX(int[] coord1, int[] coord2) {
        List<Double> mc = new ArrayList<Double>();
        if ((coord1[0] - coord2[0]) == 0) {
            mc.add((double) coord1[1]);
        } else {
            double m = (double) (coord1[1] - coord2[1]) / (double) (coord1[0] - coord2[0]);
            double c = (double) coord1[1] - m * ((double) coord1[0]);
            if (m == -0.0)
                m = 0.0;
            mc.add(m);
            mc.add(c);
        }
        return mc;
    }
}