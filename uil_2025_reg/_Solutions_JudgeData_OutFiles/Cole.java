import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Cole {
    public static void main(String[] args) throws IOException {
        new Cole().run();
    }

    private void run() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("cole.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        solve(file, out);

        file.close();
        out.close();
    }

    private class CraftingRecipe {
        private String name;
        private double t, rate;
        private HashMap<String, Integer> ingredients;

        public CraftingRecipe(String name, double p, double t, HashMap<String, Integer> ingredients) {
            this.name = name;
            this.t = t;
            this.rate = p / t;
            this.ingredients = ingredients;
        }

        public HashMap<String, Double> getNumAssemblers(HashMap<String, CraftingRecipe> recipes, double outputRate) {
            // For each ingredient, we need to know how many assemblers we need
            // to produce. This will keep track of those numbers.
            HashMap<String, Double> ingredientToAssembler = new HashMap<String, Double>();
            getNumAssemblers(recipes, ingredientToAssembler, outputRate);
            return ingredientToAssembler;
        }

        private void getNumAssemblers(HashMap<String, CraftingRecipe> recipes,
                HashMap<String, Double> ingredientToAssembler, double outputRate) {
            // We wish to producde `outputRate` of the recipe
            // One machine produces `rate` of the recipe
            double local = outputRate / rate;
            double global = ingredientToAssembler.getOrDefault(name, 0.0);
            ingredientToAssembler.put(name, global + local);

            // Determine how many assemblers we need for each ingredient of this recipe
            // to produce `outputRate` of this recipe.
            for (String ingredient : ingredients.keySet()) {
                CraftingRecipe recipe = recipes.get(ingredient);
                // Each assembler needs `q_k` units of the ingredient, and needs that many every
                // `t` units of time. We have `local` copies of the assembler, so we need
                // `(q_k / t) * local` copies of the ingredient every second.
                double ingredientRate = ((double) ingredients.get(ingredient) / t) * local;
                recipe.getNumAssemblers(recipes, ingredientToAssembler, ingredientRate);
            }
        }
    }

    class Query {
        private String A;
        private double r;

        public Query(String A, double r) {
            this.A = A;
            this.r = r;
        }
    }

    private static final double EPSILON = 1e-6;

    public void solve(BufferedReader file, PrintWriter out) throws IOException {
        StringTokenizer st = new StringTokenizer(file.readLine());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // Read in the R recipes
        HashMap<String, CraftingRecipe> recipes = new HashMap<String, CraftingRecipe>();
        while (R-- > 0) {
            String[] line = file.readLine().split("\\)?, \\(?|\\)");
            String S = line[0];
            String[] parts = line[1].split("/");
            double p = Double.parseDouble(parts[0]);
            double t = Double.parseDouble(parts[1]);

            int l = Integer.parseInt(line[2]);

            HashMap<String, Integer> ingredients = new HashMap<String, Integer>();
            for (int j = 3; j < 3 + 2 * l; j += 2) {
                String ingredient = line[j];
                int amount = Integer.parseInt(line[j + 1]);
                ingredients.put(ingredient, amount);
            }

            recipes.put(S, new CraftingRecipe(S, p, t, ingredients));
        }

        // Read in the Q queries
        Query[] queries = new Query[Q];
        HashSet<String> roots = new HashSet<String>();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(file.readLine(), ", ");
            String A = st.nextToken();
            double r = Double.parseDouble(st.nextToken());
            queries[i] = new Query(A, r);
            // Add the item to the set of items we need to produce
            roots.add(A);
        }

        // Determine how many assemblers are needed to produce one of each query per
        // second, as well as the lexicographical order the ingredients must be in.
        // Storing this helps preventing additional recursion if we need to find the
        // number of assemblers for the same queried ingredient multiple times.
        HashMap<String, HashMap<String, Double>> assemblers = new HashMap<String, HashMap<String, Double>>();
        HashMap<String, TreeSet<String>> ingredients = new HashMap<String, TreeSet<String>>();
        for (String root : roots) {
            HashMap<String, Double> currAssemblers = recipes.get(root).getNumAssemblers(recipes, 1.0);
            TreeSet<String> currIngredients = new TreeSet<String>(currAssemblers.keySet());
            assemblers.put(root, currAssemblers);
            ingredients.put(root, currIngredients);
        }

        // For each query, determine how many assemblers are needed to produce one of
        // each recipe per second
        for (Query query : queries) {
            String A = query.A;
            double r = query.r;

            out.printf("%s (%.5f/s):\n", A, r);

            HashMap<String, Double> currAssemblers = assemblers.get(A);
            for (String s : ingredients.get(A)) {
                double numAssemblersForOne = currAssemblers.get(s);
                out.printf("\t%s: %d\n", s, (long) Math.ceil(numAssemblersForOne * r - EPSILON));
            }
        }
    }
}