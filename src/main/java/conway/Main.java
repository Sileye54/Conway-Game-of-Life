package conway;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The main class
 */
public class Main {

    /**
     * The main method, called by Maven
     * @param args the arguments given to main as an array of strings
     */
    public static void main(String[] args) {
        String f = null;
        int cnt = -1;
        try {
            f = args[0];
            cnt = Integer.parseInt(args[1]);
        } catch (Exception e) { System.exit(1); }

        boolean[][] gs = null; // first, we initialize gs with null
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            int d = Integer.parseInt(r.readLine().trim());
            gs = new boolean[d][d]; // gs is now d x d
            int x = 0;
            while (x < d) {
                String l = r.readLine();
                String[] cs = l.trim().split(" ");
                for(int y = 0; y < cs.length; y++) {
                    switch(cs[y]) {
                        case "_": gs[x][y] = false; break;
                        case "X": gs[x][y] = true; break;
                        default:  System.exit(2);
                    }
                }
                x++;
            }
            r.close();
        } catch (Exception e) { System.exit(2); }

        for(int cpt = 0; cpt < cnt; cpt++) {
            int d = gs.length;
            boolean[][] ns = new boolean[d][d];
            for(int x = 0; x < d; x++) {
                for (int y = 0; y < d; y++) {
                    int n = 0;
                    if(x-1 > 0) {
                        if (y-1 > 0 && gs[x-1][y-1]) { n++; }
                        if (gs[x-1][y])              { n++; }
                        if (y+1 < d && gs[x-1][y+1]) { n++; }
                    }
                    if (y-1 > 0 && gs[x][y-1]) { n++; }
                    if (y+1 < d && gs[x][y+1]) { n++; }
                    if(x+1 < d) {
                        if (y-1 > 0 && gs[x+1][y-1]) { n++; }
                        if (gs[x+1][y])              { n++; }
                        if (y+1 < d && gs[x+1][y+1]) { n++; }
                    }
                    if      (gs[x][y] && n  < 2)  { ns[x][y] = false;    }
                    else if (gs[x][y] && n  > 3)  { ns[x][y] = false;    }
                    else if (!gs[x][y] && n == 3) { ns[x][y] = true;     }
                    else                          { ns[x][y] = gs[x][y]; }
                }
            }
            gs = ns;
        }

        System.out.println(gs.length);
        for(int x = 0; x < gs.length; x++){
            for(int y = 0; y < gs[x].length; y++) {
                if (gs[x][y]) { System.out.print("X"); }
                else { System.out.print("_"); }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
