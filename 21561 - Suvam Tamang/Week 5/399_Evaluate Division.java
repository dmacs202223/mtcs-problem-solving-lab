class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        double[] result = new double[queries.size()];
        HashMap< String, HashMap<String, Double>> graph = new HashMap<>();
        
        buildGraph(equations, values, graph);
        for(int i=0; i<queries.size(); i++) {
            result[i] = evaluateExpression(queries.get(i).get(0), queries.get(i).get(1), graph,  new ArrayList<String>());
        }
        return result;
    }
    
    public void buildGraph(List<List<String>> equations, double[] values, HashMap<String, HashMap<String, Double>> graph) {
        
        for(int i=0; i<equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
        
            if(!graph.containsKey(var1))
                graph.put(var1, new HashMap<String, Double>());
            if(!graph.containsKey(var2))
                graph.put(var2, new HashMap<String, Double>());
            
            graph.get(var1).put(var2, values[i]);
            graph.get(var2).put(var1, 1/values[i]);
        }
    }
    
    public double evaluateExpression(String num1, String num2, HashMap<String, HashMap<String, Double>> graph, ArrayList<String> visited) {
        if( !graph.containsKey(num1) || !graph.containsKey(num2) || visited.contains(num1))
            return -1d;
        if(num1.equals(num2))
            return 1d;
        visited.add(num1);
        
        for (Map.Entry<String, Double> map : graph.get(num1).entrySet()) {
            if(map.getKey().equals(num2))
                return map.getValue();
            
            double res = evaluateExpression(map.getKey(), num2, graph, visited);
            if( res != -1)
                return res * map.getValue();
        }
        return -1d;
    }
}
